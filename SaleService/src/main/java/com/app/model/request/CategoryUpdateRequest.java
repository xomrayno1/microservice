package com.app.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryUpdateRequest {
	private Long id;
	private String name;
	private Long parentId;
	private Integer level;
}