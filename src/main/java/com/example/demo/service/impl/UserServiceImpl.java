package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String email, String password) {

        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("email exists");
        }

        User user = User.builder()
                .email(email)
                .password(password)   // ✅ plain password
                .build();

        return userRepository.save(user);
    }

    @Override
    public String login(String email, String password) {
        // minimal dummy login
        return "dummy-token";
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
