package com.webpilot.browser;

import java.util.List;

public interface BrowserExecutor {

    BrowserResult execute(List<BrowserInstruction> instructions);

}