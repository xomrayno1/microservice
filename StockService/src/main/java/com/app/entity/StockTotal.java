package com.app.entity;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock_total")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockTotal extends BaseEntity {
	
	private static final long serialVersionUID = -5446927198663995118L;

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
	private String categoryName;
	
	@Comment("số lượng ")
	private Long quantity;
 
}
