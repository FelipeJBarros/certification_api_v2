package com.flpbrrs.certification.domain.questions.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class ResponseAlternativeDTO {
    private UUID id;
    private String description;
}
