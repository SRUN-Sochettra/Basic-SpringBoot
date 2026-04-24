package com.example.basicspringboot.service;

import com.example.basicspringboot.model.AuthRequest;
import com.example.basicspringboot.model.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
    AuthResponse register(AuthRequest request, String role);
}