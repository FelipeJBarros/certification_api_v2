package com.flpbrrs.certification.infra.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FieldValidationErrorDTO {
    private String field;
    private List<String> messages;
}
