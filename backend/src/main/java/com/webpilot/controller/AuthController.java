package com.webpilot.controller;

import com.webpilot.dto.LoginRequest;
import com.webpilot.dto.RegisterRequest;
import com.webpilot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request){

        return userService.register(request);

    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request){

        return userService.login(request);

    }

}