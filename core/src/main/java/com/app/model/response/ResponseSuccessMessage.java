package com.app.model.response;

import lombok.Getter;

@Getter
public enum ResponseSuccessMessage {
	DELETE_SUCCESS("Xoá thành công"),
	CREATE_SUCCESS("Tạo thành công")
	;
	
	private String message;
	
	ResponseSuccessMessage(String message) {
		this.message = message;
	}
	
}
