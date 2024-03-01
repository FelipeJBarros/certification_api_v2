package com.flpbrrs.certification.services.question;

import com.flpbrrs.certification.domain.questions.dtos.ResponseQuestionDTO;
import com.flpbrrs.certification.domain.questions.entities.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionServicesInterface {
    List<ResponseQuestionDTO> listQuestionsByTechnology(String technology);

    Question createQuestion(Question question);

    Question updateQuestion(Question data);

    void deleteQuestion(UUID questionId);
}
