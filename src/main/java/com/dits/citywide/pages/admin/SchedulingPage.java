package com.dits.citywide.pages.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class SchedulingPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By dropdownSelectSite = By.cssSelector("#rc_select_2");
	private By filters = By.xpath("//button[contains(@class,'ant-btn-primary') and contains(@class,'basicButton')]");
	private By checkboxServiceType = By.xpath("//span[@class='ant-checkbox-label']");
	private By btnApply = By.xpath("//span[contains(text(),'Apply')]");
//	private By btnAddShift = By.xpath(
//			"(//th[normalize-space()='Service Type']/ancestor::thead/following-sibling::tbody//div[@class='add-shift'])[4]");
	private By dataDate = By.xpath("//th[@class='week-day site-head-column']");

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
	private By txtNoData = By.xpath("//div[contains(text(),'No data')]");

	private By dropdownShift = By.xpath("//span[@title='Empty Shift']");
	private By dropdownShiftValue = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div");
	private By txtEmployee = By.xpath("//label[contains(text(),' Employee')]");
	private By searchEmployee = By
			.xpath("//label[contains(text(),' Employee')]/following-sibling::div//input[@type='search']");
	private By txtboxEmployee = By.xpath("(//span[@class='ant-select-selection-item'])[5]");
	private By employeeList = By
			.xpath("//div[@class='ant-select-dropdown css-yw7p3q ant-select-dropdown-placement-bottomLeft']");
	private By dataSiteId = By.xpath("//label[contains(text(),'Site Id')]/following-sibling::span");
	private By dataServiceType = By.xpath("//label[contains(text(),'Service Type')]/following-sibling::span");
	private By dataStartTime = By.xpath("(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[1]");
	private By dataEndTime = By.xpath("(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[2]");
	private By dropdownScheduledBreak = By
			.xpath("//label[contains(text(),'Scheduled break')]/..//div[@class='ant-select-selector']");
	private By dropdownScheduledBreakValues = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[4]/div/div");
	private By txtboxAddNotes = By.xpath("//textarea[@placeholder='Add Notes']");
	private By btnCreateShift = By.xpath("//span[contains(text(),'Create Shift')]");
	private By successMsgShiftAdd = By.xpath("//div[contains(text(),'Shift added successfully')]");

	private By btnPublish = By.xpath("//span[contains(text(),'Publish')]");
	private By txtAreYouSure = By.xpath("//h2[@id='swal2-title']");
	private By txtThisActionWillPublishShifts = By.xpath("//h2[@id='swal2-title']");
	private By btnOk = By.xpath("//button[contains(text(),'OK')]");
	private By btnCancel = By.xpath("//button[contains(text(),'Cancel')]");
	private By successMsgPublish = By.xpath("//div[contains(text(),'Shifts published successfully!')]");

	// Beat Selection for petrol
	private By dropdownSiteOrBeatSelection = By.xpath("(//span[@class='ant-select-selection-item'])[1]");
	private By dropdownSelectBeatValue = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By dropdownSelectBeat = By.cssSelector("#rc_select_5");
	private By scheduledStartShiftTime = By.xpath("(//input[@placeholder='HH:MM'])[1]");
	private By scheduledEndShiftTime = By.xpath("(//input[@placeholder='HH:MM'])[2]");
	private By dropdownSelectAssignShiftValue = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[3]/div/div");
	private By dropdownScheduledBreakValuesPatrol = By
			.xpath("(//div[@class='rc-virtual-list-holder-inner'])[5]/div/div");

	public SchedulingPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void clickOnFilters() {
		try {
			elementUtils.waitForElementToBeClickable(filters, Constants.DEFAULT_WAIT).click();
		} catch (NoSuchElementException | TimeoutException e) {
			System.out.println("Filters button not found or not clickable: " + e.getMessage());
		}
	}
	
	public void clickOnServiceTypeCheckbox() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(checkboxServiceType, Constants.DEFAULT_WAIT).click();
	
	}

	public void selectSiteAndApply(String siteName) throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownSelectSite, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForInvisibilityOfElementLocated(txtNoData, Constants.DEFAULT_WAIT);
		elementUtils.doActionsSendKeys(dropdownSelectSite, siteName);
		Thread.sleep(3000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(btnApply, Constants.DEFAULT_WAIT).click();
	}

	// Beat Selection for petrol
	public void selectBeatAndApply(String beatName) throws InterruptedException {

		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownSiteOrBeatSelection, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownSelectBeatValue, "Beat", Constants.DEFAULT_WAIT);

		elementUtils.waitForElementVisible(dropdownSelectBeat, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownSelectBeat, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForInvisibilityOfElementLocated(txtNoData, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		elementUtils.doActionsSendKeys(dropdownSelectBeat, beatName);
		Thread.sleep(3000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(btnApply, Constants.DEFAULT_WAIT).click();
	}

	public void addShift(String date) {
		elementUtils.waitForInvisibilityOfElementLocated(txtNoData, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(btnApply, Constants.DEFAULT_WAIT);

		int i = getDatePosition(date);
		System.out.println(i);
		String datexpath = "(//th[normalize-space()='Service Type']/ancestor::thead/following-sibling::tbody//div[@class='add-shift'])["
				+ i + "]";
		elementUtils.waitForElementVisible(By.xpath(datexpath), Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(By.xpath(datexpath), Constants.DEFAULT_WAIT).click();
	}

	// Shift Selection for petrol
	public void selectAssignShiftForPetrol(String shift) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownShift, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownSelectAssignShiftValue, shift, Constants.DEFAULT_WAIT);
	}

	// Shift Selection for Field Staff
	public void selectAssignShift(String shift) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownShift, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownShiftValue, shift, Constants.DEFAULT_WAIT);
	}

	public void fillShiftForm(String shift, String employeeID, String scheduledBreak, String notes)
			throws InterruptedException {

//		elementUtils.waitForElementToBeClickable(dropdownShift, Constants.DEFAULT_WAIT).click();
//		elementUtils.selectElementThroughLocator(dropdownShiftValue, shift, Constants.DEFAULT_WAIT);

		elementUtils.waitForElementVisible(txtEmployee, Constants.DEFAULT_WAIT);
		elementUtils.doActionsClick(searchEmployee);
		elementUtils.doActionsSendKeys(searchEmployee, employeeID);
		String empidxpath = "//span[contains(text(),'" + employeeID + "')]";
		elementUtils.waitForElementVisible(By.xpath(empidxpath), Constants.DEFAULT_WAIT);
		elementUtils.pressEnterKey();

		elementUtils.waitForElementToBeClickable(dropdownScheduledBreak, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownScheduledBreakValues, scheduledBreak, Constants.DEFAULT_WAIT);
		String xpathScheduledBreak = "//div[contains(text(),'" + scheduledBreak + "')]";
		elementUtils.waitForElementVisible(By.xpath(xpathScheduledBreak), Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxAddNotes, Constants.SHORT_TIME_OUT_WAIT).sendKeys(notes);
		elementUtils.waitForElementToBeClickable(btnCreateShift, Constants.DEFAULT_WAIT).click();
	}

	// Shift Selection for Patrol
	public void fillShiftFormPatrol(String employeeID, String startTime, String endTime, String scheduledBreak,
			String notes) throws InterruptedException {
//		elementUtils.waitForElementToBeClickable(dropdownShift, Constants.DEFAULT_WAIT).click();
//		elementUtils.selectElementThroughLocator(dropdownSelectAssignShiftValue, shift, Constants.DEFAULT_WAIT);

		elementUtils.waitForElementVisible(txtEmployee, Constants.DEFAULT_WAIT);
		elementUtils.doActionsClick(searchEmployee);
		elementUtils.doActionsSendKeys(searchEmployee, employeeID);
		String empidxpath = "//div[contains(text(),'" + employeeID + "')]";
		elementUtils.waitForElementVisible(By.xpath(empidxpath), Constants.DEFAULT_WAIT);
		Thread.sleep(4000);
		elementUtils.pressEnterKey();

		// elementUtils.doActionsSendKeys(scheduledStartShiftTime, startTime);

		elementUtils.waitForElementVisible(scheduledStartShiftTime, Constants.DEFAULT_WAIT).sendKeys(startTime);
		// elementUtils.doActionsSendKeys(scheduledEndShiftTime, endTime);

		elementUtils.waitForElementVisible(scheduledEndShiftTime, Constants.DEFAULT_WAIT).sendKeys(endTime);

		elementUtils.waitForElementToBeClickable(dropdownScheduledBreak, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownScheduledBreakValuesPatrol, scheduledBreak,
				Constants.DEFAULT_WAIT);
		String xpathScheduledBreak = "//div[contains(text(),'" + scheduledBreak + "')]";
		elementUtils.waitForElementVisible(By.xpath(xpathScheduledBreak), Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxAddNotes, Constants.SHORT_TIME_OUT_WAIT).sendKeys(notes);
		elementUtils.waitForElementToBeClickable(btnCreateShift, Constants.DEFAULT_WAIT).click();
	}

	private int getDatePosition(String targetDay) {

		List<WebElement> dateElements = elementUtils.getElements(dataDate);

		for (int i = 0; i < dateElements.size(); i++) {
			String dateText = dateElements.get(i).getText().trim();

			String[] parts = dateText.split(" ");
			if (parts.length == 3) {
				String dayNumber = parts[2];
				if (dayNumber.equals(targetDay)) {
					return i + 1;
				}
			}
		}
		return -1;
	}

	public String getSuccessMessageShiftAdded() {
		return elementUtils.waitForElementVisible(successMsgShiftAdd, Constants.DEFAULT_WAIT).getText().trim();
	}

	public void clickPublishButton() {
		elementUtils.waitForInvisibilityOfElementLocated(successMsgShiftAdd, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnPublish, Constants.DEFAULT_WAIT).click();
	}

	public String getAreYouSureText() {
		return elementUtils.waitForElementVisible(txtAreYouSure, Constants.DEFAULT_WAIT).getText();
	}

	public String getPublishShiftsConfirmationText() {
		return elementUtils.waitForElementVisible(txtThisActionWillPublishShifts, Constants.DEFAULT_WAIT).getText();
	}

	public void clickOkButton() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public void clickCancelButton() {
		elementUtils.waitForElementToBeClickable(btnCancel, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessageAfterPublish() {
		return elementUtils.waitForElementVisible(successMsgPublish, Constants.DEFAULT_WAIT).getText();
	}

}
