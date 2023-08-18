package com.app.model.event;

import com.app.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSaleOrderResponseEvent {
	private Long saleOrderId;
	
	private OrderStatus orderStatus;
	
	private String reason;
}
