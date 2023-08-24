package com.app.service.kafka.publisher.impl;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.app.service.kafka.publisher.SaleOrderKafkaPublisher;
import com.core.model.request.DecreaseStockRequest;
import com.core.service.kafka.publisher.KafkaProducer;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SaleOrderKafkaPublisherImpl implements SaleOrderKafkaPublisher{
	//kafka procedure
	
	private KafkaProducer<Serializable, Object> kafkaProducer;

	@Override
	public void published(DecreaseStockRequest decreaseStockRequest) {
		 
		kafkaProducer.send("create-sale-order-request","1", decreaseStockRequest, null);
	}

}
