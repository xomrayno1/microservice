package com.app.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateRequest {
	private String name;
	private Long categoryId;
}
