package com.app.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockTransRequest {
	private Long id;
	private String name;
	private String description;
	private Long categoryId;
}
