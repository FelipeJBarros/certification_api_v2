package com.flpbrrs.certification.infra.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotReadableDTO {
    private String message;
    private String cause;
}
