package org.example.module_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.module_8.pages.BasePage;
import org.example.module_8.pages.ContactUsPage;

public class TopMenuSection extends BasePage {

    private Locator contactUsLink;

    public TopMenuSection(Page page) {
        super(page);
        this.contactUsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us"));
    }

    public ContactUsPage clickOnContactUsLink() {
        contactUsLink.click();
        // according to Page Object Patter if we perform action that will take us to another page we need to return this new page's object
        return new ContactUsPage(page);
    }
}
