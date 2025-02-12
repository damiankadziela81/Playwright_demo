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
//        page.pause(); // can be used to record user actions and generate code!
        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("Password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).isVisible();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
        PlaywrightAssertions.assertThat(page.getByText("You logged out of the secure area!")).isVisible();
    }

    @Test
    void shouldNotLoginWithoutCredentials() {
        page.navigate("https://the-internet.herokuapp.com");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
    }

    @Test
    void shouldNotLoginWithInvalidUsername() {
        page.navigate("https://the-internet.herokuapp.com");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication")).click();
        page.getByLabel("Username").fill("tom");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
    }

    @Test
    void shouldNotLoginWithInvalidPassword() {
        page.navigate("https://the-internet.herokuapp.com");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication")).click();
        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("Password").fill("password");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        PlaywrightAssertions.assertThat(page.getByText("Your password is invalid!")).isVisible();
    }

}
