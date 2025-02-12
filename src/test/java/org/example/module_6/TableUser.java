package org.example.module_6;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
class TableUser {

    private String firstName;
    private String lastName;
    private String email;
    private String due;
    private String website;
    private Locator action;

}
