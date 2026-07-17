package com.webpilot.service.impl;

import com.webpilot.dto.BrowserAction;
import com.webpilot.service.AIService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AIServiceImpl implements AIService {

    @Override
    public List<BrowserAction> generatePlan(String task) {

        List<BrowserAction> plan = new ArrayList<>();

        String lower = task.toLowerCase();

        if (lower.startsWith("open ")) {

            String url = task.substring(5).trim();

            if (!url.startsWith("http")) {
                url = "https://" + url;
            }

            plan.add(new BrowserAction("open", url));

        } else {

            plan.add(new BrowserAction(
                    "open",
                    "https://www.google.com"
            ));

            plan.add(new BrowserAction(
                    "search",
                    task
            ));
        }

        return plan;
    }
}