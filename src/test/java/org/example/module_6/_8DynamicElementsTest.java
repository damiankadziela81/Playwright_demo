package org.example.module_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class _8DynamicElementsTest extends BaseTest {

    @Test
    void dynamicElementTest1() {
        // Ex1: hidden element revealed after button click
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/1");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        PlaywrightAssertions.assertThat(text).not().isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        PlaywrightAssertions.assertThat(text).isVisible();
    }

    @Test
    void dynamicElementTest2() {
        // Ex2: element rendered after the button click
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/2");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        PlaywrightAssertions.assertThat(text).not().isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        PlaywrightAssertions.assertThat(text).isVisible();
    }

    @Test
    void dynamicControlsTest1() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        PlaywrightAssertions.assertThat(page.locator("#checkbox")).isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove")).click();
        PlaywrightAssertions.assertThat(page.locator("#checkbox")).not().isVisible();
        PlaywrightAssertions.assertThat(page.getByText("It's gone!")).isVisible();
    }

    @Test
    void dynamicControlsTest2() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        PlaywrightAssertions.assertThat(page.locator("input[type=text]")).isDisabled();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable")).click();
        PlaywrightAssertions.assertThat(page.locator("input[type=text]")).isEnabled();
        PlaywrightAssertions.assertThat(page.getByText("It's enabled!")).isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Disable")).click();
        PlaywrightAssertions.assertThat(page.locator("input[type=text]")).isDisabled();
        PlaywrightAssertions.assertThat(page.getByText("It's disabled!")).isVisible();
    }
}
