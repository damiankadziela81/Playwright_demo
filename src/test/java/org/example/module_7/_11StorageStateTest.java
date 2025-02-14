package org.example.module_7;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class _11StorageStateTest {

    private Playwright pw = Playwright.create();
    private Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

    @Test
    void shouldSaveStorageStateAfterLoginTest() {
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        page.locator("#email").fill("demouser@akademiaqa.pl");
        page.getByLabel("Password").fill("123456");
        page.locator("#SubmitLogin").click();

        // save browser session
        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("storage/aplogin.json")));
    }

    @Test
    void shouldLoadStorageStateTest() {
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("storage/aplogin.json")));
        Page page = browserContext.newPage();
        page.navigate("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        PlaywrightAssertions.assertThat(page.locator("h1[class=page-heading]")).hasText("My account");
        page.waitForTimeout(3000);
    }
}
