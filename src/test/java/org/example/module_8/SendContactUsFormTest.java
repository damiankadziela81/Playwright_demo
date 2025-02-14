package org.example.module_8;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.example.common.BaseTest;
import org.example.module_8.dto.ContactUsDTO;
import org.example.module_8.pages.ContactUsPage;
import org.example.module_8.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SendContactUsFormTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEachTest() { // be careful not to override beforeEach method in BaseTest class!
        homePage = new HomePage(page);
        page.navigate("http://www.automationpractice.pl/index.php?");
    }

    @Test
    void shouldShowErrorWhenTryingSendEmptyForm() {

        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickOnContactUsLink();
        contactUsPage.getContactUsFormSection().clickSendMessageButton();
        PlaywrightAssertions.assertThat(contactUsPage.getContactUsFormSection().getErrorMessage()).isVisible();
    }

    @Test
    void shouldFillAndSendContactFormTest() {
        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickOnContactUsLink();
        contactUsPage.getContactUsFormSection().sendContactUsForm(ContactUsDTO.getDefaultContactUsDTO());
        PlaywrightAssertions.assertThat(contactUsPage.getContactUsFormSection().getConfirmationMessageText()).isVisible();
    }
}
