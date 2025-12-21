package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "risk_rules")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskRule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String ruleName;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RuleType ruleType;
    
    @Column(nullable = false)
    private Integer threshold;
    
    @Column(nullable = false)
    private Integer scoreImpact;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    
    public enum RuleType {
        AFTER_HOURS, FREQUENT_VISITS, BLACKLIST, KEYWORD, CUSTOM
    }
}