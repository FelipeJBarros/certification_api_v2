package com.flpbrrs.certification.services.students;

import com.flpbrrs.certification.domain.student.dtos.VerificationDTO;

public interface StudentServicesIntf {
    Boolean verifyIfHasCertification(VerificationDTO data);
}
