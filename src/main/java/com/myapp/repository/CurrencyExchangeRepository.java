package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.bean.CurrencyExchange;

public interface CurrencyExchangeRepository 
	extends JpaRepository<CurrencyExchange, Long> {
	CurrencyExchange findByFromAndTo(String from, String to);
}
