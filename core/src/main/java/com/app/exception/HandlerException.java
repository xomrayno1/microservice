package com.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ValidateException.class)
	private ResponseEntity<ErrorDetail> handleValidateException(ValidateException exception, WebRequest request){
		ErrorDetail error = new ErrorDetail(exception.getCode(), exception.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
}
