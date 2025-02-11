package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class firstTest {

    @Test
    void test1() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();

        page.navigate("https://playwright.dev");
        Assertions.assertThat(page.title()).isEqualTo("Playwright");
    }
}
