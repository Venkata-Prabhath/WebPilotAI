package com.webpilot.browser;

public interface BrowserService {

    String openWebsite(String url);

    String searchGoogle(String query);

    String click(String selector);

    String type(String selector, String text);

    String waitFor(int milliseconds);

    String takeScreenshot(String fileName);

    String closeBrowser();

}