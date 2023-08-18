package com.app.model.request;

import com.app.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockTransPagingSearchSortFilter {
	private String searchKey;
	private Long categoryId;
	private Status status;
}