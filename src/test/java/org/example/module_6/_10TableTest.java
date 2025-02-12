package org.example.module_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class _10TableTest extends BaseTest {

    @Test
    void shouldReturnAllTextFromTable() {
        page.navigate("https://the-internet.herokuapp.com//tables");
        List<String> strings = page.locator("table#table1 td").allInnerTexts();

        strings.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    void shouldReturnAllUsersFromTable() {
        page.navigate("https://the-internet.herokuapp.com//tables");
        List<Locator> rows = page.locator("table#table1 tbody tr").all();

        List<TableUser> users = rows.stream()
                .map(row -> {
                    List<Locator> cells = row.getByRole(AriaRole.CELL).all();
                    String lastName = cells.get(0).innerText();
                    String firstName = cells.get(1).innerText();
                    String email = cells.get(2).innerText();
                    String due = cells.get(3).innerText();
                    String website = cells.get(4).innerText();
                    Locator action = cells.get(5);
                    return new TableUser(firstName, lastName, email, due, website, action);
                }).toList();

        TableUser frank = users.stream()
                .filter(user -> user.getFirstName().startsWith("Frank"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        frank.getAction().getByText("edit").click();

        page.waitForTimeout(2000);

    }
}
