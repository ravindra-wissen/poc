package com.capitalone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capitalone.model.Exchange;

@RestController
public class HealthCheckController {

	@GetMapping("/health")
	public ResponseEntity<Exchange> getHealthcheck(@PathVariable String from, @PathVariable String to) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
