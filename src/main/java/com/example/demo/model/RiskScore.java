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
public class RiskScore {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Visitor visitor;

    private Integer totalScore;
    private String riskLevel;

    // 🔥 REQUIRED (tests + service use this)
    private LocalDateTime evaluatedAt;
}
