package com.dits.citywide.pages.fieldagent;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;
import com.dits.citywide.utilities.ServerTimeUtil;

public class FieldAgentReportsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnReportsTab = By.xpath("//span[normalize-space()='Reports']");
	// private By btnPreFlightReports =
	// By.xpath("(//span[contains(text(),'Pre-Flight Reports')])[2]");
	// private By btnPreFlightReports = By.xpath("//a[contains(text(),'Pre-Flight
	// Reports')]");

	private List<By> btnPreFlightReports = Arrays.asList(By.xpath("//a[contains(text(),'Pre-Flight Reports')]"),
			By.xpath("(//span[contains(text(),'Pre-Flight Reports')])[2]"),
			By.xpath("//div[contains(@class,'tab-bar-extra-content')]//span[contains(text(),'Pre-Flight Reports')]"));

	private By txtPreflightConfirmationMessage = By.cssSelector("#swal2-html-container");
	// private By btnAddNewReport = By.xpath("(//span[contains(text(),'Add New
	// Report')])[2]");
	private By btnAddNewReport = By.xpath("//a[contains(text(),'Add New Report')]");
	private By btnSubmitReports = By.xpath("//button[@type='submit']");
	private By txtNoItemsFound = By
			.xpath("//span[@class='px-2 py-8 text-base font-medium text-center text-gray-400 dark:text-white']");
	private By btnEndShift = By.xpath("//button[normalize-space()='End Shift']");
	private By endShiftConfirmationMessage = By.xpath("//div[@id='swal2-html-container']");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");

	// private By btnReOpenPatrolLog = By.xpath("//button[normalize-space()='Re-Open
	// Patrol Log']");
	private List<By> btnReOpenPatrolLog = Arrays.asList(By.xpath("//button[normalize-space()='Re-Open Patrol Log']"),
			By.xpath("//button[normalize-space()='Re-open Patrol Log']"));

	private By txtNoDataFound = By.xpath("//td[normalize-space()='No Data Found']");

	private By txtCloseOutFieldAgentLog = By.xpath("//h2[normalize-space()='Close Out Field Agent Log']");
	private By checkboxShiftIsEnd = By.cssSelector("label[for='equip_ok-3']");
	private By btnEndShiftFinal = By.xpath("(//button[text()='End Shift'])[1]");

	// My Reports
	private By txtUpdateOfficerReportEntry = By.xpath("//h1[normalize-space()='Update Officer Report Entry']");
	private By btnEditReport2 = By.xpath("(//div[@class='actionicons editPencil'])[3]");
	private By btnEditReport3 = By.xpath("(//div[@class='actionicons editPencil'])[5]");
	private By btnEditReport4 = By.xpath("(//div[@class='actionicons editPencil'])[5]");
	private By btnEditReport5 = By.xpath("(//div[@class='actionicons editPencil'])[7]");
	private By btnEditReport6 = By.xpath("(//div[@class='actionicons editPencil'])[9]");
	private By btnEditReport7 = By.xpath("(//div[@class='actionicons editPencil'])[11]");
	private By btnEditReport8 = By.xpath("(//div[@class='actionicons editPencil'])[13]");
	private By btnEditReport9 = By.xpath("(//div[@class='actionicons editPencil'])[15]");

	// private By btnNow = By.xpath("(//div[@class='ant-form-item clock-icon c-m-0
	// css-p9nxzu'])[1]");
