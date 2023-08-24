package com.app.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.app.model.event.CreateSaleOrderResponseEvent;
import com.app.service.kafka.publisher.SaleOrderKafkaPublisher;
import com.core.model.response.DecreaseStockResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class HandlerApplicationEventPublisher {
	
	//kafka
	private SaleOrderKafkaPublisher saleOrderKafkaPublisher;
	  
	@TransactionalEventListener
	public void proccess(CreateSaleOrderResponseEvent createSaleOrderResponseEvent) {
		 
		log.info(" transaction event listener : order id {} ", createSaleOrderResponseEvent.getSaleOrderId());
		
		//send kafka
		saleOrderKafkaPublisher.published(new DecreaseStockResponse(createSaleOrderResponseEvent.getSaleOrderId()
				, createSaleOrderResponseEvent.getOrderStatus(), createSaleOrderResponseEvent.getReason()));
		
	}

}
