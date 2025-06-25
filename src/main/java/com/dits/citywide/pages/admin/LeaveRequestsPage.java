package com.dits.citywide.pages.admin;

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
////	private By dataLeaveType = By
////			.xpath("(//span[text()='Leave Type']/ancestor::thead//following-sibling::tbody//td)[3]");
//	private By dataLeaveType = By.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Leave Type'])[1]");
//
////	private By dataFromDate = By
////			.xpath("(//span[text()='Leave Type']/ancestor::thead//following-sibling::tbody//td)[4]");
//	private By dataFromDate = By.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='From'])[1]");
//	private By dataToDate = By.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='To'])[1]");
//	private By dataTotalDays = By.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Total Days'])[1]");

	private By dataLeaveType = By.xpath("(//td[@data-label='Leave Type'])[1]");
	private By dataFromDate = By.xpath("(//td[@data-label='From'])[1]");
	private By dataStartTime = By.xpath("(//td[@data-label='Start Time'])[1]");
	private By dataToDate = By.xpath("(//td[@data-label='To'])[1]");
	private By dataEndTime = By.xpath("(//td[@data-label='End Time'])[1]");
	private By dataTotalDays = By.xpath("(//td[@data-label='Total Days'])[1]");

	// Approve
	private By txtAreYouSure = By.xpath("//h2[@id='swal2-title']");
	private By txtThisActionWillApproveThisLeave = By.cssSelector("#swal2-html-container");
	private By btnOk = By.xpath("//button[@class='swal2-confirm swal2-styled']");
	private By btnCancel = By.xpath("//button[@class='swal2-cancel red-cancel-button swal2-styled']");

	private By msgConfirmationMessage = By.xpath(
			"//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']/following-sibling::div");

	// Declined
	private By txtCancelValidationMessage = By.xpath("//span[@class='baseTitle']");
	private By txtboxDeclinedReason = By.xpath("//textarea[@id='reason']");
	private By btnSubmitDecline = By.xpath("//button[@type='submit']");
	private By declinedSucessMessage = By.xpath("//div[contains(text(),'Leave declined successfully')]");

	public LeaveRequestsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public String getLeaveTypeText() {
		return elementUtils.waitForElementVisible(dataLeaveType, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isAddLeaveRequestButtonDisplayed() {
		return elementUtils.waitForElementVisible(btnApplyLeave, Constants.SHORT_TIME_OUT_WAIT).isDisplayed();
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

	public String getStartTimeText() {
		return elementUtils.waitForElementVisible(dataStartTime, Constants.DEFAULT_WAIT).getText();
	}

	public String getEndTimeText() {
		return elementUtils.waitForElementVisible(dataEndTime, Constants.DEFAULT_WAIT).getText();
	}

	public ApplyLeavePage doClickApplyLeave() {
		elementUtils.waitForElementToBeClickable(btnApplyLeave, Constants.DEFAULT_WAIT).click();
		return new ApplyLeavePage(driver);
	}

	// Decline Leave Requests
	public void doClickDecline(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String expath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//span[@class='action-icon dis-approve']";

		elementUtils.waitForElementToBeClickable(By.xpath(expath), Constants.DEFAULT_WAIT).click();
	}

	public String getDeclineValidationMessage() {
		return elementUtils.waitForElementVisible(txtCancelValidationMessage, Constants.DEFAULT_WAIT).getText();
	}

	public void doEnterDeclinedReason(String reason) {
		elementUtils.waitForElementVisible(txtboxDeclinedReason, Constants.DEFAULT_WAIT).sendKeys(reason);
	}

	public void doClickSubmitDecline() {
		elementUtils.waitForElementToBeClickable(btnSubmitDecline, Constants.DEFAULT_WAIT).click();
	}

	public String getDeclinedSuccessMessage() {
		return elementUtils.waitForElementVisible(declinedSucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// Approve Leave Requests
	public void doClickApprove(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String expath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//span[@class='action-icon approve']";

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

	public String getCancelConfirmationMessage() {
		return elementUtils.waitForElementVisible(msgConfirmationMessage, Constants.DEFAULT_WAIT).getText();
	}

	// Approive Leave Requests Confirmation
	
	public String getAreYouSureText() {
		return elementUtils.waitForElementVisible(txtAreYouSure, Constants.DEFAULT_WAIT).getText();
	}

	public String getApproveLeaveWarningText() {
		return elementUtils.waitForElementVisible(txtThisActionWillApproveThisLeave, Constants.DEFAULT_WAIT).getText();
	}

	public void doClickOk() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public void doClickCancel() {
		elementUtils.waitForElementToBeClickable(btnCancel, Constants.DEFAULT_WAIT).click();
	}

	public String getApprovedConfirmationMessage() {
		return elementUtils.waitForElementVisible(msgConfirmationMessage, Constants.DEFAULT_WAIT).getText();
	}

	public String getApprovedStatus(String employeeID, String leaveType) {

		String id = employeeID;
		String leavetype = leaveType;

		String statusxpath = "//tr[td[contains(text(),'" + id + "')] and td[contains(text(),'" + leavetype
				+ "')]]//div[contains(@class,'status-completed')]";
		return elementUtils.waitForElementVisible(By.xpath(statusxpath), Constants.DEFAULT_WAIT).getText();
	}

}
