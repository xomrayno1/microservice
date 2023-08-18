package com.app.model.event;

import java.util.List;

import com.app.entity.SaleOrderDetail;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateSaleOrderEvent {
	private List<SaleOrderDetail> saleOrderDetail;
	private String orderNumber;
	private Long saleOrderId;
 
}
