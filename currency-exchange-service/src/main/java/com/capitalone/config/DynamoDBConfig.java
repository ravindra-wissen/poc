package com.capitalone.config;

import java.util.UUID;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.capitalone.kinesis.consumer.kinesis.processor.RecordProcessorFactory;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cloudwatch.CloudWatchAsyncClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.kinesis.common.ConfigsBuilder;
import software.amazon.kinesis.common.KinesisClientUtil;
//import com.amazonaws.services.kinesis.AmazonKinesis;
//import com.amazonaws.services.kinesis.AmazonKinesisClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.capitalone.dynamodb.repository")
public class DynamoDBConfig {

	@Value("${amazon.dynamodb.endpoint}")
	private String amazonDynamoDBEndpoint;

	@Value("${aws.stream-name}")
	private String streamName;
	
	@Value("${application.name}")
	private String applicationName;
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new EndpointConfiguration(amazonDynamoDBEndpoint, "us-east-2")).build();
		return db;
	}
	
//	@Bean
//	public AmazonKinesis buildAmazonKinesis() {
//		
//		AmazonKinesis ak = AmazonKinesisClientBuilder
//				.standard()
//				.withEndpointConfiguration(new EndpointConfiguration(amazonDynamoDBEndpoint, "us-east-2"))
//				.build();
//		
//		return ak;
//	}

	@Bean
	public ConfigsBuilder getConfigBuilder() {
		Region region = Region.of("us-east-2");
        KinesisAsyncClient kinesisClient = KinesisClientUtil.createKinesisAsyncClient(
                KinesisAsyncClient.builder().region(region));

        
        DynamoDbAsyncClient dynamoClient = DynamoDbAsyncClient.builder().region(region).build();

        CloudWatchAsyncClient cloudWatchClient =
                CloudWatchAsyncClient.builder().region(region).build();

        return new ConfigsBuilder(streamName, applicationName, kinesisClient, dynamoClient,
                cloudWatchClient, UUID.randomUUID().toString(), new RecordProcessorFactory());

    }
	
	

}