package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class ViolationsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtHeadingViolations = By.xpath("//h1[normalize-space()='Violations']");
	private By btnAddNewViolations = By.xpath("//span[normalize-space()='Add New Violation']");
	private By txtboxViolationName = By.xpath("//input[@id='violation']");
	private By txtboxViolationDescription = By.xpath("//textarea[@id='description']");
	private By dropdownBranch = By
			.xpath("//div[contains(@class,'ant-select ant-select-outlined ant-select-in-form-item')]");
	private By selectBranchValue = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By btnSave = By.xpath("//span[normalize-space()='Save']");

	private By btnUpdateViolation = By.xpath("//span[normalize-space()='Update']");
	private By btnOkDeleteBreak = By.xpath("//button[normalize-space()='OK']");
	private By txtSuccessMessage = By.xpath("//div[@role='alert']/div/following-sibling::div");

	private By dataBranchName = By.xpath("(//td[@data-label='Branch Name'])[1]");
	private By dataViolationName = By.xpath("(//td[@data-label='Violation'])[1]");
	private By dataDescription = By.xpath("(//td[@data-label='Description'])[1]");

	// Charges
	private By btnChargesTab = By.xpath("(//div[@id='rc-tabs-0-tab-2'])[1]");
	private By btnAddNewCharges = By.xpath("//span[normalize-space()='Add Charges']");
	private By txtboxCodeName = By.xpath("//input[@id='code']");
	private By txtboxCodeDescription = By.xpath("//textarea[@id='description']");

	private By dataChargesName = By.xpath("(//td[@data-label='Code'])[1]");
	private By dataChargesDescription = By.xpath("(//td[@data-label=\"Description\"])[11]");
	
	private By btnUpdateCharges = By.xpath("//span[normalize-space()='Update']");

	public ViolationsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isViolationsPageVisible() {
		return elementUtils.doIsDisplayed(txtHeadingViolations, Constants.DEFAULT_WAIT);
	}

	public boolean isAddNewViolationsButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddNewViolations, Constants.DEFAULT_WAIT);
	}

	public void clickAddNewViolationsButton() {
		elementUtils.waitForElementToBeClickable(btnAddNewViolations, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddNewViolationsForm(String violationName, String violationDescription, String branch)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxViolationName, Constants.DEFAULT_WAIT).sendKeys(violationName);
		elementUtils.waitForElementVisible(txtboxViolationDescription, Constants.DEFAULT_WAIT)
				.sendKeys(violationDescription);
		elementUtils.waitForElementVisible(dropdownBranch, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(selectBranchValue, branch, Constants.DEFAULT_WAIT);
		elementUtils.pressEscapeKey();
	}

	public void clickSaveButton() {
		// elementUtils.waitForElementToBeClickable(btnSaveViolation,
		// Constants.DEFAULT_WAIT).click();
		elementUtils.doClickWithActionsAndWait(btnSave, Constants.DEFAULT_WAIT);
	}

	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(txtSuccessMessage, Constants.DEFAULT_WAIT).getText();
	}

	public String getBranchName() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.getText(dataBranchName, Constants.DEFAULT_WAIT);
	}

	public String getViolationName() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataViolationName, Constants.DEFAULT_WAIT).getText();
	}

	public String getViolationDescription() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataDescription, Constants.DEFAULT_WAIT).getText();
	}

	// Update Violation

	public void clickEditViolationButton(String violationName) {
		String violationname = violationName;
		String editxpath = "//td[normalize-space()='" + violationname
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void updateViolation(String violationName, String violationDescription, String branch)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxViolationName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxViolationName);
		elementUtils.doActionsSendKeys(txtboxViolationName, violationName);

		elementUtils.waitForElementVisible(txtboxViolationDescription, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxViolationDescription);
		elementUtils.doActionsSendKeys(txtboxViolationDescription, violationDescription);
	}

	public void clickUpdateViolationButton() {
		elementUtils.waitForElementToBeClickable(btnUpdateViolation, Constants.DEFAULT_WAIT).click();
	}

	public void clickOkDeleteBreakButton() {
		elementUtils.waitForElementToBeClickable(btnOkDeleteBreak, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickDeleteViolationButton(String violationName) {
		String violationname = violationName;
		String editxpath = "//td[normalize-space()='" + violationname
				+ "']/following-sibling::td//div[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	// Charges
	public void clickChargesTab() {
		elementUtils.waitForElementToBeClickable(btnChargesTab, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAddNewChargesButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddNewCharges, Constants.DEFAULT_WAIT);
	}

	public void clickAddNewChargesButton() {
		elementUtils.waitForElementToBeClickable(btnAddNewCharges, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddNewChargesForm(String codeName, String codeDescription) {
		elementUtils.waitForElementVisible(txtboxCodeName, Constants.DEFAULT_WAIT).sendKeys(codeName);
		elementUtils.waitForElementVisible(txtboxCodeDescription, Constants.DEFAULT_WAIT).sendKeys(codeDescription);
	}

	public void clickSaveChargesButton() {
		elementUtils.doClickWithActionsAndWait(btnSave, Constants.DEFAULT_WAIT);
	}

	public String getChargesName() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataChargesName, Constants.DEFAULT_WAIT).getText();
	}

	public String getChargesDescription() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataChargesDescription, Constants.DEFAULT_WAIT).getText();
	}

	public void updateCharges(String codeName, String codeDescription) {
		elementUtils.waitForElementVisible(txtboxCodeName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxCodeName);
		elementUtils.doActionsSendKeys(txtboxCodeName, codeName);

		elementUtils.waitForElementVisible(txtboxCodeDescription, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxCodeDescription);
		elementUtils.doActionsSendKeys(txtboxCodeDescription, codeDescription);
	}
	
	public void clickUpdateChargesButton() {
		elementUtils.waitForElementToBeClickable(btnUpdateCharges, Constants.DEFAULT_WAIT).click();
	}

}
