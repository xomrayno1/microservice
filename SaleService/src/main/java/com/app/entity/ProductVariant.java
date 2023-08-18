package com.app.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product_variant")
public class ProductVariant extends BaseEntity{
	 

	private static final long serialVersionUID = -1650126434522053133L;
	
	private String name;
	private String code;
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonManagedReference
	private Product product;
}
