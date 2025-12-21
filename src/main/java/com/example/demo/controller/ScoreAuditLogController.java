package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/score-logs")
@Tag(name = "Score Audit Logs", description = "Score audit log management endpoints")
public class ScoreAuditLogController {

    private final ScoreAuditLogService scoreAuditLogService;

    public ScoreAuditLogController(ScoreAuditLogService scoreAuditLogService) {
        this.scoreAuditLogService = scoreAuditLogService;
    }

    @PostMapping("/{visitorId}/{ruleId}")
    public ResponseEntity<ScoreAuditLog> logScoreChange(@PathVariable Long visitorId, 
                                                       @PathVariable Long ruleId, 
                                                       @RequestBody ScoreAuditLog log) {
        ScoreAuditLog created = scoreAuditLogService.logScoreChange(visitorId, ruleId, log);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreAuditLog> getLog(@PathVariable Long id) {
        ScoreAuditLog log = scoreAuditLogService.getLog(id);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<ScoreAuditLog>> getLogsByVisitor(@PathVariable Long visitorId) {
        List<ScoreAuditLog> logs = scoreAuditLogService.getLogsByVisitor(visitorId);
        return ResponseEntity.ok(logs);
    }
}