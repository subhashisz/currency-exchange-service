package com.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/sample-api")
	@Retry(name = "failure", fallbackMethod = "errorResponse")
	public String sampleApi() {
		logger.info(" Failed sampleApi call .....................");
		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:9999/error", String.class);
		return entity.getBody();
	}

	public String errorResponse(Exception ex) {
		return "Error happened Rejilience4j.......................";
	}
}
