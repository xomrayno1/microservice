package com.app.service.kafka.publisher;

import com.core.model.response.DecreaseStockResponse;

public interface SaleOrderKafkaPublisher {
	
	void published(DecreaseStockResponse decreaseStockResponse);

}
