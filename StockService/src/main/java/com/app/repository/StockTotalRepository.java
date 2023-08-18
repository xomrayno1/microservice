package com.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.StockTotal;

public interface StockTotalRepository extends CrudRepository<StockTotal, Long> {
	
	StockTotal findByProductVariantId(Long id);
	
	List<StockTotal> findByProductId(Long id);

}
