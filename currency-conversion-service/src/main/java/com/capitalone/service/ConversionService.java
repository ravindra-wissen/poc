package com.capitalone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitalone.model.Exchange;
import com.capitalone.proxy.ExchangeProxy;

@Service
public class ConversionService {

	@Autowired
	private ExchangeProxy exchangeProxy;
	
	public Exchange getConversion(String from, String to, Integer quantity) {
		Exchange exchange = exchangeProxy.getExchange(from, to);
		if(exchange == null) {
			return null;
		}
		
		exchange.setTotalCalculatedAmount(exchange.getRate() * quantity);
		return exchange;
	}

}
