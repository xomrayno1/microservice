package com.app.service.kafka.publisher;

import com.core.model.request.DecreaseStockRequest;

public interface SaleOrderKafkaPublisher {
	
	void published(DecreaseStockRequest decreaseStockRequest);

}
