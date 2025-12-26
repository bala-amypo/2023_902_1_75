package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "VisitLog")
public class VisitLogController {

    private final VisitLogService service;

    public VisitLogController(VisitLogService service) {
        this.service = service;
    }

    public ResponseEntity<VisitLog> create(long visitorId, VisitLog log) {
        return ResponseEntity.ok(service.createVisitLog(visitorId, log));
    }

    public ResponseEntity<VisitLog> get(long id) {
        return ResponseEntity.ok(service.getLog(id));
    }

    public ResponseEntity<List<VisitLog>> listByVisitor(long visitorId) {
        return ResponseEntity.ok(service.getLogsByVisitor(visitorId));
    }
}
