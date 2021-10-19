package com.capitalone.kinesis.consumer.kinesis.processor;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capitalone.dynamodb.model.Exchange;
import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.kinesis.exceptions.InvalidStateException;
import software.amazon.kinesis.exceptions.ShutdownException;
import software.amazon.kinesis.lifecycle.events.InitializationInput;
import software.amazon.kinesis.lifecycle.events.LeaseLostInput;
import software.amazon.kinesis.lifecycle.events.ProcessRecordsInput;
import software.amazon.kinesis.lifecycle.events.ShardEndedInput;
import software.amazon.kinesis.lifecycle.events.ShutdownRequestedInput;
import software.amazon.kinesis.processor.ShardRecordProcessor;
import software.amazon.kinesis.retrieval.KinesisClientRecord;

public class RecordProcessor implements ShardRecordProcessor {

	private static final Logger log = LoggerFactory.getLogger(RecordProcessor.class);

	@Override
	public void initialize(InitializationInput initializationInput) {
		log.info("Initialization complete");
	}

	@Override
	public void processRecords(ProcessRecordsInput processRecordsInput) {

		// Data is read here from the Kinesis data stream
		for (KinesisClientRecord record : processRecordsInput.records()) {

			log.info("Processing Record For Partition Key : {}", record.partitionKey());

			String originalData = "";

			try {
				final byte[] bytes = new byte[record.data().remaining()];
				record.data().duplicate().get(bytes);
				originalData = new String(bytes);
				
				log.info("Data from kinesis stream : {}", originalData);

				JSONObject obj = new JSONObject(originalData);
				log.info(obj.toString());
				
//				ObjectMapper objectMapper = new ObjectMapper();
//
//				Exchange[] exchanges = objectMapper.readValue(originalData, Exchange[].class);
//
//				List<Exchange> trackDetails = new ArrayList<>();
//
//				for (Exchange exchange : exchanges) {
//
//					System.out.println(exchange);
//				}

			} catch (Exception e) {
				log.error("Error parsing record {}", e);
//                System.exit(1);
			}

			try {
				/*
				 * KCL assumes that the call to checkpoint means that all records have been
				 * processed, records which are passed to the record processor.
				 */
				processRecordsInput.checkpointer().checkpoint();

			} catch (Exception e) {
				log.error("Error during Processing of records", e);
			}
		}
	}

	@Override
	public void leaseLost(LeaseLostInput leaseLostInput) {
		log.error("LeaseLostInput {}", leaseLostInput);
	}

	@Override
	public void shardEnded(ShardEndedInput shardEndedInput) {
		try {
			shardEndedInput.checkpointer().checkpoint();
		} catch (ShutdownException | InvalidStateException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void shutdownRequested(ShutdownRequestedInput shutdownRequestedInput) {
		try {
			shutdownRequestedInput.checkpointer().checkpoint();
		} catch (ShutdownException | InvalidStateException e) {

			e.printStackTrace();
		}
	}

}