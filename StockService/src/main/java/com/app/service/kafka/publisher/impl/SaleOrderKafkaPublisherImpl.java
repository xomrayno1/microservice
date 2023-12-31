package com.app.service.kafka.publisher.impl;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.app.service.kafka.publisher.SaleOrderKafkaPublisher;
import com.core.model.response.DecreaseStockResponse;
import com.core.service.kafka.publisher.KafkaProducer;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SaleOrderKafkaPublisherImpl implements SaleOrderKafkaPublisher {
	//kafka procedure
	
	private KafkaProducer<Serializable, Object> kafkaProducer;

	@Override
	public void published(DecreaseStockResponse decreaseStockResponse) {
		kafkaProducer.send("create-sale-order-response","1", decreaseStockResponse, null);
	}

}
