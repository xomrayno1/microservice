package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.StockTrans;

public interface StockTransRepository extends CrudRepository<StockTrans, Long>{

}
