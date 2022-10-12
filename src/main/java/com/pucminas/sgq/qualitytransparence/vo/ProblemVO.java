package com.pucminas.sgq.qualitytransparence.vo;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ProblemVO {
    String problem;
    String type;
    String demage;
    Long partId;
    Long vehicleId;
    Long nonComplianceId;
    Long userId;
}

