package com.app.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.app.model.event.CreateSaleOrderEvent;
import com.app.service.kafka.publisher.SaleOrderKafkaPublisher;
import com.core.model.request.DecreaseStockRequest;
import com.core.model.request.DecreaseStockRequest.Stock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class HandlerApplicationEventPublisher {
	
	//kafka
	
	private SaleOrderKafkaPublisher createSaleOrderKafkaListener;
	  
	@TransactionalEventListener
	public void proccess(CreateSaleOrderEvent createSaleOrderEvent) {
		List<Stock> increaseStockRequests = createSaleOrderEvent
				.getSaleOrderDetail().stream()
				.map(item -> new DecreaseStockRequest.Stock(item.getProductVariant().getId(), item.getQuantity(), item.getProduct().getName() + " " +item.getProductVariant().getName()))
				.toList();
		log.info(" transaction event listener : order number {} ", createSaleOrderEvent.getOrderNumber());
		
		//send kafka
		createSaleOrderKafkaListener.published(new DecreaseStockRequest(createSaleOrderEvent.getSaleOrderId(), increaseStockRequests));
		
	}

}
