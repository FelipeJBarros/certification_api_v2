package com.flpbrrs.certification.infra.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestExceptionHandlerDTO {
    private String title;
    private List<FieldValidationErrorDTO> errors;
}
