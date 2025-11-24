package com.dits.citywide.pages.admin;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class ServiceTypePage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    // ---------- Locators ----------
    private By txtServiceTypeHeader = By.xpath("//h4[normalize-space()='Service Types']");
    private By btnAddServiceType = By.xpath("//a[normalize-space()='Add New Service']");
    private By inputServiceTypeName = By.id("name");
    private By inputServiceTypeCode = By.id("code");
    private By dropdownIsActive = By.id("status");
    private By dropdownServiceType = By.id("main_service");
    private By inputServiceTypeDescription = By.id("description");
    private By dropdownDepartmenttype = By.xpath("(//div[@data-te-select-form-outline-ref]//input[@data-te-select-input-ref and @readonly='true'])[2]");
    private By btnsubmitServiceType = By.xpath("//button[normalize-space()='Add New Service']");

    private List<By> btnSubmitServiceType = Arrays.asList(
            By.cssSelector("button[type='submit']"),
            By.xpath("//button[@type='submit']"),
            By.xpath("//button[contains(@type,'submit')]")
    );

    private By inputSearchServiceType = By.xpath("//input[@placeholder='Search']");
    private By btnEditServiceType = By.xpath("//button[@title='Edit Service']");
    private By btnDeleteServiceType = By.xpath("//button[@title='Delete Service Type']");
    private By btnConfirmDelete = By.xpath("//button[normalize-space()='OK']");

    private By txtAddSuccessMessage = By.xpath("//span[normalize-space()='Information Saved Successfully.']");

    private By txtUpdateSuccessMessage = By.xpath("//span[normalize-space()='Information Updated Successfully.']");

    private By txtDeleteSuccessMessage = By.xpath("//span[contains(normalize-space(),'Record Deleted Successfully.']");


    // ---------- Constructor ----------
    public ServiceTypePage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }

    // ---------- Visibility checks ----------
    public boolean isServiceTypeHeaderVisible() {
        return elementUtils.doIsDisplayed(txtServiceTypeHeader, Constants.DEFAULT_WAIT);
    }

    public boolean isAddServiceTypeButtonVisible() {
        return elementUtils.doIsDisplayed(btnAddServiceType, Constants.DEFAULT_WAIT);
    }

    // ---------- Add new Service Type ----------
    public void clickAddServiceTypeButton() {
        elementUtils.waitForElementToBeClickable(btnAddServiceType, Constants.DEFAULT_WAIT).click();
    }

    public void fillAddServiceTypeForm(String name,String code ,  String description) {
        elementUtils.waitForElementVisible(inputServiceTypeName, Constants.DEFAULT_WAIT).sendKeys(name);
        elementUtils.waitForElementVisible(inputServiceTypeCode, Constants.DEFAULT_WAIT).sendKeys(code);
        elementUtils.waitForElementVisible(inputServiceTypeDescription, Constants.DEFAULT_WAIT).sendKeys(description);
    }

    // ---------- Dropdowns ----------
    public void selectServiceStatus(String status) {
        elementUtils.doSelectBy(dropdownIsActive, status);
    }

    public void selectMainService(String service) {
        elementUtils.doSelectBy(dropdownServiceType, service);
    }

    public void selectDepartment(String departmentName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // 1️⃣ Locate and click the visible Department dropdown input
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//label[normalize-space(text())='Department Type']/ancestor::div[contains(@class,'relative')]//input[@data-te-select-input-ref])[2]")
            ));
            js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
            js.executeScript("arguments[0].click();", dropdown);
            Thread.sleep(1000);

            // 2️⃣ Wait for dropdown options to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-te-select-option-ref]")
            ));

            // 3️⃣ Click the desired department
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-te-select-option-ref]//span[normalize-space(text())='" + departmentName + "']")
            ));
            js.executeScript("arguments[0].scrollIntoView(true);", option);
            js.executeScript("arguments[0].click();", option);
            Thread.sleep(500);

            System.out.println("Successfully selected department: " + departmentName);
        } catch (Exception e) {
            System.out.println("Failed to select department: " + departmentName);
            e.printStackTrace();
        }
    }


    // ---------- Submit ----------
 // ---------- Submit ----------
    public void clickSubmitServiceTypeButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_WAIT));
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(btnsubmitServiceType));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
            System.out.println("Sccessfully clicked 'Add New Service' button.");
        } catch (Exception e) {
            System.out.println("Failed to click 'Add New Service' button.");
            e.printStackTrace();
        }
    }


    public String getAddSuccessMessage() {
        return elementUtils.waitForElementVisible(txtAddSuccessMessage, Constants.DEFAULT_WAIT).getText();
    }

    // ---------- Search ----------
    public void searchServiceType(String name) {
        elementUtils.waitForElementVisible(inputSearchServiceType, Constants.DEFAULT_WAIT).clear();
        elementUtils.doActionsSendKeys(inputSearchServiceType, name);
        elementUtils.pressEnterKey();
        elementUtils.waitForElementVisible(By.xpath("//td[normalize-space()='" + name + "']"), Constants.SHORT_TIME_OUT_WAIT);
    }

    // ---------- Update ----------
    public void clickEditServiceTypeButton(String name) {
        // 1) ensure the row is present (search the table / filter)
        searchServiceType(name);

        // 2) dynamic locator for the Edit button in the same row
        By editButton = By.xpath("//td[normalize-space()='" + name + "']/following-sibling::td//button[@title='Edit Service']");

        try {
            // 3) scroll into view and wait to be clickable
            elementUtils.scrollAndClick(editButton, Constants.SHORT_TIME_OUT_WAIT); // try a scroll+click helper if available
        } catch (Exception e1) {
            try {
                // fallback: explicit wait then normal click
                elementUtils.waitForElementToBeClickable(editButton, Constants.DEFAULT_WAIT).click();
            } catch (Exception e2) {
                // final fallback: JS click (handles overlays / intercepted clicks)
                try {
                    elementUtils.jsClick(editButton);
                } catch (Exception finalEx) {
                    System.out.println(" Failed to click Edit button for service: " + name);
                    finalEx.printStackTrace();
                    throw new RuntimeException("Could not click Edit button for: " + name, finalEx);
                }
            }
        }
    }

    public void updateServiceType(String name,  String description) {
        elementUtils.waitForElementVisible(inputServiceTypeName, Constants.DEFAULT_WAIT);
        elementUtils.clearTextBoxWithActions(inputServiceTypeName);
        elementUtils.doActionsSendKeys(inputServiceTypeName, name);

        elementUtils.waitForElementVisible(inputServiceTypeDescription, Constants.DEFAULT_WAIT);
        elementUtils.clearTextBoxWithActions(inputServiceTypeDescription);
        elementUtils.doActionsSendKeys(inputServiceTypeDescription, description);
    }

    public void clickUpdateServiceTypeButton() {
        for (By locator : btnSubmitServiceType) {
            if (elementUtils.doIsDisplayed(locator, Constants.SHORT_TIME_OUT_WAIT)) {
                elementUtils.waitForElementToBeClickable(locator, Constants.DEFAULT_WAIT).click();
                break;
            }
        }
    }

    public String getUpdateSuccessMessage() {
        return elementUtils.waitForElementVisible(txtUpdateSuccessMessage, Constants.DEFAULT_WAIT).getText();
    }

    // ---------- Delete ----------
    public void clickDeleteServiceTypeButton(String name) {
        searchServiceType(name);
        String deleteXpath = "//td[normalize-space()='" + name + "']/following-sibling::td//button[@title='Delete Agent']";
        elementUtils.waitForElementToBeClickable(By.xpath(deleteXpath), Constants.SHORT_TIME_OUT_WAIT).click();
    }

    public void clickConfirmDeleteButton() {
        elementUtils.waitForElementToBeClickable(btnConfirmDelete, Constants.SHORT_TIME_OUT_WAIT).click();
    }

    public String getDeleteSuccessMessage() {
        return elementUtils.waitForElementVisible(txtDeleteSuccessMessage, Constants.DEFAULT_WAIT).getText();
    }
}