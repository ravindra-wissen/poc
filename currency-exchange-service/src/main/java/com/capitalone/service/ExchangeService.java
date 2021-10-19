package com.capitalone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitalone.dynamodb.service.ExchangeDynamodbService;
import com.capitalone.model.Exchange;
import com.capitalone.repository.ExchangeRepository;

@Service
public class ExchangeService {

	@Autowired
	private ExchangeRepository exchangeRepository;
	
	@Autowired
	private ExchangeDynamodbService exchangeDynamodbService;
	
	public Exchange getExchangeByFromAndTo(String from, String to) {
		return exchangeRepository.findByExchangeFromAndExchangeTo(from, to).orElse(null);
	}

	public List<Exchange> getAllExchange() {
		return exchangeRepository.findAll();
	}

	public Exchange createExchange(Exchange exchange) {
		// Check for already exists
		Exchange exchangeDb = getExchangeByFromAndTo(exchange.getExchangeFrom(), exchange.getExchangeTo());

		if (exchangeDb != null) {
			return exchangeDb;
		}
		
		Exchange savedExchange =  exchangeRepository.save(exchange);
		exchangeDynamodbService.save(savedExchange);
		
		return savedExchange;
	}

	public void deleteExchange(Long exchangeId) {
		Exchange exchange = exchangeRepository.findById(exchangeId).orElse(null);
		if(exchange != null) {
			exchangeRepository.delete(exchange);
		}
		
	}

	public Exchange updateExchange(Exchange exchange) {
		Exchange exchangeDb = getExchangeByFromAndTo(exchange.getExchangeFrom(), exchange.getExchangeTo());
		if(exchangeDb != null && !exchangeDb.getExchangeId().equals(exchange.getExchangeId())) {
			return exchangeDb;
		}
		exchangeDb = exchangeRepository.findById(exchange.getExchangeId()).orElse(null);
		if (exchange != null) {
			exchangeDb.setExchangeFrom(exchange.getExchangeFrom());
			exchangeDb.setExchangeTo(exchange.getExchangeTo());
			exchangeDb.setRate(exchange.getRate());

			exchangeDb = exchangeRepository.save(exchangeDb);
			exchangeDynamodbService.save(exchangeDb);

		}

		return exchangeDb;
	}

}
