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

import com.app.entity.Category;
import com.app.model.request.CategoryCreateRequest;
import com.app.model.request.CategoryFilter;
import com.app.model.request.CategoryUpdateRequest;
import com.app.service.CategoryService;
import com.core.model.request.DeleteRequest;
import com.core.model.response.APIResponse;
import com.core.model.response.ResponseSuccessMessage;
import com.core.utils.PathUtils;
import com.core.utils.ResponseUtils;

import lombok.AllArgsConstructor;

/**
 * category api
 * 
 * @author tamnc
 **/
@RestController
@AllArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;

	@PostMapping(value = PathUtils.CATEGORY_API_V1 + PathUtils.CATEGORY_PAGING_SEARCH_SORT_FILTER)
	public ResponseEntity<APIResponse> getListPagingSearchSortFilter(@RequestBody CategoryFilter categoryFilter, Pageable pageable) {
		Page<Category> page = categoryService.getListPagingSearchSortFilter(categoryFilter, pageable);
		return ResponseUtils.responseSuccess(page);
	}

	@GetMapping(value = PathUtils.CATEGORY_API_V1 + PathUtils.CATEGORY_GET_BY_ID)
	public ResponseEntity<APIResponse> getById(@PathVariable("id") Long id) {
		Category category = categoryService.findById(id);
		return ResponseUtils.responseSuccess(category);
	}

	@PostMapping(value = PathUtils.CATEGORY_API_V1 + PathUtils.CATEGORY_CREATE)
	public ResponseEntity<APIResponse> create(@RequestBody CategoryCreateRequest createRequest) {
		Category category = categoryService.create(createRequest);
		return ResponseUtils.responseSuccess(category);
	}

	@PutMapping(value = PathUtils.CATEGORY_API_V1 + PathUtils.CATEGORY_UPDATE)
	public ResponseEntity<APIResponse> update(@RequestBody CategoryUpdateRequest updateRequest) {
		Category category = categoryService.update(updateRequest);
		return ResponseUtils.responseSuccess(category);
	}

	@DeleteMapping(value = PathUtils.CATEGORY_API_V1 + PathUtils.CATEGORY_DELETES)
	public ResponseEntity<APIResponse> deleteAll(@RequestBody DeleteRequest deleteRequest) {
		categoryService.deletes(deleteRequest.getIds());
		return ResponseUtils.responseSuccess(ResponseSuccessMessage.DELETE_SUCCESS);
	}

	@GetMapping(value = PathUtils.CATEGORY_API_V1 + PathUtils.CATEGORY_GET_ALL)
	public ResponseEntity<APIResponse> getAll() {
		List<Category> categories = categoryService.getAll();
		return ResponseUtils.responseSuccess(categories);
	}
	
}
