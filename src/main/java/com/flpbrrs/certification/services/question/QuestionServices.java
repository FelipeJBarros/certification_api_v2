package com.flpbrrs.certification.services.question;

import com.flpbrrs.certification.domain.questions.dtos.ResponseAlternativeDTO;
import com.flpbrrs.certification.domain.questions.dtos.ResponseQuestionDTO;
import com.flpbrrs.certification.domain.questions.entities.Question;
import com.flpbrrs.certification.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionServices implements QuestionServicesInterface {
    private final QuestionRepository questionRepository;

    public QuestionServices(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<ResponseQuestionDTO> listQuestionsByTechnology(String technology) {
        var questionList = this.questionRepository.findByTechnology(technology);

        return questionList.stream().map(question -> {
            return ResponseQuestionDTO.builder()
                    .id(question.getId())
                    .description(question.getDescription())
                    .technology(question.getTechnology())
                    .alternatives(question.getAlternatives().stream()
                            .map(alternative -> ResponseAlternativeDTO.builder()
                                    .id(alternative.getId())
                                    .description(alternative.getDescription())
                                    .build()).toList()
                    ).build();
        }).toList();
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
