package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import com.dits.citywide.utilities.ElementUtils;

public class ClientPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    private By btnAddNewClient = By.xpath("//a[normalize-space()='Add new']");
    private By dropdownSelectSites = By.xpath("//label[contains(text(),'Site') or contains(text(),'Select Site')]/following-sibling::div//input[@role='combobox']");
    private By txtClientId = By.xpath("//input[@name='badge_number']");
    private By txtClientfirstname = By.xpath("//input[@name='first_name']");
    private By txtClientLastName = By.xpath("//input[@name='last_name']");
    private By txtphoneNumber = By.xpath("//input[@name='main_phone']");
    private By txtClientEmail = By.xpath("//input[@name='email']");
    private By txtPassword = By.name("password");
    private By txtConfirmPassword = By.name("password_confirmation");
    private By dropdownClientStatus = By.xpath("//select[@id='status']");
    private By CheckboxActivitytracking = By.xpath("//input[@type='checkbox']");
    private By textareaCmnt = By.xpath("//textarea[@id='comments']");
    private By btnAddClient = By.xpath("//button[@id='submitButton']");
    private By selectAssignSite = By.id("assign_site");

    // Success message locator
    private By successMessage = By.cssSelector(".alert-success, .success-message, .alert.alert-success");

    public ClientPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    // Click on 'Add new' client button
    public void clickAddNewClient() {
        if (elementUtils.doIsClickable(btnAddNewClient, 10)) {
            elementUtils.doClick(btnAddNewClient);
            try {
                WebElement combo = driver.findElement(dropdownSelectSites);
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", combo);
                combo.click();
            } catch (Exception e) {
                System.out.println("[ClientPage] Site dropdown focus attempt failed: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("Add New Client button not clickable");
        }
    }

    // Handle both hidden <select> or virtual dropdowns
    private void selectSites(List<String> sites) {
        if (sites == null || sites.isEmpty()) return;
        try {
            // Try normal select first
            elementUtils.selectOptionsInHiddenMultiSelect(selectAssignSite, sites, 10);
            System.out.println("[ClientPage] Selected sites via hidden multi-select: " + sites);
        } catch (Exception e1) {
            System.out.println("[ClientPage] Hidden select failed, retrying virtual dropdown method...");
            try {
                for (String site : sites) {
                    elementUtils.selectVirtualDropdownOption(driver, site);
                }
                System.out.println("[ClientPage] Selected sites via virtual dropdown: " + sites);
            } catch (Exception e2) {
                throw new RuntimeException("Failed to select sites (both methods failed): " + sites, e2);
            }
        }
    }

    // Fill client creation form
    public void createNewClient(String badgeId, List<String> sites, String firstName, String lastName,
                                String phone, String email, String password, String status,
                                boolean activityTracking, String comments) {

        // 1) Select Sites FIRST
        selectSites(sites);

        // 2) Fill text fields
        elementUtils.doSendKeysWithClear(txtClientId, badgeId);
        elementUtils.doSendKeysWithClear(txtClientfirstname, firstName);
        elementUtils.doSendKeysWithClear(txtClientLastName, lastName);
        elementUtils.doSendKeysWithClear(txtphoneNumber, phone);
        elementUtils.doSendKeysWithClear(txtClientEmail, email);

        // Password fields
        elementUtils.doSendKeysWithClear(txtPassword, password);
        elementUtils.doSendKeysWithClear(txtConfirmPassword, password);

        // 3) Status dropdown (handle both <select> or virtual)
        try {
            elementUtils.doSelectBy(dropdownClientStatus, status);
        } catch (Exception e) {
            System.out.println("[ClientPage] Standard select failed, retrying virtual dropdown...");
            try {
                elementUtils.selectVirtualDropdownOption(driver, status);
            } catch (Exception e2) {
                System.out.println("[ClientPage][WARN] Failed to select Status: " + e2.getMessage());
            }
        }

        // 4) Activity tracking checkbox
        try {
            WebElement checkbox = driver.findElement(CheckboxActivitytracking);
            if (activityTracking && !checkbox.isSelected()) {
                elementUtils.safeClick(CheckboxActivitytracking);
            } else if (!activityTracking && checkbox.isSelected()) {
                elementUtils.safeClick(CheckboxActivitytracking);
            }
        } catch (Exception e) {
            throw new RuntimeException("[ClientPage] Activity tracking checkbox interaction failed: " + e.getMessage(), e);
        }

        // 5) Comments
        if (comments != null && !comments.isBlank()) {
            elementUtils.doSendKeysWithClear(textareaCmnt, comments);
        }
    }

    // Click the final Add Client button
    public void clickAddClientButton() {
        try {
            elementUtils.waitForElementToBeVisibleAndEnabled(btnAddClient, 15);
            elementUtils.safeClick(btnAddClient);
        } catch (Exception e) {
            System.out.println("[ClientPage] safeClick failed, trying jsClick: " + e.getMessage());
            try {
                elementUtils.jsClick(btnAddClient);
            } catch (Exception e2) {
                throw new RuntimeException("Add Client submit button not clickable after retries", e2);
            }
        }
    }

    // Check success message
    public boolean isSuccessMessageDisplayed() {
        return elementUtils.doIsDisplayed(successMessage, 10);
    }

    // Verify if a client email exists in table
    public boolean isClientPresent(String email) {
        List<WebElement> emailCells = driver.findElements(By.xpath("//table//td[contains(text(), '" + email + "')]"));
        return !emailCells.isEmpty();
    }
}
