package com.capitalone.dynamodb.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capitalone.dynamodb.model.Exchange;

@EnableScan
public interface ExchangeDynamoDbRepository extends CrudRepository<Exchange, String>{

		
	
}
