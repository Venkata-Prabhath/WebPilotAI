package com.webpilot.controller;

import com.webpilot.browser.BrowserCommand;
import com.webpilot.browser.BrowserResult;
import com.webpilot.browser.BrowserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/browser")
@RequiredArgsConstructor
public class BrowserController {

    private final BrowserService browserService;

    @PostMapping("/execute")
    public BrowserResult execute(@RequestBody BrowserCommand command) {
        return browserService.execute(command);
    }

}