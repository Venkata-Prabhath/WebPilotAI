package com.webpilot.browser;

public interface BrowserService {

    String openWebsite(String url);

    String searchGoogle(String query);

    String closeBrowser();

}