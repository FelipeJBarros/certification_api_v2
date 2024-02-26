package com.flpbrrs.certification.domain.questions.dtos;

import com.flpbrrs.certification.domain.questions.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlternativeDTO {
    private String description;
    private Boolean isCorrect;
}
