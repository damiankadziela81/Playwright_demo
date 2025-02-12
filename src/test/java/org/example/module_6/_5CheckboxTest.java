package org.example.module_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class _5CheckboxTest extends BaseTest {

    @Test
    void checkboxTest() {
        page.navigate("https://the-internet.herokuapp.com/checkboxes");
        Locator firstCheckbox = page.getByRole(AriaRole.CHECKBOX).first();
        firstCheckbox.check();
        Locator lastCheckbox = page.getByRole(AriaRole.CHECKBOX).last();
        lastCheckbox.uncheck();

        PlaywrightAssertions.assertThat(firstCheckbox).isChecked();
        PlaywrightAssertions.assertThat(lastCheckbox).not().isChecked();

    }
}
