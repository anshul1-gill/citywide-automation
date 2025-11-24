package com.dits.citywide.pages.patrol;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.pages.fieldagent.FieldAgentCallsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentFieldInterviewPage;
import com.dits.citywide.pages.fieldagent.FieldAgentIncidentReportsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentLeaveRequestsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentMyAttendancePage;
import com.dits.citywide.pages.fieldagent.FieldAgentMyCoursesPage;
import com.dits.citywide.pages.fieldagent.FieldAgentReportsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentParkingCitationPage;
import com.dits.citywide.pages.patrol.PatrolAgentPassdownLogsPage;
import com.dits.citywide.utilities.ElementUtils;
import com.dits.citywide.pages.fieldagent.FieldAgentTrespassNoticesPage; // added import
import com.dits.citywide.pages.fieldagent.FieldAgentTeamSupportPage; // added import
import com.dits.citywide.pages.patrol.PatrolAgentReportsPage;

public class PatrolStartShiftPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	// private By txtMessageOfTheWeek = By.xpath("//div[@class='flex items-center justify-between px-3 py-2 text-white rounded-t-lg bg-blue2 dark:bg-blue2']/h2");
	private By btnMarkAsRead = By.xpath("//div[@class='flex items-center gap-3']/button");
	private By tabStartShift = By.xpath("(//span[contains(text(),'Start Shift')])[1]");
	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
	private By btnBeatSite = By.xpath("//span[normalize-space()='View Beat']");
	private By btnStartShift = By.xpath("(//span[contains(text(),'Start Shift')])[2]");
	private By btnConfirmShift = By.xpath("//span[normalize-space()='Confirm/Reject multiple shifts']");
	private By selectCheckbox = By.xpath(" //tr[.//td[contains(@data-label,'Shift') and .//span[normalize-space()='Pending']]] //label[contains(@class,'ant-checkbox-wrapper')]");
	private By btnRejectShift = By.xpath("//span[normalize-space()='Reject']");
	private By txtboxRejectReason = By.xpath("//textarea[@id='reason']");
	private By btnSaveRejectReason = By.xpath("//button[@type='submit']");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");
	private By btnCancel = By.xpath("//button[normalize-space()='Cancel']");
	
	private By btnReportsubmit = By.xpath("//span[normalize-space()='Submit Reports']");

// Data displayed on Start Shift page popup
	private By dataSite = By.xpath("//label[contains(text(),'Site')]/following-sibling::p");
	private By dataSchedule = By.xpath("//label[contains(text(),'Schedule')]/following-sibling::p");
	private By dataServiceType = By.xpath("//label[contains(text(),'Service Type')]/following-sibling::p");
	private By dataAddress = By.xpath("//label[contains(text(),'Address')]/following-sibling::p");
	private By dataNotes = By.xpath("//label[contains(text(),'Notes')]/following-sibling::p");

	private By btnEndShift = By.xpath("//span[contains(text(),'End Shift')]");

// Start Shift Page
	private By nameFieldAgentWithWelcome = By.xpath("//h3[contains(@class,'text-primary')]");
	private By txtWelcomeDescription = By
			.xpath("//p[contains(@class, 'font-normal') and contains(@class, 'text-bas')]");
	private By btnStartShiftBegin = By.xpath("//button[contains(text(),'Start Shift')]");
	private By tabCalls = By.xpath("//span[contains(text(),'Calls')]");
	private By btnReportsTab = By.xpath("//span[normalize-space()='Reports']");
	private By menuHRManagement = By.xpath("//p[@title='HR Management']");
	private By tabLeaverequests = By.xpath("//span[normalize-space()='Leave Requests']");
	private By tabMyCourses = By.xpath("//span[normalize-space()='My Courses']");
	private By tabMyAttendance = By.xpath("//span[normalize-space()='My Attendance']");

// Confirm Reject Multiple Shifts
	private By btnConfirmRejectMultipleShifts = By.xpath("//span[normalize-space()='Confirm/Reject multiple shifts']");
	private By txtHeadingMyShifts = By.xpath("//span[@class='baseTitle']");
	private By checkboxSelectAllShifts = By.xpath("//input[@aria-label='Select all']");
	private By btnConfirm = By.xpath("//span[normalize-space()='Confirm']");
	private By btnReject = By.xpath("//span[normalize-space()='Reject']");
	private By txtboxRejectReasonMultipleShifts = By.cssSelector("#reason");
	private By btnSaveRejectReasonMultipleShifts = By.xpath("//span[normalize-space()='Save']");

