package org.example.module_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import org.example.module_8.dto.ContactUsDTO;
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

    public ContactUsFormSection clickSendMessageButton() {
        sendMessageButton.click();
        return this;
    }

    private ContactUsFormSection selectSubjectHeading(String option) {
        subjectHeading.selectOption(option);
        return this;
    }

    private ContactUsFormSection enterEmailAddress(String email) {
        emailAddressInput.fill(email);
        return this;
    }

    private ContactUsFormSection enterOrderReference(String order) {
        orderReferenceInput.fill(order);
        return this;
    }

    private ContactUsFormSection selectFileToUpload(String path) {
        fileUploadInput.setInputFiles(Paths.get(path));
        return this;
    }

    private ContactUsFormSection enterMessage(String message) {
        messageText.fill(message);
        return this;
    }

    public ContactUsFormSection sendContactUsForm(ContactUsDTO dto) {
        selectSubjectHeading(dto.getSubjectHeading())
                .enterEmailAddress(dto.getEmailAddress())
                .enterOrderReference(dto.getOrderReference())
                .selectFileToUpload(dto.getFileToUpload())
                .enterMessage(dto.getMessage())
                .clickSendMessageButton();
        return  this;
    }
}
