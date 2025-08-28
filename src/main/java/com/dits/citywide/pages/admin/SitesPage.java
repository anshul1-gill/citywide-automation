package com.dits.citywide.pages.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class SitesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By searchSite = By.cssSelector("input[placeholder='Search']");
	private By btnViewSite = By.cssSelector("button[title='View Site']");
	private By btnEditSite = By.cssSelector("button[title='Edit Site']");
	private By btnDeleteSite = By.cssSelector("button[title='Delete Site']");

	private By btnpostorder = By.xpath("//button[normalize-space()='Post Orders']");
	// Assignment fields
	private By txtaddAssignmentName = By.xpath("//input[@id='assignment_task']");
	private By dropdownAssignmentTemplate = By.cssSelector("#assignment_template");
	// private By selectOption = By.xpath("//option[@value='91VN06']");
	private By dropdownCoverage = By.cssSelector("#assignment_type");
	// private By selectCoverageOption = By.xpath("//option[text()='Fire -
	// Stationary/Single Site']");
	private By dropdowndayofweek = By.xpath("(//ul[@class='select2-selection__rendered'])[7]");
	private By searchdayofweek = By.xpath("(//input[@type='search'])[7]");
	private By txtAssignments = By.xpath("//h4[normalize-space()='Assignments']");

	private By getAssignmentByName(String assignmentName) {
		String xpath = "//th[normalize-space()='" + assignmentName + "']";
		return By.xpath(xpath);
	}

	private By getTemplateNameByAssignment(String assignmentName) {
		String xpath = "(//th[normalize-space()='" + assignmentName + "']/following-sibling::td)[1]";
		return By.xpath(xpath);
	}

	private By getCoverageTypeByAssignment(String assignmentName) {
		String xpath = "(//th[normalize-space()='" + assignmentName + "']/following-sibling::td)[2]";
		return By.xpath(xpath);
	}

	private By getDaysOfWeekByAssignment(String assignmentName) {
		String xpath = "(//th[normalize-space()='" + assignmentName + "']/following-sibling::td)[3]";
		return By.xpath(xpath);
	}

	private By getAssignmentTimeSlotByAssignment(String assignmentName) {
		String xpath = "(//th[normalize-space()='" + assignmentName + "']/following-sibling::td)[4]";
		return By.xpath(xpath);
	}

	private By getAddedByAssignment(String assignmentName) {
		String xpath = "(//th[normalize-space()='" + assignmentName + "']/following-sibling::td)[5]";
		return By.xpath(xpath);
	}

	private By deleteButtonByAssignmentName(String assignmentName) {
		String xpath = "//th[normalize-space()='" + assignmentName + "']"
				+ "/following-sibling::td//div[@class='flex gap-2']/button[2]";
		return By.xpath(xpath);
	}

	private By btnOkButton = By.xpath("//button[normalize-space()='OK']");

	// Check Point
	private By btnCheckPoint = By.xpath("//a[normalize-space()='Check Point']");
	private By txtHeadingCheckPoint = By.xpath("//h1[@class='heading-text']");
	private By btnAddNewCheckPoint = By.xpath("//span[normalize-space()='Add Checkpoint']");
	private By txtCheckpointName = By.id("label");
	private By txtCheckpointDescription = By.id("description");
	private By dropdownCheckpointType = By.xpath("(//div[@class='ant-select-selector'])[2]");

	private By getCheckpointByType(String checkpointType) {
		String xpath = "//div[@title='" + checkpointType + "']";
		return By.xpath(xpath);
	}

	private By btnSave = By.xpath("//button[@type='submit']");
	private By btnBack = By.xpath("//span[normalize-space()='Back']");

	private By sucessMessage = By
			.xpath("//div[@class='swal2-icon swal2-success swal2-icon-show']/following-sibling::h2/span");
	private By deleteCheckpointSucessMessage = By
			.xpath("//div[@class='Toastify__toast-body']/div/following-sibling::div");
	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	private By getDayOption(String day) {
		String xpath = "//li[normalize-space(text())='" + day + "']";
		return By.xpath(xpath);
	}

	private By AddAssignmentTime = By.xpath("//input[@id='assignment_time']");
	private By AddsnitchTime = By.xpath("//input[@id='assignment_grace_time']");
	private By btnAddAssignment = By.xpath("//button[normalize-space()='Add Assignment']");
	private By btnUpdatepostorder = By.xpath("//button[normalize-space()='Update']");

	private By getCheckpointByName(String checkpointName) {
		String xpath = "//td[normalize-space()='" + checkpointName + "']";
		return By.xpath(xpath);
	}

	private By getCheckpointDescriptionByName(String checkpointName) {
		String xpath = "(//td[normalize-space()='" + checkpointName + "']/following-sibling::td)[1]";
		return By.xpath(xpath);
	}

	private By getCheckpointTypeByName(String checkpointName) {
		String xpath = "(//td[normalize-space()='" + checkpointName + "']/following-sibling::td)[2]";
		return By.xpath(xpath);
	}

	private By getCheckpointSiteNameByName(String checkpointName) {
		String xpath = "(//td[normalize-space()='" + checkpointName + "']/following-sibling::td)[3]";
		return By.xpath(xpath);
	}

	private By deleteButtonByCheckpointName(String checkpointName) {
		String xpath = "//td[normalize-space()='" + checkpointName + "']"
				+ "/following-sibling::td[@data-label='Actions']" + "//div[@class='actionicons deleteIcon']";
		return By.xpath(xpath);
	}

	// Scan Rules
	private By tabScanRules = By.cssSelector("#rc-tabs-1-tab-2");
	private By btnAddScanRule = By.xpath("//span[normalize-space()='Add Scan Rule']");
	private By txtADDScanTime = By.xpath("//input[@id='scan_deadline_time']");
	private By txtAddsnitchTime = By.xpath("//input[@id='grace_period']");
	private By dropdownActiveDays = By.xpath("(//div[@class='ant-select-selector'])[2]");
	private By btnSaveScan = By.xpath("//button[@type='submit']/span[text()='Add Scan Rule']");

	// Actions Rules
	private By tabActionsRules = By.cssSelector("#rc-tabs-1-tab-3");
	private By btnAddactionRule = By.xpath("//button[@type='button']/span[text()='Add Action Rule']");
	private By txtboxAddpriority = By.xpath("//input[@id='priority']");
	private By dropdownInputtype = By.xpath("(//div[@class='ant-select-selector'])[2]");

	public By getInputType(String text) {
		return By.xpath("//div[contains(text(),'" + text + "')]");
	}

	private By txtboxDirective = By.xpath("//input[@Id='directive']");
	private By btnSaveAction = By.xpath("//button[@type='submit']/span[text()='Add Action Rule']");

	// QR Code
	private By tabViewQRcode = By.cssSelector("#rc-tabs-1-tab-4");

	public SitesPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public void searchSite(String siteName) {
		elementUtils.waitForElementVisible(searchSite, Constants.DEFAULT_WAIT).sendKeys(siteName);
	}

	public void clickViewSite() {
		elementUtils.waitForElementVisible(btnViewSite, Constants.DEFAULT_WAIT).click();
	}

	public void clickEditSite() {
		elementUtils.waitForElementVisible(btnEditSite, Constants.DEFAULT_WAIT).click();
	}

	public void clickDeleteSite() {
		elementUtils.waitForElementVisible(btnDeleteSite, Constants.DEFAULT_WAIT).click();
	}

	// Post Orders
	public void clickPostOrders() {
		elementUtils.waitForElementVisible(btnpostorder, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddAssignmentForm(String assignmentName, String template, String coverageType,
			List<String> daysOfWeek, String assignmentTime, String snitchTime) throws InterruptedException {
		elementUtils.waitForElementVisible(txtaddAssignmentName, Constants.DEFAULT_WAIT).sendKeys(assignmentName);
		elementUtils.doSelectBy(dropdownAssignmentTemplate, template);
		elementUtils.doSelectBy(dropdownCoverage, coverageType);

//		for (String day : daysOfWeek) {
//			elementUtils.doClickWithActionsAndWait(dropdowndayofweek, Constants.DEFAULT_WAIT);
//			elementUtils.doActionsSendKeys(searchdayofweek, day);
//			elementUtils.pressEnterKey();
//		}
		for (String day : daysOfWeek) {
			elementUtils.doClickWithActionsAndWait(dropdowndayofweek, Constants.DEFAULT_WAIT);
			elementUtils.waitForElementVisible(getDayOption(day), Constants.DEFAULT_WAIT).click();
		}

		elementUtils.waitForElementVisible(AddAssignmentTime, Constants.DEFAULT_WAIT).sendKeys(assignmentTime);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementVisible(AddsnitchTime, Constants.DEFAULT_WAIT).sendKeys(snitchTime);
	}

	public void clickAddAssignment() {
		elementUtils.waitForElementVisible(btnAddAssignment, Constants.DEFAULT_WAIT).click();
	}

	public void clickUpdatePostOrder() {
		elementUtils.waitForInvisibilityOfElementLocated(sucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(btnUpdatepostorder, Constants.DEFAULT_WAIT).click();
	}

	public String getAssignmentName(String assignmentName) {
		return elementUtils.waitForElementVisible(getAssignmentByName(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getTemplateName(String assignmentName) {
		return elementUtils.waitForElementVisible(getTemplateNameByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCoverageType(String assignmentName) {
		return elementUtils.waitForElementVisible(getCoverageTypeByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getDaysOfWeek(String assignmentName) {
		return elementUtils.waitForElementVisible(getDaysOfWeekByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getAssignmentTimeSlot(String assignmentName) {
		return elementUtils
				.waitForElementVisible(getAssignmentTimeSlotByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getAddedBy(String assignmentName) {
		return elementUtils.waitForElementVisible(getAddedByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getAssignmentsText() {
		return elementUtils.waitForElementVisible(txtAssignments, Constants.DEFAULT_WAIT).getText();
	}

	// Check Point Methods
	public void clickCheckPointThatOpensNewTab() {
		elementUtils.waitForElementVisible(btnCheckPoint, Constants.DEFAULT_WAIT).click();
		elementUtils.switchToNewTab(Constants.DEFAULT_WAIT);
	}

	public String getHeadingCheckPoint() {
		return elementUtils.waitForElementVisible(txtHeadingCheckPoint, Constants.DEFAULT_WAIT).getText();
	}

	public void clickAddNewCheckPoint() {
		elementUtils.waitForElementVisible(btnAddNewCheckPoint, Constants.DEFAULT_WAIT).click();
	}

	public void fillCheckPointForm(String checkpointName, String checkpointDescription, String checkpointType) {
		elementUtils.waitForElementVisible(txtCheckpointName, Constants.DEFAULT_WAIT).sendKeys(checkpointName);
		elementUtils.waitForElementVisible(txtCheckpointDescription, Constants.DEFAULT_WAIT)
				.sendKeys(checkpointDescription);
		elementUtils.doClickWithActionsAndWait(dropdownCheckpointType, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(getCheckpointByType(checkpointType), Constants.DEFAULT_WAIT).click();
	}

	public void clickSave() {
		elementUtils.waitForElementVisible(btnSave, Constants.DEFAULT_WAIT).click();
	}

	public void clickTabScanRules() {
		elementUtils.waitForInvisibilityOfElementLocated(deleteCheckpointSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(tabScanRules, Constants.DEFAULT_WAIT).click();
	}

	public void clickAddScanRule() {
		elementUtils.waitForElementVisible(btnAddScanRule, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddScanRuleForm(String scanTime, String snitchTime, List<String> activeDays) {
		elementUtils.waitForElementVisible(txtADDScanTime, Constants.DEFAULT_WAIT).sendKeys(scanTime);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementVisible(txtAddsnitchTime, Constants.DEFAULT_WAIT).sendKeys(snitchTime);
		elementUtils.waitForElementToBeClickable(dropdownActiveDays, Constants.DEFAULT_WAIT).click();
		for (String day : activeDays) {
			By dayOption = By.xpath("//div[@title='" + day + "' and contains(@class,'ant-select-item-option')]");
			elementUtils.waitForElementVisible(dayOption, Constants.DEFAULT_WAIT).click();
		}
	}

	public void clickSaveScanRule() {
		elementUtils.waitForElementVisible(btnSaveScan, Constants.DEFAULT_WAIT).click();
	}

	public void clickTabActionsRules() {
		elementUtils.waitForElementVisible(tabActionsRules, Constants.DEFAULT_WAIT).click();
	}

	public void clickAddActionRule() {
		elementUtils.waitForElementVisible(btnAddactionRule, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddActionRuleForm(String priority, String inputType, String directive) {
		elementUtils.waitForElementVisible(txtboxAddpriority, Constants.DEFAULT_WAIT).sendKeys(priority);
		elementUtils.doClickWithActionsAndWait(dropdownInputtype, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(getInputType(inputType), Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxDirective, Constants.DEFAULT_WAIT).sendKeys(directive);
	}

	public void clickSaveActionRule() {
		elementUtils.waitForElementVisible(btnSaveAction, Constants.DEFAULT_WAIT).click();
	}

	public void clickTabViewQRcode() {
		elementUtils.waitForElementVisible(tabViewQRcode, Constants.DEFAULT_WAIT).click();
	}

	public void clickBack() throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActionsAndWait(btnBack, Constants.DEFAULT_WAIT);
	}

	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.MEDIUM_TIME_OUT_WAIT).getText();
	}

	public String getDeleteCheckpointSuccessMessage() {
		return elementUtils.waitForElementVisible(deleteCheckpointSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT)
				.getText();
	}

	public String getCheckpointName(String checkpointName) {
		return elementUtils.waitForElementVisible(getCheckpointByName(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCheckpointDescription(String checkpointName) {
		return elementUtils
				.waitForElementVisible(getCheckpointDescriptionByName(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCheckpointType(String checkpointName) {
		return elementUtils.waitForElementVisible(getCheckpointTypeByName(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCheckpointSiteName(String checkpointName) {
		return elementUtils.waitForElementVisible(getCheckpointSiteNameByName(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public boolean isDeleteAssignmentPresent(String assignmentName) {
		return elementUtils.doIsDisplayed(deleteButtonByAssignmentName(assignmentName), Constants.DEFAULT_WAIT);
	}

	public void clickDeleteAssignmentByName(String assignmentName) {
		elementUtils.waitForElementVisible(deleteButtonByAssignmentName(assignmentName), Constants.DEFAULT_WAIT)
				.click();
	}

	public void clickOkButton() {
		elementUtils.waitForElementVisible(btnOkButton, Constants.DEFAULT_WAIT).click();
	}

	public boolean isDeleteCheckpointPresent(String checkpointName) {
		return elementUtils.doIsDisplayed(deleteButtonByCheckpointName(checkpointName), Constants.DEFAULT_WAIT);
	}

	public void clickDeleteCheckpointByName(String checkpointName) {
		elementUtils.waitForElementVisible(deleteButtonByCheckpointName(checkpointName), Constants.DEFAULT_WAIT)
				.click();
	}

	public String getScanRuleSuccessMessage() {
		return elementUtils.waitForElementVisible(deleteCheckpointSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT)
				.getText();
	}

	public String getActionRuleSuccessMessage() {
		return elementUtils.waitForElementVisible(deleteCheckpointSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT)
				.getText();
	}

}
