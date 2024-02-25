package com.flpbrrs.certification.domain.questions.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlternativeDTO {
    private String description;
    private UUID questionId;
    private boolean isCorrect;
}
