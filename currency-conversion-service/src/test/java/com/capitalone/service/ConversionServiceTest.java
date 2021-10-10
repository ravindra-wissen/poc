package com.capitalone.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capitalone.model.Exchange;
import com.capitalone.proxy.ExchangeProxy;

public class ConversionServiceTest {

	@InjectMocks
	private ConversionService conversionService;

	@Mock
	private ExchangeProxy exchangeProxy;

	private Exchange exchange;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		exchange = new Exchange();
		exchange.setExchangeFrom("from");
		exchange.setTotalCalculatedAmount(1f);
		exchange.setExchangeTo("to");
		exchange.setRate(1.1f);
	}

	@Test
	public void getConversionTest() {
//		when(exchangeProxy.getExchange("from", "to")).thenReturn(exchange);
		Exchange result = conversionService.getConversion("from", "to", 10);
		Assert.assertNotNull(result);

	}
}
