package com.pucminas.sgq.qualitytransparence.service;

import com.pucminas.sgq.qualitytransparence.vo.IncidentProblemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentProblemService {

    @Autowired
    private IncidentProblemPublisher incidentProblemPublisher;

    public IncidentProblemVO publishIncidentProblem(IncidentProblemVO incidentProblemVO) {
        String messageToPublish = "Nova mensagem";

        if (incidentProblemVO.getIncidentId() != null) {
            // todo obter incident
        }

        if (incidentProblemVO.getProblemId() != null) {
            // todo obter problem
        }

        // preencher obj

        incidentProblemPublisher.publish(messageToPublish);

        IncidentProblemVO incident = IncidentProblemVO
                .builder()
                .message(messageToPublish)
                .build();

        return incident;
    }
}
