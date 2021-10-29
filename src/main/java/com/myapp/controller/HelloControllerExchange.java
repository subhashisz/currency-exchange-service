package com.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class HelloControllerExchange {

	private final Logger LOGGER = LoggerFactory.getLogger(HelloControllerExchange.class);

	@GetMapping("/")
	public String hello() {
		LOGGER.trace("A TRACE Message");
		LOGGER.debug("A DEBUG Message");
		LOGGER.info("An INFO Message");
		LOGGER.warn("A WARN Message");
		LOGGER.error("An ERROR Message");
		LOGGER.info("Inside hello of HelloControllerExchange...........................");
		return "from currency-exchange path=/ ";
	}

	@GetMapping("/hello-url")
	public String helloUrl() {
		LOGGER.info("Inside helloUrl of HelloControllerExchange........................");
		return "from currency-exchange path=/exchange ";
	}

}
