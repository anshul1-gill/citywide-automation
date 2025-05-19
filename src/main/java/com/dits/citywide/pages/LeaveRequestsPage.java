package com.dits.citywide.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;
import com.dits.citywide.utilities.DateFormatterUtils;

public class LeaveRequestsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnApplyLeave = By.xpath("//span[contains(text(),'Apply Leave')]");
	// Both xpath are working
//	private By dataLeaveType = By
//			.xpath("(//span[text()='Leave Type']/ancestor::thead//following-sibling::tbody//td)[3]");
	private By dataLeaveType = By.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Leave Type'])[1]");

//	private By dataFromDate = By
//			.xpath("(//span[text()='Leave Type']/ancestor::thead//following-sibling::tbody//td)[4]");
	private By dataFromDate = By.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='From'])[1]");
	private By dataToDate = By.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='To'])[1]");
	private By dataTotalDays = By.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Total Days'])[1]");

	private By txtAreYouSure = By.xpath("//h2[@id='swal2-title']");
	private By txtThisActionWillCancelThisLeave = By.cssSelector("#swal2-html-container");
	private By btnOk = By.xpath("//button[@class='swal2-confirm swal2-styled']");
	private By btnCancel = By.xpath("//button[@class='swal2-cancel red-cancel-button swal2-styled']");

	private By msgCancelConfirmationMessage = By.xpath(
			"//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']/following-sibling::div");

	public LeaveRequestsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public String getLeaveTypeText() {
		return elementUtils.waitForElementVisible(dataLeaveType, Constants.DEFAULT_WAIT).getText();
	}

	public String[] getFromDateText() {
		String fromDate = elementUtils.waitForElementVisible(dataFromDate, Constants.DEFAULT_WAIT).getText();
		return DateFormatterUtils.splitDateToMonthDayYear(fromDate);
	}

	public String[] getToDateText() {
		String toDate = elementUtils.waitForElementVisible(dataToDate, Constants.DEFAULT_WAIT).getText();
		return DateFormatterUtils.splitDateToMonthDayYear(toDate);
	}

	public String getTotalDaysText() {
		return elementUtils.waitForElementVisible(dataTotalDays, Constants.DEFAULT_WAIT).getText();
	}

	public ApplyLeavePage doClickApplyLeave() {
		elementUtils.waitForElementToBeClickable(btnApplyLeave, Constants.DEFAULT_WAIT).click();
		return new ApplyLeavePage(driver);
	}

	public void doClickDecline(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String expath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//span[@aria-label='close']";

		elementUtils.waitForElementToBeClickable(By.xpath(expath), Constants.DEFAULT_WAIT).click();
	}

	public void doClickApprove(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String expath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//span[@aria-label='check']";

		elementUtils.waitForElementToBeClickable(By.xpath(expath), Constants.DEFAULT_WAIT).click();
	}

	public String getCanceledStatus(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String statusxpath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//div[contains(@class,'status-canceled')]";
		return elementUtils.waitForElementVisible(By.xpath(statusxpath), Constants.DEFAULT_WAIT).getText();

	}

	public String getDeclinedStatus(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String statusxpath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//div[contains(@class,'status-declined')]";
		return elementUtils.waitForElementVisible(By.xpath(statusxpath), Constants.DEFAULT_WAIT).getText();

	}

	public String getApprovedStatus(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String statusxpath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//div[contains(@class,'status-completed')]";
		return elementUtils.waitForElementVisible(By.xpath(statusxpath), Constants.DEFAULT_WAIT).getText();

	}

	public String getAreYouSureText() {
		return elementUtils.waitForElementVisible(txtAreYouSure, Constants.DEFAULT_WAIT).getText();
	}

	public String getCancelLeaveWarningText() {
		return elementUtils.waitForElementVisible(txtThisActionWillCancelThisLeave, Constants.DEFAULT_WAIT).getText();
	}

	public void doClickOk() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public void doClickCancel() {
		elementUtils.waitForElementToBeClickable(btnCancel, Constants.DEFAULT_WAIT).click();
	}

	public String getCancelConfirmationMessage() {
		return elementUtils.waitForElementVisible(msgCancelConfirmationMessage, Constants.DEFAULT_WAIT).getText();
	}

}
