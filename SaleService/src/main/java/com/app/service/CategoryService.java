package com.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.entity.Category;
import com.app.model.request.CategoryCreateRequest;
import com.app.model.request.CategoryFilter;
import com.app.model.request.CategoryUpdateRequest;

public interface CategoryService {
	Page<Category> getListPagingSearchSortFilter(CategoryFilter categoryFilter, Pageable pageable);
	
	Category create(CategoryCreateRequest createRequest);
	
	Category update(CategoryUpdateRequest updateRequest);
	
	void delete(Long id);
	
	Category findById(Long id);
	
	void deletes(List<Long> ids);
	
	List<Category> getAll();
}
