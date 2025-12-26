package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Visitor")
public class VisitorController {

    private final VisitorService service;

    public VisitorController(VisitorService service) {
        this.service = service;
    }

    public ResponseEntity<Visitor> create(Visitor v) {
        return ResponseEntity.ok(service.createVisitor(v));
    }

    public ResponseEntity<Visitor> get(long id) {
        return ResponseEntity.ok(service.getVisitor(id));
    }

    public ResponseEntity<List<Visitor>> all() {
        return ResponseEntity.ok(service.getAllVisitors());
    }
}
