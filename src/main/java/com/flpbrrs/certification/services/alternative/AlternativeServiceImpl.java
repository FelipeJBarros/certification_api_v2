package com.flpbrrs.certification.services.alternative;

import com.flpbrrs.certification.domain.questions.dtos.AlternativeDTO;
import com.flpbrrs.certification.domain.questions.entities.Alternative;
import com.flpbrrs.certification.domain.questions.entities.Question;
import com.flpbrrs.certification.repositories.AlternativeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlternativeServiceImpl implements AlternativeServiceIntf{
    private final AlternativeRepository alternativeRepository;

    public AlternativeServiceImpl(AlternativeRepository repository) {
        this.alternativeRepository = repository;
    }

    @Override
    public List<Alternative> createAll(List<Alternative> alternatives) {
        return this.alternativeRepository.saveAll(alternatives);
    }
}
