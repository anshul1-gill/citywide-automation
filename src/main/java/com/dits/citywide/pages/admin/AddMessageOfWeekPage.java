package com.dits.citywide.pages.admin;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class AddMessageOfWeekPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    // Locators
    private By messageOfWeekLink = By.xpath("//a[normalize-space()='Message Of The Week']");
    private By addNewMessageButton = By.xpath("//a[normalize-space()='Add New Message']");
    private By messageTypeDropdown = By.xpath("//label[contains(normalize-space(),'Message Type')]/following::input[contains(@aria-haspopup,'true')]");
    private By selectAdminOption = By.xpath("//span[contains(normalize-space(.), 'Select all')]/input[@type='checkbox']");
    private By messageSubjectTextbox = By.id("message_subject");
    private By messageTextArea = By.id("message_text");
    private By submitButton = By.xpath("//button[@id='submitButton' and contains(normalize-space(text()),'Add New Message')]");
    

    public AddMessageOfWeekPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }
    
    
 // Locator for success toast / confirmation message
    private By successMessageToast = By.xpath("//div[contains(text(),'Message of the week published successfully')]");

    // Navigate to Message of the Week Page
    public void navigateToMessageOfWeek() {
        elementUtils.safeClick(messageOfWeekLink);
    }

    // Add a new message
    public void addNewMessage(String messageType, String subject, String message) throws InterruptedException {
        elementUtils.safeClick(addNewMessageButton);

        // Select message type (React dropdown)
        elementUtils.selectFromReactDropdown(messageTypeDropdown, messageType);

        elementUtils.checkCheckbox(selectAdminOption);
        // Fill message details
        elementUtils.doSendKeysWithClear(messageSubjectTextbox, subject);
        elementUtils.doSendKeysWithClear(messageTextArea, message);

        // Submit
        elementUtils.safeClick(submitButton);
    }
}