package com.app.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Product;
import com.app.model.request.ProductCreateRequest;
import com.app.model.request.ProductPagingSearchSortFilter;
import com.app.model.request.ProductUpdateRequest;
import com.app.model.request.ProductVariantCreateRequest;
import com.app.model.response.ProductResponse;
import com.app.service.ProductService;
import com.core.model.request.DeleteRequest;
import com.core.model.response.APIResponse;
import com.core.model.response.ResponseSuccessMessage;
import com.core.utils.PathUtils;
import com.core.utils.ResponseUtils;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductController {
	
	private final ProductService productService;

	@PostMapping(value = PathUtils.PRODUCT_API_V1 + PathUtils.PRODUCT_PAGING_SEARCH_SORT_FILTER)
	public ResponseEntity<APIResponse> getListPagingSearchSortFilter(
			@RequestBody ProductPagingSearchSortFilter filter, Pageable pageable) {
		Page<Product> page = productService.getListPagingSearchSortFilter(filter, pageable);
		return ResponseUtils.responseSuccess(page);
	}

	@GetMapping(value = PathUtils.PRODUCT_API_V1 + PathUtils.PRODUCT_GET_BY_ID)
	public ResponseEntity<APIResponse> getById(@PathVariable("id") Long id) {
		ProductResponse product = productService.findById(id);
		return ResponseUtils.responseSuccess(product);
	}

	@PostMapping(value = PathUtils.PRODUCT_API_V1 + PathUtils.PRODUCT_CREATE)
	public ResponseEntity<APIResponse> create(@RequestBody ProductCreateRequest createRequest) {
		Product product = productService.create(createRequest);
		return ResponseUtils.responseSuccess(product);
	}

	@PutMapping(value = PathUtils.PRODUCT_API_V1 + PathUtils.PRODUCT_UPDATE)
	public ResponseEntity<APIResponse> update(@RequestBody ProductUpdateRequest updateRequest) {
		Product product = productService.update(updateRequest);
		return ResponseUtils.responseSuccess(product);
	}

	@DeleteMapping(value = PathUtils.PRODUCT_API_V1 + PathUtils.PRODUCT_DELETES)
	public ResponseEntity<APIResponse> deleteAll(@RequestBody DeleteRequest deleteRequest) {
		productService.deletes(deleteRequest.getIds());
		return ResponseUtils.responseSuccess(ResponseSuccessMessage.DELETE_SUCCESS);
	}

	@GetMapping(value = PathUtils.PRODUCT_API_V1 + PathUtils.PRODUCT_GET_ALL)
	public ResponseEntity<APIResponse> productGetAll() {
		List<Product> products = productService.getAll();
		return ResponseUtils.responseSuccess(products);
	}

	@PostMapping(value = PathUtils.PRODUCT_API_V1 + PathUtils.VARIANT_API + PathUtils.VARIANT_CREATE )
	public ResponseEntity<APIResponse> createVariants(@RequestBody List<ProductVariantCreateRequest> createRequests) {
		productService.createVariants(createRequests);
		return ResponseUtils.responseSuccess(ResponseSuccessMessage.CREATE_SUCCESS);
	}
}
