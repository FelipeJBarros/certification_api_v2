package com.flpbrrs.certification.domain.questions.dtos;

import com.flpbrrs.certification.domain.questions.entities.Alternative;
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

    public static ResponseAlternativeDTO from(Alternative alternative) {
        return ResponseAlternativeDTO.builder()
                .id(alternative.getId())
                .description(alternative.getDescription())
                .build();
    }
}
