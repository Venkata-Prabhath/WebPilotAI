package com.webpilot.controller;

import com.webpilot.browser.BrowserService;
import com.webpilot.dto.BrowserRequest;
import com.webpilot.dto.BrowserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/browser")
@RequiredArgsConstructor
public class BrowserController {

    private final BrowserService browserService;

    @PostMapping("/open")
    public BrowserResponse openWebsite(@RequestBody BrowserRequest request) {

        String message = browserService.openWebsite(request.getInput());

        return new BrowserResponse(message);
    }

    @PostMapping("/search")
    public BrowserResponse searchGoogle(@RequestBody BrowserRequest request) {

        String message = browserService.searchGoogle(request.getInput());

        return new BrowserResponse(message);
    }

    @PostMapping("/close")
    public BrowserResponse closeBrowser() {

        String message = browserService.closeBrowser();

        return new BrowserResponse(message);
    }
}