package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class ERMRemarksHistoryPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtHeadingRemarksHistory = By.xpath("//h1[normalize-space()='Remarks History']");
	private By searchBox = By.cssSelector("input[placeholder='Search']");
	private By btnViewRemakes = By.xpath("//div[@class='actionicons viewIcon']");
	private By btnAssignCourse = By.xpath("(//div[@class='actionicons editPencil'])[1]");
	private By btnAddRemarks = By.xpath("(//div[@class='actionicons editPencil'])[2]");

	// Data
	private By dataBranchName = By.xpath("//td[@data-label='Branch Name']");
	private By dataEmployeeName = By.xpath("//td[@data-label='Employee']");
	private By dataRemarks = By.xpath("//td[@data-label='Remarks']");
	private By dataPositiveRemarks = By.xpath("//td[@data-label='Positives']");
	private By dataNegativeRemarks = By.xpath("//td[@data-label='Negatives']");
	private By dataComplaints = By.xpath("//td[@data-label='Complaints']");
	private By dataLastUpdate = By.xpath("//td[@data-label='Last Updated']");

	// View Remarks
	private By btnAddRemarksOnViewPage = By.xpath("//span[normalize-space()='Add Remarks']");
	private By btnEditRemark = By.xpath("//span[normalize-space()='Edit Remark']");
	private By txtheadingEditRemarks = By.xpath("//span[@class='baseTitle']");
	private By btnAssignNewCourse = By.xpath("//span[normalize-space()='Assign New Course']");
	private By btnSubmitRemark = By.xpath("//button[@type='submit']");

	private By btnAssignNewCourseOnViewPage = By.xpath("//span[normalize-space()='Assign New Course']");

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

	// Add Remarks
	private By dropdownRemarkType = By.xpath("(//span[@class='ant-select-selection-wrap'])[2]");

	private By getRemarkTypeLocator(String remarkType) {
		return By.xpath("//div[@class='ant-select-item-option-content' and text()='" + remarkType + "']");
	}

	private By dropdownRemarkTypeValues = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");

	private By dropdownRemarkCategory = By.xpath("(//span[@class='ant-select-selection-wrap'])[3]");
	private By searchRemarkCategory = By.cssSelector("#counsel_type");
	private By incidentDate = By.cssSelector("#incident_date");
	private By dropdownSelectSite = By.xpath("(//span[@class='ant-select-selection-wrap'])[4]");
	private By searchSite = By.cssSelector("#remark_site");
	private By dropdownReason = By.xpath("(//span[@class='ant-select-selection-wrap'])[5]");
	private By searchReason = By.cssSelector("#reason");
	private By txtboxRemarks = By.cssSelector("#comment");
	private By btnSubmit = By.cssSelector("button[type='submit']");

	// Assign course
	private By txtHeadingCourse = By.cssSelector(".baseTitle");
	private By searchCourse = By.cssSelector("input[placeholder='Search']");
	private By serachCourseResult = By.xpath("(//input[@name='Search'])[2]");
	private By btnAssignCourses = By.xpath("(//div[contains(@class,'actionicons editPencil')])[1]");
	private By btnAssignCourses2 = By.xpath("(//div[contains(@class,'actionicons editPencil')])[3]");
	private By btnAssign = By.xpath("//span[normalize-space()='Assign']");
	private By txtConfirmationMessage = By.cssSelector(".modal-text");

	private By btnClose = By.cssSelector("button[aria-label='Close']");

	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");
	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	public ERMRemarksHistoryPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public String getHeadingRemarksHistory() {
		return elementUtils.waitForElementVisible(txtHeadingRemarksHistory, Constants.DEFAULT_WAIT).getText();
	}

	public void searchRemarks(String searchText) {
		elementUtils.waitForElementVisible(searchBox, Constants.DEFAULT_WAIT).sendKeys(searchText);
	}

	public void clickViewRemarks() {
		elementUtils.waitForElementToBeClickable(btnViewRemakes, Constants.DEFAULT_WAIT).click();
	}

	public void clickAssignCourse() {
		elementUtils.waitForElementToBeClickable(btnAssignCourse, Constants.DEFAULT_WAIT).click();
	}

	public void clickAddRemarks() {
		elementUtils.waitForElementToBeClickable(btnAddRemarks, Constants.DEFAULT_WAIT).click();
	}

	public String getBranchName() {
		return elementUtils.waitForElementVisible(dataBranchName, Constants.DEFAULT_WAIT).getText();
	}

	public String getEmployeeName() {
		return elementUtils.waitForElementVisible(dataEmployeeName, Constants.DEFAULT_WAIT).getText();
	}

	public String getRemarks() {
		return elementUtils.waitForElementVisible(dataRemarks, Constants.DEFAULT_WAIT).getText();
	}

	public String getPositiveRemarks() {
		return elementUtils.waitForElementVisible(dataPositiveRemarks, Constants.DEFAULT_WAIT).getText();
	}

	public String getNegativeRemarks() {
		return elementUtils.waitForElementVisible(dataNegativeRemarks, Constants.DEFAULT_WAIT).getText();
	}

	public String getComplaints() {
		return elementUtils.waitForElementVisible(dataComplaints, Constants.DEFAULT_WAIT).getText();
	}

	public String getLastUpdate() {
		return elementUtils.waitForElementVisible(dataLastUpdate, Constants.DEFAULT_WAIT).getText();
	}

	public void clickAddRemarksOnViewPage() {
		elementUtils.waitForElementToBeClickable(btnAddRemarksOnViewPage, Constants.DEFAULT_WAIT).click();
	}

	public void clickAssignNewCourse(String remarkType) {
		elementUtils.waitForElementToBeClickable(btnAssignNewCourse, Constants.DEFAULT_WAIT).click();
	}

	public void clickAssignNewCourseOnViewPage() {
		elementUtils.waitForElementToBeClickable(btnAssignNewCourseOnViewPage, Constants.DEFAULT_WAIT).click();
	}

	// Add Remarks Methods

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
	}

	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// Assign Course
	public String getHeadingCourse() {
		return elementUtils.waitForElementVisible(txtHeadingCourse, Constants.DEFAULT_WAIT).getText();
	}

	public void searchCourse(String courseName) {
		elementUtils.waitForElementVisible(searchCourse, Constants.DEFAULT_WAIT).sendKeys(courseName);
	}

	public void searchCourseResult(String courseName) {
		elementUtils.waitForElementToBeClickable(serachCourseResult, Constants.DEFAULT_WAIT).sendKeys(courseName);
	}

	public void clickAssignCourses() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAssignCourses, Constants.DEFAULT_WAIT).click();
	}
	
	public void clickAssignCourses2() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAssignCourses2, Constants.DEFAULT_WAIT).click();
	}

	public String getConfirmationMessage() {
		return elementUtils.waitForElementVisible(txtConfirmationMessage, Constants.DEFAULT_WAIT).getText();
	}

	public void clickAssign() {
		elementUtils.waitForElementToBeClickable(btnAssign, Constants.DEFAULT_WAIT).click();
	}

	public void closePopup() {
		elementUtils.waitForInvisibilityOfElementLocated(sucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnClose, Constants.DEFAULT_WAIT).click();
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

	// Edit Remark Methods

	public void clickEditRemark() {
		elementUtils.waitForElementToBeClickable(btnEditRemark, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingEditRemarks() {
		return elementUtils.waitForElementVisible(txtheadingEditRemarks, Constants.DEFAULT_WAIT).getText();
	}

	public void fillUpdateRemark(String remarkType, String remarkCategory, String incidentDate, String site,
			String reason, String remarkTypeValue) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownRemarkType, Constants.DEFAULT_WAIT).click();
		WebElement value = elementUtils.waitForElementToBeClickable(getRemarkTypeLocator(remarkType),
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWeBElement(value);
//		elementUtils.selectElementThroughLocator(dropdownRemarkTypeValues, remarkType, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		elementUtils.waitForElementToBeClickable(dropdownRemarkCategory, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(searchRemarkCategory, Constants.DEFAULT_WAIT).sendKeys(remarkCategory);
		Thread.sleep(3000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(this.incidentDate, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(this.incidentDate);
		elementUtils.waitForElementToBeClickable(this.incidentDate, Constants.DEFAULT_WAIT).sendKeys(incidentDate);
		elementUtils.waitForElementToBeClickable(dropdownSelectSite, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(searchSite, Constants.DEFAULT_WAIT).sendKeys(site);
		Thread.sleep(4000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(dropdownReason, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(searchReason, Constants.DEFAULT_WAIT).sendKeys(reason);
		Thread.sleep(3000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(txtboxRemarks, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxRemarks);
		elementUtils.waitForElementToBeClickable(txtboxRemarks, Constants.DEFAULT_WAIT).sendKeys(remarkTypeValue);
	}

	public void submitUpdateRemark() {
		elementUtils.waitForElementToBeClickable(btnSubmitRemark, Constants.DEFAULT_WAIT).click();
	}

}
