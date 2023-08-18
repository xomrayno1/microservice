package com.app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Product;
import com.app.entity.ProductVariant;
import com.app.entity.SaleOrder;
import com.app.entity.SaleOrderDetail;
import com.app.enums.OrderStatus;
import com.app.exception.ValidateException;
import com.app.model.event.CreateSaleOrderEvent;
import com.app.model.request.SaleOrderCreateRequest;
import com.app.model.request.SaleOrderPagingSearchSortFilter;
import com.app.model.response.APIStatus;
import com.app.repository.ProductRepository;
import com.app.repository.ProductVariantRepository;
import com.app.repository.SaleOrderRepository;
import com.app.service.SaleOrderService;
import com.app.utils.Commons;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleOrderServiceImpl implements SaleOrderService {
	
	private SaleOrderRepository saleOrderRepository;
	
	private ProductRepository productRepository;
	
	private ProductVariantRepository productVariantRepository;
	
	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public Page<SaleOrder> getListPagingSearchSortFilter(SaleOrderPagingSearchSortFilter filter, Pageable pageable) {
		return null;
	}

	@Override
	@Transactional
	public SaleOrder create(SaleOrderCreateRequest saleOrderCreateRequest) {
		//lưu db
		SaleOrder saleOrder = createSaleOrder(saleOrderCreateRequest);
		SaleOrder sareOrderSaved = saleOrderRepository.save(saleOrder);
 
		// kafka send queue stock service
		applicationEventPublisher.publishEvent(
				CreateSaleOrderEvent.builder()
					.saleOrderDetail(sareOrderSaved.getSaleOrderDetails())
					.saleOrderId(saleOrder.getId())
					.build());
		
		return sareOrderSaved;
	}
	
	private SaleOrder createSaleOrder(SaleOrderCreateRequest saleOrderCreateRequest) {
		SaleOrder saleOrderBuilder = SaleOrder.builder()
				.amount(saleOrderCreateRequest.getAmount())
				.customerAddress(saleOrderCreateRequest.getCustomerAddress())
				.customerName(saleOrderCreateRequest.getCustomerName())
				.customerPhone(saleOrderCreateRequest.getCustomerPhone())
				.description(saleOrderCreateRequest.getDescription())
				.discount(saleOrderCreateRequest.getDiscount())
				.orderDate(LocalDateTime.now())
				.orderNumber(Commons.generateRandomNumber().toString())
				.orderStatus(OrderStatus.PENDING)
				.price(saleOrderCreateRequest.getPrice())
				.quantity(saleOrderCreateRequest.getQuantity())
				.totalPrice(saleOrderCreateRequest.getTotalPrice())
				
				.build();
		
		List<SaleOrderDetail> saleOrderDetails =  saleOrderCreateRequest.getSaleOrderDetails().stream().map(item -> {
			Product product = productRepository.findById(item.getProductId())
						.orElseThrow(() -> new ValidateException(APIStatus.ERR_PRODUCT_ID_NOT_EXISTS));
			
			ProductVariant productVariant = productVariantRepository.findById(item.getProductVariantId())
					.orElseThrow(() -> new ValidateException(APIStatus.ERR_PRODUCT_ID_NOT_EXISTS));
			
			  return  SaleOrderDetail.builder()
					  .amount(item.getAmount())
					  .discount(item.getDiscount())
					  .price(item.getPrice())
					  .product(product)
					  .productVariant(productVariant)
					  .quantity(item.getQuantity())
					  .totalPrice(item.getTotalPrice())
					  .saleOrder(saleOrderBuilder)
					  .build();
		}).collect(Collectors.toList());
		saleOrderBuilder.setSaleOrderDetails(saleOrderDetails);
		return saleOrderBuilder;
	}

	@Override
	public SaleOrder findById(Long id) {
		return saleOrderRepository.findById(id).orElse(null);
	}

}
