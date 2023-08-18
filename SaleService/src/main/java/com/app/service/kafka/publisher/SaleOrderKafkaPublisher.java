package com.app.service.kafka.publisher;

import com.app.model.request.DecreaseStockRequest;

public interface SaleOrderKafkaPublisher {
	
	void published(DecreaseStockRequest decreaseStockRequest);

}
