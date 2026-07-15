package com.webpilot.service;

import com.webpilot.dto.LoginRequest;
import com.webpilot.dto.RegisterRequest;
import com.webpilot.entity.Role;
import com.webpilot.entity.User;
import com.webpilot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())){
            return "Email already exists";
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if(user == null){
            return "Invalid Credentials";
        }

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            return "Invalid Credentials";
        }

        return "Login Successful";
    }
}