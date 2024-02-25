package com.flpbrrs.certification.services.question;

import com.flpbrrs.certification.domain.questions.dtos.QuestionDTO;
import com.flpbrrs.certification.domain.questions.entities.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionServicesIntf {
    public List<Question> listAll();
    public Question createQuestion(QuestionDTO data);

    public Question uodateQuestion(QuestionDTO data);

    public void deleteQuestion(UUID questionId);
}
