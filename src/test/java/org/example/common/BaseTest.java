package org.example.common;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private static Playwright pw;
    private static Browser browser;

    private BrowserContext context;
    protected Page page;

    @BeforeAll
    static  void beforeAll() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    void beforeEach() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void afterEach() {
        context.close(); // no need for page.close() as this will close all pages as well
    }

    @AfterAll
    static void afterAll() {
        pw.close(); // no need for browser.close() as this will close all browsers as well
    }

}
