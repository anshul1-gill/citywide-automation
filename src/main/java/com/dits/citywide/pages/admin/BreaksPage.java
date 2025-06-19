package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.CompanySettingsConstant;
import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class BreaksPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	// Add Breaks
	private By txtHeadingBreaks = By.xpath("//h1[normalize-space()='Breaks']");
	private By btnAddBreak = By.xpath("//span[normalize-space()='Add Break']");
	private By txtboxBreakName = By.xpath("//input[@id='break_name']");
	private By dropdownBreakDuration = By.xpath("(//span[@class='ant-select-selection-search'])[1]");
	private By valuesBreakDuration = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By dropdownPaidOrUnpaid = By.xpath("(//span[@class='ant-select-selection-search'])[2]");
	private By valuesPaidOrUnpaid = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div");
	private By dropdownActivityCode = By.xpath("(//span[@class='ant-select-selection-search'])[3]");
	private By valuesActivityCode = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[3]/div/div");
	private By txtboxDescription = By.xpath("//textarea[@id='description']");
	private By checkboxMandatory = By.cssSelector("label[title='Mandatory']");
	private By btnSubmitAddBreak = By.xpath("//button[contains(@type,'submit')]");

	private By sucessMessage = By.xpath("//div[contains(text(),'Break added successfully')]");

	private By getDataBreakName = By.xpath("(//td[@data-label='Break Name'])[1]");
	private By getDataBreakDuration = By.xpath("(//td[@data-label='Break Duration'])[1]");
	private By getDataBreakPaymentType = By.xpath("(//td[@data-label='Paid/Unpaid'])[1]");
	private By getDataBreakDescription = By.xpath("(//td[@data-label='Description'])[1]");

	// Edit and Delete Breaks
	private By editvaluesBreakDuration = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By editvaluesPaidOrUnpaid = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div");
	private By editvaluesActivityCode = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[3]/div/div");
	private By editTxtboxDescription = By.xpath("//textarea[@id='description']");
	private By editCheckboxMandatory = By.cssSelector("label[title='Mandatory']");
	private By btnUpdateBreak = By.xpath("//button[contains(@type,'submit')]");

	private By updateSuccessMessage = By.xpath("//div[contains(text(),'Break updated successfully')]");

	private By deleteconfirmationMessage = By.xpath("//div[@id='swal2-html-container']");
	private By btnOkDeleteBreak = By.xpath("//button[normalize-space()='OK']");
	private By deletesuccessMessage = By.xpath("//div[contains(text(),'Break deleted successfully')]");

	public BreaksPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void doClickAddBreakButton() {
		elementUtils.waitForElementToBeClickable(btnAddBreak, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public boolean isBreaksPageDisplayed() {
		return elementUtils.doIsDisplayed(txtHeadingBreaks, Constants.DEFAULT_WAIT);
	}

	// Add Break Form
	public void fillAddBreakForm(String breakName, String breakDuration, String paymentType, String activityCode,
			String description) {
		elementUtils.waitForElementVisible(txtboxBreakName, Constants.DEFAULT_WAIT).sendKeys(breakName);
		elementUtils.waitForElementToBeClickable(dropdownBreakDuration, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesBreakDuration, breakDuration, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownPaidOrUnpaid, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesPaidOrUnpaid, paymentType, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownActivityCode, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesActivityCode, activityCode, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT).sendKeys(description);
		elementUtils.waitForElementToBeClickable(checkboxMandatory, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnSubmitAddBreak, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public boolean isBreakAddedSuccessfully() {
		return elementUtils.doIsDisplayed(sucessMessage, Constants.DEFAULT_WAIT);
	}

	public void clickEditBreakButton(String breakName) {
		String breakname = breakName;
		String editxpath = "//td[normalize-space()='" + breakname
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickDeleteBreakButton(String breakName) {
		String breakname = breakName;
		String editxpath = "//td[normalize-space()='" + breakname
				+ "']/following-sibling::td//div[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public String getDataBreakName() {
		return elementUtils.waitForElementVisible(getDataBreakName, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataBreakDuration() {
		return elementUtils.waitForElementVisible(getDataBreakDuration, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataBreakPaymentType() {
		return elementUtils.waitForElementVisible(getDataBreakPaymentType, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataBreakDescription() {
		return elementUtils.waitForElementVisible(getDataBreakDescription, Constants.DEFAULT_WAIT).getText();
	}

	// Edit Break Form
	public void updateBreakForm(String breakName, String breakDuration, String paymentType, String activityCode,
			String description) throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxBreakName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxBreakName);
		elementUtils.doActionsSendKeys(txtboxBreakName, breakName);

		String breakduration = CompanySettingsConstant.BREAK_DURATION;
		String editxpath = "//span[@title='" + breakduration + "']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(editvaluesBreakDuration, breakDuration, Constants.SHORT_TIME_OUT_WAIT);
		String paymentTypeValue = CompanySettingsConstant.PAYMENT_TYPE;
		String paymentTypeXpath = "//span[@title='" + paymentTypeValue + "']";
		elementUtils.waitForElementToBeClickable(By.xpath(paymentTypeXpath), Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(editvaluesPaidOrUnpaid, paymentType, Constants.SHORT_TIME_OUT_WAIT);
		String activityCodeValue = CompanySettingsConstant.ACTIVITY_CODE;
		String activityCodeXpath = "//span[@title='" + activityCodeValue + "']";
		elementUtils.waitForElementToBeClickable(By.xpath(activityCodeXpath), Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(editvaluesActivityCode, activityCode, Constants.SHORT_TIME_OUT_WAIT);
		
		elementUtils.waitForElementVisible(editTxtboxDescription, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(editTxtboxDescription);
		elementUtils.doActionsSendKeys(editTxtboxDescription, description);
		
		elementUtils.waitForElementToBeClickable(editCheckboxMandatory, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnUpdateBreak, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public boolean isBreakUpdatedSuccessfully() {
		return elementUtils.doIsDisplayed(updateSuccessMessage, Constants.DEFAULT_WAIT);
	}

	public boolean isDeleteConfirmationMessageDisplayed() {
		return elementUtils.doIsDisplayed(deleteconfirmationMessage, Constants.DEFAULT_WAIT);
	}

	public void clickOkDeleteBreakButton() {
		elementUtils.waitForElementToBeClickable(btnOkDeleteBreak, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public boolean isBreakDeletedSuccessfully() {
		return elementUtils.doIsDisplayed(deletesuccessMessage, Constants.DEFAULT_WAIT);
	}
}
