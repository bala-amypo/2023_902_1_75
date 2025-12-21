package com.example.demo.controller;

import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-rules")
@Tag(name = "Risk Rules", description = "Risk rule management endpoints")
public class RiskRuleController {

    private final RiskRuleService riskRuleService;

    public RiskRuleController(RiskRuleService riskRuleService) {
        this.riskRuleService = riskRuleService;
    }

    @PostMapping
    public ResponseEntity<RiskRule> createRule(@RequestBody RiskRule rule) {
        RiskRule created = riskRuleService.createRule(rule);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskRule> getRule(@PathVariable Long id) {
        RiskRule rule = riskRuleService.getRule(id);
        return ResponseEntity.ok(rule);
    }

    @GetMapping
    public ResponseEntity<List<RiskRule>> getAllRules() {
        List<RiskRule> rules = riskRuleService.getAllRules();
        return ResponseEntity.ok(rules);
    }
}