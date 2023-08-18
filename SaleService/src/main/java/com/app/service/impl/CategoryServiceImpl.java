package com.app.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Category;
import com.app.enums.Status;
import com.app.exception.ValidateException;
import com.app.model.request.CategoryCreateRequest;
import com.app.model.request.CategoryFilter;
import com.app.model.request.CategoryUpdateRequest;
import com.app.model.response.APIStatus;
import com.app.repository.CategoryRepository;
import com.app.service.CategoryService;
import com.app.utils.Commons;
import com.app.utils.StringUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository cateRepository;

	
	@Override
	public Page<Category> getListPagingSearchSortFilter(CategoryFilter categoryFilter, Pageable pageable) {
		 return cateRepository.findAll(categoryFilter.getSearchKey(), categoryFilter.getStatus(), pageable);
	}

	@Override
	public Category create(CategoryCreateRequest createRequest) {
		String code = createRequest.getCode();
		if (StringUtils.isNullOrEmpty(code)) {
			code = Commons.generateCategoryCode();
		}

		Category category = new Category();
		category.setCode(code);
		category.setName(createRequest.getName());
		Category parentCategory = cateRepository.findById(createRequest.getParentId()).orElse(null);
		category.setParentCategory(parentCategory);
		category.setLevel(createRequest.getLevel());
		return cateRepository.save(category);
	}

	@Override
	public Category update(CategoryUpdateRequest updateRequest) {
		if (updateRequest.getId() == null) {
			throw new ValidateException(APIStatus.ERR_CATEGORY_ID_NOT_EXISTS);
		}

		Category category = cateRepository.findById(updateRequest.getId())
				.orElseThrow(() -> new ValidateException(APIStatus.ERR_CATEGORY_NOT_EXISTS));
		category.setName(updateRequest.getName());
		Category parentCategory = cateRepository.findById(updateRequest.getParentId()).orElse(null);
		category.setParentCategory(parentCategory);
		category.setLevel(updateRequest.getLevel());
		return cateRepository.save(category);
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			throw new ValidateException(APIStatus.ERR_CATEGORY_ID_NOT_EXISTS);
		}
		Category category = cateRepository.findById(id)
				.orElseThrow(() -> new ValidateException(APIStatus.ERR_CATEGORY_NOT_EXISTS));
		category.setStatus(Status.DELETED);
		cateRepository.save(category);
	}

	@Override
	public Category findById(Long id) {
		return cateRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deletes(List<Long> ids) {
		if (Commons.isNullOrEmpty(ids)) {
			throw new ValidateException(APIStatus.ERR_CATEGORY_ID_NOT_EXISTS);
		}
		List<Category> listDelete = cateRepository.findByIdIn(ids);
		for (Category category : listDelete) {
			category.setStatus(Status.DELETED);
		}

		cateRepository.saveAll(listDelete);
	}

	@Override
	public List<Category> getAll() {
		return cateRepository.findByStatus(Status.ACTIVE);
	}
}
