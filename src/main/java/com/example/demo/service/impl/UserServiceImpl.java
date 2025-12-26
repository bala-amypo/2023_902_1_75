package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepository repo,
                           PasswordEncoder encoder,
                           JwtTokenProvider jwt) {}

    @Override
    public Object register(RegisterRequest request) {
        return User.builder().email(request.getEmail()).build();
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        return new AuthResponse("token");
    }
}
