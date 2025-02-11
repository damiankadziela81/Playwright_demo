package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class AllBrowserTest {

    @Test
    void shouldOpenSupportedBrowsersChromium() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();

        page.navigate("https://www.whatismybrowser.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/chromium.png")));
    }

    @Test
    void shouldOpenSupportedBrowsersFirefox() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch();
        Page page = browser.newPage();

        page.navigate("https://www.whatismybrowser.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/firefox.png")));
    }
}
