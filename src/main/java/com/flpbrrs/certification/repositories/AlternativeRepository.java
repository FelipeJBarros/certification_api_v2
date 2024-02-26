package com.flpbrrs.certification.repositories;

import com.flpbrrs.certification.domain.questions.entities.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlternativeRepository extends JpaRepository<Alternative, UUID> {
}
