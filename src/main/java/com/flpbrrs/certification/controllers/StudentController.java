package com.flpbrrs.certification.controllers;

import com.flpbrrs.certification.domain.student.dtos.VerificationDTO;
import com.flpbrrs.certification.domain.student.dtos.VerificationResponseDTO;
import com.flpbrrs.certification.domain.student.dtos.StartCertificationDTO;
import com.flpbrrs.certification.domain.student.entities.Certification;
import com.flpbrrs.certification.services.certification.CertificationServices;
import com.flpbrrs.certification.services.student.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final CertificationServices certificationServices;

    public StudentController(StudentService studentService, CertificationServices certificationServices) {
        this.studentService = studentService;
        this.certificationServices = certificationServices;
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

    @PostMapping("/begin-certification")
    public ResponseEntity<Certification> startCertification(@RequestBody StartCertificationDTO data) {
        var student = this.studentService.registerStudent(data.getEmail());
        var certification = this.certificationServices.registerCertification(student, data.getTechnology());

        return ResponseEntity.status(HttpStatus.CREATED).body(certification);
    }
}
