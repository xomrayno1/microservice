package com.app.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.model.response.APIResponse;
import com.app.model.response.APIStatus;
import com.app.model.response.ResponseSuccessMessage;

public class ResponseUtils {
	private ResponseUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static ResponseEntity<APIResponse> responseSuccess(Object data) {
		return buildResponse(APIStatus.OK, data, HttpStatus.OK);
	}
	
	public static ResponseEntity<APIResponse> responseSuccess(ResponseSuccessMessage responseSuccessMessage) {
		return buildResponse(APIStatus.OK, responseSuccessMessage.getMessage(), HttpStatus.OK);
	}

	public static ResponseEntity<APIResponse> buildResponse(APIStatus apiStatus, Object data, HttpStatus httpStatus) {
		return new ResponseEntity<>(new APIResponse<Object>(apiStatus, data), httpStatus);
	}

}
