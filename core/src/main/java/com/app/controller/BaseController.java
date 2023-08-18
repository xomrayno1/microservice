package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.model.response.APIResponse;
import com.app.model.response.APIStatus;
 

public class BaseController {
 

	public static <T> ResponseEntity<APIResponse<T>> responseSuccess(T data) {
		return buildResponse(APIStatus.OK, data, HttpStatus.OK);
	}
	
//	public static <T>  ResponseEntity<APIResponse<T>> responseSuccess(ResponseSuccessMessage responseSuccessMessage) {
//		return buildResponse(APIStatus.OK, responseSuccessMessage.getMessage(), HttpStatus.OK);
//	}

	public static <T>  ResponseEntity<APIResponse<T>> buildResponse(APIStatus apiStatus, T data, HttpStatus httpStatus) {
		return new ResponseEntity<APIResponse<T>>(new APIResponse<T>(apiStatus, data), httpStatus);
	}
	
	 
}
