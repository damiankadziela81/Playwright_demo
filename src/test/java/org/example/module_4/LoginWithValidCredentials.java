package org.example.module_4;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

// add "PWDEBUG=1" as Environment Variable in Run/Debug Configuration for debug mode

class LoginWithValidCredentials extends BaseTest {

    @Test
    void shouldLoginWithValidCredentials() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("Password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).isVisible();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
        PlaywrightAssertions.assertThat(page.getByText("You logged out of the secure area!")).isVisible();
    }
}
