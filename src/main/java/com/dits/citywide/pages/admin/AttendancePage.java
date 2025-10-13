package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class AttendancePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By datePicker = By.xpath("//div[@class='ant-picker ant-picker-outlined css-m6wp4j attendance-filter']");
	private By datePickerInput = By.xpath("//input[@placeholder='Select date']");
	private By dropdownSelectEmployee = By.xpath("(//div[@class='ant-select-selector'])[3]");
	private By searchEmployeeInput = By.xpath("//input[@id='rc_select_0']");
	private By dropdownSelectStatus = By.xpath("(//div[@class='ant-select-selector'])[4]");

	public By getStatusLocator(String statusText) {
		String xpath = "//div[@class='rc-virtual-list-holder-inner']//div[text()='" + statusText + "']";
		return By.xpath(xpath);
	}

	private By btnClear = By.xpath("//span[normalize-space()='Clear']");
	private By btnExport = By.xpath("//span[normalize-space()='Export']");

	public By getBranchName(String employeeID) {
		String xpath = "(//td[contains(normalize-space(), '" + employeeID + "')]/preceding-sibling::td)[1]";
		return By.xpath(xpath);
	}

	public By getSiteOrBit(String employeeID) {
		String xpath = "(//td[contains(normalize-space(), '" + employeeID + "')]/preceding-sibling::td)[2]";
		return By.xpath(xpath);
	}

	public By getEmployeeName(String employeeID) {
		String xpath = "//td[contains(normalize-space(),'" + employeeID + "')]";
		return By.xpath(xpath);
	}

	public By getEmployeeShiftStart(String employeeID) {
		String xpath = "(//td[contains(normalize-space(), '" + employeeID + "')]/following-sibling::td)[1]";
		return By.xpath(xpath);
	}

	public By getEmployeeCheckIn(String employeeID) {
		String xpath = "(//td[contains(normalize-space(), '" + employeeID + "')]/following-sibling::td)[2]";
		return By.xpath(xpath);
	}

	public By getEmployeeShiftEnd(String employeeID) {
		String xpath = "(//td[contains(normalize-space(), '" + employeeID + "')]/following-sibling::td)[3]";
		return By.xpath(xpath);
	}

	public By getEmployeeCheckOut(String employeeID) {
		String xpath = "(//td[contains(normalize-space(), '" + employeeID + "')]/following-sibling::td)[4]";
		return By.xpath(xpath);
	}

	public By getEmployeeShiftHours(String employeeID) {
		String xpath = "(//td[contains(normalize-space(), '" + employeeID + "')]/following-sibling::td)[5]";
		return By.xpath(xpath);
	}

	public By getEmployeeTotalHours(String employeeID) {
		String xpath = "(//td[contains(normalize-space(), '" + employeeID + "')]/following-sibling::td)[6]";
		return By.xpath(xpath);
	}

	public By getEmployeeStatus(String employeeID) {
		String xpath = "(//td[contains(normalize-space(), '" + employeeID + "')]/following-sibling::td)[7]/div";
		return By.xpath(xpath);
	}

	public AttendancePage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public void selectDate(String date) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(datePicker, Constants.DEFAULT_WAIT).click();
		Thread.sleep(500);
		elementUtils.clearTextBoxWithKeys(datePickerInput);
		Thread.sleep(500);
		elementUtils.doActionsSendKeys(datePickerInput, date);
	}

	public void selectEmployee(String employeeName) {
		elementUtils.waitForElementToBeClickable(dropdownSelectEmployee, Constants.DEFAULT_WAIT).click();
		elementUtils.doActionsSendKeys(searchEmployeeInput, employeeName);
		elementUtils.pressEnterKey();
	}

	public void selectStatus(String status) {
		elementUtils.waitForElementToBeClickable(dropdownSelectStatus, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getStatusLocator(status), Constants.DEFAULT_WAIT).click();
	}

	public void clickClearButton() {
		elementUtils.waitForElementToBeClickable(btnClear, Constants.DEFAULT_WAIT).click();
	}

	public void clickExportButton() {
		elementUtils.waitForElementToBeClickable(btnExport, Constants.DEFAULT_WAIT).click();
	}

	// Methods to get data from the attendance table based on branch name and
	// employee name
	public String getDataBranchName(String branchName) {
		return elementUtils.waitForElementToBeClickable(getBranchName(branchName), Constants.DEFAULT_WAIT).getText();
	}

	public String getDataSiteOrBit(String branchName) {
		return elementUtils.waitForElementToBeClickable(getSiteOrBit(branchName), Constants.DEFAULT_WAIT).getText();
	}

	public String getDataEmployeeName(String employeeName) {
		return elementUtils.waitForElementToBeClickable(getEmployeeName(employeeName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getDataEmployeeShiftStart(String employeeName) {
		return elementUtils.waitForElementToBeClickable(getEmployeeShiftStart(employeeName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getDataEmployeeCheckIn(String employeeName) {
		return elementUtils.waitForElementToBeClickable(getEmployeeCheckIn(employeeName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getDataEmployeeShiftEnd(String employeeName) {
		return elementUtils.waitForElementToBeClickable(getEmployeeShiftEnd(employeeName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getDataEmployeeCheckOut(String employeeName) {
		return elementUtils.waitForElementToBeClickable(getEmployeeCheckOut(employeeName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getDataEmployeeShiftHours(String employeeName) {
		return elementUtils.waitForElementToBeClickable(getEmployeeShiftHours(employeeName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getDataEmployeeTotalHours(String employeeName) {
		return elementUtils.waitForElementToBeClickable(getEmployeeTotalHours(employeeName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getDataEmployeeStatus(String employeeName) {
		return elementUtils.waitForElementToBeClickable(getEmployeeStatus(employeeName), Constants.DEFAULT_WAIT)
				.getText();
	}

}
