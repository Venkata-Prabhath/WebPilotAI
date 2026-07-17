package com.webpilot.agent;

import org.springframework.stereotype.Service;

@Service
public class PlannerServiceImpl implements PlannerService {

    @Override
    public AgentContext createPlan(String prompt) {
        return new AgentContext(prompt, AgentState.CREATED);
    }
}