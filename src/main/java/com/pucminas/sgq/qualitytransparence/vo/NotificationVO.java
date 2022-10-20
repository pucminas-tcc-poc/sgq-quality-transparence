package com.pucminas.sgq.qualitytransparence.vo;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class NotificationVO {
    Long incidentId;
    Long problemId;
    String tittle;
    String message;
}
