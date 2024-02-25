package com.flpbrrs.certification.domain.questions.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDTO {
    private String description;
    private String technology;
    private List<AlternativeDTO> alternatives;
}
