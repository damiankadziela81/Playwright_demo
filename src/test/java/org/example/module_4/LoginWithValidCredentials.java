package org.example.module_4;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

// add "PWDEBUG=1" as Environment Variable in Run/Debug Configuration for debug mode

class LoginWithValidCredentials extends BaseTest {

    @Test
    void shouldLoginWithValidCredentials() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.fill("#username","tomsmith"); // id=username == #username
        page.fill("id=password","SuperSecretPassword!");
        page.click("#login button"); // css selector - button in the login form
        PlaywrightAssertions.assertThat(page.locator("text=You logged into a secure area!")).isVisible();
        page.click("//i[contains(text(), 'Logout')]"); // xpath selector
        PlaywrightAssertions.assertThat(page.locator("text=You logged out of the secure area!")).isVisible();
    }
}
