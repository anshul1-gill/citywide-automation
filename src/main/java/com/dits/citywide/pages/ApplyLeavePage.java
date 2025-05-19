package com.dits.citywide.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.Calendar;
import com.dits.citywide.utilities.ElementUtils;

public class ApplyLeavePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By dropdownLeaveType = By.className("ant-select-selector");
	private By dropdownLeaveTypeValues = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");

	private By fromDateCalender = By.id("from_date");
	private By toDateCalender = By.id("to_date");
	private By inputStartTime = By.id("start_time");
	private By inputEndTime = By.id("end_time");

	private By txtboxDescription = By.id("description");
	private By btnApplyLeave = By.xpath("//button[contains(@type,'submit')]");
	private By btnReset = By.xpath("//button[@type='reset']");

	private By msgSucess = By.xpath("//div[contains(text(),\"Leave applied successfully.\")]");

	public ApplyLeavePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isLeaveAppliedSuccessMessageDisplayed() {
		return elementUtils.doIsEnabled(msgSucess, Constants.DEFAULT_WAIT);
	}

	public void doReset() {
		elementUtils.waitForElementToBeClickable(btnReset, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public LeaveRequestsPage fillApplyLeaveForm(String leaveType, String fromMonth, String fromYear, String fromDate,
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

		elementUtils.waitForElementToBeClickable(btnApplyLeave, Constants.SHORT_TIME_OUT_WAIT).click();

		return new LeaveRequestsPage(driver);
	}
}
