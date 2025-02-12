package org.example.module_6;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _1PageTest extends BaseTest {

    @Test
    void pageTestOptions() {
        page.navigate("https://the-internet.herokuapp.com", new Page.NavigateOptions().setTimeout(10000));

        page.navigate("https://the-internet.herokuapp.com", new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        // 1. DOMCONTENTLOADED - html loaded, css and js not yet loaded
        // 2. LOAD - html, css and js loaded | DEFAULT
        // 3. NETWORKIDLE - no more additional requests for 500ms

        page.navigate("https://the-internet.herokuapp.com", new Page.NavigateOptions().setReferer("https://onet.pl"));

        // page traversing
        page.reload();
        page.goBack();
        page.goForward();

        // mouse click options
        page.click("",new Page.ClickOptions().setClickCount(10));
        page.click("", new Page.ClickOptions().setButton(MouseButton.RIGHT));
        page.dblclick("");

        // multiple keyboard keys
        page.click("",new Page.ClickOptions().setModifiers(Arrays.asList(KeyboardModifier.CONTROL, KeyboardModifier.ALT)));

        // checkbox interaction
        page.check("");
        page.uncheck("");
    }
}
