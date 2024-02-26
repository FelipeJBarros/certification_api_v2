package com.flpbrrs.certification.services.question;

import com.flpbrrs.certification.domain.questions.dtos.QuestionDTO;
import com.flpbrrs.certification.domain.questions.entities.Question;
import com.flpbrrs.certification.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
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
    public Question createQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question data) {
        return this.questionRepository.save(data);
    }

    @Override
    public void deleteQuestion(UUID questionId) {

    }
}
