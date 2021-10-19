package com.capitalone.dynamodb.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitalone.dynamodb.repository.ExchangeDynamoDbRepository;
import com.capitalone.model.Exchange;

@Service
public class ExchangeDynamodbService {

	@Autowired
	private ExchangeDynamoDbRepository dbRepository;

	public void save(Exchange exchangeDb) {
		com.capitalone.dynamodb.model.Exchange exchangeDynamodb = new com.capitalone.dynamodb.model.Exchange();
		BeanUtils.copyProperties(exchangeDb, exchangeDynamodb);
		exchangeDynamodb.setUpdatedDate(new Date());
		
		dbRepository.save(exchangeDynamodb);

	}

}
