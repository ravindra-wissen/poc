package com.capitalone;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import software.amazon.kinesis.common.ConfigsBuilder;
import software.amazon.kinesis.common.InitialPositionInStream;
import software.amazon.kinesis.common.InitialPositionInStreamExtended;
import software.amazon.kinesis.coordinator.Scheduler;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.capitalone.repository")
public class CurrencyExchangeServiceApplication implements CommandLineRunner {

	@Autowired
	private ConfigsBuilder configsBuilder;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * The Scheduler is the entry point to the KCL. This instance is configured with
		 * defaults provided by the ConfigsBuilder.
		 */
//		Scheduler scheduler = new Scheduler(configsBuilder.checkpointConfig(), configsBuilder.coordinatorConfig(),
//				configsBuilder.leaseManagementConfig(), configsBuilder.lifecycleConfig(),
//				configsBuilder.metricsConfig(), configsBuilder.processorConfig(),
//				configsBuilder.retrievalConfig().maxListShardsRetryAttempts(5).initialPositionInStreamExtended(
//						InitialPositionInStreamExtended.newInitialPosition(InitialPositionInStream.TRIM_HORIZON)));
//
//		Thread schedulerThread = new Thread(scheduler);
//		schedulerThread.setDaemon(true);
//		schedulerThread.start();

	}

}
