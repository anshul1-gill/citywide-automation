package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class HRConfigurationsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtHeadingHRConfigurations = By.xpath("//h1[normalize-space()='HR Configurations']");
	private By btnAddNotificationType = By.xpath("//span[normalize-space()='Add Notification Type']");
	private By dropdownNotificationType = By.xpath("(//div[contains(@class,'ant-select-selector')])[2]");
	private By txtboxNotificationTypeName = By.xpath("//input[@id='type']");
	private By dropdownEmployee = By.xpath("(//div[contains(@aria-required,'true')])[2]");
	private By txtboxEmployeeName = By.xpath("//input[@id='employee']");
	private By txtboxEmails = By.xpath("//input[@id='emails']");
	private By btnSaveNotificationsType = By.xpath("//button[contains(@type,'submit')]");

	// Allowance Type
	private By tabAllowanceType = By.xpath("//div[@id='rc-tabs-0-tab-3']");
	private By btnAddAllowanceType = By.xpath("//span[normalize-space()='Add Allowance type']");
	private By headingAllowanceType = By.xpath("//span[@class='ant-table-column-title']");
	private By txtboxAllowanceTypeName = By.xpath("//input[@id='allowance']");
	private By btnSaveAllowanceType = By.xpath("//span[normalize-space()='Save Allowance Type']");

	private By dataAllowanceType = By.xpath("(//td[@data-label='Allowance Type'])[1]");

	private By btnUpdateAllowanceType = By.xpath("//span[normalize-space()='Update Allowance Type']");

	// Department
	private By tabDepartmentType = By.xpath("//div[@id='rc-tabs-0-tab-4']");
	private By btnAddDepartmentType = By.xpath("//span[normalize-space()='Add Department']");
	private By txtboxDepartmentName = By.xpath("//input[@id='name']");
	private By btnSaveDepartment = By.xpath("//span[normalize-space()='Save']");

	private By dataDepartmentName = By.xpath("(//td[@data-label='Department Name'])[1]");
	private By btnUpdateDepartment = By.xpath("//span[normalize-space()='Update']");

	// WC Class Code
	private By tabWCClassCode = By.xpath("//div[@id='rc-tabs-0-tab-5']");
	private By btnAddWCClassCode = By.xpath("//span[normalize-space()='Add WC Class Code']");
	private By txtboxWCClassCode = By.xpath("//input[@id='name']");
	private By btnSaveWCClassCode = By.xpath("//span[normalize-space()='Save']");

	private By dataWCClassCode = By.xpath("(//td[@data-label='WC Class Code'])[1]");

	// Employment Type
	private By tabEmploymentType = By.xpath("//div[@id='rc-tabs-0-tab-6']");
	private By btnAddEmploymentType = By.xpath("//span[normalize-space()='Add Employment Type']");
	private By txtboxEmploymentType = By.xpath("//input[@id='name']");
	private By btnSaveEmploymentType = By.xpath("//span[normalize-space()='Save']");
	private By dataEmploymentType = By.xpath("(//td[@data-label='Employment Type'])[1]");

	// Comman Elements
	private By successMessage = By.xpath("//div[@class='Toastify__toast-body']/div/following-sibling::div");
	private By btnOkDelete = By.xpath("//button[normalize-space()='OK']");
	private By btnUpdate = By.xpath("//span[normalize-space()='Update']");

	public HRConfigurationsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isHRConfigurationsPageVisible() {
		return elementUtils.doIsDisplayed(txtHeadingHRConfigurations, Constants.DEFAULT_WAIT);
	}

	public boolean isAddNotificationTypeButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddNotificationType, Constants.DEFAULT_WAIT);
	}

	public void clickOnAddNotificationTypeButton() {
		elementUtils.waitForElementToBeClickable(btnAddNotificationType, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddNotificationTypeForm(String notificationTypeName, String employeeName, String emails) {
		elementUtils.waitForElementToBeClickable(dropdownNotificationType, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(txtboxNotificationTypeName, Constants.DEFAULT_WAIT)
				.sendKeys(notificationTypeName);
		elementUtils.waitForElementToBeClickable(dropdownEmployee, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(txtboxEmployeeName, Constants.DEFAULT_WAIT).sendKeys(employeeName);
		elementUtils.waitForElementToBeClickable(txtboxEmails, Constants.DEFAULT_WAIT).sendKeys(emails);
		elementUtils.waitForElementToBeClickable(btnSaveNotificationsType, Constants.DEFAULT_WAIT).click();
	}

	public void clickSaveNotificationTypeButton() {
		elementUtils.waitForElementToBeClickable(btnSaveNotificationsType, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessage() {
		return elementUtils.getText(successMessage, Constants.DEFAULT_WAIT);
	}

	// Allowance Type Methods
	public boolean isAllowanceTypeTabVisible() {
		return elementUtils.doIsDisplayed(tabAllowanceType, Constants.DEFAULT_WAIT);
	}

	public void clickOnAllowanceTypeTab() {
		elementUtils.waitForElementToBeClickable(tabAllowanceType, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAddAllowanceTypeButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddAllowanceType, Constants.DEFAULT_WAIT);
	}

	public void clickOnAddAllowanceTypeButton() {
		elementUtils.waitForElementToBeClickable(btnAddAllowanceType, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddAllowanceTypeForm(String allowanceTypeName) {
		elementUtils.waitForElementToBeClickable(txtboxAllowanceTypeName, Constants.DEFAULT_WAIT)
				.sendKeys(allowanceTypeName);
		elementUtils.waitForElementToBeClickable(btnSaveAllowanceType, Constants.DEFAULT_WAIT).click();
	}

	public String getAllowanceTypeData() {
		return elementUtils.getText(dataAllowanceType, Constants.DEFAULT_WAIT);
	}

	// Edit Allowance Type
	public boolean isAllowanceTypeHeadingVisible() {
		return elementUtils.doIsDisplayed(headingAllowanceType, Constants.DEFAULT_WAIT);
	}

	public void clickEditAllowanceTypeButton(String allowanceTypeName) {
		String editXpath = "//td[@data-label='Allowance Type' and normalize-space()='" + allowanceTypeName
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editXpath), Constants.DEFAULT_WAIT).click();
	}

	public boolean updateAllownaceButtonVisible() {
		return elementUtils.doIsDisplayed(btnUpdateAllowanceType, Constants.DEFAULT_WAIT);
	}

	public void updateAllowanceType(String updatedAllowanceTypeName) {
		elementUtils.clearTextBoxWithActions(txtboxAllowanceTypeName);
		elementUtils.doActionsSendKeys(txtboxAllowanceTypeName, updatedAllowanceTypeName);
		elementUtils.waitForElementToBeClickable(btnUpdateAllowanceType, Constants.DEFAULT_WAIT).click();
	}

	// Delete Allowance Type
	public void deleteAllowanceType(String allowanceTypeName) {
		String deleteXpath = "//td[@data-label='Allowance Type' and normalize-space()='" + allowanceTypeName
				+ "']/following-sibling::td//div[@class='actionicons deleteIcon']";
		elementUtils.waitForElementToBeClickable(By.xpath(deleteXpath), Constants.DEFAULT_WAIT).click();
	}

	public void clickOkDeleteButton() {
		elementUtils.waitForElementToBeClickable(btnOkDelete, Constants.DEFAULT_WAIT).click();
	}

	// Department Methods
	public boolean isDepartmentTabVisible() {
		return elementUtils.doIsDisplayed(tabDepartmentType, Constants.DEFAULT_WAIT);
	}

	public void clickOnDepartmentTab() {
		elementUtils.waitForElementToBeClickable(tabDepartmentType, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAddDepartmentButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddDepartmentType, Constants.DEFAULT_WAIT);
	}

	public void clickOnAddDepartmentButton() {
		elementUtils.waitForElementToBeClickable(btnAddDepartmentType, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddDepartmentForm(String departmentName) {
		elementUtils.waitForElementToBeClickable(txtboxDepartmentName, Constants.DEFAULT_WAIT).sendKeys(departmentName);
		elementUtils.waitForElementToBeClickable(btnSaveDepartment, Constants.DEFAULT_WAIT).click();
	}

	public String getDepartmentSuccessMessage() {
		return elementUtils.getText(successMessage, Constants.DEFAULT_WAIT);
	}

	public String getDepartmentNameData() {
		return elementUtils.getText(dataDepartmentName, Constants.DEFAULT_WAIT);

	}

	// Edit Department
	public void clickEditDepartmentButton(String departmentName) {
		String editXpath = "//td[@data-label='Department Name' and normalize-space()='" + departmentName
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editXpath), Constants.DEFAULT_WAIT).click();
	}

	public void updateDepartmentName(String updatedDepartmentName) {
		elementUtils.clearTextBoxWithActions(txtboxDepartmentName);
		elementUtils.doActionsSendKeys(txtboxDepartmentName, updatedDepartmentName);
		elementUtils.waitForElementToBeClickable(btnUpdateDepartment, Constants.DEFAULT_WAIT).click();
	}

	public String getDepartmentUpdateSuccessMessage() {
		return elementUtils.getText(successMessage, Constants.DEFAULT_WAIT);
	}

	public boolean updateDepartmentButtonVisible() {
		return elementUtils.doIsDisplayed(btnUpdateDepartment, Constants.DEFAULT_WAIT);
	}

	// Delete Department
	public void clickDeleteDepartmentButton(String departmentName) {
		String deleteXpath = "//td[@data-label='Department Name' and normalize-space()='" + departmentName
				+ "']/following-sibling::td//div[@class='actionicons deleteIcon']";
		elementUtils.waitForElementToBeClickable(By.xpath(deleteXpath), Constants.DEFAULT_WAIT).click();
	}

	public void clickOkDeleteDepartmentButton() {
		elementUtils.waitForElementToBeClickable(btnOkDelete, Constants.DEFAULT_WAIT).click();
	}

	public String getDeleteDepartmentSuccessMessage() {
		return elementUtils.getText(successMessage, Constants.DEFAULT_WAIT);
	}

	// WC Class Code Methods
	public boolean isWCClassCodeTabVisible() {
		return elementUtils.doIsDisplayed(tabWCClassCode, Constants.DEFAULT_WAIT);
	}

	public void clickOnWCClassCodeTab() {
		elementUtils.waitForElementToBeClickable(tabWCClassCode, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAddWCClassCodeButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddWCClassCode, Constants.DEFAULT_WAIT);
	}

	public void clickOnAddWCClassCodeButton() {
		elementUtils.waitForElementToBeClickable(btnAddWCClassCode, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddWCClassCodeForm(String wcClassCodeName) {
		elementUtils.waitForElementToBeClickable(txtboxWCClassCode, Constants.DEFAULT_WAIT).sendKeys(wcClassCodeName);
		elementUtils.waitForElementToBeClickable(btnSaveWCClassCode, Constants.DEFAULT_WAIT).click();
	}

	public String getWCClassCodeData() {
		elementUtils.waitForInvisibilityOfElementLocated(successMessage, Constants.DEFAULT_WAIT);
		return elementUtils.getText(dataWCClassCode, Constants.DEFAULT_WAIT);
	}

	// Update WC Class Code

	public void clickEditWCClassCodeButton(String wcClassCodeName) {
		String editXpath = "//td[@data-label='WC Class Code' and normalize-space()='" + wcClassCodeName
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editXpath), Constants.DEFAULT_WAIT).click();
	}

	public boolean isUpdateWCClassCodeButtonVisible() {
		return elementUtils.doIsDisplayed(btnUpdate, Constants.DEFAULT_WAIT);
	}

	public void updateWCClassCode(String updatedWCClassCodeName) {
		elementUtils.clearTextBoxWithActions(txtboxWCClassCode);
		elementUtils.doActionsSendKeys(txtboxWCClassCode, updatedWCClassCodeName);
		elementUtils.waitForElementToBeClickable(btnUpdate, Constants.DEFAULT_WAIT).click();
	}

	public String getUpdateWCClassCodeSuccessMessage() {
		elementUtils.waitForInvisibilityOfElementLocated(successMessage, Constants.DEFAULT_WAIT);
		return elementUtils.getText(successMessage, Constants.DEFAULT_WAIT);
	}

	// Delete WC Class Code
	public void clickDeleteWCClassCodeButton(String wcClassCodeName) {
		String deleteXpath = "//td[@data-label='WC Class Code' and normalize-space()='" + wcClassCodeName
				+ "']/following-sibling::td//div[@class='actionicons deleteIcon']";
		elementUtils.waitForElementToBeClickable(By.xpath(deleteXpath), Constants.DEFAULT_WAIT).click();
	}

	public void confirmDeleteWCClassCode() {
		elementUtils.waitForElementToBeClickable(btnOkDelete, Constants.DEFAULT_WAIT).click();
	}

	public String getDeleteWCClassCodeSuccessMessage() {
		return elementUtils.getText(successMessage, Constants.DEFAULT_WAIT);
	}
	
	// Employment Type Methods
	public boolean isEmploymentTypeTabVisible() {
		return elementUtils.doIsDisplayed(tabEmploymentType, Constants.DEFAULT_WAIT);
	}
	
	public void clickOnEmploymentTypeTab() {
		elementUtils.waitForElementToBeClickable(tabEmploymentType, Constants.DEFAULT_WAIT).click();
	}
	
	public boolean isAddEmploymentTypeButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddEmploymentType, Constants.DEFAULT_WAIT);
	}
	
	public void clickOnAddEmploymentTypeButton() {
		elementUtils.waitForElementToBeClickable(btnAddEmploymentType, Constants.DEFAULT_WAIT).click();
	}
	
	public void fillAddEmploymentTypeForm(String employmentTypeName) {
		elementUtils.waitForElementToBeClickable(txtboxEmploymentType, Constants.DEFAULT_WAIT)
				.sendKeys(employmentTypeName);
		elementUtils.waitForElementToBeClickable(btnSaveEmploymentType, Constants.DEFAULT_WAIT).click();
	}
	
	public String getEmploymentTypeData() {
		elementUtils.waitForInvisibilityOfElementLocated(successMessage, Constants.DEFAULT_WAIT);
		return elementUtils.getText(dataEmploymentType, Constants.DEFAULT_WAIT);
	}
	
	// Edit Employment Type
	public void clickEditEmploymentTypeButton(String employmentTypeName) {
		String editXpath = "//td[@data-label='Employment Type' and normalize-space()='" + employmentTypeName
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editXpath), Constants.DEFAULT_WAIT).click();
	}
	
	public boolean isUpdateEmploymentTypeButtonVisible() {
		return elementUtils.doIsDisplayed(btnUpdate, Constants.DEFAULT_WAIT);
	}
	
	public void updateEmploymentType(String updatedEmploymentTypeName) {
		elementUtils.clearTextBoxWithActions(txtboxEmploymentType);
		elementUtils.doActionsSendKeys(txtboxEmploymentType, updatedEmploymentTypeName);
		elementUtils.waitForElementToBeClickable(btnUpdate, Constants.DEFAULT_WAIT).click();
	}
	public String getUpdateEmploymentTypeSuccessMessage() {
		elementUtils.waitForInvisibilityOfElementLocated(successMessage, Constants.DEFAULT_WAIT);
		return elementUtils.getText(successMessage, Constants.DEFAULT_WAIT);
	}
	
	// Delete Employment Type
	public void clickDeleteEmploymentTypeButton(String employmentTypeName) {
		String deleteXpath = "//td[@data-label='Employment Type' and normalize-space()='" + employmentTypeName
				+ "']/following-sibling::td//div[@class='actionicons deleteIcon']";
		elementUtils.waitForElementToBeClickable(By.xpath(deleteXpath), Constants.DEFAULT_WAIT).click();
	}
	
	public void confirmDeleteEmploymentType() {
		elementUtils.waitForElementToBeClickable(btnOkDelete, Constants.DEFAULT_WAIT).click();
	}
	
	public String getDeleteEmploymentTypeSuccessMessage() {
		return elementUtils.getText(successMessage, Constants.DEFAULT_WAIT);
	}

}
