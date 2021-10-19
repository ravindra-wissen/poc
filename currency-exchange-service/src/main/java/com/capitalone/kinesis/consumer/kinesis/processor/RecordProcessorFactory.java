package com.capitalone.kinesis.consumer.kinesis.processor;

import org.springframework.stereotype.Component;
import software.amazon.kinesis.processor.ShardRecordProcessor;
import software.amazon.kinesis.processor.ShardRecordProcessorFactory;

@Component
public class RecordProcessorFactory implements ShardRecordProcessorFactory {

	@Override
	public ShardRecordProcessor shardRecordProcessor() {
		return new RecordProcessor();
	}

}