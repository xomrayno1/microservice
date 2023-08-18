package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Category;
import com.app.enums.Status;

@Repository
public interface CategoryRepository extends JpaSpecificationExecutor<Category>, CrudRepository<Category, Long>{
	
	 
	@Query(" SELECT c FROM Category c where c.status = :status "
			+ " and ( COALESCE(:codeOrName, null) is null or c.code like :codeOrName or c.name like :codeOrName ) "
			)
	Page<Category> findAll(String codeOrName, Status status, Pageable pageable);
	
	
	Optional<Category> findByCode(String code);

	List<Category> findByIdIn(List<Long> ids);
	
	List<Category> findByStatus(Status status);

}
