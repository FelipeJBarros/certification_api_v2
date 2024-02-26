package com.flpbrrs.certification.domain.questions.dtos;

import jakarta.validation.constraints.*;
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
    @NotEmpty(message = "The description field cannot be empty or null")
    @NotBlank(message = "The description field cannot be blank")
    private String description;
    @NotEmpty(message = "The technology field cannot be empty or null")
    @NotBlank(message = "The technology field cannot be blank")
    private String technology;
    @NotNull
    @Size(min = 4, message = "At least four alternatives")
    private List<AlternativeDTO> alternatives;
}
