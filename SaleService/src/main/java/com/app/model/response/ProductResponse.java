package com.app.model.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	private String name;
	private String code;
	private String description;
	private Category category;
	private List<ProductVariant> productVariants;
	 
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Category {
		private Long id;
		private String name;
	}
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ProductVariant{
		private String name;
		private String code;
		private BigDecimal price;
		private Long quantity;
	}
}
