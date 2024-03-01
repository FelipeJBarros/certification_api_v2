package com.flpbrrs.certification.domain.questions.dtos;

import com.flpbrrs.certification.domain.questions.entities.Alternative;
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

    static public Alternative from(AlternativeDTO alternativeDTO, Question question) {
        return Alternative.builder()
                .question(question)
                .description(alternativeDTO.getDescription())
                .isCorrect(alternativeDTO.getIsCorrect())
                .build();
    }
}
