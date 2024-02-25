package com.flpbrrs.certification.domain.entities;

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
    private Question question;

    @Column(name = "is_correct")
    private boolean isCorrect;
}
