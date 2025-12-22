package com.example.demo.util;

public class RiskLevelUtils {
    
    public static String determineRiskLevel(int score) {
        if (score >= 0 && score <= 19) {
            return "LOW";
        } else if (score >= 20 && score <= 49) {
            return "MEDIUM";
        } else if (score >= 50 && score <= 79) {
            return "HIGH";
        } else {
            return "CRITICAL";
        }
    }
}