package com.webpilot.browser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrowserResult {

    private boolean success;
    private String message;

}