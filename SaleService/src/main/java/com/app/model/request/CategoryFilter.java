package com.app.model.request;

import com.app.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryFilter {
	private String searchKey;
	private Status status;
}
