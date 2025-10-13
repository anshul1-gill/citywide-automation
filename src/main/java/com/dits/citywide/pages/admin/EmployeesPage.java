package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class EmployeesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAddNewEmployee = By.xpath("//span[text()='Add New Employee']");
	private By txtNoDataFound = By.xpath("//div[contains(text(),'No Data Found')]");

	private By dropdownStatus = By.xpath("(//span[@class='ant-select-selection-wrap'])[3]");
	private By txtboxSearch = By.cssSelector("input[placeholder='Search']");
	private By searchDropdownValues = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
//	private By employeeID = By.xpath("//td[text()='808']");

	private By dataEmployeeID = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Employee ID']");
	private By dataFirstName = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='First Name']");
	private By dataLastName = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Last Name']");
	private By dataBranchName = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Branch Name']");
	private By dataPhoneNumberPrimary = By
			.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Phone Number (Primary)']");
	private By dataRoles = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Role(s)']");

	private By btnViewEmployee = By.cssSelector(".actionicons.viewIcon");
	private By btnEditEmployee = By.xpath("//a[@class='cursor-pointer']/div[@class='actionicons editPencil']");

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	private By permissionError = By
			.xpath("//h3[contains(text(),'You may not have the correct permissions to view the page.')]");

	// Comment
	private By btnAddRemarks = By.cssSelector("span[aria-label='plus']");
	private By txtHeadingAddRemarks = By.cssSelector(".baseTitle");
	// Add Remarks
	private By dropdownRemarkType = By.xpath("(//span[@class='ant-select-selection-wrap'])[4]");

	private By getRemarkTypeLocator(String remarkType) {
		return By.xpath("//div[@class='ant-select-item-option-content' and text()='" + remarkType + "']");
	}

	private By dropdownRemarkTypeValues = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");

	private By dropdownRemarkCategory = By.xpath("(//span[@class='ant-select-selection-wrap'])[5]");
	private By searchRemarkCategory = By.cssSelector("#counsel_type");
	private By incidentDate = By.cssSelector("#incident_date");
	private By dropdownSelectSite = By.xpath("(//span[@class='ant-select-selection-wrap'])[6]");
	private By searchSite = By.cssSelector("#remark_site");
	private By dropdownReason = By.xpath("(//span[@class='ant-select-selection-wrap'])[7]");
	private By searchReason = By.cssSelector("#reason");
	private By txtboxRemarks = By.cssSelector("#comment");
	private By btnSubmit = By.cssSelector("button[type='submit']");

	// View Remarks
	private By viewRemarksButton = By.cssSelector(".actionicons.eyeIcon");
	private By dropdownRemarkTypeOnViewPage = By.xpath("//span[@class='ant-select-selection-item']");

	public By getRemarkTypeDropdownOption(String remarkType) {
		String xpath = String.format("//div[@class='ant-select-item-option-content'][normalize-space()='%s']",
				remarkType);
		return By.xpath(xpath);
	}

	private By btnExport = By.xpath("//span[normalize-space()='Export']");
	private By btnPrint = By.xpath("//span[normalize-space()='Print']");

	private By dataReason = By.xpath("//div[@class='reason']");
	private By dataRemarkName = By.xpath("//div[normalize-space()='Remark Name:']/following-sibling::div");
	private By dataPostedBy = By.xpath("//div[normalize-space()='Posted By:']/following-sibling::div");
	private By dataIncidentDate = By.xpath("//div[normalize-space()='Incident Date:']/following-sibling::div");
	private By dataSiteName = By.xpath("//div[normalize-space()='Site Name:']/following-sibling::div");
	private By dataDescription = By.xpath("//div[normalize-space()='Description:']/following-sibling::div");
	private By btnActionTaken = By.xpath("//div[normalize-space()='Action Taken:']/following-sibling::div");

	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	public EmployeesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isAddNewEmployeeButtonDisplayed() {
		return elementUtils.doIsDisplayed(btnAddNewEmployee, Constants.DEFAULT_WAIT);
	}

	public boolean isAddNewEmployeeButtonClickable() {
		return elementUtils.doIsClickable(btnAddNewEmployee, Constants.SHORT_TIME_OUT_WAIT);
	}

	public AddEmployeePage doClickAddNewEmployee() {
		elementUtils.waitForInvisibilityOfElementLocated(txtNoDataFound, Constants.MEDIUM_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAddNewEmployee, Constants.DEFAULT_WAIT).click();
		return new AddEmployeePage(driver);
	}

	public void selectStatus() {
		elementUtils.waitForInvisibilityOfElementLocated(txtNoDataFound, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownStatus, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(searchDropdownValues, "All", Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public void searchInTextbox(String searchText) throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);

//		String xpath = "//td[text()='" + searchText + "']";
//		elementUtils.waitForElementVisible(By.xpath(xpath), Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxSearch, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(txtboxSearch, Constants.SHORT_TIME_OUT_WAIT).sendKeys(searchText);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getEmployeeIdData() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataEmployeeID, Constants.DEFAULT_WAIT).getText();
	}

	public String getFirstNameData() {
		return elementUtils.waitForElementVisible(dataFirstName, Constants.DEFAULT_WAIT).getText();
	}

	public String getLastNameData() {
		return elementUtils.waitForElementVisible(dataLastName, Constants.DEFAULT_WAIT).getText();
	}

	public String getBranchNameData() {
		return elementUtils.waitForElementVisible(dataBranchName, Constants.DEFAULT_WAIT).getText();
	}

	public String getPrimaryPhoneNumberData() {
		return elementUtils.waitForElementVisible(dataPhoneNumberPrimary, Constants.DEFAULT_WAIT).getText();
	}

	public String getRolesData() {
		return elementUtils.waitForElementVisible(dataRoles, Constants.DEFAULT_WAIT).getText();
	}

	public ViewEmployeePage doClickViewEmployee() {
		elementUtils.waitForElementVisible(btnViewEmployee, Constants.DEFAULT_WAIT);
		elementUtils.clickElementWithScroll(btnViewEmployee, Constants.SHORT_TIME_OUT_WAIT);
		return new ViewEmployeePage(driver);
	}

	public UpdateEmployeePage doClickEditEmployee() {
		elementUtils.waitForElementVisible(btnEditEmployee, Constants.DEFAULT_WAIT);
		elementUtils.clickElementWithScroll(btnEditEmployee, Constants.SHORT_TIME_OUT_WAIT);
		return new UpdateEmployeePage(driver);
	}

	// Comments
	public boolean isAddRemarksButtonDisplayed() {
		return elementUtils.doIsDisplayed(btnAddRemarks, Constants.DEFAULT_WAIT);
	}

	public boolean isAddRemarksButtonClickable() {
		return elementUtils.doIsClickable(btnAddRemarks, Constants.SHORT_TIME_OUT_WAIT);
	}

	public void clickAddRemarks() {
		elementUtils.waitForElementToBeClickable(btnAddRemarks, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingAddRemarks() {
		return elementUtils.waitForElementVisible(txtHeadingAddRemarks, Constants.DEFAULT_WAIT).getText();
	}

	public void fillAddNewRemark(String remarkType, String remarkCategory, String incidentDate, String site,
			String reason, String remarkTypeValue) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownRemarkType, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getRemarkTypeLocator(remarkType), Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(dropdownRemarkCategory, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(searchRemarkCategory, Constants.DEFAULT_WAIT).sendKeys(remarkCategory);
		Thread.sleep(4000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(this.incidentDate, Constants.DEFAULT_WAIT).sendKeys(incidentDate);
		elementUtils.waitForElementToBeClickable(dropdownSelectSite, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(searchSite, Constants.DEFAULT_WAIT).sendKeys(site);
		Thread.sleep(4000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(dropdownReason, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(searchReason, Constants.DEFAULT_WAIT).sendKeys(reason);
		Thread.sleep(4000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(txtboxRemarks, Constants.DEFAULT_WAIT).sendKeys(remarkTypeValue);
	}

	public void submitAddNewRemark() {
		elementUtils.waitForElementToBeClickable(btnSubmit, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForInvisibilityOfElementLocated(btnSubmit, Constants.DEFAULT_WAIT);
	}

	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// Comments View
	
	public boolean isViewRemarksButtonDisplayed() {
		return elementUtils.doIsDisplayed(viewRemarksButton, Constants.DEFAULT_WAIT);
	}
	
	public boolean isViewRemarksButtonClickable() {
		return elementUtils.doIsClickable(viewRemarksButton, Constants.SHORT_TIME_OUT_WAIT);
	}
	
	public void clickViewRemarks() {
		elementUtils.waitForElementToBeClickable(viewRemarksButton, Constants.DEFAULT_WAIT).click();
	}

	public void selectRemarkTypeOnViewPage(String remarkType) {
		elementUtils.waitForElementToBeClickable(dropdownRemarkTypeOnViewPage, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getRemarkTypeDropdownOption(remarkType), Constants.DEFAULT_WAIT)
				.click();
	}

	public boolean isExportButtonDisplayed() {
		return elementUtils.isElementVisible(btnExport, Constants.DEFAULT_WAIT);
	}

	public boolean isExportButtonClickable() {
		return elementUtils.doIsClickable(btnExport, Constants.DEFAULT_WAIT);
	}

	public boolean isPrintButtonDisplayed() {
		return elementUtils.isElementVisible(btnPrint, Constants.DEFAULT_WAIT);
	}

	public boolean isPrintButtonClickable() {
		return elementUtils.doIsClickable(btnPrint, Constants.DEFAULT_WAIT);
	}

	public String getReason() {
		return elementUtils.waitForElementVisible(dataReason, Constants.DEFAULT_WAIT).getText();
	}

	public String getRemarkName() {
		return elementUtils.waitForElementVisible(dataRemarkName, Constants.DEFAULT_WAIT).getText();
	}

	public String getPostedBy() {
		return elementUtils.waitForElementVisible(dataPostedBy, Constants.DEFAULT_WAIT).getText();
	}

	public String getIncidentDate() {
		return elementUtils.waitForElementVisible(dataIncidentDate, Constants.DEFAULT_WAIT).getText();
	}

	public String getSiteName() {
		return elementUtils.waitForElementVisible(dataSiteName, Constants.DEFAULT_WAIT).getText();
	}

	public String getDescription() {
		return elementUtils.waitForElementVisible(dataDescription, Constants.DEFAULT_WAIT).getText();
	}

	public String getActionTaken() {
		return elementUtils.waitForElementVisible(btnActionTaken, Constants.DEFAULT_WAIT).getText();
	}

}
