package com.flpbrrs.certification.services.certification;

import com.flpbrrs.certification.domain.student.entities.Certification;
import com.flpbrrs.certification.domain.student.entities.Student;
import com.flpbrrs.certification.repositories.CertificationRepository;
import org.springframework.stereotype.Service;

@Service
public class CertificationServices implements CertificationServiceIntf{
    private final CertificationRepository certificationRepository;

    public CertificationServices(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }
    @Override
    public Certification registerCertification(Student student, String technology) {
        var certification = Certification.builder()
                .student(student)
                .technology(technology)
                .grade(0)
                .build();

        return this.certificationRepository.save(certification);
    }
}
