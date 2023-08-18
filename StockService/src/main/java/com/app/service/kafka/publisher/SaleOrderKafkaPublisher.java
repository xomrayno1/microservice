package com.app.service.kafka.publisher;

import com.app.model.response.DecreaseStockResponse;

public interface SaleOrderKafkaPublisher {
	
	void published(DecreaseStockResponse decreaseStockResponse);

}
