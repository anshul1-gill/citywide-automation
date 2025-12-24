package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentMySchedulePage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    // Locators
    private By linkMySchedule = By.xpath("//span[text()='My Schedule']");
    private By notificationOpenShift = By.xpath("//div[contains(text(),'An open shift is now available')]");
    private By openShiftOnCalendar = By.xpath("//p[contains(normalize-space(),'Open Shift')]");
    private By btnAccept = By.xpath("//button[.//span[normalize-space()='Accept']]");
    private By btnReject = By.xpath("//button[.//span[normalize-space()='Reject']]");
    private By txtRejectReason = By.id("reason");
    private By btnSaveRejection = By.xpath("//button[@type='submit']//span[text()='Save']");
    private By btnOkConfirmation = By.xpath("//button[normalize-space()='OK']");

    // Constructor
    public FieldAgentMySchedulePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    /**
     * Navigate to My Schedule page
     */
    public void navigateToMySchedule() throws InterruptedException {
        try {
            elementUtils.waitForElementToBeClickable(linkMySchedule, Constants.DEFAULT_WAIT).click();
            System.out.println("✅ Navigated to 'My Schedule'");
            Thread.sleep(2000); // Wait for page to load
        } catch (Exception e) {
            System.out.println("❌ Failed to navigate to My Schedule");
            throw e;
        }
    }

    /**
     * Click on open shift notification
     */
    public void clickOnOpenShift() throws InterruptedException {
        try {
            elementUtils.waitForElementToBeClickable(openShiftOnCalendar, Constants.DEFAULT_WAIT).click();
            System.out.println("✅ Clicked on open shift");
            Thread.sleep(2000); // Wait for modal to open
        } catch (Exception e) {
            System.out.println("❌ Failed to click on open shift");
            throw e;
        }
    }

    /**
     * Click Accept button
     */
    public void clickAcceptButton() throws InterruptedException {
        try {
            elementUtils.waitForElementToBeClickable(btnAccept, Constants.DEFAULT_WAIT).click();
            System.out.println("✅ Clicked 'Accept' button");
            Thread.sleep(1000); // Wait for confirmation modal
        } catch (Exception e) {
            System.out.println("❌ Failed to click Accept button");
            throw e;
        }
    }

    /**
     * Click Reject button
     */
    public void clickRejectButton() throws InterruptedException {
        try {
            elementUtils.waitForElementToBeClickable(btnReject, Constants.DEFAULT_WAIT).click();
            System.out.println("✅ Clicked 'Reject' button");
            Thread.sleep(1000); // Wait for rejection reason modal
        } catch (Exception e) {
            System.out.println("❌ Failed to click Reject button");
            throw e;
        }
    }

    /**
     * Enter rejection reason
     */
    public void enterRejectionReason(String reason) throws InterruptedException {
        try {
            WebElement reasonField = elementUtils.waitForElementVisible(txtRejectReason, Constants.DEFAULT_WAIT);
            reasonField.clear();
            reasonField.sendKeys(reason);
            System.out.println("✅ Entered rejection reason: " + reason);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("❌ Failed to enter rejection reason");
            throw e;
        }
    }

    /**
     * Click Save button after entering rejection reason
     */
    public void clickSaveRejection() throws InterruptedException {
        try {
            elementUtils.waitForElementToBeClickable(btnSaveRejection, Constants.DEFAULT_WAIT).click();
            System.out.println("✅ Clicked 'Save' button for rejection");
            Thread.sleep(2000); // Wait for rejection to be processed
        } catch (Exception e) {
            System.out.println("❌ Failed to click Save button");
            throw e;
        }
    }

    /**
     * Click OK on confirmation modal
     */
    public void clickOkConfirmation() throws InterruptedException {
        try {
            elementUtils.waitForElementToBeClickable(btnOkConfirmation, Constants.DEFAULT_WAIT).click();
            System.out.println("✅ Clicked 'OK' on confirmation modal");
            Thread.sleep(2000); // Wait for action to complete
        } catch (Exception e) {
            System.out.println("❌ Failed to click OK button");
            throw e;
        }
    }

    /**
     * Verify open shift notification is visible
     */
    public boolean isOpenShiftNotificationVisible() {
        try {
            return elementUtils.isElementVisible(notificationOpenShift, 5);
        } catch (Exception e) {
            return false;
        }
    }
}
