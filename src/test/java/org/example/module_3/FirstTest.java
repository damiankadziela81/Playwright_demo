package org.example.module_3;

import org.assertj.core.api.Assertions;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class FirstTest extends BaseTest {

    @Test
    void shouldReturnCorrectPageTitle() {
        page.navigate("https://playwright.dev");
        Assertions.assertThat(page.title()).isEqualTo("Fast and reliable end-to-end testing for modern web apps | Playwright");
    }
}
