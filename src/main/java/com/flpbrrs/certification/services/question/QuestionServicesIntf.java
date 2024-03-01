package com.flpbrrs.certification.services.question;

import com.flpbrrs.certification.domain.questions.dtos.QuestionDTO;
import com.flpbrrs.certification.domain.questions.entities.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionServicesIntf {
    public List<Question> listAll();

    public List<Question> getQuestionsByTechnology(String technology);
    public Question createQuestion(Question question);

    public Question updateQuestion(Question data);

    public void deleteQuestion(UUID questionId);
}
