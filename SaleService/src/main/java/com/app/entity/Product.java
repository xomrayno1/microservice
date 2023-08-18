package com.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product extends BaseEntity {
 
	private static final long serialVersionUID = -2149848180427787818L;
	
	private String name;
	private String code;
	private String description;
 
	@ManyToOne
	@JoinColumn(name = "category")
	@JsonManagedReference
	private Category category;
	
	@OneToMany(mappedBy = "product")
	@JsonBackReference
	private List<ProductVariant> productVariants;

	
	
}