// Previous Shift Logout
	private By txtHeadingPreviousShiftLogout = By.xpath("//h2[normalize-space()='Log out of previous shift']");
	private By txtboxReasonPreviousShiftLogout = By.xpath("//textarea[@id='activity_text']");
	private By btnVerifyMileagePreviousShiftLogout = By.xpath("//input[@id='verify_miles']");
	private By btnSubmitPreviousShiftLogout = By.xpath("//button[@id='submitButton']");
	private By txtSucessMessagePreviousShiftLogout = By.xpath("//h2[@id='swal2-title']/span");
	
	private By btnStartBreak = By.xpath("//button[normalize-space()='Start Break']");
	private By SelectBreak = By.xpath("//a[normalize-space()='Lunch Break']");
	private By StartedSuccessmessage = By.xpath("//div[contains(text(),'Break Started')]");
	private By EndBreakbutton = By.xpath("//span[@id='countup-timer']");
	private By EndSuccessmessage = By.xpath("//div[contains(text(),'Break Ended')]");

// Passdown of a day
	private By txtPassdownOfADay = By.xpath("//h2[normalize-space()='Passdown of the day']");
	private By btnCountViewPassdown = By.xpath("//td[@data-label='Action']/button");

	public By getCreateReportButtonByIndex(int pasdownbuttonCount) {
		String xpath = "(//button[normalize-space()='Create Report'])[" + pasdownbuttonCount + "]";
		return By.xpath(xpath);
	}

	private By tabPassdownLogs = By.xpath("//span[normalize-space()='Passdown Logs']");

	// Petrol Beats
	private By tabPatrolBeats = By.xpath("//span[normalize-space()='Patrol Beats']");

	private By tabVehicleInspection = By.xpath("//span[normalize-space()='Vehicle Inspection']");
	private By tabTeamSupport = By.xpath("//span[normalize-space()='Team Support']"); // added locator

