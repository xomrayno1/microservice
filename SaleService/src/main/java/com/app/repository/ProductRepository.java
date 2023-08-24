package com.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.Product;
import com.core.enums.Status;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>, CrudRepository<Product, Long> {
	
	@Query(" SELECT p FROM Product p "
			+ "	where p.status = :status "
			+ " and ( COALESCE(:codeOrName, null) is null or p.code like :codeOrName or p.name like :codeOrName ) "
			+ " and p.category.id = :categoryId  "
			)
	Page<Product> findAll(String codeOrName, Long categoryId, Status status, Pageable pageable);
	
	List<Product> findByStatus(Status status);
	
	Product findByCode(String code);
}
