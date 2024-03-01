package com.flpbrrs.certification.controllers;

import com.flpbrrs.certification.domain.questions.dtos.QuestionDTO;
import com.flpbrrs.certification.domain.questions.dtos.ResponseQuestionDTO;
import com.flpbrrs.certification.services.alternative.AlternativeServiceImpl;
import com.flpbrrs.certification.services.question.QuestionServices;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
    @GetMapping
    public ResponseEntity<List<ResponseQuestionDTO>> listQuestionsByTech(@RequestParam @NotBlank String technology) {
        var questions = this.questionService.listQuestionsByTechnology(technology);
        return ResponseEntity.ok(questions);
    }
    @PostMapping
    public ResponseEntity<ResponseQuestionDTO> createQuestion(@Valid @RequestBody QuestionDTO data) {
        ResponseQuestionDTO question = this.questionService.createQuestion(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(question);
    }
}
