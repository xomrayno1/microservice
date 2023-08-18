package com.app.CloudGateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@GetMapping("/orderServiceFallBack")
	public String orderServiceFallback() {
		return "Order service is down!";
	}
	
	
}
