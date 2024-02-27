package com.flpbrrs.certification.domain.student.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerificationResponseDTO {

    private String message;
    private Boolean hasCertification;
}
