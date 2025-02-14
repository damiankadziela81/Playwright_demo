package org.example.module_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.assertj.core.api.Assertions;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class _12JavaScriptTest extends BaseTest {

    // https://developer.mozilla.org/en-US/docs/Web/API/Window

    @Test
    void evaluateTest() {
        page.navigate("https://the-internet.herokuapp.com");
        String window = (String) page.evaluate("window.origin");
        System.out.println("WindowInfo: " + window);
    }

    @Test
    void evalOnSelectorTest() {
        page.navigate("https://the-internet.herokuapp.com");
        PlaywrightAssertions.assertThat(page.getByText("Welcome to the-internet")).isVisible();
        page.evalOnSelector("h1[class=heading]", "e => e.remove()");
        page.waitForTimeout(2000);
        PlaywrightAssertions.assertThat(page.locator("h1[class=heading]")).not().isVisible();
    }

    @Test
    void evalOnSelectorAllTest() {
        page.navigate("https://the-internet.herokuapp.com");
        Integer numberOfLinks = (Integer) page.evalOnSelectorAll("ul li", "e => e.length");
        Assertions.assertThat(numberOfLinks).isEqualTo(44);
    }

}
