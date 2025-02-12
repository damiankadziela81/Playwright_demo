package org.example.module_6;

import com.microsoft.playwright.Page;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class _2InputTest extends BaseTest {

    @Test
    void inputTest() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.fill("#username", "tom"); // paste whole String in one go
        page.type("#password", "pass"); // types in letter-by-letter (useful for autocomplete-type inputs)

        // allows to access input if it's obscured by other element
        page.fill("","value",new Page.FillOptions().setForce(true)); // default - false
    }
}
