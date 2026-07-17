package com.webpilot.ai;

import org.springframework.stereotype.Service;

@Service
public class OpenAIService implements LLMService {

    @Override
    public String generate(String prompt) {
        return "AI Response";
    }

}