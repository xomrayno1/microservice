package com.app.service;

import java.util.List;

import com.app.entity.StockTotal;
import com.app.model.request.DecreaseStockRequest;
import com.app.model.response.StockTotalResponse;

public interface StockTotalService {
  
	StockTotal findById(Long id);
	
	StockTotalResponse findByProductVariantId(Long id);
	
	List<StockTotal> findByProductId(Long id);

	void decreaseStock(DecreaseStockRequest decreaseStockRequest);
}
