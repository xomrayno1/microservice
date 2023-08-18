package com.app.model.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVariantCreateRequest {
	
	private String name;
	private String code;
	private BigDecimal price;
	private Long productId;

}
