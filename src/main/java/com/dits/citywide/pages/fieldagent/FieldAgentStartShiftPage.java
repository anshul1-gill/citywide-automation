package com.dits.citywide.pages.fieldagent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.CurrentDateTimeUtils;
import com.dits.citywide.utilities.ElementUtils;
import com.dits.citywide.utilities.ServerTimeUtil;

public class FieldAgentStartShiftPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

//	private By txtMessageOfTheWeek = By.xpath(
//			"//div[@class='flex items-center justify-between px-3 py-2 text-white rounded-t-lg bg-blue2 dark:bg-blue2']/h2");
	private By btnMarkAsRead = By.xpath("//div[@class='flex items-center gap-3']/button");
	private By tabStartShift = By.xpath("(//span[contains(text(),'Start Shift')])[1]");
	private By tabOpenSites = By.xpath("//span[normalize-space()='Sites']");

	private By getDateLocator(String day) {
		return By.xpath(
				"//td[contains(@class, 'ant-picker-cell-in-view')]//div[@class='ant-picker-calendar-date-value' and normalize-space(text())='"
						+ day + "']/following-sibling::div");
	}

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
	private By btnViewSite = By.xpath("//span[normalize-space()='View Site']");
	private By btnStartShift = By.xpath("(//span[contains(text(),'Start Shift')])[2]");
	private By btnConfirmShift = By.xpath("//span[normalize-space()='Confirm/Reject multiple shifts']");
	private By selectCheckbox = By.xpath( "//tr[.//td[contains(@data-label,'Shift') and .//span[normalize-space()='Pending']]] //label[contains(@class,'ant-checkbox-wrapper')]");
	private By Confirmbtn = By.xpath("//button[normalize-space()='Confirm']");
	
	private By btnRejectShift = By.xpath("//span[normalize-space()='Reject']");
	private By txtboxRejectReason = By.xpath("//textarea[@id='reason']");
	private By btnSaveRejectReason = By.xpath("//button[@type='submit']");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");
	private By btnCancel = By.xpath("//button[normalize-space()='Cancel']");

	// Data displayed on Start Shift page popup
	private By dataSite = By.xpath("//label[contains(text(),'Site')]/following-sibling::p");
	private By dataSchedule = By.xpath("//label[contains(text(),'Schedule')]/following-sibling::p");
	private By dataServiceType = By.xpath("//label[contains(text(),'Service Type')]/following-sibling::p");
	private By dataAddress = By.xpath("//label[contains(text(),'Address')]/following-sibling::p");
	private By dataNotes = By.xpath("//label[contains(text(),'Notes')]/following-sibling::p");
	
	private By btnStartBreak = By.xpath("//button[normalize-space()='Start Break']");
	private By SelectBreak = By.xpath("//a[normalize-space()='Lunch Break']");
	private By StartedSuccessmessage = By.xpath("//div[contains(text(),'Break Started')]");
	private By EndBreakbutton = By.xpath("//span[@id='countup-timer']");
	private By EndSuccessmessage = By.xpath("//div[contains(text(),'Break Ended')]");
	

	private By btnEndShift = By.xpath("//button[contains(text(),'End Shift')]");

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
	private By txtboxCheckOutDateTime = By.cssSelector("#depart_timedate");
	private By txtboxReasonPreviousShiftLogout = By.xpath("//textarea[@id='activity_text']");
	private By btnSubmitPreviousShiftLogout = By.xpath("//button[@id='submitButton']");
	private By txtSucessMessagePreviousShiftLogout = By.xpath("//h2[@id='swal2-title']/span");

	// Passdown of a day
	private By txtPassdownOfADay = By.xpath("//h2[normalize-space()='Passdown of the day']");
	private By btnCountViewPassdown = By.xpath("//td[@data-label='Action']/button");

	// Profile
	private By tabProfileMenu = By.xpath("//button[@class='flex items-center gap-2 text-sm']");
	private By btnProfile = By.xpath("//a[normalize-space()='Profile']");

	// Form
	private By formsclick = By.xpath("//p[@title='Forms']");
	private By parkingCitationFormLink = By.xpath("//span[normalize-space()='Parking Citation']");
	private By trespassNoticesFormLink = By.xpath("//span[normalize-space()='Trespass Notice']");
	private By fieldInterviewFormLink = By.xpath("//span[normalize-space()='Field Interview']");
	private By incidentReportFormLink = By.xpath("//span[normalize-space()='Incident Report']");

	public By getCreateReportButtonByIndex(int pasdownbuttonCount) {
		String xpath = "(//button[normalize-space()='Create Report'])[" + pasdownbuttonCount + "]";
		return By.xpath(xpath);
	}

	private By tabPassdownLogs = By.xpath("//span[normalize-space()='Passdown Logs']");
	private By tabTeamSupport = By.xpath("//span[normalize-space()='Team Support']");

	// Common
	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	public FieldAgentStartShiftPage(WebDriver driver) {
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

	public void doClickTabStartShift() {
		elementUtils.waitForElementToBeClickable(tabStartShift, Constants.EXPLICIT_WAIT).click();
	}

	public void viewShiftDetails(String day) throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.EXPLICIT_WAIT);
		Thread.sleep(1000);
		if (day.length() == 1) {
			day = "0" + day;
		}
		elementUtils.doClickWithActionsAndWait(getDateLocator(day), Constants.EXPLICIT_WAIT);
	}

	public String getSite() {
		return elementUtils.waitForElementVisible(dataSite, Constants.EXPLICIT_WAIT).getText();
	}

	public boolean getSchedule() {
		return elementUtils.doIsDisplayed(dataSchedule, Constants.EXPLICIT_WAIT);
	}

	public boolean getServiceType() {
		return elementUtils.doIsDisplayed(dataServiceType, Constants.EXPLICIT_WAIT);
	}

	public boolean getAddress() {
		return elementUtils.doIsDisplayed(dataAddress, Constants.EXPLICIT_WAIT);
	}

	public String getNotes() {
		return elementUtils.waitForElementVisible(dataNotes, Constants.EXPLICIT_WAIT).getText();
	}

	public void doClickViewSite() {
		elementUtils.waitForElementToBeClickable(btnViewSite, Constants.EXPLICIT_WAIT).click();
	}

	public boolean isViewSiteVisible() {
		return elementUtils.doIsDisplayed(btnViewSite, Constants.EXPLICIT_WAIT);
	}

	// Start Shift
	public void doClickStartShift() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessagePreviousShiftLogout, Constants.EXPLICIT_WAIT);
		elementUtils.waitForElementToBeClickable(btnStartShift, Constants.EXPLICIT_WAIT).click();
		String currenttimeStartShift = ServerTimeUtil.getServerTimeInPST();
		System.out.println("Start Shift Time: " + currenttimeStartShift);
	}

	public LocalDate getServerDate(String baseUrl) {
		// Example serverTimeStr = "08/20/2025 14:45"
		String serverTimeStr = ServerTimeUtil.getServerTimeInPST();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		LocalDateTime serverDateTime = LocalDateTime.parse(serverTimeStr, formatter);
		return serverDateTime.toLocalDate();
	}

	public LocalDate getScheduledDate(String shiftDate) {
		// Example shiftDate = "08/20/2025"
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return LocalDate.parse(shiftDate, formatter);
	}

	public boolean isStartShiftButtonVisible() {
		return elementUtils.doIsDisplayed(btnStartShift, Constants.EXPLICIT_WAIT);
	}

	public void doClickConfirmShift() {
		elementUtils.waitForElementToBeClickable(btnConfirmShift, Constants.EXPLICIT_WAIT).click();
	}

	public boolean isConfirmShiftButtonVisible() {
		return elementUtils.doIsDisplayed(btnConfirmShift, Constants.EXPLICIT_WAIT);
	}
	
	public void doSelectCheckbox() throws InterruptedException {
		Thread.sleep(500);
		elementUtils.waitForElementToBeClickable(selectCheckbox, Constants.EXPLICIT_WAIT).click();
	}
	
	public void doClickConfirmShiftbutton() {
		elementUtils.waitForElementToBeClickable(Confirmbtn, Constants.EXPLICIT_WAIT).click();
	}

	public void doClickRejectShift() {
		elementUtils.waitForElementToBeClickable(btnRejectShift, Constants.EXPLICIT_WAIT).click();
	}

	public boolean isRejectShiftButtonVisible() {
		return elementUtils.doIsDisplayed(btnRejectShift, Constants.EXPLICIT_WAIT);
	}

	public void enterRejectReason(String reason) {
		elementUtils.waitForElementVisible(txtboxRejectReason, Constants.EXPLICIT_WAIT).sendKeys(reason);
	}

	public void doClickSaveRejectReason() {
		elementUtils.waitForElementToBeClickable(btnSaveRejectReason, Constants.EXPLICIT_WAIT).click();
	}

	public void doClickOkButton() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.EXPLICIT_WAIT).click();
	}

	public void doClickCancelButton() {
		elementUtils.waitForElementToBeClickable(btnCancel, Constants.EXPLICIT_WAIT).click();
	}
	
	// Start Break
	public boolean isStartBreakButtonVisible() {
		return elementUtils.doIsDisplayed(btnStartBreak, Constants.EXPLICIT_WAIT);
	}
	
	public void doClickStartBreak() {
		elementUtils.waitForElementToBeClickable(btnStartBreak, Constants.EXPLICIT_WAIT).click();
	}
	
	public void doSelectBreak() {
		elementUtils.waitForElementToBeClickable(SelectBreak, Constants.EXPLICIT_WAIT).click();
	}
	
	public String getSuccessBreakMessage() {
		return elementUtils.waitForElementVisible(StartedSuccessmessage, Constants.EXPLICIT_WAIT).getText();
	}
	public void doClickEndBreak() {
		elementUtils.waitForElementToBeClickable(EndBreakbutton, Constants.EXPLICIT_WAIT).click();
	}
	public String getSuccessBreakEndMessage() {
		return elementUtils.waitForElementVisible(EndSuccessmessage, Constants.EXPLICIT_WAIT).getText();
	}
	
	

	// End Shift
	public boolean isEndShiftButtonVisible() {
		return elementUtils.doIsDisplayed(btnEndShift, Constants.EXPLICIT_WAIT);
	}

	public FieldAgentReportsPage doClickEndShift() {
		elementUtils.waitForElementToBeClickable(btnEndShift, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentReportsPage(driver);
	}

	// Start Shift Page
	public String getFieldAgentNameWithWelcome() {
		return elementUtils.waitForElementVisible(nameFieldAgentWithWelcome, Constants.EXPLICIT_WAIT).getText();
	}

	public String getWelcomeDescriptionText() {
		return elementUtils.waitForElementVisible(txtWelcomeDescription, Constants.EXPLICIT_WAIT).getText();
	}

	public FieldAgentReportsPage doClickStartShiftBegin() {
		elementUtils.waitForInvisibilityOfElementLocated(txtHeadingPreviousShiftLogout, Constants.EXPLICIT_WAIT);
		elementUtils.waitForElementToBeClickable(btnStartShiftBegin, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentReportsPage(driver);
	}

	public FieldAgentCallsPage doClickCallsTab() {
		elementUtils.waitForElementToBeClickable(tabCalls, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentCallsPage(driver);
	}

	public FieldAgentReportsPage clickOnReportsTab() {
		elementUtils.waitForElementToBeClickable(btnReportsTab, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentReportsPage(driver);
	}

	// HR Management
	public void clickOnHRManagementMenu() {
		elementUtils.waitForElementToBeClickable(menuHRManagement, Constants.EXPLICIT_WAIT).click();
	}

	public FieldAgentLeaveRequestsPage clickOnLeaveRequestsTab() {
		elementUtils.waitForElementToBeClickable(tabLeaverequests, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentLeaveRequestsPage(driver);
	}

	public FieldAgentMyCoursesPage clickOnMyCoursesTab() {
		elementUtils.waitForElementToBeClickable(tabMyCourses, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentMyCoursesPage(driver);
	}

	public FieldAgentMyAttendancePage clickOnMyAttendanceTab() {
		elementUtils.waitForElementToBeClickable(tabMyAttendance, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentMyAttendancePage(driver);
	}

	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.EXPLICIT_WAIT).getText();
	}

	// Confirm Reject Multiple Shifts
	public void doClickConfirmRejectMultipleShifts() {
		elementUtils.waitForElementToBeClickable(btnConfirmRejectMultipleShifts, Constants.EXPLICIT_WAIT).click();
	}

	public boolean isHeadingMyShiftsVisible() {
		return elementUtils.doIsDisplayed(txtHeadingMyShifts, Constants.EXPLICIT_WAIT);
	}

	public void doClickSelectAllShifts() {
		elementUtils.waitForElementToBeClickable(checkboxSelectAllShifts, Constants.EXPLICIT_WAIT).click();
	}

	public void doClickConfirm() {
		elementUtils.waitForElementToBeClickable(btnConfirm, Constants.EXPLICIT_WAIT).click();
	}

	public void doClickReject() {
		elementUtils.waitForElementToBeClickable(btnReject, Constants.EXPLICIT_WAIT).click();
	}

	public void enterRejectReasonMultipleShifts(String reason) {
		elementUtils.waitForElementVisible(txtboxRejectReasonMultipleShifts, Constants.EXPLICIT_WAIT).sendKeys(reason);
	}

	public void doClickSaveRejectReasonMultipleShifts() {
		elementUtils.waitForElementToBeClickable(btnSaveRejectReasonMultipleShifts, Constants.EXPLICIT_WAIT).click();
	}

	public FieldAgentPassdownLogsPage clickOnPassdownLogsTab() {
		elementUtils.waitForElementToBeClickable(tabPassdownLogs, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentPassdownLogsPage(driver);
	}

	public FieldAgentProfileDetailsPage clickOnProfile() {
		elementUtils.waitForElementToBeClickable(tabProfileMenu, Constants.EXPLICIT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnProfile, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentProfileDetailsPage(driver);
	}

	public FieldAgentTeamSupportPage clickOnTeamSupportTab() {
		elementUtils.waitForElementToBeClickable(tabTeamSupport, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentTeamSupportPage(driver);
	}

	public FieldAgentParkingCitationPage clickOnParkingCitationFormLink() {
		elementUtils.waitForElementToBeClickable(formsclick, Constants.EXPLICIT_WAIT).click();
		elementUtils.waitForElementToBeClickable(parkingCitationFormLink, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentParkingCitationPage(driver);
	}

	public FieldAgentTrespassNoticesPage clickOnTrespassNoticesFormLink() {
		elementUtils.waitForElementToBeClickable(formsclick, Constants.EXPLICIT_WAIT).click();
		elementUtils.waitForElementToBeClickable(trespassNoticesFormLink, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentTrespassNoticesPage(driver);
	}

	public FieldAgentFieldInterviewPage clickOnFieldInterviewFormLink() {
		elementUtils.waitForElementToBeClickable(formsclick, Constants.EXPLICIT_WAIT).click();
		elementUtils.waitForElementToBeClickable(fieldInterviewFormLink, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentFieldInterviewPage(driver);
	}

	public FieldAgentIncidentReportsPage clickOnIncidentReportFormLink() {
		elementUtils.waitForElementToBeClickable(formsclick, Constants.EXPLICIT_WAIT).click();
		elementUtils.waitForElementToBeClickable(incidentReportFormLink, Constants.EXPLICIT_WAIT).click();
		return new FieldAgentIncidentReportsPage(driver);
	}

	// Previous Shift Logout
	public void logoutFromPreviousShift() {
		try {

			if (elementUtils.isElementVisible(txtHeadingPreviousShiftLogout, Constants.SHORT_TIME_OUT_WAIT)) {

				System.out.println("Previous shift logout popup is visible.");
				elementUtils.waitForElementVisible(txtboxCheckOutDateTime, Constants.SHORT_TIME_OUT_WAIT).clear();
				elementUtils.doActionsSendKeys(txtboxCheckOutDateTime, CurrentDateTimeUtils.getCurrentDateTime());

				elementUtils.waitForElementVisible(txtboxReasonPreviousShiftLogout, Constants.SHORT_TIME_OUT_WAIT)
						.sendKeys("Auto logout due to previous unclosed shift");

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

	public FieldAgentOpenSitesPage navigateToOpenSitesTab() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(tabOpenSites, Constants.EXPLICIT_WAIT).click();
		Thread.sleep(1000); // Wait for tab to load, adjust as needed
		return new FieldAgentOpenSitesPage(driver);
	}

	public void selectUserByName(String officerName) {
        // This assumes there is a clickable element (e.g., a row or link) with the officer's name visible
        By userRow = By.xpath("//*[text()='" + officerName + "']");
        elementUtils.waitForElementToBeClickable(userRow, 10).click();
    }

}
