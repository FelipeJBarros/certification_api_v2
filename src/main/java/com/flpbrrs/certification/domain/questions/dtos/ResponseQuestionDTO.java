package com.flpbrrs.certification.domain.questions.dtos;

import com.flpbrrs.certification.domain.questions.entities.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ResponseQuestionDTO {
    private UUID id;
    private String description;
    private String technology;
    private List<ResponseAlternativeDTO> alternatives;

    public static ResponseQuestionDTO from(Question question) {
        return ResponseQuestionDTO.builder()
                .id(question.getId())
                .description(question.getDescription())
                .technology(question.getTechnology())
                .alternatives(question.getAlternatives().stream().map(ResponseAlternativeDTO::from).toList())
                .build();
    }
}
