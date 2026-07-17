package com.webpilot.agent;

import com.webpilot.browser.BrowserService;
import com.webpilot.dto.BrowserAction;
import com.webpilot.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final BrowserService browserService;
    private final AIService aiService;

    @Override
    public String executeTask(String task) {

        List<BrowserAction> plan = aiService.generatePlan(task);

        for (BrowserAction action : plan) {

            switch (action.getAction()) {

                case "open" ->
                        browserService.openWebsite(action.getValue());

                case "search" ->
                        browserService.searchGoogle(action.getValue());
            }
        }

        return "AI Agent executed task: " + task;
    }
}