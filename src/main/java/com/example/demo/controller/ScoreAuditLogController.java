package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "ScoreAuditLog")
public class ScoreAuditLogController {

    private final ScoreAuditLogService service;

    public ScoreAuditLogController(ScoreAuditLogService service) {
        this.service = service;
    }

    public ResponseEntity<ScoreAuditLog> create(long v, long r, ScoreAuditLog log) {
        return ResponseEntity.ok(service.logScoreChange(v, r, log));
    }

    public ResponseEntity<ScoreAuditLog> get(long id) {
        return ResponseEntity.ok(service.getLog(id));
    }

    public ResponseEntity<List<ScoreAuditLog>> logsByVisitor(long id) {
        return ResponseEntity.ok(service.getLogsByVisitor(id));
    }
}
