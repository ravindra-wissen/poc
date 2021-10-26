package com.capitalone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capitalone.model.Exchange;
import com.capitalone.service.ExchangeService;

@RestController
public class ExchangeController { 

	@Autowired
	private ExchangeService exchangeService;

	@GetMapping("/from/{from}/to/{to}")
	public ResponseEntity<Exchange> getExchange(@PathVariable String from, @PathVariable String to) {

		Exchange exchange = exchangeService.getExchangeByFromAndTo(from, to);
		return new ResponseEntity<>(exchange, HttpStatus.OK);
	}

	@GetMapping("/exchanges")
	public ResponseEntity<List<Exchange>> getAllExchange() {

		List<Exchange> exchange = exchangeService.getAllExchange();
		return new ResponseEntity<>(exchange, HttpStatus.OK);
	}

	@PostMapping("/exchanges")
	public ResponseEntity<Exchange> createExchange(@RequestBody Exchange exchange) {

		Exchange exchangeDb = exchangeService.createExchange(exchange);
		return new ResponseEntity<>(exchangeDb, HttpStatus.CREATED);
	}

	@DeleteMapping("/exchanges/{exchangeId}")
	public ResponseEntity<Exchange> deleteExchange(@PathVariable Long exchangeId) {

		exchangeService.deleteExchange(exchangeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/exchanges")
	public ResponseEntity<Exchange> updateExchange(@RequestBody Exchange exchange) {
		Exchange exchangedb = exchangeService.updateExchange(exchange);
		return new ResponseEntity<>(exchangedb, HttpStatus.OK);
	}
}
