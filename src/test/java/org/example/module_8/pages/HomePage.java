package org.example.module_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.module_8.pages.sections.TopMenuSection;

public class HomePage extends BasePage{


    @Getter
    private TopMenuSection topMenuSection;

    public HomePage(final Page page) {
        super(page);
        this.topMenuSection = new TopMenuSection(page);
    }

}
