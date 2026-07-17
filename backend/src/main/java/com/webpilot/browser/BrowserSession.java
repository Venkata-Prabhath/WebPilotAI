package com.webpilot.browser;

import com.microsoft.playwright.Page;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrowserSession {

    private String sessionId;
    private Page page;

}