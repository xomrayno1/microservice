package com.app.service.saga;

import org.springframework.stereotype.Component;

import com.app.entity.SaleOrder;
import com.app.exception.ValidateException;
import com.app.model.response.APIStatus;
import com.app.model.response.DecreaseStockResponse;
import com.app.repository.SaleOrderRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class CreateSaleOrderSaga implements SagaStep<DecreaseStockResponse>{
	
	private final SaleOrderRepository saleOrderRepo;
	
	@Override
	public void process(DecreaseStockResponse data) {
		log.info("process sale order id {} ", data.getSaleOrderId());
		SaleOrder saleOrder = saleOrderRepo.findById(data.getSaleOrderId())
				.orElseThrow(() -> new ValidateException(APIStatus.ERR_SALE_ORDER_NOT_EXISTS));
		saleOrder.setOrderStatus(data.getOrderStatus());
		saleOrderRepo.save(saleOrder);
	}

	@Override
	public void rollback(DecreaseStockResponse data) {
		log.info("rollback sale order id {} ", data.getSaleOrderId());
		SaleOrder saleOrder = saleOrderRepo.findById(data.getSaleOrderId())
				.orElseThrow(() -> new ValidateException(APIStatus.ERR_SALE_ORDER_NOT_EXISTS));
		saleOrder.setOrderStatus(data.getOrderStatus());
		saleOrder.setDescription(data.getReason());
		saleOrderRepo.save(saleOrder);
	}

}
