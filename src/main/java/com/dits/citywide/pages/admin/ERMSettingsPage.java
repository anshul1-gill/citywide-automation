package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class ERMSettingsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	// Remarks
	private By headingtxtSettings = By.xpath("//h1[normalize-space()='Settings']");
	private By btnAddRemark = By.xpath("//span[normalize-space()='Add Remark']");
	private By headingtxtAddRemarks = By.xpath("//h1[@class='heading-text']");
	private By txtboxRemarkCategory = By.xpath("//input[@id='counsel_name']");

	// data
	private By dataType = By.xpath("//td[@data-label='Type']/div");
	private By dataRemarkCategory = By.xpath("//td[@data-label='Remark Category']");
	private By dataCreatedAt = By.xpath("//td[@data-label='Created At']");
	private By dataCreatedBy = By.xpath("//td[@data-label='Created By']");

	private By btnEdit = By.xpath("//div[@class='actionicons editPencil']");
	private By btnDelete = By.xpath("//div[@class='actionicons deleteIcon']");
	private By btnOkButton = By.xpath("//button[normalize-space()='OK']");

	// Reason
	private By tabReason = By.cssSelector("#rc-tabs-0-tab-2");
	private By btnAddReason = By.xpath("//span[normalize-space()='Add Reason']");
	private By headingtxtAddReason = By.xpath("//h1[@class='heading-text']");
	private By txtboxReasonCategory = By.id("reason");
	private By dropdownReasonType = By.xpath("//span[@class='ant-select-selection-wrap']");

	private By dataReasonType = By.xpath("//td[@data-label='Type']/div");
	private By dataReason = By.xpath("//td[@data-label='Reason']");
	private By dataReasonCreatedAt = By.xpath("//td[@data-label='Created At']");
	private By dataReasonCreatedBy = By.xpath("//td[@data-label='Created By']");

	private By searchCategory = By.cssSelector("input[placeholder='Search']");
	private By dropdownRemarkType = By.xpath("//span[@class='ant-select-selection-wrap']");

	private By getRemarkTypeLocator(String remarkType) {
		return By.xpath("//div[@class='ant-select-item-option-content' and text()='" + remarkType + "']");
	}

	private By btnSaveButton = By.xpath("//span[text()='Save']");
	private By btnUpdateButton = By.cssSelector("button[type='submit'] span");
	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	public ERMSettingsPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public String getHeadingText() {
		return elementUtils.getText(headingtxtSettings, Constants.DEFAULT_WAIT);
	}

	public void searchRemarkCategory(String category) {
		elementUtils.waitForInvisibilityOfElementLocated(sucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(searchCategory, Constants.DEFAULT_WAIT).sendKeys(category);
	}

	public void clickAddRemark() {
		elementUtils.waitForElementToBeClickable(btnAddRemark, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingTextAddRemarks() {
		return elementUtils.getText(headingtxtAddRemarks, Constants.DEFAULT_WAIT);
	}

	public void fillAddRemarkForm(String remarkCategory, String remarkType) {
		elementUtils.waitForElementVisible(txtboxRemarkCategory, Constants.DEFAULT_WAIT).sendKeys(remarkCategory);
		elementUtils.waitForElementToBeClickable(dropdownRemarkType, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getRemarkTypeLocator(remarkType), Constants.DEFAULT_WAIT).click();
	}

	public void clickSaveButton() {
		elementUtils.waitForElementToBeClickable(btnSaveButton, Constants.DEFAULT_WAIT).click();
	}

	public String getRemarkType() {
		elementUtils.waitForInvisibilityOfElementLocated(sucessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.getText(dataType, Constants.DEFAULT_WAIT);
	}

	public String getRemarkCategory() {
		return elementUtils.getText(dataRemarkCategory, Constants.DEFAULT_WAIT);
	}

	public String getCreatedAt() {
		return elementUtils.getText(dataCreatedAt, Constants.DEFAULT_WAIT);
	}

	public String getCreatedBy() {
		return elementUtils.getText(dataCreatedBy, Constants.DEFAULT_WAIT);
	}

	public void clickEditButton() {
		elementUtils.waitForElementToBeClickable(btnEdit, Constants.DEFAULT_WAIT).click();
	}

	public void clickDeleteButton() {
		elementUtils.waitForElementToBeClickable(btnDelete, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessage() {
		return elementUtils.getText(sucessMessage, Constants.DEFAULT_WAIT);
	}

	// Updated
	public void fillUpdatedRemarkForm(String remarkCategory, String remarkType) {
		elementUtils.waitForElementVisible(txtboxRemarkCategory, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxRemarkCategory);
		elementUtils.doActionsSendKeys(txtboxRemarkCategory, remarkCategory);

		elementUtils.waitForElementToBeClickable(dropdownRemarkType, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getRemarkTypeLocator(remarkType), Constants.DEFAULT_WAIT).click();
	}

	public void clickUpdateButton() {
		elementUtils.waitForElementToBeClickable(btnUpdateButton, Constants.DEFAULT_WAIT).click();
	}

	public void clickOkButton() {
		elementUtils.waitForElementToBeClickable(btnOkButton, Constants.DEFAULT_WAIT).click();
	}

	// Reason

	public void clickTabReason() {
		elementUtils.waitForElementToBeClickable(tabReason, Constants.DEFAULT_WAIT).click();
	}

	public void clickAddReason() {
		elementUtils.waitForElementToBeClickable(btnAddReason, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingTextAddReason() {
		return elementUtils.getText(headingtxtAddReason, Constants.DEFAULT_WAIT);
	}

	public void fillAddReasonForm(String reasonCategory, String reasonType) {
		elementUtils.waitForElementVisible(txtboxReasonCategory, Constants.DEFAULT_WAIT).sendKeys(reasonCategory);
		elementUtils.waitForElementToBeClickable(dropdownReasonType, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getRemarkTypeLocator(reasonType), Constants.DEFAULT_WAIT).click();
	}

	public void clickSaveReasonButton() {
		elementUtils.waitForElementToBeClickable(btnSaveButton, Constants.DEFAULT_WAIT).click();
	}

	public String getReasonType() {
		elementUtils.waitForInvisibilityOfElementLocated(sucessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.getText(dataReasonType, Constants.DEFAULT_WAIT);
	}

	public String getReasonCategory() {
		return elementUtils.getText(dataReason, Constants.DEFAULT_WAIT);
	}

	public String getReasonCreatedAt() {
		return elementUtils.getText(dataReasonCreatedAt, Constants.DEFAULT_WAIT);
	}

	public String getReasonCreatedBy() {
		return elementUtils.getText(dataReasonCreatedBy, Constants.DEFAULT_WAIT);
	}

	public void searchReasonCategory(String category) {
		elementUtils.waitForInvisibilityOfElementLocated(sucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(searchCategory, Constants.DEFAULT_WAIT).sendKeys(category);
	}

	// Updated Reason
	public void fillUpdatedReasonForm(String reasonCategory, String reasonType) {
		elementUtils.waitForElementVisible(txtboxReasonCategory, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxReasonCategory);
		elementUtils.doActionsSendKeys(txtboxReasonCategory, reasonCategory);

		elementUtils.waitForElementToBeClickable(dropdownReasonType, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getRemarkTypeLocator(reasonType), Constants.DEFAULT_WAIT).click();
	}

	public void clickUpdateReasonButton() {
		elementUtils.waitForElementToBeClickable(btnUpdateButton, Constants.DEFAULT_WAIT).click();
	}

	public void clickOkReasonButton() {
		elementUtils.waitForElementToBeClickable(btnOkButton, Constants.DEFAULT_WAIT).click();
	}

}
