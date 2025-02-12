package org.example.module_6;

import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

class _3TextTest extends BaseTest {

    @Test
    void textTest() {
        page.navigate("https://the-internet.herokuapp.com/notification_message_rendered");

        // 1 .innerHTML() - tags + text
//        System.out.println(page.innerHTML("#content"));

        // 2 .innerText() - text
//        System.out.println(page.innerText("#content"));

        // 3 .textContent() - text (including invisible text on page)
//        System.out.println(page.textContent("#content"));

        // 4 .getAttribute() - attributes of html element
        System.out.println(page.getAttribute("div img","alt"));

    }
}
