package com.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.entity.Product;
import com.app.model.request.ProductCreateRequest;
import com.app.model.request.ProductPagingSearchSortFilter;
import com.app.model.request.ProductUpdateRequest;
import com.app.model.request.ProductVariantCreateRequest;
import com.app.model.response.ProductResponse;

public interface ProductService {
	Page<Product> getListPagingSearchSortFilter(ProductPagingSearchSortFilter filter, Pageable pageable);
	
	Product create(ProductCreateRequest createRequest);
	
	Product update(ProductUpdateRequest updateRequest);
	
	void delete(Long id);
	
	ProductResponse findById(Long id);
	
	void deletes(List<Long> ids);
	
	List<Product> getAll();
	
	void createVariants(List<ProductVariantCreateRequest> createRequests);
}
