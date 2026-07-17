package com.webpilot.browser;

import com.microsoft.playwright.*;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BrowserExecutorImpl implements BrowserExecutor {

    private final Playwright playwright;
    private final Browser browser;
    private final Page page;

    public BrowserExecutorImpl() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );
        page = browser.newPage();
    }

    @Override
    public BrowserResult execute(List<BrowserInstruction> instructions) {
        try {
            for (BrowserInstruction instruction : instructions) {
                switch (instruction.getAction()) {
                    case OPEN -> page.navigate(instruction.getTarget());
                    case SEARCH -> page.navigate(
                            "https://www.google.com/search?q=" +
                                    instruction.getValue().replace(" ", "+")
                    );
                    case BACK -> page.goBack();
                    case FORWARD -> page.goForward();
                    case REFRESH -> page.reload();
                }
            }

            return BrowserResult.builder()
                    .success(true)
                    .message("Executed " + instructions.size() + " instruction(s)")
                    .build();

        } catch (Exception e) {
            return BrowserResult.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PreDestroy
    public void cleanup() {
        if (playwright != null) {
            playwright.close();
        }
    }
}