//	private By btnNow = By.cssSelector("div[title='Arrive Now']");
	private By dropdownPatrolSite = By.xpath("(//div[@class='ant-select-selector'])[1]");
	private By patrolSite = By.cssSelector("#patrol_site_id");
	private By dropdownActivityCode = By.xpath("(//div[@class='ant-select-selector'])[2]");
	private By searchboxActivityCode = By.cssSelector("#activity_code");
	private By dropdowncallId = By.xpath("(//div[@class='ant-select-selector'])[3]");
	private By callId = By.cssSelector("#call_id");
	// private By valueActivityCode = By.xpath("//div[@class='list-none m-0
	// p-0']/div/span");
	
	
	private By clockArriveNow = By.xpath("(//span[@aria-label='clock-circle'])[1]");		
	private By txtboxStreetNumber = By.xpath("//input[@id='street_num']");
	private By txtboxStreetName = By.xpath("//input[@id='street_name']");
	private By txtboxApartmentNumber = By.xpath("//input[@id='apartment']");
	private By txtboxCity = By.xpath("//input[@id='city']");
	private By txtboxStreetSate = By.xpath("//input[@id='state']");
	private By txtboxzipcode = By.xpath("//input[@id='zipcode']");
	private By txtboxDescription = By.xpath("//textarea[@id='activity_text']");

	private By txtHeadingReportPhotoVideoUpload = By.xpath("//h4[normalize-space()='Report Photo/Video Upload']");
	private By uploadFile = By.xpath("//input[@type='file']");
	private By uploadFileMyAssignment = By.xpath("(//input[@type='file'])[2]");
	private By btnUpdateLogEntry = By.cssSelector("button[type='submit'] span");
	private By txtboxImageName = By.cssSelector("#Name0");
	private By txtboxImageDescription = By.cssSelector("#Description0");

	// Start shift data
	private By dataArriveDateTime = By
			.xpath("//p[normalize-space()='SS']/ancestor::td/preceding-sibling::td[@data-label='Arrive']/p");
	private By dataSiteName = By
			.xpath("//p[normalize-space()='SS']/ancestor::td/preceding-sibling::td[@data-label='Site']//div");
	private By dataDepartDateTime = By
			.xpath("//p[normalize-space()='SS']/ancestor::td/preceding-sibling::td[@data-label='Depart']/p");

	// All reports
	private By btnAllReports = By.cssSelector("#rc-tabs-0-tab-all-reports");
	private By txtboxSearch = By.xpath("//input[@placeholder='Search']");
	private By dropdownColumn = By.xpath("//div[@class='ant-dropdown-trigger']");
	private By selectActivityCode = By.xpath("//span[contains(text(),'Activity Code')]");

	private By getOfficerNameDataStartOfShift = By.xpath("(//td[@data-label='Officer'])[1]");
	private By getSiteDataStartOfShift = By.xpath("(//td[@data-label='Site'])[10]/a");
	private By getArriveDataStartOfShift = By.xpath("(//td[@data-label='Arrive'])[1]");
	private By getDepartDataStartOfShift = By.xpath("(//td[@data-label='Depart'])[1]");
	private By getActivityCodeDataStartOfShift = By.xpath("(//td[@data-label='Activity Code'])[1]");

	private By getOfficerNameDataEndOfShift = By.xpath("(//td[@data-label='Officer'])[1]");
	private By getSiteDataEndOfShift = By.xpath("(//td[@data-label='Site'])[1]/a");
	private By getArriveDataEndOfShift = By.xpath("(//td[@data-label='Arrive'])[1]");
	private By getDepartDataEndOfShift = By.xpath("(//td[@data-label='Depart'])[1]");
	private By getActivityCodeDataEndOfShift = By.xpath("(//td[@data-label='Activity Code'])[1]");

	// My Assignments
	// private By btnMyAssignments = By.cssSelector("#rc-tabs-0-tab-my-assignment");
	private By btnMyAssignments = By.xpath("(//div[normalize-space()='My Assignments'])[2]");

	private By search = By.cssSelector("input[placeholder='Search']");

	private By siteNameByAssignment(String assignmentName) {
		String xpath = "//td[normalize-space()='" + assignmentName + "']/following-sibling::td[1]";
		return By.xpath(xpath);
	}

	private By timeSlotByAssignment(String assignmentName) {
		String xpath = "//td[normalize-space()='" + assignmentName + "']/following-sibling::td[2]";
		return By.xpath(xpath);
	}

	private By snitchTimeByAssignment(String assignmentName) {
		String xpath = "//td[normalize-space()='" + assignmentName + "']/following-sibling::td[3]";
		return By.xpath(xpath);
	}

	private By addedByByAssignment(String assignmentName) {
		String xpath = "//td[normalize-space()='" + assignmentName + "']/following-sibling::td[4]";
		return By.xpath(xpath);
	}

	private By statusByAssignment(String assignmentName) {
		String xpath = "//td[normalize-space()='" + assignmentName + "']/following-sibling::td[5]/span/span";
		return By.xpath(xpath);
	}

	private By actionByAssignment(String assignmentName) {
		String xpath = "//td[normalize-space()='" + assignmentName
				+ "']/following-sibling::td[6]//div[@class='cursor-pointer']";
		return By.xpath(xpath);
	}

	private By tabCheckPoints = By.cssSelector("#rc-tabs-1-tab-checkpoints");

	// Checkpoint name cell
	private By checkpointByName(String checkpointName) {
		return By.xpath("//td[normalize-space()='" + checkpointName + "']");
	}

	// Site name
	private By siteNameByCheckpoint(String checkpointName) {
		return By.xpath("//td[normalize-space()='" + checkpointName + "']/following-sibling::td[1]");
	}

	// Checkpoint type
	private By checkpointTypeByName(String checkpointName) {
		return By.xpath("//td[normalize-space()='" + checkpointName + "']/following-sibling::td[2]");
	}

	// Scan time
	private By scanTimeByCheckpoint(String checkpointName) {
		return By.xpath("//td[normalize-space()='" + checkpointName + "']/following-sibling::td[3]");
	}

	// View checkpoint (action)
	private By viewCheckpointByName(String checkpointName) {
		return By.xpath("//td[normalize-space()='" + checkpointName + "']/following-sibling::td[4]");
	}

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	public FieldAgentReportsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void clickPreFlightReports() {
		for (By locator : btnPreFlightReports) {
			if (elementUtils.doIsDisplayed(locator, Constants.DEFAULT_WAIT)) {
				elementUtils.waitForElementToBeClickable(locator, Constants.DEFAULT_WAIT).click();
				break;
			}
		}
	}

	public boolean isPreFlightReportsButtonVisible() {
		for (By locator : btnPreFlightReports) {
			if (elementUtils.doIsDisplayed(locator, Constants.DEFAULT_WAIT)) {
				return true;
			}
		}
		return false;
	}

