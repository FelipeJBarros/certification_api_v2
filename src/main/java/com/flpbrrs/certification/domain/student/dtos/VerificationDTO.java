package com.flpbrrs.certification.domain.student.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerificationDTO {
    @Email(message = "The email must be valid")
    @NotEmpty(message = "The e-mail field cannot be empty or null")
    private String email;
    @NotEmpty(message = "The technology field cannot be empty or null")
    private String technology;
}
