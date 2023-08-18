package com.app.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryCreateRequest {
	private String code;
	private String name;
	private Long parentId;
	private Integer level;
 

}