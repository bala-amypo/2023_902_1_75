package com.example.demo.controller;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-scores")
@Tag(name = "Risk Scores", description = "Risk score management endpoints")
public class RiskScoreController {

    private final RiskScoreService riskScoreService;

    public RiskScoreController(RiskScoreService riskScoreService) {
        this.riskScoreService = riskScoreService;
    }

    @PostMapping("/evaluate/{visitorId}")
    public ResponseEntity<RiskScore> evaluate(@PathVariable Long visitorId) {
        RiskScore score = riskScoreService.evaluateVisitor(visitorId);
        return ResponseEntity.ok(score);
    }

    @GetMapping("/{visitorId}")
    public ResponseEntity<RiskScore> getScoreForVisitor(@PathVariable Long visitorId) {
        RiskScore score = riskScoreService.getScoreForVisitor(visitorId);
        return ResponseEntity.ok(score);
    }

    @GetMapping
    public ResponseEntity<List<RiskScore>> getAllScores() {
        List<RiskScore> scores = riskScoreService.getAllScores();
        return ResponseEntity.ok(scores);
    }
}