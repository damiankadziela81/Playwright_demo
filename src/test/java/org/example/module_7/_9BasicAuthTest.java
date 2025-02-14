package org.example.module_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.example.common.BaseTestWithBasicAuth;
import org.junit.jupiter.api.Test;

class _9BasicAuthTest extends BaseTestWithBasicAuth {

    @Test
    void basicAuthTest() {
        // see BaseTestWithBasicAuth for different context init in BeforeEach
        page.navigate("https://the-internet.herokuapp.com/basic_auth");
        PlaywrightAssertions.assertThat(page.getByText("Congratulations! You must have the proper credentials."));
    }

}
