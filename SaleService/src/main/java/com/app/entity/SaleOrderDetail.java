package com.app.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sale_order_detail")
@Builder
public class SaleOrderDetail extends BaseEntity{
	
	private static final long serialVersionUID = 6190191207052127415L;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "product_variant_id")
	private ProductVariant productVariant;
	
	private BigDecimal price;
	
	private Integer quantity;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	
	private BigDecimal discount;
	
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name = "sale_order_id")
	@JsonManagedReference
	private SaleOrder saleOrder;

}
