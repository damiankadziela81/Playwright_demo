package org.example.common;

import com.microsoft.playwright.*;
import org.example.utils.StringUtils;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTestWithTrace {

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

        // for tracing
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true)
        );

        page = context.newPage();
    }

    @AfterEach
    void afterEach(TestInfo testInfo)
    {
        String traceName = "traces/trace_"
                + StringUtils.removeParentheses(testInfo.getDisplayName()) + "_"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".zip";

        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
        context.close(); // no need for page.close() as this will close all pages as well
    }

    @AfterAll
    static void afterAll() {
        pw.close(); // no need for browser.close() as this will close all browsers as well
    }

}
