package com.webpilot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AIConfig {

    @Value("${ai.api.key}")
    private String apiKey;

    @Value("${ai.provider}")
    private String provider;

}