package com.dits.citywide.pages.admin;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class ActivityCodePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	// ---------- Locators ----------
	private By txtActivityCodeHeader = By.xpath("//h1[normalize-space()='Activity Codes']");
	private By btnAddActivityCode = By.xpath("//a[normalize-space()='Add New Code']");
	private By inputActivityCodeName = By.id("code");
	private By inputActivityCodeDescription = By.id("description");
	private By radiobtnPriorityHigh = By.xpath("//label[normalize-space()='High Priority']");
	private By radiobtnPriorityLow = By.xpath("//label[normalize-space()='Low Priority']");

	// Handling dynamic submit button like in BeatsPage
	private List<By> btnSubmitActivityCode = Arrays.asList(
			By.cssSelector("button[type='submit']"),
			By.xpath("//button[@type='submit']"),
			By.xpath("//button[contains(@type,'submit')]")
	);

	private By inputSearchActivityCode = By.xpath("//input[@placeholder='Search']");
	private By txtAddedCodeName = By.xpath("(//td[@data-label='Code'])[1]");
	private By txtAddedDescription = By.xpath("(//td[@data-label='Description'])[1]");
	private By txtAddedPriority = By.xpath("(//td[@data-label='Priority'])[1]");

	private By btnEditActivityCode = By.xpath("//button[@title='Edit Code']");
	private By btnDeleteActivityCode = By.xpath("//button[@title='Delete Code']");
	private By btnConfirmDelete = By.xpath("//button[normalize-space()='OK']");
	private By txtDeleteSuccessMessage = By.xpath("//div[contains(text(),'Record deleted successfully.')]");
	private By txtAddSuccessMessage = By.xpath("//div[contains(text(),'Information Saved Successfully.')]");
	private By txtUpdateSuccessMessage = By.xpath("//div[contains(text(),'Information Updated Successfully.')]");

	// ---------- Constructor ----------
	public ActivityCodePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	// ---------- Visibility checks ----------
	public boolean isActivityCodeHeaderVisible() {
		return elementUtils.doIsDisplayed(txtActivityCodeHeader, Constants.DEFAULT_WAIT);
	}

	public boolean isAddActivityCodeButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddActivityCode, Constants.DEFAULT_WAIT);
	}

	// ---------- Add new Activity Code ----------
	public void clickAddActivityCodeButton() {
		elementUtils.waitForElementToBeClickable(btnAddActivityCode, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddActivityCodeForm(String codeName, String description, String priority) {
		elementUtils.waitForElementVisible(inputActivityCodeName, Constants.DEFAULT_WAIT).sendKeys(codeName);
		elementUtils.waitForElementVisible(inputActivityCodeDescription, Constants.DEFAULT_WAIT).sendKeys(description);

		if (priority.equalsIgnoreCase("High")) {
			elementUtils.waitForElementToBeClickable(radiobtnPriorityHigh, Constants.DEFAULT_WAIT).click();
		} else {
			elementUtils.waitForElementToBeClickable(radiobtnPriorityLow, Constants.DEFAULT_WAIT).click();
		}
	}

	public void clickSubmitActivityCodeButton() {
		for (By locator : btnSubmitActivityCode) {
			if (elementUtils.doIsDisplayed(locator, Constants.SHORT_TIME_OUT_WAIT)) {
				elementUtils.waitForElementToBeClickable(locator, Constants.DEFAULT_WAIT).click();
				break;
			}
		}
	}

	// ---------- Get data for assertions ----------
	public String getAddedCodeName() {
		return elementUtils.waitForElementVisible(txtAddedCodeName, Constants.DEFAULT_WAIT).getText();
	}

	public String getAddedDescription() {
		return elementUtils.waitForElementVisible(txtAddedDescription, Constants.DEFAULT_WAIT).getText();
	}

	public String getAddedPriority() {
		return elementUtils.waitForElementVisible(txtAddedPriority, Constants.DEFAULT_WAIT).getText();
	}

	public String getAddSuccessMessage() {
		return elementUtils.waitForElementVisible(txtAddSuccessMessage, Constants.DEFAULT_WAIT).getText();
	}
	
	public void searchActivityCode(String codeName) {
	    elementUtils.waitForElementVisible(inputSearchActivityCode, Constants.DEFAULT_WAIT).clear();
	    elementUtils.doActionsSendKeys(inputSearchActivityCode, codeName);
	    elementUtils.pressEnterKey();
	    // optional: wait a bit for table to refresh
	    elementUtils.waitForElementVisible(By.xpath("//td[normalize-space()='" + codeName + "']"), Constants.SHORT_TIME_OUT_WAIT);
	}


	// ---------- Update Activity Code ----------
	public void clickEditActivityCodeButton(String codeName) {
	    // Always search first
	    searchActivityCode(codeName);
	    String editXpath = "//td[normalize-space()='" + codeName + "']/following-sibling::td//button[@title='Edit Code']";
	    elementUtils.waitForElementToBeClickable(By.xpath(editXpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}
	public void updateActivityCode(String codeName, String description, String priority) {
		elementUtils.waitForElementVisible(inputActivityCodeName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(inputActivityCodeName);
		elementUtils.doActionsSendKeys(inputActivityCodeName, codeName);

		elementUtils.waitForElementVisible(inputActivityCodeDescription, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(inputActivityCodeDescription);
		elementUtils.doActionsSendKeys(inputActivityCodeDescription, description);

		if (priority.equalsIgnoreCase("High")) {
			elementUtils.waitForElementToBeClickable(radiobtnPriorityHigh, Constants.DEFAULT_WAIT).click();
		} else {
			elementUtils.waitForElementToBeClickable(radiobtnPriorityLow, Constants.DEFAULT_WAIT).click();
		}
	}

	public void clickUpdateActivityCodeButton() {
		for (By locator : btnSubmitActivityCode) {
			if (elementUtils.doIsDisplayed(locator, Constants.SHORT_TIME_OUT_WAIT)) {
				elementUtils.waitForElementToBeClickable(locator, Constants.DEFAULT_WAIT).click();
				break;
			}
		}
	}

	public String getUpdateSuccessMessage() {
		return elementUtils.waitForElementVisible(txtUpdateSuccessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// ---------- Delete Activity Code ----------
	public void clickDeleteActivityCodeButton(String codeName) {
	    // Step 1: Search for the Activity Code first
	    searchActivityCode(codeName);

	    // Step 2: Click the Delete button for that specific code
	    String deleteXpath = "//td[normalize-space()='" + codeName + "']/following-sibling::td//button[@title='Delete Code']";
	    elementUtils.waitForElementToBeClickable(By.xpath(deleteXpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}


	public void clickConfirmDeleteButton() {
		elementUtils.waitForElementToBeClickable(btnConfirmDelete, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public String getDeleteSuccessMessage() {
		return elementUtils.waitForElementVisible(txtDeleteSuccessMessage, Constants.DEFAULT_WAIT).getText();
	}
}
