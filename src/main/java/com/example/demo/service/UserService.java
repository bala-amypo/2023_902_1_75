package com.example.demo.service;

import com.example.demo.dto.*;

public interface UserService {
    Object register(RegisterRequest request);
    AuthResponse login(AuthRequest request);
}
