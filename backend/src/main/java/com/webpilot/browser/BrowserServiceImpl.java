package com.webpilot.browser;

import com.microsoft.playwright.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrowserServiceImpl implements BrowserService {

    private final Playwright playwright;
    private final BrowserSession browserSession;

    @Override
    public String openWebsite(String url) {

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate(url);

        browserSession.setBrowser(browser);
        browserSession.setContext(context);
        browserSession.setPage(page);

        return "Opened : " + url;
    }

    @Override
    public String searchGoogle(String query) {

        if(browserSession.getPage()==null){
            return "Browser not started";
        }

        Page page = browserSession.getPage();

        page.navigate("https://www.google.com");

        page.locator("textarea[name='q']").fill(query);

        page.keyboard().press("Enter");

        page.waitForTimeout(3000);

        return "Searched : " + query;
    }

    @Override
    public String closeBrowser() {

        if(browserSession.getBrowser()!=null){
            browserSession.getBrowser().close();
        }

        return "Browser Closed";
    }

}