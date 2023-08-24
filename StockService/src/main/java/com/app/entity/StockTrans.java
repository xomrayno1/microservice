package com.app.entity;

import java.time.LocalDateTime;

import com.core.entity.BaseEntity;
import com.core.enums.StockTransType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_trans")
public class StockTrans extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "total_quantity")
	private Long totalQuantity;
	
	@Column(name = "date_time")
	private LocalDateTime dateTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "stock_trans_type")
	private StockTransType stockTransType;

}
