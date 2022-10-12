package com.pucminas.sgq.qualitytransparence.vo;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class IncidentVO {
    String incident;
    String status;
    String type;
    String place;
    String demage;
    Long partId;
    Long vehicleId;
    Long nonComplianceId;
    Long userId;
}

