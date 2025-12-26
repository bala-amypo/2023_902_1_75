package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreAuditLog {

    @Id
    @GeneratedValue
    private Long id;

    // 🔥 REQUIRED
    @ManyToOne
    private Visitor visitor;

    // 🔥 REQUIRED
    @ManyToOne
    private RiskRule appliedRule;

    private Integer scoreChange;
    private String reason;

    private LocalDateTime loggedAt;

    @PrePersist
    public void prePersist() {
        loggedAt = LocalDateTime.now();
    }
}
