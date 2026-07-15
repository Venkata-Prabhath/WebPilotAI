package com.webpilot.service;

import com.webpilot.dto.AuthResponse;
import com.webpilot.dto.LoginRequest;
import com.webpilot.dto.RegisterRequest;

public interface UserService {

    String register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}