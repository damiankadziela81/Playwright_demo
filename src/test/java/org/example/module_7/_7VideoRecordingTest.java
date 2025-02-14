package org.example.module_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.common.BaseTestWithRecording;
import org.junit.jupiter.api.Test;

class _7VideoRecordingTest extends BaseTestWithRecording {

    @Test
    void videoTest() {
        // see context init in BaseTestWithRecording
        page.navigate("https://the-internet.herokuapp.com/login");
        page.fill("#username", "user");
        page.fill("#password", "pass123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

    }
}
