package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class RespondingAgenciesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	// Agency Type
	private By txtHeadingRespondingAgencies = By.xpath("//h1[normalize-space()='Responding Agencies']");
	private By btnAddAgencyType = By.xpath("//span[normalize-space()='Add Agency Type']");
	private By txtboxAgencyTypeName = By.xpath("//input[@id='name']");
	private By btnSave = By.xpath("//button[@type='submit']");
	private By btnUpdate = By.xpath("//span[normalize-space()='Update']");

	// Agencies
	private By tabAgencies = By.xpath("//div[@id='rc-tabs-0-tab-2']");
	private By btnAddAgency = By.xpath("//span[normalize-space()='Add Agency']");
	private By dropdownAgencyType = By
			.xpath("//div[contains(@class,'ant-select ant-select-outlined ant-select-in-form-item')]");
	private By dropdownAgencyTypeValues = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By txtboxAgencyName = By.xpath("//input[@id='name']");
	private By txtboxContactNumber = By.xpath("(//input[@type='tel'])[1]");
	private By txtboxAlternatePhoneNumber = By.xpath("(//input[@type='tel'])[2]");
	private By txtboxLiasonOff = By.xpath("//input[@id='liaison']");

	private By txtAddAgencyTypeSuccessMessage = By
			.xpath("//div[@class='Toastify__toast-body']/div/following-sibling::div");
	private By btnOkDeleteBreak = By.xpath("//button[normalize-space()='OK']");

	private By dataAgencyName = By.xpath("(//td[@data-label='Agency Name'])[1]");
	private By dataAgencyType = By.xpath("(//td[@data-label='Agency Type'])[1]");
	private By dataContactNumber = By.xpath("(//td[@data-label='Non-Emergency Contact Number'])[1]");

	public RespondingAgenciesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isRespondingAgenciesPageVisible() {
		return elementUtils.doIsDisplayed(txtHeadingRespondingAgencies, Constants.DEFAULT_WAIT);
	}

	public boolean isAddAgencyTypeButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddAgencyType, Constants.DEFAULT_WAIT);
	}

	public void clickAddAgencyTypeButton() {
		elementUtils.waitForElementToBeClickable(btnAddAgencyType, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddAgencyTypeForm(String agencyTypeName) {
		elementUtils.waitForElementToBeClickable(txtboxAgencyTypeName, Constants.DEFAULT_WAIT).sendKeys(agencyTypeName);
		elementUtils.waitForElementToBeClickable(btnSave, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(txtAddAgencyTypeSuccessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// Edit Agency Type
	public void clickEditViolationButton(String agencyTypeName) {
		String agencytypeName = agencyTypeName;
		String editxpath = "//td[normalize-space()='" + agencytypeName
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void updateAgencyType(String updatedAgencyTypeName) {
		elementUtils.waitForElementVisible(txtboxAgencyTypeName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxAgencyTypeName);
		elementUtils.doActionsSendKeys(txtboxAgencyTypeName, updatedAgencyTypeName);
	}

	public void clickUpdateButton() {
		elementUtils.waitForElementToBeClickable(btnUpdate, Constants.DEFAULT_WAIT).click();
	}

	// Delete Agency Type
	public void clickDeleteAgencyTypeButton(String agencyTypeName) {
		String agencytypeName = agencyTypeName;
		String editxpath = "//td[contains(normalize-space(), '" + agencytypeName
				+ "')]/following-sibling::td//div[@class='actionicons deleteIcon']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickOkDeleteButton() {
		elementUtils.waitForElementToBeClickable(btnOkDeleteBreak, Constants.DEFAULT_WAIT).click();
	}

	// Agencies
	public void clickAgenciesTab() {
		elementUtils.waitForElementToBeClickable(tabAgencies, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAddAgencyButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddAgency, Constants.DEFAULT_WAIT);
	}

	public void clickAddAgencyButton() {
		elementUtils.waitForElementToBeClickable(btnAddAgency, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddAgencyForm(String agencyType, String agencyName, String contactNumber,
			String alternatePhoneNumber, String liaison) {
		elementUtils.waitForElementToBeClickable(dropdownAgencyType, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(By.xpath("//div[@title='" + agencyType + "']"), Constants.DEFAULT_WAIT)
				.click();
		elementUtils.waitForElementToBeClickable(txtboxAgencyName, Constants.DEFAULT_WAIT).sendKeys(agencyName);
		elementUtils.waitForElementToBeClickable(txtboxContactNumber, Constants.DEFAULT_WAIT).sendKeys(contactNumber);
		elementUtils.waitForElementToBeClickable(txtboxAlternatePhoneNumber, Constants.DEFAULT_WAIT)
				.sendKeys(alternatePhoneNumber);
		elementUtils.waitForElementToBeClickable(txtboxLiasonOff, Constants.DEFAULT_WAIT).sendKeys(liaison);
	}

	public void clickSaveButton() {
		elementUtils.waitForElementToBeClickable(btnSave, Constants.DEFAULT_WAIT).click();
	}

	// Update Agency
	public void clickEditAgencyButton(String agencyName) {
		String agencyname = agencyName;
		String editxpath = "//td[normalize-space()='" + agencyname
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void fillUpdateAgencyForm(String agencyType, String agencyName, String contactNumber,
			String alternatePhoneNumber, String liaison) {
		elementUtils.waitForElementToBeClickable(dropdownAgencyType, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(By.xpath("//div[@title='" + agencyType + "']"), Constants.DEFAULT_WAIT)
				.click();

		elementUtils.waitForElementVisible(txtboxAgencyName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxAgencyName);
		elementUtils.doActionsSendKeys(txtboxAgencyName, agencyName);

		elementUtils.waitForElementVisible(txtboxContactNumber, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxContactNumber);
		elementUtils.doActionsSendKeys(txtboxContactNumber, contactNumber);

		elementUtils.waitForElementVisible(txtboxAlternatePhoneNumber, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxAlternatePhoneNumber);
		elementUtils.doActionsSendKeys(txtboxAlternatePhoneNumber, alternatePhoneNumber);

		elementUtils.waitForElementVisible(txtboxLiasonOff, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxLiasonOff);
		elementUtils.doActionsSendKeys(txtboxLiasonOff, liaison);
	}

	public String getAgencyName() {
		return elementUtils.waitForElementVisible(dataAgencyName, Constants.DEFAULT_WAIT).getText();
	}

	public String getAgencyType() {
		return elementUtils.waitForElementVisible(dataAgencyType, Constants.DEFAULT_WAIT).getText();
	}

	public String getContactNumber() {
		return elementUtils.waitForElementVisible(dataContactNumber, Constants.DEFAULT_WAIT).getText();
	}

	// Delete Agency
	public void clickDeleteAgencyButton(String agencyName) {
		String agencyname = agencyName;
		String editxpath = "//td[normalize-space()='" + agencyname
				+ "']/following-sibling::td//div[@class='actionicons deleteIcon']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickOkDeleteAgencyButton() {
		elementUtils.waitForElementToBeClickable(btnOkDeleteBreak, Constants.DEFAULT_WAIT).click();
	}

	public String getAgencyContactNumber() {
		return elementUtils.waitForElementVisible(dataContactNumber, Constants.DEFAULT_WAIT).getText();
	}
}
