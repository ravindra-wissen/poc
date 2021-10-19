package com.capitalone.kinesis.consumer.kinesis.processor;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.capitalone.sns.AmazonSnsService;

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
				AmazonSnsService amazonSnsService = new AmazonSnsService();
				amazonSnsService.sendEmail("This email is sent from the Amazon kinesis stream record processing.\n\n\n" + originalData);

			} catch (Exception e) {
				log.error("Error parsing record {}", e);
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