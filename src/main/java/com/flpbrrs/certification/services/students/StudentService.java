package com.flpbrrs.certification.services.students;

import com.flpbrrs.certification.domain.student.dtos.VerificationDTO;
import com.flpbrrs.certification.repositories.CertificationRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServicesIntf{
    private final CertificationRepository certificationRepository;

    public StudentService(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }
    @Override
    public Boolean verifyIfHasCertification(VerificationDTO data) {

        var certification = this.certificationRepository
                .findStudentByEmailAndTechnology(data.getEmail(), data.getTechnology());

        return !certification.isEmpty();
    }
}
