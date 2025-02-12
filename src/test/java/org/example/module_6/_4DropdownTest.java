package org.example.module_6;

import com.microsoft.playwright.options.AriaRole;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class _4DropdownTest extends BaseTest {

    @Test
    void dropdownTest() {
        page.navigate("https://the-internet.herokuapp.com/dropdown");
        page.selectOption("#dropdown", "1");
//        page.selectOption("#dropdown", "Option 2");
    }

    @Test
    void multiSelectTest() {
        page.navigate("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        page.getByRole(AriaRole.LISTBOX).selectOption(new String[] {"ms2", "ms3", "ms4"});
        page.waitForTimeout(3000);
    }
}
