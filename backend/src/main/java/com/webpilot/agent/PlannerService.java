package com.webpilot.agent;

public interface PlannerService {
    AgentContext createPlan(String prompt);
}