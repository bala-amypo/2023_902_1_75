package com.example.demo.service;

import com.example.demo.model.RiskScore;
import java.util.List;

public interface RiskScoreService {
    RiskScore evaluateVisitor(Long id);
    RiskScore getScoreForVisitor(Long id);
    List<RiskScore> getAllScores();
}
