package com.flpbrrs.certification.services.certification;

import com.flpbrrs.certification.domain.student.entities.Certification;
import com.flpbrrs.certification.domain.student.entities.Student;

public interface CertificationServiceIntf {
    Certification registerCertification(Student student, String technology);
}
