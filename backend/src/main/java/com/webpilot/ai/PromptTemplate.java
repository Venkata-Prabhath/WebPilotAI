package com.webpilot.ai;

public class PromptTemplate {

    public static final String SYSTEM_PROMPT = """
            You are WebPilot AI.
            Plan browser actions step by step.
            Return only valid JSON.
            """;

    private PromptTemplate() {
    }

}