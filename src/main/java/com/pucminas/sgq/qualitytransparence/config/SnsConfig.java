package com.pucminas.sgq.qualitytransparence.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnsConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.sns.topic.notification.arn}")
    private String notificationTopic;

    @Bean
    public AmazonSNS snsClient() {
        BasicAWSCredentials basic = new BasicAWSCredentials("dummy", "dummy");
        return AmazonSNSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(basic))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        "http://localhost:4566", awsRegion))
                .build();
    }

    @Bean(name = "notificationTopic")
    public Topic snsNotificationTopic() {
        return new Topic().withTopicArn(notificationTopic);
    }

}