// Common
	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	// Form locators added for Field Interview access
	private By formsclick = By.xpath("//p[@title='Forms']");
	private By fieldInterviewFormLink = By.xpath("//span[normalize-space()='Field Interview']");
	// Add Incident Report form locator
	private By incidentReportFormLink = By.xpath("//span[normalize-space()='Incident Report']");
	private By parkingCitationFormLink = By.xpath("//span[normalize-space()='Parking Citation']");
	private By skipSearchliunk = By.xpath("//a[@id='new_citation']");	
	private By trespassNoticesFormLink = By.xpath("//span[normalize-space()='Trespass Notice']"); // added locator

	// Profile navigation (mirroring FieldAgentStartShiftPage)
    private By tabProfileMenu = By.xpath("//button[@class='flex items-center gap-2 text-sm']");
    private By btnProfile = By.xpath("//a[normalize-space()='Profile']");

	public PatrolStartShiftPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void handleMessageOfTheWeek() {
		try {
			elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.SHORT_TIME_OUT_WAIT);

			// Check if element is present and visible
			if (elementUtils.isElementVisible(btnMarkAsRead, Constants.SHORT_TIME_OUT_WAIT)) {
				elementUtils.waitForElementVisible(btnMarkAsRead, Constants.SHORT_TIME_OUT_WAIT).click();
				System.out.println("Clicked on 'Mark As Read' button.");
			} else {
				System.out.println("'Mark As Read' button not present or not visible. Skipping click.");
			}
		} catch (Exception e) {
			System.out.println("Exception while handling 'Mark As Read': " + e.getMessage());
		}
	}
	
	public void doClickConfirmShift() {
		elementUtils.waitForElementToBeClickable(btnConfirmShift, Constants.DEFAULT_WAIT).click();
	}

	public boolean isConfirmShiftButtonVisible() {
		return elementUtils.doIsDisplayed(btnConfirmShift, Constants.DEFAULT_WAIT);
	}
	
	public void doSelectCheckbox() throws InterruptedException {
		Thread.sleep(500);
		elementUtils.waitForElementToBeClickable(selectCheckbox, Constants.DEFAULT_WAIT).click();
	}
	public void doClickConfirmShiftbutton() {
		elementUtils.waitForElementToBeClickable(btnConfirm, Constants.DEFAULT_WAIT).click();
	}

	public void doClickTabStartShift() {
		elementUtils.waitForElementToBeClickable(tabStartShift, Constants.DEFAULT_WAIT).click();
	}

	public void viewShiftDetails(String day) throws InterruptedException {

		if (day.length() == 1) {
			day = "0" + day;
		}
		String dayxpath = "//td[contains(@class, 'ant-picker-cell-in-view')]//div[@class='ant-picker-calendar-date-value' and normalize-space(text())='"
				+ day + "']/following-sibling::div";
		elementUtils.waitForElementVisible(By.xpath(dayxpath), Constants.DEFAULT_WAIT);
		elementUtils.doActionsClick(By.xpath(dayxpath));

	}

	public String getSite() {
		return elementUtils.waitForElementVisible(dataSite, Constants.DEFAULT_WAIT).getText();
	}

	public boolean getSchedule() {
		return elementUtils.doIsDisplayed(dataSchedule, Constants.DEFAULT_WAIT);
	}

	public boolean getServiceType() {
		return elementUtils.doIsDisplayed(dataServiceType, Constants.DEFAULT_WAIT);
	}

	public boolean getAddress() {
		return elementUtils.doIsDisplayed(dataAddress, Constants.DEFAULT_WAIT);
	}

	public String getNotes() {
		return elementUtils.waitForElementVisible(dataNotes, Constants.DEFAULT_WAIT).getText();
	}

	public void doClickViewSite() {
		elementUtils.waitForElementToBeClickable(btnBeatSite, Constants.DEFAULT_WAIT).click();
	}

	public boolean isClickableViewSite() {
		return elementUtils.doIsDisplayed(btnBeatSite, Constants.DEFAULT_WAIT);
	}

	// Start Shift
	public void doClickStartShift() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessagePreviousShiftLogout, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnStartShift, Constants.DEFAULT_WAIT).click();
	}

	public boolean isStartShiftButtonVisible() {
		return elementUtils.doIsDisplayed(btnStartShift, Constants.DEFAULT_WAIT);
	}



	public void doClickRejectShift() {
		elementUtils.waitForElementToBeClickable(btnRejectShift, Constants.DEFAULT_WAIT).click();
	}

	public boolean isRejectShiftButtonVisible() {
		return elementUtils.doIsDisplayed(btnRejectShift, Constants.DEFAULT_WAIT);
	}

	public void enterRejectReason(String reason) {
		elementUtils.waitForElementVisible(txtboxRejectReason, Constants.DEFAULT_WAIT).sendKeys(reason);
	}

	public void doClickSaveRejectReason() {
		elementUtils.waitForElementToBeClickable(btnSaveRejectReason, Constants.DEFAULT_WAIT).click();
	}

	public void doClickOkButton() {
		try {
			elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
		} catch (org.openqa.selenium.TimeoutException e) {
			// Log page source and take screenshot for debugging
			System.out.println("[ERROR] OK button not found or not clickable. Logging page source and taking screenshot.");
			try {
				String pageSource = driver.getPageSource();
				System.out.println("[PAGE SOURCE]\n" + pageSource);
				// Take screenshot (if driver supports it)
				if (driver instanceof org.openqa.selenium.TakesScreenshot) {
					java.io.File srcFile = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
					java.nio.file.Files.copy(srcFile.toPath(), java.nio.file.Paths.get("screenshot_doClickOkButton_failure.png"), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
					System.out.println("[SCREENSHOT] Saved to screenshot_doClickOkButton_failure.png");
				}
			} catch (Exception ex) {
				System.out.println("[ERROR] Failed to log page source or take screenshot: " + ex.getMessage());
			}
			throw e;
		}
	}

	public void doClickCancelButton() {
		elementUtils.waitForElementToBeClickable(btnCancel, Constants.DEFAULT_WAIT).click();
	}

	// End Shift
	public boolean isEndShiftButtonVisible() {
		return elementUtils.doIsDisplayed(btnEndShift, Constants.DEFAULT_WAIT);
	}

	public FieldAgentReportsPage doClickEndShift() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(btnEndShift, Constants.DEFAULT_WAIT).click();
	    Thread.sleep(2000);
		elementUtils.waitForElementToBeClickable(btnReportsubmit, Constants.DEFAULT_WAIT).click();
		return new FieldAgentReportsPage(driver);
	}

	// Start Shift Page
	public String getFieldAgentNameWithWelcome() {
		return elementUtils.waitForElementVisible(nameFieldAgentWithWelcome, Constants.DEFAULT_WAIT).getText();
	}

	public String getWelcomeDescriptionText() {
		return elementUtils.waitForElementVisible(txtWelcomeDescription, Constants.DEFAULT_WAIT).getText();
	}

	public FieldAgentReportsPage doClickStartShiftBegin() {
		elementUtils.waitForInvisibilityOfElementLocated(txtHeadingPreviousShiftLogout, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnStartShiftBegin, Constants.DEFAULT_WAIT).click();
		return new FieldAgentReportsPage(driver);
	}

	public FieldAgentCallsPage doClickCallsTab() {
		elementUtils.waitForElementToBeClickable(tabCalls, Constants.DEFAULT_WAIT).click();
		return new FieldAgentCallsPage(driver);
	}

	public PatrolAgentReportsPage clickOnReportsTab() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(btnReportsTab, Constants.DEFAULT_WAIT).click();
		return new PatrolAgentReportsPage(driver);
		
	}

	// HR Management
	public void clickOnHRManagementMenu() {
		elementUtils.waitForElementToBeClickable(menuHRManagement, Constants.DEFAULT_WAIT).click();
	}

	public PatrolLeaveRequestsPage clickOnLeaveRequestsTab() {
		elementUtils.waitForElementToBeClickable(tabLeaverequests, Constants.DEFAULT_WAIT).click();
		return new PatrolLeaveRequestsPage(driver);
	}

	public FieldAgentMyCoursesPage clickOnMyCoursesTab() {
		elementUtils.waitForElementToBeClickable(tabMyCourses, Constants.DEFAULT_WAIT).click();
		return new FieldAgentMyCoursesPage(driver);
	}

	public FieldAgentMyAttendancePage clickOnMyAttendanceTab() {
		elementUtils.waitForElementToBeClickable(tabMyAttendance, Constants.DEFAULT_WAIT).click();
		return new FieldAgentMyAttendancePage(driver);
	}

	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// Confirm Reject Multiple Shifts
	public void doClickConfirmRejectMultipleShifts() {
		elementUtils.waitForElementToBeClickable(btnConfirmRejectMultipleShifts, Constants.DEFAULT_WAIT).click();
	}

	public boolean isHeadingMyShiftsVisible() {
		return elementUtils.doIsDisplayed(txtHeadingMyShifts, Constants.DEFAULT_WAIT);
	}

	public void doClickSelectAllShifts() {
		elementUtils.waitForElementToBeClickable(checkboxSelectAllShifts, Constants.DEFAULT_WAIT).click();
	}

	public void doClickConfirm() {
		elementUtils.waitForElementToBeClickable(btnConfirm, Constants.DEFAULT_WAIT).click();
	}

	public void doClickReject() {
		elementUtils.waitForElementToBeClickable(btnReject, Constants.DEFAULT_WAIT).click();
	}
	
	// Start Break
	public boolean isStartBreakButtonVisible() {
		return elementUtils.doIsDisplayed(btnStartBreak, Constants.DEFAULT_WAIT);
	}
	
	public void doClickStartBreak() {
		elementUtils.waitForElementToBeClickable(btnStartBreak, Constants.DEFAULT_WAIT).click();
	}
	
	public void doSelectBreak() {
		elementUtils.waitForElementToBeClickable(SelectBreak, Constants.DEFAULT_WAIT).click();
	}
	
	public String getSuccessBreakMessage() {
		return elementUtils.waitForElementVisible(StartedSuccessmessage, Constants.DEFAULT_WAIT).getText();
	}
	public void doClickEndBreak() {
		elementUtils.waitForElementToBeClickable(EndBreakbutton, Constants.DEFAULT_WAIT).click();
	}
	public String getSuccessBreakEndMessage() {
		return elementUtils.waitForElementVisible(EndSuccessmessage, Constants.DEFAULT_WAIT).getText();
	}
	

	public void enterRejectReasonMultipleShifts(String reason) {
		elementUtils.waitForElementVisible(txtboxRejectReasonMultipleShifts, Constants.DEFAULT_WAIT).sendKeys(reason);
	}

	public void doClickSaveRejectReasonMultipleShifts() {
		elementUtils.waitForElementToBeClickable(btnSaveRejectReasonMultipleShifts, Constants.DEFAULT_WAIT).click();
	}

	public PatrolAgentPassdownLogsPage clickOnPassdownLogsTab() {
		elementUtils.waitForElementToBeClickable(tabPassdownLogs, Constants.DEFAULT_WAIT).click();
		return new PatrolAgentPassdownLogsPage(driver);
	}

	// Patrol Beats
	public PatrolBeatsPage clickOnPatrolBeatsTab() {
		elementUtils.waitForElementToBeClickable(tabPatrolBeats, Constants.DEFAULT_WAIT).click();
		return new PatrolBeatsPage(driver);
	}

	// Vehicle Inspection
	public PatrolVehicleInspectionPage clickOnVehicleInspectionTab() {
		elementUtils.waitForElementToBeClickable(tabVehicleInspection, Constants.DEFAULT_WAIT).click();
		return new PatrolVehicleInspectionPage(driver);
	}

	public FieldAgentTeamSupportPage clickOnTeamSupportTab() { // added method
		elementUtils.waitForElementToBeClickable(tabTeamSupport, Constants.DEFAULT_WAIT).click();
		return new FieldAgentTeamSupportPage(driver);
	}

	// Previous Shift Logout
	public void logoutFromPreviousShift() {
		try {

			if (elementUtils.isElementVisible(txtHeadingPreviousShiftLogout, Constants.SHORT_TIME_OUT_WAIT)) {

				System.out.println("Previous shift logout popup is visible.");

				elementUtils.waitForElementVisible(txtboxReasonPreviousShiftLogout, Constants.SHORT_TIME_OUT_WAIT)
						.sendKeys("Auto logout due to previous unclosed shift");
				
				elementUtils.waitForElementVisible(btnVerifyMileagePreviousShiftLogout, Constants.SHORT_TIME_OUT_WAIT).sendKeys("0");				
				elementUtils.waitForElementVisible(btnSubmitPreviousShiftLogout, Constants.SHORT_TIME_OUT_WAIT).click();
				
				

				System.out.println("Submitted previous shift logout reason.");

			} else {
				System.out.println("Previous shift logout popup not visible. Skipping logout action.");
			}
		} catch (Exception e) {
			System.out.println("Exception while handling previous shift logout: " + e.getMessage());
		}
	}

	// Handle Passdown of a day

	public void handlePassdownOfTheDay() {
		try {
			if (elementUtils.isElementVisible(txtPassdownOfADay, Constants.SHORT_TIME_OUT_WAIT)) {
				System.out.println("'Passdown of a day' popup is visible.");

				List<WebElement> viewButtons = elementUtils.waitForVisibilityOfAllElements(btnCountViewPassdown,
						Constants.SHORT_TIME_OUT_WAIT);

				int buttonCount = viewButtons.size();
				System.out.println("Found " + buttonCount + " 'View Passdown' button(s).");

				for (int i = 1; i <= buttonCount; i++) {
					try {
						WebElement createReportButton = elementUtils
								.waitForElementVisible(getCreateReportButtonByIndex(i), Constants.SHORT_TIME_OUT_WAIT);
						createReportButton.click();
						System.out.println("Clicked on 'Create Report' button #" + i);
					} catch (Exception clickException) {
						System.out.println(
								"Could not click 'Create Report' button #" + i + ": " + clickException.getMessage());
					}
				}

			} else {
				System.out.println("'Passdown of a day' popup not visible. Skipping.");
			}
		} catch (Exception e) {
			System.out.println("Exception while handling 'Passdown of a day': " + e.getMessage());
		}
	}

	// Field Interview form navigation (added)
	public FieldAgentFieldInterviewPage clickOnFieldInterviewFormLink() {
		elementUtils.waitForElementToBeClickable(formsclick, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(fieldInterviewFormLink, Constants.DEFAULT_WAIT).click();
		return new FieldAgentFieldInterviewPage(driver);
	}
	// Incident Report form navigation (added)
	public FieldAgentIncidentReportsPage clickOnIncidentReportFormLink() {
		elementUtils.waitForElementToBeClickable(formsclick, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(incidentReportFormLink, Constants.DEFAULT_WAIT).click();
		return new FieldAgentIncidentReportsPage(driver);
	}
	// Parking Citation form navigation (added)
	public FieldAgentParkingCitationPage clickOnParkingCitationFormLink() {
		elementUtils.waitForElementToBeClickable(formsclick, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(parkingCitationFormLink, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(skipSearchliunk, Constants.DEFAULT_WAIT).click();
		return new FieldAgentParkingCitationPage(driver);
	}


	public FieldAgentTrespassNoticesPage clickOnTrespassNoticesFormLink() { // added method
		elementUtils.waitForElementToBeClickable(formsclick, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(trespassNoticesFormLink, Constants.DEFAULT_WAIT).click();
		return new FieldAgentTrespassNoticesPage(driver);
	}

	public com.dits.citywide.pages.fieldagent.FieldAgentProfileDetailsPage clickOnProfile() {
        elementUtils.waitForElementToBeClickable(tabProfileMenu, com.dits.citywide.constants.Constants.EXPLICIT_WAIT).click();
        elementUtils.waitForElementToBeClickable(btnProfile, com.dits.citywide.constants.Constants.EXPLICIT_WAIT).click();
        return new com.dits.citywide.pages.fieldagent.FieldAgentProfileDetailsPage(driver);
    }

    public void selectUserByName(String officerName) {
        By userRow = By.xpath("//*[text()='" + officerName + "']");
        elementUtils.waitForElementToBeClickable(userRow, 10).click();
    }
}
