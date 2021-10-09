package com.capitalone.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.capitalone.model.Exchange;
//import com.capitalone.post.model.Post;
import com.capitalone.service.ExchangeService;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeControllerTests {

	@Mock
	private ExchangeService exchangeService;

	@InjectMocks
	private ExchangeController exchangeController;

	private Exchange exchange;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		exchange = new Exchange();
	}

	@Test
	public void getAllExchangeTest() {
		when(exchangeService.getAllExchange()).thenReturn(Arrays.asList(exchange));
		ResponseEntity<List<Exchange>> result = exchangeController.getAllExchange();
		Assert.assertNotNull(result);
	}
	
	@Test
	public void createExchangeTest() {
		when(exchangeService.createExchange(exchange)).thenReturn(exchange);
		ResponseEntity<Exchange> result = exchangeController.createExchange(exchange);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void deleteExchangeTest() {
		ResponseEntity<Exchange> result = exchangeController.deleteExchange(1l);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void updateExchangeTest() {
		when(exchangeService.updateExchange(exchange)).thenReturn(exchange);
		ResponseEntity<Exchange> result = exchangeController.updateExchange(exchange);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void getExchangeTest() {
		when(exchangeService.getExchangeByFromAndTo("usd", "inr")).thenReturn(exchange);
		ResponseEntity<Exchange> result = exchangeController.getExchange("usd", "inr");
		Assert.assertNotNull(result);
	}
}
