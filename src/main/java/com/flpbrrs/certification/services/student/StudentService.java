package com.flpbrrs.certification.services.student;

import com.flpbrrs.certification.domain.student.dtos.VerificationDTO;
import com.flpbrrs.certification.domain.student.entities.Student;
import com.flpbrrs.certification.repositories.CertificationRepository;
import com.flpbrrs.certification.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService implements StudentServicesIntf{
    private final CertificationRepository certificationRepository;
    private final StudentRepository studentRepository;

    public StudentService(CertificationRepository certificationRepository, StudentRepository studentRepository) {
        this.certificationRepository = certificationRepository;
        this.studentRepository = studentRepository;
    }
    @Override
    public Boolean verifyIfHasCertification(VerificationDTO data) {

        var certification = this.certificationRepository
                .findStudentByEmailAndTechnology(data.getEmail(), data.getTechnology());

        return !certification.isEmpty();
    }

    @Override
    public Student registerStudent(String email) {
        var student = Student.builder().email(email).build();
        return this.studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(UUID id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public Optional<Student> getStudentByEmail(String email) {
        return this.studentRepository.findByEmail(email);
    }
}
