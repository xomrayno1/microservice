package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.SaleOrder;
import com.app.model.request.SaleOrderCreateRequest;
import com.app.model.response.APIResponse;
import com.app.service.SaleOrderService;
import com.app.utils.PathUtils;
import com.app.utils.ResponseUtils;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SaleOrderController {
	
	
	private final SaleOrderService saleOrderService;

//	@PostMapping(value = PathUtils.SALE_ORDER_API + PathUtils.SALE_ORDER_PAGING_SEARCH_SORT_FILTER)
//	public ResponseEntity<APIResponse> getListPagingSearchSortFilter(
//			@RequestBody ProductPagingSearchSortFilter filter, Pageable pageable) {
//		Page<Product> page = productService.getListPagingSearchSortFilter(filter, pageable);
//		return ResponseUtils.responseSuccess(page);
//	}

	@GetMapping(value = PathUtils.SALE_ORDER_API_V1 + PathUtils.SALE_ORDER_GET_BY_ID)
	public ResponseEntity<APIResponse> getById(@PathVariable("id") Long id) {
		SaleOrder saleOrder = saleOrderService.findById(id);
		return ResponseUtils.responseSuccess(saleOrder);
	}

	@PostMapping(value = PathUtils.SALE_ORDER_API_V1 + PathUtils.SALE_ORDER_CREATE)
	public ResponseEntity<APIResponse> create(@RequestBody SaleOrderCreateRequest createRequest) {
		SaleOrder saleOrder = saleOrderService.create(createRequest);
		return ResponseUtils.responseSuccess(saleOrder);
	}

}
