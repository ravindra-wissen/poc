package com.capitalone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capitalone.model.Exchange;
import com.capitalone.service.ConversionService;

@RestController
public class ConversionController {

	@Autowired
	private ConversionService conversionService;

	@GetMapping("from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<Exchange> getConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable Integer quantity) {

		Exchange exchange = conversionService.getConversion(from, to, quantity);
		return new ResponseEntity<>(exchange, HttpStatus.OK);
	}

}
