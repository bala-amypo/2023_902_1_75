package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit-logs")
@Tag(name = "Visit Logs", description = "Visit log management endpoints")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/{visitorId}")
    public ResponseEntity<VisitLog> createVisitLog(@PathVariable Long visitorId, @RequestBody VisitLog log) {
        VisitLog created = visitLogService.createVisitLog(visitorId, log);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> getLog(@PathVariable Long id) {
        VisitLog log = visitLogService.getLog(id);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<VisitLog>> getLogsByVisitor(@PathVariable Long visitorId) {
        List<VisitLog> logs = visitLogService.getLogsByVisitor(visitorId);
        return ResponseEntity.ok(logs);
    }
}