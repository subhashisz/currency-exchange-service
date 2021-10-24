package com.myapp.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.myapp.bean.CurrencyExchange;
import com.myapp.repository.CurrencyExchangeRepository;

@Component
public class CurrencyExchangeHelper {

	private final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeHelper.class);

	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;

	public CurrencyExchange findByFromAndTo(String from, String to) {
		
		LOGGER.info("Inside findByFromAndTo of CurrencyExchangeController...........................");

		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to);
		}

		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}

}
