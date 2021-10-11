package com.capitalone.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capitalone.model.Exchange;
import com.capitalone.proxy.ExchangeProxy;

@Service
public class ConversionService {

//	@Autowired
//	private ExchangeProxy exchangeProxy;
	
	public Exchange getConversion(String from, String to, Integer quantity) {
//		Exchange exchange = exchangeProxy.getExchange(from, to);
		Map<String, String> map = new HashMap<>();
		map.put("from", from);
		map.put("to", to);

		RestTemplate t = new RestTemplate();
		ResponseEntity<Exchange> forEntity = t.getForEntity("http://dev-lb-22205762.us-east-2.elb.amazonaws.com//exchange/from/{from}/to/{to}", 
				Exchange.class, map);
		Exchange exchange = forEntity.getBody();
		if(exchange == null) {
			return null;
		}
		
		exchange.setTotalCalculatedAmount(exchange.getRate() * quantity);
		return exchange;
	}

}
