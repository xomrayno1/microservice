package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.entity.ProductVariant;
import com.app.enums.Status;
import com.app.exception.ValidateException;
import com.app.model.request.ProductCreateRequest;
import com.app.model.request.ProductPagingSearchSortFilter;
import com.app.model.request.ProductUpdateRequest;
import com.app.model.request.ProductVariantCreateRequest;
import com.app.model.response.APIResponse;
import com.app.model.response.APIStatus;
import com.app.model.response.ProductResponse;
import com.app.model.response.StockTotalResponse;
import com.app.repository.CategoryRepository;
import com.app.repository.ProductRepository;
import com.app.repository.ProductVariantRepository;
import com.app.service.ProductService;
import com.app.service.feign.StockClient;
import com.app.utils.Commons;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepo;

	private final CategoryRepository categoryRepo;
	
	private final ProductVariantRepository productVariantRepo;
 
	private final ModelMapper modelMapper;
	
	private final StockClient stockClient;

	
	@Override
	public Page<Product> getListPagingSearchSortFilter(ProductPagingSearchSortFilter filter, Pageable pageable) {
		return productRepo.findAll(filter.getSearchKey(), filter.getCategoryId(), filter.getStatus(), pageable);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Product create(ProductCreateRequest createRequest) {
		if (createRequest.getCategoryId() == null) {
			throw new ValidateException(APIStatus.ERR_CATEGORY_ID_NOT_EXISTS);
		}

		Category category = categoryRepo.findById(createRequest.getCategoryId())
				.orElseThrow(() -> new ValidateException(APIStatus.ERR_CATEGORY_NOT_EXISTS));

		Product newProduct = modelMapper.map(createRequest, Product.class);
		newProduct.setCode(Commons.generateProductCode());
		newProduct.setCategory(category);
		return productRepo.save(newProduct);
	}

	@Override
	public Product update(ProductUpdateRequest updateRequest) {
		if (updateRequest.getCategoryId() == null) {
			throw new ValidateException(APIStatus.ERR_CATEGORY_ID_NOT_EXISTS);
		}

		Category category = categoryRepo.findById(updateRequest.getCategoryId())
				.orElseThrow(() -> new ValidateException(APIStatus.ERR_CATEGORY_NOT_EXISTS));

		Product newProduct = modelMapper.map(updateRequest, Product.class);
		newProduct.setCode(Commons.generateProductCode());
		newProduct.setCategory(category);
		return productRepo.save(newProduct);
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			throw new ValidateException(APIStatus.ERR_PRODUCT_ID_NOT_EXISTS);
		}
		Product product = productRepo.findById(id)
				.orElseThrow(() -> new ValidateException(APIStatus.ERR_PRODUCT_NOT_EXISTS));
		product.setStatus(Status.DELETED);
		productRepo.save(product);
	}

	@Override
	public ProductResponse findById(Long id) {
		Product product = productRepo.findById(id).orElse(null);
		if(product == null) {
			return null;
		}
		
		ProductResponse productResponse = modelMapper.map(product, ProductResponse.class);
		productResponse.setCategory(modelMapper.map(product.getCategory(), ProductResponse.Category.class)); 
		productResponse.setProductVariants(product.getProductVariants().stream().map(item -> {
			StockTotalResponse stockTotalResponse =  stockClient.getByProductVariantId(item.getId()).getBody().getData();
			Long quantity = 0L;
			if(stockTotalResponse != null) {
				quantity = stockTotalResponse.getQuantity();
			}
			return new ProductResponse.ProductVariant(item.getName(), item.getCode(), item.getPrice(), quantity);
		}).toList());
		
		return productResponse;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deletes(List<Long> ids) {
		if (Commons.isNullOrEmpty(ids)) {
			throw new ValidateException(APIStatus.ERR_PRODUCT_ID_NOT_EXISTS);
		}
		List<Product> listDelete = productRepo.findAllById(ids);
		listDelete.forEach(item -> item.setStatus(Status.DELETED));
		productRepo.saveAll(listDelete);
	}

	@Override
	public List<Product> getAll() {
		return productRepo.findByStatus(Status.ACTIVE);
	}

	@Override
	@Transactional
	public void createVariants(List<ProductVariantCreateRequest> createRequests) {
		 List<ProductVariant> productVariants = createRequests.stream().map(item -> {
			 ProductVariant productVariant = new ProductVariant();
			 BeanUtils.copyProperties(item, productVariant);
			 Product product = productRepo.findById(item.getProductId()).orElse(null);
			 productVariant.setProduct(product);
			 return productVariant;
		 }).toList();
		productVariantRepo.saveAll(productVariants);
	}
}
