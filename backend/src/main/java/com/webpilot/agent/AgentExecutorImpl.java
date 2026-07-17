package com.webpilot.agent;

import org.springframework.stereotype.Service;

@Service
public class AgentExecutorImpl implements AgentExecutor {

    @Override
    public String execute(AgentContext context) {
        return "Execution completed.";
    }
}