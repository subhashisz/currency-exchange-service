package com.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerExchange {

	@GetMapping("/")
	public String hello() {
		return "from currency-exchange path=/ ";
	}

	@GetMapping("/exchange")
	public String helloUrl() {
		return "from currency-exchange path=/exchange ";
	}

}
