package org.example.module_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import org.example.module_8.pages.BasePage;

import java.nio.file.Paths;

@Getter
public class ContactUsFormSection extends BasePage {

    private Locator sendMessageButton;
    private Locator errorMessage;
    private Locator subjectHeading;
    private Locator emailAddressInput;
    private Locator orderReferenceInput;
    private Locator fileUploadInput;
    private Locator messageText;
    private Locator confirmationMessageText;

    public ContactUsFormSection(Page page) {
        super(page);
        this.sendMessageButton = page.locator("#submitMessage");
        this.errorMessage = page.getByText("Invalid email address.");
        this.subjectHeading = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Subject Heading"));
//        this.subjectHeading = page.locator("#id_contact");
        this.emailAddressInput = page.getByLabel("Email address");
        this.orderReferenceInput = page.locator("#id_order");
        this.fileUploadInput = page.locator("#fileUpload");
        this.messageText = page.getByLabel("Message");
        this.confirmationMessageText = page.getByText("Your message has been successfully sent to our team.");
    }

    public void clickSendMessageButton() {
        sendMessageButton.click();
    }

    public void selectSubjectHeading(String option) {
        subjectHeading.selectOption(option);
    }

    public void enterEmailAddress(String email) {
        emailAddressInput.fill(email);
    }

    public void enterOrderReference(String order) {
        orderReferenceInput.fill(order);
    }

    public void selectFileToUpload(String path) {
        fileUploadInput.setInputFiles(Paths.get(path));
    }

    public void enterMessage(String message) {
        messageText.fill(message);
    }
}
