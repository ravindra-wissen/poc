package com.capitalone.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capitalone.model.Exchange;

@FeignClient(name = "exchange")
public interface ExchangeProxy {

	@GetMapping("exchange/from/{from}/to/{to}")
	public Exchange getExchange(@PathVariable String from, @PathVariable String to);
}
