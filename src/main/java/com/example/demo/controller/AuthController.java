package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    public ResponseEntity<?> register(RegisterRequest req) {
        return ResponseEntity.ok(service.register(req));
    }

    public ResponseEntity<AuthResponse> login(AuthRequest req) {
        return ResponseEntity.ok(service.login(req));
    }
}
