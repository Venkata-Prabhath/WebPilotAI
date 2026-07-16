package com.webpilot.agent;

import com.webpilot.browser.BrowserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final BrowserService browserService;

    @Override
    public String executeTask(String task) {

        String lowerTask = task.toLowerCase();

        if (lowerTask.startsWith("open ")) {

            String url = task.substring(5).trim();

            if (!url.startsWith("http")) {
                url = "https://" + url;
            }

            return browserService.openWebsite(url);
        }

        browserService.openWebsite("https://www.google.com");
        browserService.searchGoogle(task);

        return "AI Agent executed task: " + task;
    }
}