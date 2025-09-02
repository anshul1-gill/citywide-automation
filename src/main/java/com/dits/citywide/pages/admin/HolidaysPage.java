package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class HolidaysPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtHolidayName = By.xpath("//h1[normalize-space()='Holidays']");
	private By btnAddHoliday = By.xpath("//span[normalize-space()='Add Holiday']");

	// Federal Holiday
	private By btnAddFederalHoliday = By.xpath("//div[@id='rc-tabs-0-tab-1']");
	private By txtAddHolidayName = By.xpath("//h1[normalize-space()='Add Holiday']");
	private By dropdownFederalHoliday = By.xpath("(//div[contains(@class,'ant-select-selector')])[1]");
	// private By valuesFederalHoliday =
	// By.xpath("//div[@class='rc-virtual-list-holder']//div[@class='rc-virtual-list-holder-inner']/div");
	private By valuesFederalHoliday = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	// private By valuesFederalHoliday = By.xpath("//div[contains(text(),'Christmas
	// Day')]");
	private By startTime = By.xpath("//input[@id='775']");
	private By endTime = By.xpath("//input[@id='776']");
	private By dropdownRecurring = By.xpath("(//div[contains(@class,'ant-select-selector')])[2]");
	private By valuesRecurring = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div");
	private By dropdownPaymentType = By.xpath("(//div[contains(@class,'ant-select-selector')])[3]");
	private By valuesPaymentType = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[3]/div/div");
	private By txtboxDescription = By.cssSelector("#description");
	private By btnSubmitAddHoliday = By.xpath("//button[contains(@type,'submit')]");

	private By dataHolidayName = By.xpath("(//td[@data-label='Holiday Name'])[1]");
	private By dataHolidayStartDate = By.xpath("(//td[@data-label='Date'])[1]");
	private By dataHolidayStartTime = By.xpath("(//td[@data-label='Start Time'])[1]");
	private By dataHolidayEndTime = By.xpath("(//td[@data-label='End Time'])[1]");
	private By dataHolidayRecurring = By.xpath("(//td[@data-label='Recurring'])[1]");
	private By dataHolidayPaymentType = By.xpath("(//td[@data-label='Paid/Unpaid'])[1]");
	private By dataHolidayDescription = By.xpath("(//td[@data-label='Description'])[1]");

	private By txtUpdateHolidayName = By.xpath("//h1[normalize-space()='Update Holiday']");
	private By btnUpdateHoliday = By.xpath("//button[@type='submit']");

	private By deleteconfirmationMessage = By.xpath("//div[@id='swal2-html-container']");
	private By btnOkDeleteBreak = By.xpath("//button[normalize-space()='OK']");
	private By deletesuccessMessage = By.xpath("//div[contains(text(),'Holiday deleted successfully')]");

	// Custom Holiday
	private By btnAddCustomHoliday = By.xpath("//div[@id='rc-tabs-0-tab-2']");
	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
	private By txtboxCustomHolidayName = By.xpath("//input[@id='holiday_name' and @placeholder='Holiday Name']");
	private By txtboxCustomHolidayDate = By.xpath("//input[@id='date']");
	private By startTimeCustom = By.xpath("(//input[@id='775'])[2]");
	private By endTimeCustom = By.xpath("(//input[@id='776'])[2]");
	private By dropdownRecurringCustom = By.xpath("(//div[contains(@class,'ant-select-selector')])[5]");
	private By valuesRecurringCustom = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By dropdownPaymentTypeCustom = By.xpath("(//div[contains(@class,'ant-select-selector')])[6]");
	private By valuesPaymentTypeCustom = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div");
	private By txtboxDescriptionCustom = By.xpath("(//textarea[@placeholder='Description'])[2]");
	private By btnSubmitCustomHoliday = By.xpath("(//button[contains(@type,'submit')])[2]");

	// For updating custom holiday
	private By txtboxUpdateCustomHolidayName = By.cssSelector("#holiday_name");
	private By txtboxUpdateCustomHolidayDate = By.xpath("//input[@id='date']");
	private By startTimeCustomUpdate = By.xpath("//input[@id='775']");
	private By endTimeCustomUpdate = By.xpath("//input[@id='776']");
	private By dropdownUpdateRecurringCustom = By.xpath("(//div[contains(@class,'ant-select-selector')])[1]");
	private By valuesRecurringCustomUpdate = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By dropdownUpdatePaymentTypeCustom = By.xpath("(//div[contains(@class,'ant-select-selector')])[2]");
	private By valuesUpdatePaymentTypeCustom = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div");

	public HolidaysPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void waitForLoaderToDisappear() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public boolean isHolidayPageTitleDisplayed() {
		return elementUtils.doIsDisplayed(txtHolidayName, Constants.DEFAULT_WAIT);
	}

	public void doClickAddHolidayButton() {
		elementUtils.waitForElementToBeClickable(btnAddHoliday, Constants.DEFAULT_WAIT).click();
	}

	public boolean isHolidayPageDisplayed() {
		return elementUtils.doIsDisplayed(txtAddHolidayName, Constants.DEFAULT_WAIT);
	}

	public void fillFederalHolidayDetails(String holidayName, String startTime, String endTime, String recurring,
			String paymentType, String description) throws InterruptedException {

		elementUtils.waitForElementToBeClickable(dropdownFederalHoliday, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeVisibleAndEnabled(valuesFederalHoliday, Constants.DEFAULT_WAIT);
//		elementUtils.waitForElementToBeClickable(valuesFederalHoliday, Constants.DEFAULT_WAIT).click();
		elementUtils.doActionsClick(valuesFederalHoliday);

		elementUtils.waitForElementToBeClickable(this.startTime, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.waitForElementVisible(this.startTime, Constants.DEFAULT_WAIT).sendKeys(startTime);
		elementUtils.waitForElementToBeClickable(this.endTime, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.waitForElementVisible(this.endTime, Constants.DEFAULT_WAIT).sendKeys(endTime);
		elementUtils.waitForElementToBeClickable(dropdownRecurring, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesRecurring, recurring, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownPaymentType, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesPaymentType, paymentType, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT).sendKeys(description);
	}

	public void doClickSubmitAddHolidayButton() {
		elementUtils.waitForElementToBeClickable(btnSubmitAddHoliday, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void doClickAddFederalHolidayButton() {
		elementUtils.waitForElementToBeClickable(btnAddFederalHoliday, Constants.DEFAULT_WAIT).click();
	}

	public String getDataHolidayName() {
		return elementUtils.waitForElementVisible(dataHolidayName, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataHolidayStartDate() {
		return elementUtils.waitForElementVisible(dataHolidayStartDate, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataHolidayStartTime() {
		return elementUtils.waitForElementVisible(dataHolidayStartTime, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataHolidayEndTime() {
		return elementUtils.waitForElementVisible(dataHolidayEndTime, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataHolidayRecurring() {
		return elementUtils.waitForElementVisible(dataHolidayRecurring, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataHolidayPaymentType() {
		return elementUtils.waitForElementVisible(dataHolidayPaymentType, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataHolidayDescription() {
		return elementUtils.waitForElementVisible(dataHolidayDescription, Constants.DEFAULT_WAIT).getText();
	}

	// update and delete

	public void clickEditHolidayButton(String holidayName) {
		String holidayname = holidayName;
		String editxpath = "//td[normalize-space()='" + holidayname
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public boolean isUpdateHolidayPageDisplayed() {
		return elementUtils.doIsDisplayed(txtUpdateHolidayName, Constants.DEFAULT_WAIT);
	}

	public void updateFederalHoliday(String holidayName, String startTime, String endTime, String recurring,
			String paymentType, String description) throws InterruptedException {
		// Wait for and update Holiday Name
		elementUtils.waitForElementToBeClickable(dropdownFederalHoliday, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeVisibleAndEnabled(valuesFederalHoliday, Constants.DEFAULT_WAIT);
//		elementUtils.waitForElementToBeClickable(valuesFederalHoliday, Constants.DEFAULT_WAIT).click();
		elementUtils.doActionsClick(valuesFederalHoliday);

		elementUtils.waitForElementVisible(this.startTime, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(this.startTime);
		elementUtils.doActionsSendKeys(this.startTime, startTime);

		elementUtils.waitForElementVisible(this.endTime, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(this.endTime);
		elementUtils.doActionsSendKeys(this.endTime, endTime);

		elementUtils.waitForElementToBeClickable(dropdownRecurring, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesRecurring, recurring, Constants.SHORT_TIME_OUT_WAIT);

		elementUtils.waitForElementToBeClickable(dropdownPaymentType, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesPaymentType, paymentType, Constants.SHORT_TIME_OUT_WAIT);

		elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxDescription);
		elementUtils.doActionsSendKeys(txtboxDescription, description);
	}

	public void doClickUpdateHolidayButton() {
		elementUtils.waitForElementToBeClickable(btnUpdateHoliday, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickDeleteHolidayButton(String holidayName) {
		String holidayname = holidayName;
		String editxpath = "//td[normalize-space()='" + holidayname
				+ "']/following-sibling::td//div[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public String getDeleteConfirmationMessage() {
		return elementUtils.waitForElementVisible(deleteconfirmationMessage, Constants.DEFAULT_WAIT).getText();
	}

	public void doClickOkDeleteHolidayButton() {
		elementUtils.waitForElementToBeClickable(btnOkDeleteBreak, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public boolean isDeleteSuccessMessageDisplayed() {
		return elementUtils.doIsDisplayed(deletesuccessMessage, Constants.DEFAULT_WAIT);
	}

	// Custom Holiday

	public void doClickAddCustomHolidayButton() {
		elementUtils.waitForElementToBeClickable(btnAddCustomHoliday, Constants.DEFAULT_WAIT).click();
		waitForLoaderToDisappear();
	}

	public void fillCustomHolidayDetails(String holidayName, String holidayDate, String startTime, String endTime,
			String recurring, String paymentType, String description) throws InterruptedException {

		elementUtils.waitForElementVisible(txtboxCustomHolidayName, Constants.DEFAULT_WAIT).sendKeys(holidayName);
		elementUtils.waitForElementVisible(txtboxCustomHolidayDate, Constants.DEFAULT_WAIT).sendKeys(holidayDate);
		elementUtils.waitForElementToBeClickable(startTimeCustom, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.waitForElementVisible(startTimeCustom, Constants.DEFAULT_WAIT).sendKeys(startTime);
		elementUtils.waitForElementToBeClickable(endTimeCustom, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.waitForElementVisible(endTimeCustom, Constants.DEFAULT_WAIT).sendKeys(endTime);
		elementUtils.waitForElementToBeClickable(dropdownRecurringCustom, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesRecurringCustom, recurring, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownPaymentTypeCustom, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesPaymentTypeCustom, paymentType, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementVisible(txtboxDescriptionCustom, Constants.DEFAULT_WAIT).sendKeys(description);
	}

	public void doClickSubmitCustomHolidayButton() {
		elementUtils.waitForElementToBeClickable(btnSubmitCustomHoliday, Constants.SHORT_TIME_OUT_WAIT).click();
		waitForLoaderToDisappear();
	}

	public void updateCustomHoliday(String holidayName, String holidayDate, String startTime, String endTime,
			String recurring, String paymentType, String description) throws InterruptedException {

		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxUpdateCustomHolidayName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxUpdateCustomHolidayName);
		elementUtils.doActionsSendKeys(txtboxUpdateCustomHolidayName, holidayName);

		elementUtils.waitForElementVisible(txtboxUpdateCustomHolidayDate, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxUpdateCustomHolidayDate);
		elementUtils.doActionsSendKeys(txtboxUpdateCustomHolidayDate, holidayDate);

		elementUtils.waitForElementVisible(startTimeCustomUpdate, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(startTimeCustomUpdate);
		elementUtils.doActionsSendKeys(startTimeCustomUpdate, startTime);

		elementUtils.waitForElementVisible(endTimeCustomUpdate, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(endTimeCustomUpdate);
		elementUtils.doActionsSendKeys(endTimeCustomUpdate, endTime);

		elementUtils.waitForElementToBeClickable(dropdownUpdateRecurringCustom, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesRecurringCustomUpdate, recurring, Constants.SHORT_TIME_OUT_WAIT);

		elementUtils.waitForElementToBeClickable(dropdownUpdatePaymentTypeCustom, Constants.SHORT_TIME_OUT_WAIT)
				.click();
		elementUtils.selectElementThroughLocator(valuesUpdatePaymentTypeCustom, paymentType,
				Constants.SHORT_TIME_OUT_WAIT);

		elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxDescription);
		elementUtils.doActionsSendKeys(txtboxDescription, description);
	}

}
