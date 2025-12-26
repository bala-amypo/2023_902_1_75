package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Set;

public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        return "token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public Claims getClaims(String token) {
        return Jwts.claims().setSubject("user");
    }
}
