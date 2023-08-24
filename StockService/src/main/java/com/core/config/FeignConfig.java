package com.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.core.exception.CustomerErrorDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfig {

	@Bean
	ErrorDecoder errorDecoder() {
		return new CustomerErrorDecoder();
	}
}
