package com.flpbrrs.certification.domain.questions.dtos;

import com.flpbrrs.certification.domain.questions.entities.Question;
import com.flpbrrs.certification.infra.validations.assertOneTrue.AssertOneAlternativeTrue;
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
    @Size(min = 4, max = 4, message = "Each question must have 4 alternatives")
    @AssertOneAlternativeTrue(message = "One alternative must be true")
    private List<AlternativeDTO> alternatives;

    public Question toQuestion() {
        return Question.builder()
                .description(this.getDescription())
                .technology(this.getTechnology())
                .build();
    }
}
