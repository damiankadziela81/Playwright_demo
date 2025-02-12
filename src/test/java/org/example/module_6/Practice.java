package org.example.module_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.assertj.core.api.Assertions;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;

class Practice extends BaseTest {

    @Test
    void shouldVerifyAllProductsContainsPrinted() {
        page.navigate("http://www.automationpractice.pl/index.php?");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dresses").setExact(true)).click();

        List<Locator> nameLocators = page.locator(".right-block .product-name").all();
        nameLocators.forEach(locator -> PlaywrightAssertions.assertThat(locator).containsText("Printed"));

        nameLocators.forEach(locator -> System.out.println(locator.allInnerTexts()));
    }

    @Test
    void shouldVerifyAllProductPricesAbove15() {
        page.navigate("http://www.automationpractice.pl/index.php?");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dresses").setExact(true)).click();

        List<Double> convertedPrices = page.locator(".right-block .price").allInnerTexts().stream()
                .map(price -> price.replace("$",""))
                .map(Double::parseDouble)
                .toList();

        Assertions.assertThat(convertedPrices.stream().allMatch(p -> p>15)).isTrue();

        convertedPrices.forEach(System.out::println);

    }
}
