package com.app.model.request;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleOrderCreateRequest {
	
	private BigDecimal price;
	
	private Integer quantity;
 
	private BigDecimal totalPrice;
	
	private BigDecimal discount;
	
	private BigDecimal amount;
 
	private String customerName;
 
	private String customerPhone;
 
	private String customerAddress;
	
	private String description;
	
	private List<SaleOrderDetailRequest> saleOrderDetails;
	
	@Getter
	@Setter
	public static class SaleOrderDetailRequest {
		
		private Long productId;
		
		private Long productVariantId;
		
		private BigDecimal price;
		
		private Integer quantity;
	 
		private BigDecimal totalPrice;
		
		private BigDecimal discount;
		
		private BigDecimal amount;
		
	}
}
