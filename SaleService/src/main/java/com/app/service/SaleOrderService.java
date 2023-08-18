package com.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.entity.SaleOrder;
import com.app.model.request.SaleOrderCreateRequest;
import com.app.model.request.SaleOrderPagingSearchSortFilter;

public interface SaleOrderService {
	
	Page<SaleOrder> getListPagingSearchSortFilter(SaleOrderPagingSearchSortFilter filter, Pageable pageable);
	
	SaleOrder create(SaleOrderCreateRequest saleOrderCreateRequest);
	
	SaleOrder findById(Long id);
}
