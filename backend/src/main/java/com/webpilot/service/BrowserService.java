package com.webpilot.service;

import com.webpilot.browser.BrowserCommand;
import com.webpilot.browser.BrowserResult;

public interface BrowserService {

    BrowserResult execute(BrowserCommand command);

}