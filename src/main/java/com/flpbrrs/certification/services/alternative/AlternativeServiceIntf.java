package com.flpbrrs.certification.services.alternative;

import com.flpbrrs.certification.domain.questions.dtos.AlternativeDTO;
import com.flpbrrs.certification.domain.questions.entities.Alternative;
import com.flpbrrs.certification.domain.questions.entities.Question;

import java.util.List;

public interface AlternativeServiceIntf {
    public List<Alternative> createAll(List<Alternative> alternatives);
}
