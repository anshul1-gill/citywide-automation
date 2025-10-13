package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class LeavesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	// Add Leave Data
	private By leavesPageHeader = By.xpath("//h1[normalize-space()='Leaves']");
	private By btnAddLeave = By.xpath("//span[normalize-space()='Add Leave']");
	private By txtboxLeaveName = By.xpath("//input[@id='leave_name']");
	private By txtboxNumberOdDays = By.xpath("//input[@id='number_of_days']");
	private By txtboxDescription = By.xpath("//textarea[@id='description']");
	private By btnSubmitAddLeave = By.xpath("//button[@type='submit']");

	private By dataLeaveName = By.xpath("(//td[@data-label='Leave Name'])[1]");
	private By dataNumberOfDays = By.xpath("(//td[@data-label='Number of Days'])[1]");
	private By dataDescription = By.xpath("(//td[@data-label='Description'])[1]");

	// Edit Leave Data
	private By txtHeadingUpdateLeave = By.xpath("//h1[normalize-space()='Update Leave']");
	private By btnUpdateLeave = By.xpath("//button[@type='submit']");

	// Delete Leave
	private By deleteconfirmationMessage = By.xpath("//div[@id='swal2-html-container']");
	private By btnOkDeleteBreak = By.xpath("//button[normalize-space()='OK']");
	private By deletesuccessMessage = By.xpath("//div[contains(text(),'Leave deleted successfully')]");

	public LeavesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isLeavesPageHeaderVisible() {
		return elementUtils.doIsDisplayed(leavesPageHeader, Constants.DEFAULT_WAIT);
	}

	public boolean isAddLeaveButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddLeave, Constants.DEFAULT_WAIT);
	}

	public void clickAddLeaveButton() {
		elementUtils.waitForElementToBeClickable(btnAddLeave, Constants.DEFAULT_WAIT).click();
	}

	public void fillLeaveForm(String leaveName, String numberOfDays, String description) {
		WebElement ele = elementUtils.waitForElementVisible(txtboxLeaveName, Constants.DEFAULT_WAIT);
		ele.sendKeys(leaveName);
		elementUtils.waitForElementVisible(txtboxNumberOdDays, Constants.DEFAULT_WAIT).sendKeys(numberOfDays);
		elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT).sendKeys(description);
	}

	public void submitLeaveForm() {
		elementUtils.waitForElementToBeClickable(btnSubmitAddLeave, Constants.DEFAULT_WAIT).click();
	}

	public String getDataLeaveName() {
		return elementUtils.waitForElementVisible(dataLeaveName, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataNumberOfDays() {
		return elementUtils.waitForElementVisible(dataNumberOfDays, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataDescription() {
		return elementUtils.waitForElementVisible(dataDescription, Constants.DEFAULT_WAIT).getText();
	}

	// Edit Leave Data

	public void clickEditHolidayButton(String leaveName) {
		String leavename = leaveName;
		String editxpath = "//td[normalize-space()='" + leavename
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public boolean isUpdateLeaveHeaderVisible() {
		return elementUtils.doIsDisplayed(txtHeadingUpdateLeave, Constants.DEFAULT_WAIT);
	}

	public void updateLeaveForm(String leaveName, String numberOfDays, String description) {

		elementUtils.waitForElementVisible(txtboxLeaveName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxLeaveName);
		elementUtils.doActionsSendKeys(txtboxLeaveName, leaveName);

		elementUtils.waitForElementVisible(txtboxNumberOdDays, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxNumberOdDays);
		elementUtils.doActionsSendKeys(txtboxNumberOdDays, numberOfDays);

		elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxDescription);
		elementUtils.doActionsSendKeys(txtboxDescription, description);
	}

	public void submitUpdateLeaveForm() {
		elementUtils.waitForElementToBeClickable(btnUpdateLeave, Constants.DEFAULT_WAIT).click();
	}

	// Delete Leave

	public void clickDeleteLeaveButton(String leaveName) {
		String leavename = leaveName;
		String editxpath = "//td[normalize-space()='" + leavename
				+ "']/following-sibling::td//div[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public boolean isDeleteConfirmationMessageVisible() {
		return elementUtils.doIsDisplayed(deleteconfirmationMessage, Constants.DEFAULT_WAIT);
	}

	public void confirmDeleteLeave() {
		elementUtils.waitForElementToBeClickable(btnOkDeleteBreak, Constants.DEFAULT_WAIT).click();
	}

	public boolean isDeleteSuccessMessageVisible() {
		return elementUtils.doIsDisplayed(deletesuccessMessage, Constants.DEFAULT_WAIT);
	}

}
