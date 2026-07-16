package com.webpilot.controller;

import com.webpilot.agent.AgentService;
import com.webpilot.dto.AgentRequest;
import com.webpilot.dto.AgentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @PostMapping("/execute")
    public AgentResponse execute(@RequestBody AgentRequest request) {

        String result = agentService.executeTask(request.getTask());

        return new AgentResponse(result);
    }
}