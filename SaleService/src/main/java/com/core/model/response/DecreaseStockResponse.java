package com.core.model.response;

import com.core.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DecreaseStockResponse {
	
	private Long saleOrderId;
	
	private OrderStatus orderStatus;
	
	private String reason;

}
