package com.app.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateRequest {
	private Long id;
	private String name;
	private String description;
	private Long categoryId;
}
