package com.flpbrrs.certification.controllers;

import com.flpbrrs.certification.domain.questions.dtos.QuestionDTO;
import com.flpbrrs.certification.domain.questions.dtos.ResponseAlternativeDTO;
import com.flpbrrs.certification.domain.questions.dtos.ResponseQuestionDTO;
import com.flpbrrs.certification.domain.questions.entities.Alternative;
import com.flpbrrs.certification.domain.questions.entities.Question;
import com.flpbrrs.certification.services.alternative.AlternativeServiceImpl;
import com.flpbrrs.certification.services.question.QuestionServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionServices questionService;
    private final AlternativeServiceImpl alternativeService;

    public QuestionController(AlternativeServiceImpl alternativeService, QuestionServices questionService) {
        this.alternativeService = alternativeService;
        this.questionService = questionService;
    }
    @GetMapping("/{technology}")
    public ResponseEntity<List<ResponseQuestionDTO>> listQuestionsByTech(@PathVariable String technology) {
        var questions = this.questionService.listQuestionsByTechnology(technology);
        return ResponseEntity.ok(questions);
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
