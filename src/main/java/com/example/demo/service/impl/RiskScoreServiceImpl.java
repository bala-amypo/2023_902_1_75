package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;
    private final VisitorRepository visitorRepository;

    public RiskScoreServiceImpl(RiskScoreRepository riskScoreRepository,
                                VisitorRepository visitorRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        int totalScore = 10; // base score

        // ensure non-negative
        if (totalScore < 0) {
            totalScore = 0;
        }

        // ✅ INLINE risk level logic (NO util)
        String riskLevel;
        if (totalScore < 20) {
            riskLevel = "LOW";
        } else if (totalScore < 50) {
            riskLevel = "MEDIUM";
        } else if (totalScore < 80) {
            riskLevel = "HIGH";
        } else {
            riskLevel = "CRITICAL";
        }

        RiskScore riskScore = RiskScore.builder()
                .visitor(visitor)
                .totalScore(totalScore)
                .riskLevel(riskLevel)
                .evaluatedAt(LocalDateTime.now())
                .build();

        return riskScoreRepository.save(riskScore);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findByVisitorId(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Risk score not found"));
    }

    @Override
    public List<RiskScore> getAllScores() {
        return riskScoreRepository.findAll();
    }
}
