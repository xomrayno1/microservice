package com.app.entity;

import java.util.List;

import com.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
	
	private static final long serialVersionUID = -3916747687569884477L;

	private String code;
	
	private String name;
	 
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Category parentCategory;
	
	private Integer level;
	
	@OneToMany(mappedBy = "category")
	@JsonBackReference
	private List<Product> products;

}
