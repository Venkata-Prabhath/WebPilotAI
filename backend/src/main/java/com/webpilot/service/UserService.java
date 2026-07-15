package com.webpilot.service;

import com.webpilot.dto.LoginRequest;
import com.webpilot.dto.RegisterRequest;

public interface UserService {

    String register(RegisterRequest request);

    String login(LoginRequest request);

}