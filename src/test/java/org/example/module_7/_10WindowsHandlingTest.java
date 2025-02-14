package org.example.module_7;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

class _10WindowsHandlingTest {

    private Playwright pw = Playwright.create();
    private Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

    @Test
    void shouldOpenMultipleWindowsTest() {
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

        page.locator("#email").fill("demouser@akademiaqa.pl");
        page.getByLabel("Password").fill("123456");
        page.locator("#SubmitLogin").click();

        BrowserContext browserContext1 = browser.newContext();
        Page page1 = browserContext1.newPage();

        page1.navigate("http://automationpractice.pl/index.php");
        page1.locator("a[title=Women]").click();

        page.waitForTimeout(5000);

    }

}
