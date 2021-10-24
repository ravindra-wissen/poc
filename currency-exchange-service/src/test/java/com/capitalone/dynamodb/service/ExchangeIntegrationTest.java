package com.capitalone.dynamodb.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.capitalone.CurrencyExchangeServiceApplication;
import com.capitalone.dynamodb.model.Exchange;
import com.capitalone.dynamodb.repository.ExchangeDynamoDbRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CurrencyExchangeServiceApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
//@TestPropertySource(properties = { "amazon.dynamodb.endpoint=http://localhost:8001/" })
public class ExchangeIntegrationTest {

	private DynamoDBMapper dynamoDBMapper;

	@Autowired
	private AmazonDynamoDB amazonDynamoDB;

	@Autowired
	ExchangeDynamoDbRepository repository;

	@Before
	public void setup() throws Exception {
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

//		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Exchange.class);
//		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
//		List<String> tables = amazonDynamoDB.listTables().getTableNames();
//		if(!tables.isEmpty() && tables.contains("exchange")) {
//			amazonDynamoDB.deleteTable(new DeleteTableRequest("exchange"));
//			amazonDynamoDB.createTable(tableRequest);
//			
//		} else {
//			amazonDynamoDB.createTable(tableRequest);
//		}
	}

	@Test
	public void givenItemWithExpectedCost_whenRunFindAll_thenItemIsFound() {
		Exchange exchange = new Exchange();
		exchange.setExchangeFrom("usd");
		exchange.setExchangeTo("inr");
		exchange.setRate(78f);
		exchange.setUpdatedDate(new Date());
		
		repository.save(exchange);
		List<Exchange> result = (List<Exchange>) repository.findAll();

		assertThat(result.size(), is(greaterThan(0)));
//		assertThat(result.get(0).getRate(), is(equalTo(78f)));
	}
}