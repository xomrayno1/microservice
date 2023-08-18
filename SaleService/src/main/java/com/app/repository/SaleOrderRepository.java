package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.SaleOrder;

public interface SaleOrderRepository extends CrudRepository<SaleOrder, Long>{

}
