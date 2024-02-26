package com.flpbrrs.certification.domain.questions.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "alternatives")
@Entity(name = "alternatives")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Alternative {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @JsonIgnoreProperties(value = { "alternatives" ,"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @JsonBackReference
    private Question question;

    @Column(name = "is_correct")
    private boolean isCorrect;
}
