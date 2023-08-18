package com.app.entity;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "stock_trans_detail")
public class StockTransDetail extends BaseEntity {
	
	private static final long serialVersionUID = 1897491781599550542L;

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_variant_id")
	private Long productVariantId;
	
	@Column(name = "product_variant_name")
	private String productVariantName; 

	@Column(name = "category_id")
	private Long categoryId;
	
	@Column(name = "category_name")
	private Long categoryName;
	
	@Comment("số lượng ")
	private Long quantity;

}
