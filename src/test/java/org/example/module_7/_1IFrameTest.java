package org.example.module_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class _1IFrameTest extends BaseTest {

    @Test
    void shouldGetAttributeFromFrame() {
        page.navigate("https://the-internet.herokuapp.com/iframe");
        // if frame element doesn't have name attribute use frameLocator with locator as parameter
        System.out.println(page.frameLocator("#mce_0_ifr").locator("#tinymce").getAttribute("contenteditable"));
    }

    @Test
    void shouldGetTextFromNestedFrames() {
        page.navigate("https://the-internet.herokuapp.com/nested_frames");
        // if frame element has a name attribute use frame method with name as parameter
        PlaywrightAssertions.assertThat(page.frame("frame-middle").locator("#content")).hasText("MIDDLE");
    }
}
