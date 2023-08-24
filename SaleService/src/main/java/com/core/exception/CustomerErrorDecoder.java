package com.core.exception;

import java.io.IOException;

import com.core.model.response.APIStatus;
import com.core.model.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomerErrorDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ErrorResponse erorRespose = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
			return new ValidateException(erorRespose.getErrorCode(), erorRespose.getErrorMessage());
		} catch (IOException e) {
			throw new ValidateException(APIStatus.INTERNAL_SERVER_ERROR);
		} 
	}

}
