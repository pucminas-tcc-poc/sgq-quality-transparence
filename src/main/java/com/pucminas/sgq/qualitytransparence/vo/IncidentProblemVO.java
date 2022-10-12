package com.pucminas.sgq.qualitytransparence.vo;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class IncidentProblemVO {
    Long incidentId;
    Long problemId;
    String tittle;
    String message;
}
