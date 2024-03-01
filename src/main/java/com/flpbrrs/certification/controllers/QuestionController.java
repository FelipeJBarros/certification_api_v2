package com.flpbrrs.certification.controllers;

import com.flpbrrs.certification.domain.questions.dtos.QuestionDTO;
import com.flpbrrs.certification.domain.questions.dtos.ResponseAlternativeDTO;
import com.flpbrrs.certification.domain.questions.dtos.ResponseQuestionDTO;
import com.flpbrrs.certification.domain.questions.entities.Alternative;
import com.flpbrrs.certification.domain.questions.entities.Question;
import com.flpbrrs.certification.services.alternative.AlternativeServiceImpl;
import com.flpbrrs.certification.services.question.QuestionServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionServiceImpl questionService;
    private final AlternativeServiceImpl alternativeService;

    public QuestionController(AlternativeServiceImpl alternativeService, QuestionServiceImpl questionService) {
        this.alternativeService = alternativeService;
        this.questionService = questionService;
    }
    @GetMapping("/{technology}")
    public ResponseEntity<List<ResponseQuestionDTO>> listQuestionsByTech(@PathVariable String technology) {
        var technologyQuestions = this.questionService.getQuestionsByTechnology(technology);

        var response = technologyQuestions.stream().map(question -> {
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

        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody QuestionDTO data) {
        var dtoToQuestion = Question.builder()
                .description(data.getDescription())
                .technology(data.getTechnology())
                .build();

        var question = this.questionService.createQuestion(dtoToQuestion);

        var alternativeList = data.getAlternatives().stream().map(alternativeDTO -> {
            return Alternative.builder()
                    .question(question)
                    .description(alternativeDTO.getDescription())
                    .isCorrect(alternativeDTO.getIsCorrect())
                    .build();
        }).toList();

        var alternatives = this.alternativeService.createAll(alternativeList);

        question.setAlternatives(alternatives);

        var finalQuestion = this.questionService.updateQuestion(question);

        return ResponseEntity.status(HttpStatus.CREATED).body(finalQuestion);
    }
}
