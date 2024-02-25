package com.flpbrrs.certification.services.question;

import com.flpbrrs.certification.domain.questions.dtos.QuestionDTO;
import com.flpbrrs.certification.domain.questions.entities.Question;
import com.flpbrrs.certification.repositories.QuestionRepository;

import java.util.List;
import java.util.UUID;

public class QuestionServiceImpl implements QuestionServicesIntf{
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> listAll() {
        return null;
    }

    @Override
    public Question createQuestion(QuestionDTO data) {
        return null;
    }

    @Override
    public Question uodateQuestion(QuestionDTO data) {
        return null;
    }

    @Override
    public void deleteQuestion(UUID questionId) {

    }
}
