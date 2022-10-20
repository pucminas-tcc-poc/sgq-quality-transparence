package com.pucminas.sgq.qualitytransparence.vo;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidentVO {
    String description;
    String status;
    String type;
    String place;
    String demage;
}

