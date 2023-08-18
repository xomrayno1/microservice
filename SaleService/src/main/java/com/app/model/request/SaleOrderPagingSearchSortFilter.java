package com.app.model.request;

import java.time.LocalDate;

import com.app.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleOrderPagingSearchSortFilter {
	
	private String orderNumber;
	private Status status;
	private String customerNameOrPhone;
	private LocalDate fromDate;
	private LocalDate toDate;
	
}
