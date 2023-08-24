package com.app.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.core.entity.BaseEntity;
import com.core.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sale_order")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleOrder extends BaseEntity{
	
	private static final long serialVersionUID = 7255181419679754778L;

	@Column(name = "order_date")
	private LocalDateTime orderDate;
	
	@Column(name = "order_number")	
	private String orderNumber;

	private BigDecimal price;
	
	private Integer quantity;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	
	private BigDecimal discount;
	
	private BigDecimal amount;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_phone")
	private String customerPhone;
	
	@Column(name = "customer_address")
	private String customerAddress;
	
	private String description;
	
	@Column(name = "order_status")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	private String note;
	
	@OneToMany(mappedBy = "saleOrder", cascade = CascadeType.PERSIST)
	@JsonBackReference
	private List<SaleOrderDetail> saleOrderDetails;
	
}
