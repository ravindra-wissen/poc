package com.capitalone.sns;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

public class AmazonSnsService {

	public void sendEmail(String body) {

		String topicArn = "arn:aws:sns:us-east-2:434466469068:SendEmailDynamodbStream";
		try {
			SnsClient snsClient = SnsClient
					.builder()
					.region(software.amazon.awssdk.regions.Region.US_EAST_2)
//					.httpClient(ApacheHttpClient.builder().build())
					.build();
			PublishRequest request = PublishRequest.builder().message(body).topicArn(topicArn).build();

			PublishResponse result = snsClient.publish(request);
			System.out
					.println(result.messageId() + " Message sent. Status is " + result.sdkHttpResponse().statusCode());

		} catch (SnsException e) {
			System.err.println(e.awsErrorDetails().errorMessage());
		}

	}
}