package org.example.module_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class Practice extends BaseTest {

    @Test
    void shouldDisplayErrorMessageTest() {
        page.navigate("http://www.automationpractice.pl/index.php?");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.locator("#submitMessage").click();
        PlaywrightAssertions.assertThat(page.getByText("Invalid email address.")).isVisible();
    }

    @Test
    void shouldFillAndSendFormTest() {
        page.navigate("http://www.automationpractice.pl/index.php?");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Subject Heading")).selectOption("2");
        page.getByLabel("Email address").fill("tom@gmail.com");
        page.locator("#id_order").fill("123");
        page.setInputFiles("#fileUpload", Paths.get("uploads/sample-text-file.txt"));
        page.getByLabel("Message").fill("message");
        page.locator("#submitMessage").click();
        PlaywrightAssertions.assertThat(page.getByText("Your message has been successfully sent to our team.")).isVisible();
    }
}
