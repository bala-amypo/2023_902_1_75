package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "risk_scores")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskScore {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;
    
    @Column(nullable = false)
    private Integer totalScore;
    
    @Column(nullable = false)
    private String riskLevel;
    
    @Column(nullable = false)
    private LocalDateTime evaluatedAt;
    
    @PrePersist
    protected void onCreate() {
        evaluatedAt = LocalDateTime.now();
    }
}