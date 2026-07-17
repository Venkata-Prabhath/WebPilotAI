package com.webpilot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIServiceImpl implements AIService {

    @Override
    public String generate(String prompt) {
        return "AI Response";
    }

}