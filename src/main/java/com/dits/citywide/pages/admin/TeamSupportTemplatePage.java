package com.dits.citywide.pages.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class TeamSupportTemplatePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By pageHeader = By.cssSelector(".heading-text");

	// Add Template
	private By btnAddNewTemplate = By.xpath("//button[normalize-space()='Add New Template']");
	private By txtboxTemplatename = By.xpath("//input[@placeholder='Template Name']");
	private By txtboxDepartmentName = By.xpath("(//div[@class='ant-select-selector'])[1]");
	private By searchDepartment = By.cssSelector("#department_id");
	private By txtboxAssignedTo = By.xpath("(//div[@class='ant-select-selector'])[2]");
	private By assignedToSearch = By.cssSelector("#responding_person_id");
	private By txtboxDescriptionMaker = By.xpath("(//div[@class='ant-select-selector'])[3]");
	private By decisionMakerSearch = By.cssSelector("#cc_responding_person_id");
	private By btnzdropdownStatus = By.xpath("(//div[@class='ant-select-selector'])[4]");
	private By txtNoDataFound = By.xpath("//div[@class='ant-empty-description']");

	public static By getStatusLocator(String status) {
		String xpath = String.format("//div[contains(text(),'%s')]", status);
		return By.xpath(xpath);
	}

	private By txtDescription = By.xpath("//textarea[@id='description']");
	private By valueAssignedTo = By.xpath("//div[@class='ant-select-item ant-select-item-option']");
	// Drag and Drop
	private By dragdropTextinput = By.xpath("//li[@draggable='true' and normalize-space()='Text Input']");
	private By draganddropNumber = By.xpath("//li[@draggable='true' and normalize-space()='Number']");
	private By draganddroptextarea = By.xpath("//li[@draggable='true' and normalize-space()='Text Area']");
	private By dragandropdropdown = By.xpath("//li[@draggable='true' and normalize-space()='Dropdown']");
	private By draganddropdatefield = By.xpath("//li[@draggable='true' and normalize-space()='Date Field']");
	private By draganddropradiogroup = By.xpath("//li[@draggable='true' and normalize-space()='Radio Group']");
	private By draganddropfileupload = By.xpath("//li[@draggable='true' and normalize-space()='File Upload']");
	private By draganddropemail = By.xpath("//li[@draggable='true' and normalize-space()='Email']");

	// Edit the dropdownelemensts label
	private By edittextinput = By.xpath("(//div[@class='btn is-isolated']/i[@class='is-isolated fas fa-edit'])[1]");

	// Edit number question
	private By editNumbertxt = By.xpath("(//div[@class='btn is-isolated']/i[@class='is-isolated fas fa-edit'])[2]");

	// Edit Text Area
	private By edittextarea = By.xpath("(//div[@class='btn is-isolated']/i[@class='is-isolated fas fa-edit'])[3]");
	// Edit dopdown
	private By editdropdown = By.xpath("(//div[@class='btn is-isolated']/i[@class='is-isolated fas fa-edit'])[4]");

	// dropdown xpaths
	private By dropdownoptionone = By.xpath("(//input[@placeholder='Option text'])[1]");
	private By dropdownoptiontwo = By.xpath("(//input[@placeholder='Option text'])[2]");
	private By dropdownoptionthree = By.xpath("(//input[@placeholder='Option text'])[3]");

	// Edit datefield
	private By editdatefield = By.xpath("(//div[@class='btn is-isolated']/i[@class='is-isolated fas fa-edit'])[5]");
	private By checkboxshowtime = By.xpath("//input[@id='show-time-select']");

	// editRadiogroup
	private By editRadiogrp = By.xpath("(//div[@class='btn is-isolated']/i[@class='is-isolated fas fa-edit'])[6]");
	private By checkboxgrp = By.xpath("//input[@id='display-horizontal']");

	// edit email
	private By editemailbtn = By.xpath("(//div[@class='btn is-isolated']/i[@class='is-isolated fas fa-edit'])[7]");

	// Common for all elements while editing
	private By txtareatodisplay = By.xpath("(//div[@aria-label='rdw-editor' and @role='textbox'])[1]");
	private By labeldisplay = By.xpath("(//div[@aria-label='rdw-editor' and @role='textbox'])[2]");
	private By checkboxrequired = By.xpath("//input[@id='is-required']");

	private By savebtn = By.xpath("//button[@type='submit']");

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	public TeamSupportTemplatePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isPageHeaderVisible() {
		return elementUtils.waitForElementVisible(pageHeader, Constants.DEFAULT_WAIT).isDisplayed();
	}

	public void clickOnAddNewTemplate() {
		elementUtils.waitForElementToBeClickable(btnAddNewTemplate, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddTemplateDetails(String templatename, String departmentname, String assignedto,
			String decisionmaker, String status, String description) throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxTemplatename, Constants.DEFAULT_WAIT).sendKeys(templatename);
		elementUtils.doClickWithActionsAndWait(txtboxDepartmentName, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(searchDepartment, Constants.DEFAULT_WAIT).sendKeys(departmentname);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();
		// Thread.sleep(5000);
		elementUtils.waitForElementToBeClickable(txtboxAssignedTo, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(valueAssignedTo, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(assignedToSearch, Constants.DEFAULT_WAIT).sendKeys(assignedto);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(txtboxDescriptionMaker, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(decisionMakerSearch, Constants.DEFAULT_WAIT).sendKeys(decisionmaker);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementVisible(btnzdropdownStatus, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(getStatusLocator(status), Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtDescription, Constants.DEFAULT_WAIT).sendKeys(description);
	}
//
//	public void selectToolboxElements(String textInputTextToDispaly, String textInputLabelToDisplay,
//			String numberTextToDisplay, String textAreaTextToDisplay, String textAreaLabelToDisplay,
//			String dropdownOptionOne, String dropdownOptionTwo, String dropdownOptionThree,
//			String dateFieldTextToDisplay, String radioGrpTextToDisplay, String emailTextToDisplay) {
//
//		elementUtils.waitForElementToBeClickable(dragdropTextinput, Constants.DEFAULT_WAIT).click();
//		elementUtils.waitForElementToBeClickable(edittextinput, Constants.DEFAULT_WAIT).click();
//		elementUtils.doSendKeysWithClear(btnAddNewTemplate, textInputTextToDispaly);
//		elementUtils.doSendKeysWithClear(btnAddNewTemplate, textInputLabelToDisplay);
//		elementUtils.waitForElementToBeClickable(draganddropNumber, Constants.DEFAULT_WAIT).click();
//		elementUtils.waitForElementToBeClickable(draganddroptextarea, Constants.DEFAULT_WAIT).click();
//		elementUtils.waitForElementToBeClickable(dragandropdropdown, Constants.DEFAULT_WAIT).click();
//		elementUtils.waitForElementToBeClickable(draganddropdatefield, Constants.DEFAULT_WAIT).click();
//		elementUtils.waitForElementToBeClickable(draganddropradiogroup, Constants.DEFAULT_WAIT).click();
//		elementUtils.waitForElementToBeClickable(draganddropemail, Constants.DEFAULT_WAIT).click();
//	}

	public void clickOnTextInputToolbox() {
		elementUtils.doClickWithActionsAndWait(dragdropTextinput, Constants.DEFAULT_WAIT);
	}

	public void clickOnNumberToolbox() {
		elementUtils.doClickWithActionsAndWait(draganddropNumber, Constants.DEFAULT_WAIT);
	}

	public void clickOnTextAreaToolbox() {
		elementUtils.doClickWithActionsAndWait(draganddroptextarea, Constants.DEFAULT_WAIT);
	}

	public void clickOnDropdownToolbox() {
		elementUtils.doClickWithActionsAndWait(dragandropdropdown, Constants.DEFAULT_WAIT);
	}

	public void clickOnDateFieldToolbox() {
		elementUtils.doClickWithActionsAndWait(draganddropdatefield, Constants.DEFAULT_WAIT);
	}

	public void clickOnRadioGroupToolbox() {
		elementUtils.doClickWithActionsAndWait(draganddropradiogroup, Constants.DEFAULT_WAIT);
	}

	public void clickOnFileUploadToolbox() {
		elementUtils.doClickWithActionsAndWait(draganddropfileupload, Constants.DEFAULT_WAIT);
	}

	public void clickOnEmailToolbox() throws InterruptedException {
		elementUtils.doClickWithActionsAndWait(draganddropemail, Constants.DEFAULT_WAIT);
	}

	// ---- Text Input ----
	public void addTextInput(String textInputTextToDispaly, String textInputLabelToDisplay)
			throws InterruptedException {
		elementUtils.doClickWithActionsAndWait(edittextinput, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtareatodisplay, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtareatodisplay);
		elementUtils.doActionsSendKeys(txtareatodisplay, textInputTextToDispaly);

		elementUtils.waitForElementVisible(labeldisplay, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(labeldisplay);
		elementUtils.doActionsSendKeys(labeldisplay, textInputLabelToDisplay);

		elementUtils.doClickWithActionsAndWait(checkboxrequired, Constants.DEFAULT_WAIT);
	}

	// ================= Number =================
	public void addNumberField(String numberTextToDisplay, String numberLabelToDisplay) {
		elementUtils.doClickWithActionsAndWait(editNumbertxt, Constants.DEFAULT_WAIT);

		elementUtils.clearTextBoxWithActions(txtareatodisplay);
		elementUtils.doActionsSendKeys(txtareatodisplay, numberTextToDisplay);

		elementUtils.clearTextBoxWithActions(labeldisplay);
		elementUtils.doActionsSendKeys(labeldisplay, numberLabelToDisplay);
	}

	// ================= Text Area =================
	public void addTextArea(String textAreaTextToDisplay, String textAreaLabelToDisplay) {
		elementUtils.doClickWithActionsAndWait(edittextarea, Constants.DEFAULT_WAIT);

		elementUtils.clearTextBoxWithActions(txtareatodisplay);
		elementUtils.doActionsSendKeys(txtareatodisplay, textAreaTextToDisplay);

		elementUtils.clearTextBoxWithActions(labeldisplay);
		elementUtils.doActionsSendKeys(labeldisplay, textAreaLabelToDisplay);

	}

	// ================= Dropdown =================
	public void addDropdown(String dropdownTextToDisplay, String dropdownLabelToDisplay, List<String> dropdownOptions) {
		elementUtils.doClickWithActionsAndWait(editdropdown, Constants.DEFAULT_WAIT);

		elementUtils.clearTextBoxWithActions(txtareatodisplay);
		elementUtils.doActionsSendKeys(txtareatodisplay, dropdownTextToDisplay);

		elementUtils.clearTextBoxWithActions(labeldisplay);
		elementUtils.doActionsSendKeys(labeldisplay, dropdownLabelToDisplay);

		// Enter options dynamically (limit: 3 locators shared)
		if (dropdownOptions.size() > 0) {
			elementUtils.clearTextBoxWithActions(dropdownoptionone);
			elementUtils.doActionsSendKeys(dropdownoptionone, dropdownOptions.get(0));
		}
		if (dropdownOptions.size() > 1) {
			elementUtils.clearTextBoxWithActions(dropdownoptiontwo);
			elementUtils.doActionsSendKeys(dropdownoptiontwo, dropdownOptions.get(1));
		}
		if (dropdownOptions.size() > 2) {
			elementUtils.clearTextBoxWithActions(dropdownoptionthree);
			elementUtils.doActionsSendKeys(dropdownoptionthree, dropdownOptions.get(2));
		}
	}

	// ================= Date Field =================
	public void addDateField(String dateFieldTextToDisplay, String dateLabelToDisplay) throws InterruptedException {
		elementUtils.doClickWithActionsAndWait(editdatefield, Constants.DEFAULT_WAIT);

		elementUtils.clearTextBoxWithActions(txtareatodisplay);
		elementUtils.doActionsSendKeys(txtareatodisplay, dateFieldTextToDisplay);

		elementUtils.clearTextBoxWithActions(labeldisplay);
		elementUtils.doActionsSendKeys(labeldisplay, dateLabelToDisplay);

		elementUtils.doClickWithActionsAndWait(checkboxshowtime, Constants.DEFAULT_WAIT);
	}

	// ================= Radio Group =================
	public void addRadioGroup(String radioGrpTextToDisplay, String radioLabelToDisplay, List<String> radioOptions)
			throws InterruptedException {
		// Step 1: Click edit button
		elementUtils.doClickWithActionsAndWait(editRadiogrp, Constants.DEFAULT_WAIT);

		// Step 2: Set Radio Group Display Text
		elementUtils.clearTextBoxWithActions(txtareatodisplay);
		elementUtils.doActionsSendKeys(txtareatodisplay, radioGrpTextToDisplay);

		// Step 3: Set Radio Group Label
		elementUtils.clearTextBoxWithActions(labeldisplay);
		elementUtils.doActionsSendKeys(labeldisplay, radioLabelToDisplay);

		// Step 4: Fill options dynamically (limit: 3)
		if (radioOptions.size() > 0) {
			elementUtils.clearTextBoxWithActions(dropdownoptionone);
			elementUtils.doActionsSendKeys(dropdownoptionone, radioOptions.get(0));
		}
		if (radioOptions.size() > 1) {
			elementUtils.clearTextBoxWithActions(dropdownoptiontwo);
			elementUtils.doActionsSendKeys(dropdownoptiontwo, radioOptions.get(1));
		}
		if (radioOptions.size() > 2) {
			elementUtils.clearTextBoxWithActions(dropdownoptionthree);
			elementUtils.doActionsSendKeys(dropdownoptionthree, radioOptions.get(2));
		}
		// Step 5: Click checkbox (horizontal alignment etc.)
		elementUtils.doClickWithActionsAndWait(checkboxgrp, Constants.DEFAULT_WAIT);
	}

	// ================= Email =================
	public void addEmailField(String emailTextToDisplay, String emailLabelToDisplay) {
		elementUtils.doClickWithActionsAndWait(editemailbtn, Constants.DEFAULT_WAIT);

		elementUtils.clearTextBoxWithActions(txtareatodisplay);
		elementUtils.doActionsSendKeys(txtareatodisplay, emailTextToDisplay);

		elementUtils.clearTextBoxWithActions(labeldisplay);
		elementUtils.doActionsSendKeys(labeldisplay, emailLabelToDisplay);
	}

	public void clickOnSaveButton() {
		elementUtils.doClickWithActionsAndWait(savebtn, Constants.DEFAULT_WAIT);
	}
	
	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.DEFAULT_WAIT).getText();
	}

}