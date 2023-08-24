package com.app.service.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.service.saga.CreateSaleOrderSaga;
import com.core.enums.OrderStatus;
import com.core.model.response.DecreaseStockResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class SaleOrderListener {
 
	private final CreateSaleOrderSaga createSaleOrderSaga;
	
	@KafkaListener(id = "saleOrderGroup", topics = "create-sale-order-response")
	@Transactional(rollbackFor = Exception.class)
	public void createSaleOrder(DecreaseStockResponse response) throws Exception {
		log.info("listener event topic create-sale-order-response sale order id : {}  with order status : {} ", response.getSaleOrderId(), response.getOrderStatus().name());
		if(response.getOrderStatus().equals(OrderStatus.CANCEL_BY_SYSTEM)) {
			createSaleOrderSaga.rollback(response);
		}else {
			createSaleOrderSaga.process(response);
		}
	}

}
