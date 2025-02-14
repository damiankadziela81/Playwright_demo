package org.example.module_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.common.BaseTestWithTrace;
import org.junit.jupiter.api.Test;

class _8TracingTest extends BaseTestWithTrace {

    @Test
    void tracingTest() {
        // check BaseTestWithTrace class on how to enable trace options (BeforeEach AfterEach)
        page.navigate("https://the-internet.herokuapp.com");
        page.getByText("Form Authentication").click();
        page.fill("#username", "tom");
        page.fill("#password", "pass123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }

    //after trace is generated use trace.playwright.dev website to analyze it
}