//	public boolean isPreFlightReportsButtonVisible() {
//		return elementUtils.doIsDisplayed(btnPreFlightReports, Constants.DEFAULT_WAIT);
//	}

	public boolean isStartShiftButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddNewReport, Constants.DEFAULT_WAIT);
	}

//	public void clickPreFlightReports() {
//		elementUtils.waitForElementToBeClickable(btnPreFlightReports, Constants.DEFAULT_WAIT).click();
//	}

	public String getPreflightConfirmationMessage() {
		return elementUtils.waitForElementVisible(txtPreflightConfirmationMessage, Constants.DEFAULT_WAIT).getText();
	}

	public void clickSubmitReports() {
		// elementUtils.waitForInvisibilityOfElementLocated(btnPreFlightReports,
		// Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnSubmitReports, Constants.DEFAULT_WAIT).click();
	}

	public boolean isNoItemsFoundVisible() {
		return elementUtils.doIsDisplayed(txtNoItemsFound, Constants.DEFAULT_WAIT);
	}

	public void clickEndShift() {
		isNoItemsFoundVisible();
		elementUtils.waitForElementToBeClickable(btnEndShift, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnOk, Constants.SHORT_TIME_OUT_WAIT).click();
		isCloseOutFieldAgentLogVisible();
		elementUtils.waitForElementToBeClickable(checkboxShiftIsEnd, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnEndShiftFinal, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnOk, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickOkButton() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public String getNoDataFoundText() {
		return elementUtils.waitForElementVisible(txtNoDataFound, Constants.DEFAULT_WAIT).getText();
	}

//	public boolean isReOpenPatrolLogVisible() {
//		return elementUtils.doIsDisplayed(btnReOpenPatrolLog, Constants.DEFAULT_WAIT);
//	}
	public boolean isReOpenPatrolLogVisible() {
		for (By locator : btnReOpenPatrolLog) {
			if (elementUtils.doIsDisplayed(locator, Constants.SHORT_TIME_OUT_WAIT)) {
				return true;
			}
		}
		return false;
	}

	public String getEndShiftConfirmationMessage() {
		return elementUtils.waitForElementVisible(endShiftConfirmationMessage, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isCloseOutFieldAgentLogVisible() {
		return elementUtils.doIsDisplayed(txtCloseOutFieldAgentLog, Constants.DEFAULT_WAIT);
	}

	// My Reports
	public String getArriveDateTime() {
		return elementUtils.waitForElementVisible(dataArriveDateTime, Constants.DEFAULT_WAIT).getText();
	}

	public String getSiteName() {
		return elementUtils.waitForElementVisible(dataSiteName, Constants.DEFAULT_WAIT).getText();
	}

	public String getDepartDateTime() {
		return elementUtils.waitForElementVisible(dataDepartDateTime, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isUpdateOfficerReportEntryVisible() {
		return elementUtils.doIsDisplayed(txtUpdateOfficerReportEntry, Constants.DEFAULT_WAIT);
	}

	public void clickEditReport2() {
		List<WebElement> editIcons = driver.findElements(By.xpath("//div[@class='actionicons editPencil']"));
		if (editIcons.size() < 3) {
			throw new RuntimeException("Not enough edit icons present. Expected at least 3, but found: " + editIcons.size());
		}
		elementUtils.waitForElementToBeClickable(btnEditReport2, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickEditReport3() {
		elementUtils.waitForElementToBeClickable(btnEditReport3, Constants.DEFAULT_WAIT).click();
	}

	public void clickEditReport4() {
		elementUtils.waitForElementToBeClickable(btnEditReport4, Constants.DEFAULT_WAIT).click();
	}

	public void clickEditReport5() {
		elementUtils.waitForElementToBeClickable(btnEditReport5, Constants.DEFAULT_WAIT).click();
	}

	public void clickEditReport6() {
		elementUtils.waitForElementToBeClickable(btnEditReport6, Constants.DEFAULT_WAIT).click();
	}

	public void clickEditReport7() {
		elementUtils.waitForElementToBeClickable(btnEditReport7, Constants.DEFAULT_WAIT).click();
	}

	public void clickEditReport8() {
		elementUtils.waitForElementToBeClickable(btnEditReport8, Constants.DEFAULT_WAIT).click();
	}

	public void clickEditReport9() {
		elementUtils.waitForElementToBeClickable(btnEditReport9, Constants.DEFAULT_WAIT).click();
	}

	public void addOfficerReportEntry(String url, String siteName, String activityCode, String callID,
			String streetNumber, String streetName, String apartmentNumber, String city, String state, String zipcode,
			String description, String imagePath, String fileName, String fileDescription) throws InterruptedException {

		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		// Check if the clockArriveNow element is present and visible before clicking
		if (!elementUtils.isElementVisible(clockArriveNow, Constants.SHORT_TIME_OUT_WAIT)) {
			System.out.println("clockArriveNow element not visible. Skipping addOfficerReportEntry step.");
			return;
		}
		elementUtils.waitForElementToBeClickable(clockArriveNow, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(dropdownPatrolSite, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownPatrolSite, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(patrolSite, Constants.SHORT_TIME_OUT_WAIT).sendKeys(siteName);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();

		elementUtils.waitForElementToBeClickable(dropdownActivityCode, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchboxActivityCode, Constants.SHORT_TIME_OUT_WAIT).sendKeys(activityCode);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();
//		elementUtils.waitForElementVisible(valueActivityCode, Constants.SHORT_TIME_OUT_WAIT);
//		elementUtils.selectElementThroughLocator(valueActivityCode, activityCode, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdowncallId, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(callId, Constants.SHORT_TIME_OUT_WAIT).sendKeys(callID);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();

		elementUtils.waitForElementVisible(txtboxStreetNumber, Constants.SHORT_TIME_OUT_WAIT).sendKeys(streetNumber);
		elementUtils.waitForElementVisible(txtboxStreetName, Constants.SHORT_TIME_OUT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtboxApartmentNumber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(apartmentNumber);
		elementUtils.waitForElementVisible(txtboxCity, Constants.SHORT_TIME_OUT_WAIT).sendKeys(city);
		elementUtils.waitForElementVisible(txtboxStreetSate, Constants.SHORT_TIME_OUT_WAIT).sendKeys(state);
		elementUtils.waitForElementVisible(txtboxzipcode, Constants.SHORT_TIME_OUT_WAIT).sendKeys(zipcode);
		elementUtils.waitForElementVisible(txtboxDescription, Constants.SHORT_TIME_OUT_WAIT).sendKeys(description);

//		WebElement fileInput = elementUtils.getElement(uploadFile);
//		String absolutePath = new File(imagePath).getAbsolutePath();
//		fileInput.sendKeys(absolutePath);
//		elementUtils.waitForElementVisible(uploadFile, Constants.DEFAULT_WAIT);
//		elementUtils.uploadFile(uploadFile, imagePath);

//		elementUtils.waitForElementVisible(txtboxImageName, Constants.DEFAULT_WAIT).sendKeys(fileName);
//		elementUtils.waitForElementVisible(txtboxImageDescription, Constants.DEFAULT_WAIT).sendKeys(fileDescription);

//		elementUtils.waitForElementToBeClickable(btnUpdateLogEntry, Constants.DEFAULT_WAIT).click();
	}

	public boolean isReportPhotoVideoUploadHeadingVisible() {
		return elementUtils.doIsDisplayed(txtHeadingReportPhotoVideoUpload, Constants.DEFAULT_WAIT);
	}

	public void uploadFile(String imagePath, String fileName, String fileDescription) {
		elementUtils.waitForElementVisible(uploadFile, Constants.DEFAULT_WAIT);
		elementUtils.uploadFile(uploadFile, imagePath);
		elementUtils.waitForElementVisible(txtboxImageName, Constants.DEFAULT_WAIT).sendKeys(fileName);
		elementUtils.waitForElementVisible(txtboxImageDescription, Constants.DEFAULT_WAIT).sendKeys(fileDescription);
	}

	public void uploadFileMyAssignment(String imagePath, String fileName, String fileDescription) {
		elementUtils.waitForElementVisible(uploadFileMyAssignment, Constants.DEFAULT_WAIT);
		elementUtils.uploadFile(uploadFileMyAssignment, imagePath);
		elementUtils.waitForElementVisible(txtboxImageName, Constants.DEFAULT_WAIT).sendKeys(fileName);
		elementUtils.waitForElementVisible(txtboxImageDescription, Constants.DEFAULT_WAIT).sendKeys(fileDescription);
	}

	public void clickUpdateLogEntry() {
		elementUtils.waitForElementToBeClickable(btnUpdateLogEntry, Constants.DEFAULT_WAIT).click();
	}

	// All Reports Module
	public void clickOnReportsTab() {
		elementUtils.waitForElementToBeClickable(btnReportsTab, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAllReportsButtonVisible() {
		return elementUtils.doIsDisplayed(btnAllReports, Constants.DEFAULT_WAIT);
	}

	public void clickAllReports() {
		elementUtils.waitForElementToBeClickable(btnAllReports, Constants.DEFAULT_WAIT).click();
	}

	public void enterTextInSearchBox(String searchText) {
		elementUtils.waitForElementVisible(txtboxSearch, Constants.DEFAULT_WAIT).sendKeys(searchText);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public void clickDropdownColumn() {
		elementUtils.waitForElementToBeClickable(dropdownColumn, Constants.DEFAULT_WAIT).click();
	}

	public void selectActivityCode() {
		elementUtils.waitForElementToBeClickable(selectActivityCode, Constants.DEFAULT_WAIT).click();
	}

	// Start of Shift
	public String getOfficerNameDataStartOfShift() {
		return elementUtils.waitForElementVisible(getOfficerNameDataStartOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getSiteDataStartOfShift() {
		return elementUtils.waitForElementVisible(getSiteDataStartOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getArriveDataStartOfShift() {
		return elementUtils.waitForElementVisible(getArriveDataStartOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getDepartDataStartOfShift() {
		return elementUtils.waitForElementVisible(getDepartDataStartOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getActivityCodeDataStartOfShift() {
		return elementUtils.waitForElementVisible(getActivityCodeDataStartOfShift, Constants.DEFAULT_WAIT).getText();
	}

	// End Of Shift
	public String getOfficerNameDataEndOfShift() {
		return elementUtils.waitForElementVisible(getOfficerNameDataEndOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getSiteDataEndOfShift() {
		return elementUtils.waitForElementVisible(getSiteDataEndOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getArriveDataEndOfShift() {
		return elementUtils.waitForElementVisible(getArriveDataEndOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getDepartDataEndOfShift() {
		return elementUtils.waitForElementVisible(getDepartDataEndOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getActivityCodeDataEndOfShift() {
		return elementUtils.waitForElementVisible(getActivityCodeDataEndOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// My Assignments

	public void clickMyAssignments() {
		elementUtils.waitForElementToBeClickable(btnMyAssignments, Constants.DEFAULT_WAIT).click();
	}

	public void enterTextInSearchBoxMyAssignments(String searchText) {
		elementUtils.waitForElementVisible(search, Constants.DEFAULT_WAIT).sendKeys(searchText);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getSiteNameByAssignment(String assignmentName) {
		return elementUtils.waitForElementVisible(siteNameByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getTimeSlotByAssignment(String assignmentName) {
		return elementUtils.waitForElementVisible(timeSlotByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getSnitchTimeByAssignment(String assignmentName) {
		return elementUtils.waitForElementVisible(snitchTimeByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getAddedByByAssignment(String assignmentName) {
		return elementUtils.waitForElementVisible(addedByByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getStatusByAssignment(String assignmentName) {
		return elementUtils.waitForElementVisible(statusByAssignment(assignmentName), Constants.DEFAULT_WAIT).getText();
	}

	public boolean isActionByAssignmentVisible(String assignmentName) {
		return elementUtils.doIsDisplayed(actionByAssignment(assignmentName), Constants.DEFAULT_WAIT);
	}

	public void clickActionByAssignment(String assignmentName) {
		elementUtils.waitForElementToBeClickable(actionByAssignment(assignmentName), Constants.DEFAULT_WAIT).click();
	}

	// DEBUG: Print all assignment names in the My Assignments table
	public void printAllAssignmentNames() {
		List<WebElement> assignmentCells = driver.findElements(By.xpath("//td[1]"));
		System.out.println("[DEBUG] Assignment names in My Assignments table:");
		for (WebElement cell : assignmentCells) {
			System.out.println("[ASSIGNMENT] '" + cell.getText() + "'");
		}
	}

	// Check Points Tab
	public void clickCheckPointsTab() {
		elementUtils.waitForElementToBeClickable(tabCheckPoints, Constants.DEFAULT_WAIT).click();
	}

	public String getCheckpointByName(String checkpointName) {
		return elementUtils.waitForElementVisible(checkpointByName(checkpointName), Constants.DEFAULT_WAIT).getText();
	}

	public String getSiteNameByCheckpoint(String checkpointName) {
		return elementUtils.waitForElementVisible(siteNameByCheckpoint(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCheckpointTypeByName(String checkpointName) {
		return elementUtils.waitForElementVisible(checkpointTypeByName(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getScanTimeByCheckpoint(String checkpointName) {
		return elementUtils.waitForElementVisible(scanTimeByCheckpoint(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public boolean isViewCheckpointByNameVisible(String checkpointName) {
		return elementUtils.doIsDisplayed(viewCheckpointByName(checkpointName), Constants.DEFAULT_WAIT);
	}

}