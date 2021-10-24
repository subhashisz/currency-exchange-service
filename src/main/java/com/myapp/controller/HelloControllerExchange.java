package com.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerExchange {
	
	private final Logger LOGGER = LoggerFactory.getLogger(HelloControllerExchange.class);

	@GetMapping("/")
	public String hello() {
		LOGGER.info("Inside hello of HelloControllerExchange");
		return "from currency-exchange path=/ ";
	}

	@GetMapping("/exchange")
	public String helloUrl() {
		LOGGER.info("Inside helloUrl of HelloControllerExchange");
		return "from currency-exchange path=/exchange ";
	}

}
