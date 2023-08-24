package com.core.model.request;

import java.util.List;

import lombok.Getter;

@Getter
public class DeleteRequest {
	private List<Long> ids;
}