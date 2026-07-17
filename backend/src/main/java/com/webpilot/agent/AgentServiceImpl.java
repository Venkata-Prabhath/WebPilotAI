package com.webpilot.agent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final PlannerService plannerService;
    private final AgentExecutor agentExecutor;

    @Override
    @Transactional
    public String executeTask(String prompt) {
        try {
            AgentContext context = plannerService.createPlan(prompt);
            // In production, update AgentState in DB here
            return agentExecutor.execute(context);
        } catch (Exception e) {
            // Log error and trigger a failure state for the autopilot
            throw new AgentException("Agent execution failed: " + e.getMessage());
        }
    }
}