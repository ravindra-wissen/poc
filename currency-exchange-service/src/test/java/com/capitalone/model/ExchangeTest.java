package com.capitalone.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ExchangeTest {

	@InjectMocks
	private Exchange exchange;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getExchangeFromTest() {
		exchange.setExchangeFrom("title");
		String result = exchange.getExchangeFrom();
		assertEquals(result, "title");

	}

	@Test
	public void getExchangeIdTest() {
		exchange.setExchangeId(1l);
		Long result = exchange.getExchangeId();
		assertEquals(result, Long.valueOf(1l));

	}

	@Test
	public void getRateTest() {
		exchange.setRate(1.1f);
		Float result = exchange.getRate();
		assertEquals(result, Float.valueOf(1.1f));

	}

	@Test
	public void getExchangeToTest() {
		exchange.setExchangeTo("Description");
		String result = exchange.getExchangeTo();
		assertEquals(result, "Description");

	}
}
