package com.flpbrrs.certification.services.student;

import com.flpbrrs.certification.domain.student.dtos.VerificationDTO;
import com.flpbrrs.certification.domain.student.entities.Student;

import java.util.Optional;
import java.util.UUID;

public interface StudentServicesIntf {
    Boolean verifyIfHasCertification(VerificationDTO data);

    Student registerStudent(String email);

    Student updateStudent(Student student);

    Optional<Student> getStudentById(UUID id);

}
