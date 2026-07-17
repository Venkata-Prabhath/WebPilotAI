package com.webpilot.memory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrowserMemory {

    private String sessionId;
    private String currentUrl;

}