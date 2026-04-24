package com.example.basicspringboot.controller;

import com.example.basicspringboot.model.ApiResponse;
import com.example.basicspringboot.model.AuthRequest;
import com.example.basicspringboot.model.AuthResponse;
import com.example.basicspringboot.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody AuthRequest request) {
        try {
            AuthResponse authResponse = authService.login(request);
            return ResponseEntity.ok(new ApiResponse<>(
                    true,
                    "Login successful",
                    authResponse
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ApiResponse<>(
                    false,
                    e.getMessage(),
                    null
            ));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody AuthRequest request) {
        try {
            AuthResponse authResponse = authService.register(request, "USER");
            return ResponseEntity.ok(new ApiResponse<>(
                    true,
                    "Registration successful",
                    authResponse
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(new ApiResponse<>(
                    false,
                    e.getMessage(),
                    null
            ));
        }
    }

    @PostMapping("/register-admin")
    public ResponseEntity<ApiResponse<AuthResponse>> registerAdmin(@RequestBody AuthRequest request) {
        try {
            AuthResponse authResponse = authService.register(request, "ADMIN");
            return ResponseEntity.ok(new ApiResponse<>(
                    true,
                    "Admin registration successful",
                    authResponse
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(new ApiResponse<>(
                    false,
                    e.getMessage(),
                    null
            ));
        }
    }
}