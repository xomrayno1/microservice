package com.core.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockTotalResponse implements Serializable{
 
	private static final long serialVersionUID = -3617427137800501956L;
	
	private Long productId;
	private String productName; 
	private Long productVariantId;
	private String productVariantName; 
	private Long categoryId;
	private String categoryName;
	private Long quantity;
}
