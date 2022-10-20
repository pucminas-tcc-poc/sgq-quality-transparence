package com.pucminas.sgq.qualitytransparence.service;

import com.pucminas.sgq.qualitytransparence.vo.IncidentVO;
import com.pucminas.sgq.qualitytransparence.vo.NotificationVO;
import com.pucminas.sgq.qualitytransparence.vo.ProblemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class NotificationService {

    @Autowired
    private NotificationPublisher notificationPublisher;

    @Autowired
    private SgqAPIGatewayRestClient sgqAPIGatewayRestClient;

    public void publish(NotificationVO notificationVO) {
        StringBuilder messageToPublish = new StringBuilder()
        .append(notificationVO.getTittle())
        .append("\n")
        .append(notificationVO.getMessage())
        .append("\n");

        if (Objects.nonNull(notificationVO.getIncidentId())) {
            IncidentVO incidentVO = sgqAPIGatewayRestClient.getIncidentById(notificationVO.getIncidentId());
            messageToPublish.append(incidentVO.getDescription());
        } else {
            ProblemVO problemVO = sgqAPIGatewayRestClient.getProblemById(notificationVO.getProblemId());
            messageToPublish.append(problemVO.getDescription());
        }

        notificationPublisher.publish(messageToPublish.toString());
    }
}
