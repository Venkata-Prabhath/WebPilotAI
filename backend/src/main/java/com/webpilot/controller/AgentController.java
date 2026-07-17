package com.webpilot.controller;

import com.webpilot.agent.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @PostMapping("/execute")
    public String execute(@RequestBody String prompt) {
        return agentService.executeTask(prompt);
    }

}