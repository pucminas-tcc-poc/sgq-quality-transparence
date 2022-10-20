package com.pucminas.sgq.qualitytransparence.vo;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemVO {
    String description;
    String type;
    String demage;
}

