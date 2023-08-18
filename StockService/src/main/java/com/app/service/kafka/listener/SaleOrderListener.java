package com.app.service.kafka.listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.enums.OrderStatus;
import com.app.exception.ValidateException;
import com.app.model.event.CreateSaleOrderResponseEvent;
import com.app.model.request.DecreaseStockRequest;
import com.app.repository.StockTotalRepository;
import com.app.service.StockTotalService;
import com.app.utils.StringUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class SaleOrderListener {
	
	private final StockTotalRepository stockTotalRepository;
	
	private final StockTotalService stockService;
	
	private final ApplicationEventPublisher applicationEventPublisher;
	
	@KafkaListener(id = "saleOrderGroup", topics = "create-sale-order-request")	 
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public void createSaleOrder(DecreaseStockRequest request) throws Exception {
		log.info("listener event sale order id : {} ", request.getSaleOrderId());
		String reasonCancel = "";
		try {
			stockService.decreaseStock(request);
		} catch (ValidateException e) {
			 reasonCancel = e.getMessage();
		} finally {
			if(!StringUtils.isNullOrEmpty(reasonCancel)) {
				log.info("response reasonCancel : {} ",reasonCancel);
				applicationEventPublisher.publishEvent(new CreateSaleOrderResponseEvent(request.getSaleOrderId(), OrderStatus.CANCEL_BY_SYSTEM, reasonCancel));
			}else {
				log.info("response success : {} ", reasonCancel);
				applicationEventPublisher.publishEvent(new CreateSaleOrderResponseEvent(request.getSaleOrderId(), OrderStatus.APRROVE, null));
			}
		}
	}
	
 

}
