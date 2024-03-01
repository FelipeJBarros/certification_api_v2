package com.flpbrrs.certification.services.question;

import com.flpbrrs.certification.domain.questions.dtos.AlternativeDTO;
import com.flpbrrs.certification.domain.questions.dtos.QuestionDTO;
import com.flpbrrs.certification.domain.questions.dtos.ResponseAlternativeDTO;
import com.flpbrrs.certification.domain.questions.dtos.ResponseQuestionDTO;
import com.flpbrrs.certification.domain.questions.entities.Alternative;
import com.flpbrrs.certification.domain.questions.entities.Question;
import com.flpbrrs.certification.repositories.QuestionRepository;
import com.flpbrrs.certification.services.alternative.AlternativeServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class QuestionServices implements QuestionServicesInterface {
    private final QuestionRepository questionRepository;
    private final AlternativeServiceImpl alternativeService;

    public QuestionServices(QuestionRepository questionRepository, AlternativeServiceImpl alternativeService) {
        this.questionRepository = questionRepository;
        this.alternativeService = alternativeService;
    }

    @Override
    public List<ResponseQuestionDTO> listQuestionsByTechnology(String technology) {
        List<Question> questionList = this.questionRepository.findByTechnology(technology);

        return questionList
                .stream()
                .map(ResponseQuestionDTO::from).toList();
    }

    @Override
    public ResponseQuestionDTO createQuestion(QuestionDTO questionDTO) {
        Question question = this.questionRepository.save(questionDTO.toQuestion());

        var alternatives = this.alternativeService.createAll(
          questionDTO
                  .getAlternatives()
                  .stream()
                  .map(alternativeDTO -> AlternativeDTO.from(alternativeDTO, question))
                  .toList()
        );

        question.setAlternatives(alternatives);

        Question questionWithAlternatives = this.questionRepository.save(question);

        return ResponseQuestionDTO.from(questionWithAlternatives);
    }

    @Override
    public Question updateQuestion(Question data) {
        return this.questionRepository.save(data);
    }

    @Override
    public void deleteQuestion(UUID questionId) {

    }
}
