package com.flpbrrs.certification.services.question;

import com.flpbrrs.certification.domain.questions.dtos.ResponseQuestionDTO;
import com.flpbrrs.certification.domain.questions.entities.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionServicesInterface {
    public List<ResponseQuestionDTO> listQuestionsByTechnology(String technology);

    public Question createQuestion(Question question);

    public Question updateQuestion(Question data);

    public void deleteQuestion(UUID questionId);
}
