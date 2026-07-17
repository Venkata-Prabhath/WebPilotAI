package com.webpilot.browser;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrowserServiceImpl implements BrowserService {

    private final Playwright playwright;
    private final BrowserSession browserSession;

    private Page getPage() {
        if (browserSession.getPage() == null) {
            throw new IllegalStateException("Browser not started");
        }
        return browserSession.getPage();
    }

    @Override
    public String openWebsite(String url) {

        if (browserSession.getBrowser() != null) {
            browserSession.getBrowser().close();
            browserSession.setBrowser(null);
            browserSession.setContext(null);
            browserSession.setPage(null);
        }

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));

        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate(url, new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.NETWORKIDLE));

        browserSession.setBrowser(browser);
        browserSession.setContext(context);
        browserSession.setPage(page);

        return "Opened : " + url;
    }

    @Override
    public String searchGoogle(String query) {
        Page page = getPage();

        page.navigate("https://www.google.com", new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.NETWORKIDLE));

        page.locator("textarea[name='q']").fill(query);
        page.keyboard().press("Enter");

        // More reliable than hard-coded timeout
        page.waitForURL("**/search**");

        return "Searched : " + query;
    }

    @Override
    public String click(String selector) {
        getPage().locator(selector).click();
        return "Clicked : " + selector;
    }

    @Override
    public String type(String selector, String text) {
        getPage().locator(selector).fill(text);
        return "Typed : " + text;
    }

    @Override
    public String waitFor(int milliseconds) {
        getPage().waitForTimeout(milliseconds);
        return "Waited : " + milliseconds + " ms";
    }

    @Override
    public String takeScreenshot(String fileName) {
        getPage().screenshot(
                new Page.ScreenshotOptions()
                        .setPath(java.nio.file.Paths.get(fileName))
        );
        return "Screenshot Saved : " + fileName;
    }

    @Override
    public String closeBrowser() {
        if (browserSession.getBrowser() != null) {
            browserSession.getBrowser().close();
        }

        browserSession.setBrowser(null);
        browserSession.setContext(null);
        browserSession.setPage(null);

        return "Browser Closed";
    }
}