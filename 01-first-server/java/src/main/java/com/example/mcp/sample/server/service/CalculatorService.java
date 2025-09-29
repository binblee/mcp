package com.example.mcp.sample.server.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Tool(description = "Adds two numbers")
    public String add(double a, double b) {
        double result = a + b;
        return formatResult(a, b, result, "+");
    }

    @Tool(description = "Subtracts the second number from the first")
    public String subtract(double a, double b) {
        double result = a - b;
        return formatResult(a, b, result, "-");
    }

    @Tool(description = "Get help about available calculator operations")
    public String help() {
        return "Available operations:\n" +
               "1. add(a, b) - Adds two numbers\n" +
               "2. subtract(a, b) - Subtracts the second number from the first\n\n" + 
               "Example usage: add(3, 5) will return 3+5=8";
    }

    private String formatResult(double a, double b, double result, String operation) {
        return String.format("%.2f %s %.2f = %.2f", a, operation, b, result);
    }
}
