package com.flpbrrs.certification.controllers;

import com.flpbrrs.certification.domain.student.dtos.VerificationDTO;
import com.flpbrrs.certification.domain.student.dtos.VerificationResponseDTO;
import com.flpbrrs.certification.services.students.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/verify-certification")
    public ResponseEntity<VerificationResponseDTO> verifyIfHasCertification(@Valid @RequestBody VerificationDTO data) {
        var alreadyHasCertification = this.studentService.verifyIfHasCertification(data);
        var certificationMessage = VerificationResponseDTO.builder()
                .message(alreadyHasCertification ? "User already has certification" : "User can do certification")
                .hasCertification(alreadyHasCertification)
                .build();
        return ResponseEntity.ok(certificationMessage);
    }
}
