package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.Calendar;
import com.dits.citywide.utilities.DateFormatterUtils;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentLeaveRequestsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAddLeaveRequest = By.xpath("//span[normalize-space()='Apply Leave']");

	private By dropdownLeaveType = By.className("ant-select-selector");
	private By dropdownLeaveTypeValues = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");

	private By fromDateCalender = By.id("from_date");
	private By toDateCalender = By.id("to_date");
	private By inputStartTime = By.id("start_time");
	private By inputEndTime = By.id("end_time");

	private By txtboxDescription = By.id("description");
	private By btnApplyLeave = By.xpath("//button[contains(@type,'submit')]");
	private By btnReset = By.xpath("//button[@type='reset']");

	private By dataLeaveType = By.xpath("(//td[@data-label='Leave Type'])[1]");
	private By dataFromDate = By.xpath("(//td[@data-label='From'])[1]");
	private By dataStartTime = By.xpath("(//td[@data-label='Start Time'])[1]");
	private By dataToDate = By.xpath("(//td[@data-label='To'])[1]");
	private By dataEndTime = By.xpath("(//td[@data-label='End Time'])[1]");
	private By dataTotalDays = By.xpath("(//td[@data-label='Total Days'])[1]");

	// Edit and Delete

	private By btnUpdateLeave = By.xpath("//span[normalize-space()='Update Leave']");

	private By txtCancelVakidationMessage = By.xpath("//div[@id='swal2-html-container']");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");
	private By txtCancelConfirmation = By.xpath("//div[contains(text(),'Leave cancelled successfully')]");

	public FieldAgentLeaveRequestsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isAddLeaveRequestButtonDisplayed() {
		return elementUtils.waitForElementVisible(btnAddLeaveRequest, Constants.SHORT_TIME_OUT_WAIT).isDisplayed();
	}

	public void clickAddLeaveRequest() {
		elementUtils.waitForElementToBeClickable(btnAddLeaveRequest, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void fillApplyLeaveForm(String leaveType, String fromMonth, String fromYear, String fromDate,
			String startTime, String toMonth, String toYear, String toDate, String endTime, String description)
			throws InterruptedException {

		WebElement leaveTypeElement = elementUtils.waitForElementToBeClickable(dropdownLeaveType,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(leaveTypeElement);
		elementUtils.selectElementThroughLocator(dropdownLeaveTypeValues, leaveType, Constants.SHORT_TIME_OUT_WAIT);

		WebElement fromElement = elementUtils.waitForElementToBeClickable(fromDateCalender, Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(fromElement);
		Calendar.selectNextDateMultipleCalenderOnSamePage(driver, fromMonth, fromYear, fromDate);

		WebElement startElement = elementUtils.waitForElementToBeClickable(inputStartTime, Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(startElement);
		elementUtils.waitForElementVisible(inputStartTime, Constants.DEFAULT_WAIT).sendKeys(startTime);

		elementUtils.waitForElementToBeClickable(toDateCalender, Constants.DEFAULT_WAIT);
		elementUtils.clickByLocator(toDateCalender);
		Calendar.selectNextDateMultipleCalenderOnSamePage(driver, toMonth, toYear, toDate);

		WebElement endTimeElement = elementUtils.waitForElementToBeClickable(inputEndTime, Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(endTimeElement);
		elementUtils.waitForElementVisible(inputEndTime, Constants.DEFAULT_WAIT).sendKeys(endTime);

		elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT).sendKeys(description);

	}

	public void doApplyLeave() {
		elementUtils.waitForElementToBeClickable(btnApplyLeave, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void doReset() {
		elementUtils.waitForElementToBeClickable(btnReset, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public String getLeaveType() {
		return elementUtils.waitForElementVisible(dataLeaveType, Constants.DEFAULT_WAIT).getText();
	}

	public String[] getFromDate() {
		String fromDate = elementUtils.waitForElementVisible(dataFromDate, Constants.DEFAULT_WAIT).getText();
		return DateFormatterUtils.splitDateToMonthDayYear(fromDate);
	}

	public String getStartTime() {
		return elementUtils.waitForElementVisible(dataStartTime, Constants.DEFAULT_WAIT).getText();
	}

	public String[] getToDate() {
		String toDate = elementUtils.waitForElementVisible(dataToDate, Constants.DEFAULT_WAIT).getText();
		return DateFormatterUtils.splitDateToMonthDayYear(toDate);

	}

	public String getEndTime() {
		return elementUtils.waitForElementVisible(dataEndTime, Constants.DEFAULT_WAIT).getText();
	}

	public String getTotalDays() {
		return elementUtils.waitForElementVisible(dataTotalDays, Constants.DEFAULT_WAIT).getText();
	}

	// Edit and Delete

	public void doClickEditButton(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String expath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//span[@aria-label='edit']";

		elementUtils.waitForElementToBeClickable(By.xpath(expath), Constants.DEFAULT_WAIT).click();
	}

	public void updateLeaveForm(String leaveType, String fromMonth, String fromYear, String fromDate, String startTime,
			String toMonth, String toYear, String toDate, String endTime, String description)
			throws InterruptedException {

		WebElement leaveTypeElement = elementUtils.waitForElementToBeClickable(dropdownLeaveType,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(leaveTypeElement);
		elementUtils.selectElementThroughLocator(dropdownLeaveTypeValues, leaveType, Constants.SHORT_TIME_OUT_WAIT);

		WebElement fromElement = elementUtils.waitForElementToBeClickable(fromDateCalender, Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(fromElement);
		Calendar.selectNextDateMultipleCalenderOnSamePage(driver, fromMonth, fromYear, fromDate);

		WebElement startElement = elementUtils.waitForElementToBeClickable(inputStartTime, Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(startElement);
		elementUtils.waitForElementVisible(inputStartTime, Constants.DEFAULT_WAIT).sendKeys(startTime);

		elementUtils.waitForElementToBeClickable(toDateCalender, Constants.DEFAULT_WAIT);
		elementUtils.clickByLocator(toDateCalender);
		Calendar.selectNextDateMultipleCalenderOnSamePage(driver, toMonth, toYear, toDate);

		WebElement endTimeElement = elementUtils.waitForElementToBeClickable(inputEndTime, Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(endTimeElement);
		elementUtils.waitForElementVisible(inputEndTime, Constants.DEFAULT_WAIT).sendKeys(endTime);

		elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxDescription);
		elementUtils.doActionsSendKeys(txtboxDescription, description);

	}

	public void doClickUpdateLeave() {
		elementUtils.waitForElementToBeClickable(btnUpdateLeave, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void doClickCancelButton(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String expath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//span[@aria-label='close']";

		elementUtils.waitForElementToBeClickable(By.xpath(expath), Constants.DEFAULT_WAIT).click();
	}

	public String getCancelValidationMessage() {
		return elementUtils.waitForElementVisible(txtCancelVakidationMessage, Constants.DEFAULT_WAIT).getText();
	}

	public void doClickOkButton() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForInvisibilityOfElementLocated(btnOk, Constants.DEFAULT_WAIT);
	}

	public String getCancelConfirmationMessage() {
		return elementUtils.waitForElementVisible(txtCancelConfirmation, Constants.DEFAULT_WAIT).getText();
	}

	public String getStatus(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String expath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//div[normalize-space()='Canceled']";

		return elementUtils.waitForElementVisible(By.xpath(expath), Constants.DEFAULT_WAIT).getText();
	}

}
