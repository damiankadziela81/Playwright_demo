package org.example.module_8.pages;

import com.microsoft.playwright.Page;

public class BasePage {

    protected Page page;

    public BasePage(final Page page) {
        this.page = page;
    }
}
