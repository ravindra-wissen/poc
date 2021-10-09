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
import com.capitalone.service.ConversionService;

@RunWith(MockitoJUnitRunner.class)
public class ConversionControllerTests {

	@Mock
	private ConversionService conversionService;

	@InjectMocks
	private ConversionController conversionController;

	private Exchange exchange;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		exchange = new Exchange();
	}

	@Test
	public void getConversionTest() {
		when(conversionService.getConversion("usd", "inr", 10)).thenReturn(exchange);
		ResponseEntity<Exchange> result = conversionController.getConversion("usd", "inr", 10);
		Assert.assertNotNull(result);
	}
}
