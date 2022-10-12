package com.pucminas.sgq.qualitytransparence.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class IncidentProblemPublisher {
    private static final Logger LOG = LoggerFactory.getLogger(
            IncidentProblemPublisher.class);

    private AmazonSNS snsClient;
    private Topic incidentProblemTopic;

    public IncidentProblemPublisher(AmazonSNS snsClient,
                            @Qualifier("incidentProblemTopic")Topic incidentProblemTopic) {
        this.snsClient = snsClient;
        this.incidentProblemTopic = incidentProblemTopic;
    }

    public void publish(String message) {
        PublishResult publishResult = snsClient.publish(
                incidentProblemTopic.getTopicArn(),
                message);

        LOG.info("MessageId: {}", publishResult.getMessageId());
    }
}
