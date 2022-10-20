package com.pucminas.sgq.qualitytransparence.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationPublisher {
    private static final Logger LOG = LoggerFactory.getLogger(
            NotificationPublisher.class);

    private AmazonSNS snsClient;
    private Topic notificationTopic;

    public NotificationPublisher(AmazonSNS snsClient,
                                 @Qualifier("notificationTopic")Topic notificationTopic) {
        this.snsClient = snsClient;
        this.notificationTopic = notificationTopic;
    }

    public void publish(String message) {
        PublishResult publishResult = snsClient.publish(
                notificationTopic.getTopicArn(),
                message);

        LOG.info("MessageId: {}", publishResult.getMessageId());
    }
}
