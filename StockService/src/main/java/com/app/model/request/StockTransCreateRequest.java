package com.app.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockTransCreateRequest {
	private String name;
	private Long categoryId;
}
