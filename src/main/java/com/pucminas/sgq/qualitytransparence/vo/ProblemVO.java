package com.pucminas.sgq.qualitytransparence.vo;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
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

