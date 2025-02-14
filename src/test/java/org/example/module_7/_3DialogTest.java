package org.example.module_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class _3DialogTest extends BaseTest {

    @Test
    void dialogAlertTest() { // dialog pop-up will be automatically closed by PW, in this case by OK button by default
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        // handler always before click action!
        page.onDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.accept();
        });
        // in this case the handler is not really needed since PW will close the pop-up automatically
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Alert")).click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You successfully clicked an alert");
    }

    @Test
    void dialogConfirmTest() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.onDialog(dialog -> {
            dialog.accept();
        });

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Ok");
    }

    @Test
    void dialogDismissTest() { // this is default behavior if not using the handler - CANCEL
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.onDialog(dialog -> {
            dialog.dismiss();
        });

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Cancel");
    }

    @Test
    void dialogConfirmAndDismissTest() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        // if you want to handle a pop-up dialog several times differently use onceDialog
        page.onceDialog(dialog -> {
            dialog.accept();
        });

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Ok");

        page.onceDialog(dialog -> {
            dialog.dismiss();
        });

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Cancel");
    }

    @Test
    void dialogPromptTest() { // by default enter nothing and press CANCEL
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.onceDialog(dialog -> dialog.accept("test"));

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Prompt")).click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You entered: test");
    }
}
