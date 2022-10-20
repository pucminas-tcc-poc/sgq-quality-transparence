package com.pucminas.sgq.qualitytransparence.vo;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
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

