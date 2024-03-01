package com.flpbrrs.certification.domain.questions.dtos;

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
}
