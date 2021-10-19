package com.capitalone.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capitalone.dynamodb.service.ExchangeDynamodbService;
import com.capitalone.model.Exchange;
import com.capitalone.repository.ExchangeRepository;

public class ExchangeServiceTest {

	@InjectMocks
	private ExchangeService exchangeService;

	@Mock
	private ExchangeDynamodbService exchangeDynamodbService;
	
	@Mock
	private ExchangeRepository exchangeRepository;

	private Exchange exchange;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	
		exchange = new Exchange();
		exchange.setExchangeFrom("from");
		exchange.setExchangeId(1l);
		exchange.setExchangeTo("to");
		exchange.setRate(1.1f);
	}

	@Test
	public void getExchangeByFromAndToTest() {
		when(exchangeRepository.findByExchangeFromAndExchangeTo("from", "to")).thenReturn(Optional.of(exchange));
		Exchange result = exchangeService.getExchangeByFromAndTo("from", "to");
		Assert.assertNotNull(result);

	}

	

	@Test
	public void getAllExchangeTest() {
		when(exchangeRepository.findAll()).thenReturn(Arrays.asList(exchange));
		List<Exchange> result = exchangeService.getAllExchange();
		Assert.assertNotNull(result);

	}
	

	@Test
	public void createExchangeTest() {
		when(exchangeRepository.save(exchange)).thenReturn(exchange);
		when(exchangeRepository.save(exchange)).thenReturn(exchange);
		
		Exchange result = exchangeService.createExchange(exchange);
		Assert.assertNotNull(result);

	}
	

	@Test
	public void deleteExchangeTest() {
		when(exchangeRepository.findById(1l)).thenReturn(Optional.of(exchange));
		exchangeService.deleteExchange(1l);

	}
	

	@Test
	public void updateExchangeTest() {
		when(exchangeRepository.findById(exchange.getExchangeId())).thenReturn(Optional.of(exchange));
		exchangeService.updateExchange(exchange);
	}
	
	
}
