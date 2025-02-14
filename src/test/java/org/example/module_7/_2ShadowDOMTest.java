package org.example.module_7;

import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class _2ShadowDOMTest extends BaseTest {

    @Test
    void shadowDOMTest() {
        page.navigate("https://the-internet.herokuapp.com/shadowdom");
        // if #shadow-root (closed) you can't get to it with PW
        System.out.println(page.locator("span[slot=my-text]").innerText());
    }

}
