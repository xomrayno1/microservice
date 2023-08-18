package com.app.model.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DecreaseStockRequest {
	private Long saleOrderId;
	private List<Stock> stocks;
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Stock {
		private Long productVariantId;
		private Integer quantity;
		private String productVariantNameFull;
	}
}
