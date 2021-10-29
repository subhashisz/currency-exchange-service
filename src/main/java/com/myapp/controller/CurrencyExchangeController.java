package com.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.bean.CurrencyExchange;
import com.myapp.helper.CurrencyExchangeHelper;
import com.myapp.repository.CurrencyExchangeRepository;

@RestController
//@RequestMapping("/exchange")
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

	private final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;

	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		LOGGER.info("Inside retrieveExchangeValue of CurrencyExchangeController...........................");
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to);
		}

		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);

		return currencyExchange;

	}

	/*
	 * @Autowired private CurrencyExchangeHelper helper;
	 * 
	 * @GetMapping("/currency-exchange/from/{from}/to/{to}") public CurrencyExchange
	 * retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
	 * LOGGER.
	 * info("Inside retrieveExchangeValue of CurrencyExchangeController..........................."
	 * ); return helper.findByFromAndTo(from, to);
	 * 
	 * }
	 */

}
