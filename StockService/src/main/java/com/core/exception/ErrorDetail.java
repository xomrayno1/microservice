package com.core.exception;

import java.time.LocalDateTime;
import java.util.Map;

import com.core.model.response.APIStatus;
import com.core.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ErrorDetail {
	private final int code;
	private final String message;
	@JsonFormat(shape = Shape.STRING, pattern = DateUtils.PATTERN_DATE_TIME_FORMAT)
	private final LocalDateTime time;
	@Setter
	private Map<String, String> error;
	
	public ErrorDetail(int code, String message, LocalDateTime time) {
		this.code = code;
		this.message = message;
		this.time = time;
	}
 
	public ErrorDetail(APIStatus apiStatus, LocalDateTime time) {
		if(apiStatus == null) {
			throw new IllegalArgumentException("apiStatus invalid"); 
		}
		this.code = apiStatus.getCode();
		this.message = apiStatus.getMessage();
		this.time = time;
	}
  
}