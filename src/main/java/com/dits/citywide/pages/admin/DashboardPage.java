package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class DashboardPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtDashboard = By.xpath("//li[text()='Dashboard']");
	private By dropdownHRManagement = By.xpath("//span[normalize-space()='HR Management']");
	private By lnkEmployees = By.xpath("//span[text()='Employees']");
	private By lnkLeaveRequests = By.xpath("//span[contains(text(),'Leave Requests')]");
	private By lnkProfileMenu = By.xpath("//i[@class='ml-1 text-xs fa-solid fa-chevron-down']");
	private By lnkScheduling = By.xpath("//span[contains(text(),'Scheduling')]");
	private By lnkCompanySettings = By.xpath("//span[normalize-space()='Company Settings']");
	private By lnkTraining = By.xpath("//span[contains(text(),'Training')]");
	private By lnkAttendance = By.xpath("//span[normalize-space()='Attendance']");
	private By lnkERM = By.xpath("//span[contains(text(),'ERM')]");
	private By lnkTeamSupport = By.xpath("//span[normalize-space()='Team Support']");
	private By lnkApplicantTrackingSystem = By.xpath("//span[normalize-space()='Applicant Tracking System']");
	private By lnkStatus = By.xpath("//span[normalize-space()='Status']");
	private By lnkMessageOfTheWeek = By.xpath("//span[normalize-space()='Message Of The Week']");
	private By lnkFleetManagement = By.xpath("//span[normalize-space()='Fleet Management']");
	private By lnkPayroll = By.xpath("//span[normalize-space()='Payroll']");
	private By lnkInvoice = By.xpath("//span[normalize-space()='Invoice']");

	// Logout
	private By btnLogout = By.id("user-menu-item-2");
	private By btnOk = By.cssSelector(".swal2-confirm.swal2-styled.swal2-default-outline");
	private By btnCancel = By.cssSelector(".swal2-cancel.swal2-styled.swal2-default-outline");

	private By txtAreYouSure = By.id("swal2-title");
	private By txtLogoutConfirmatio = By.id("swal2-html-container");

	private By permissionError = By
			.xpath("//h3[contains(text(),'You may not have the correct permissions to view the page.')]");

	private By tabCalls = By.xpath("//span[contains(text(),'Calls')]");
	private By tabSites = By.xpath("//span[contains(text(),'Sites')]");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isDashboardTextDisplayed() {
		return elementUtils.doIsEnabled(txtDashboard, Constants.DEFAULT_WAIT);
	}

	public boolean isHRManagementDropdownDisplayed() {
		return elementUtils.doIsDisplayed(dropdownHRManagement, Constants.DEFAULT_WAIT);
	}

	public boolean isHRManagementDropdownClickable() {
		return elementUtils.doIsClickable(dropdownHRManagement, Constants.SHORT_TIME_OUT_WAIT);
	}

	public void doClickHRManagement() {
		elementUtils.doClickWithActionsAndWait(dropdownHRManagement, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(lnkEmployees, Constants.DEFAULT_WAIT);
	}

//	public EmployeesPage doClickEmployees() {
//		elementUtils.waitForElementToBeClickable(lnkEmployees, Constants.DEFAULT_WAIT).click();
//		return new EmployeesPage(driver);
//	}

	public EmployeesPage doClickEmployees() {
		try {
			elementUtils.waitForElementToBeClickable(lnkEmployees, Constants.DEFAULT_WAIT).click();
		} catch (Exception e) {
			if (getCurrentUrl().contains("/unauthorized")) {
				// Retry after handling unauthorized redirect
				// doClickHRManagement();
				elementUtils.waitForElementToBeClickable(lnkEmployees, Constants.DEFAULT_WAIT).click();
			} else {
				// Re-throw if it's not the specific error we're handling
				throw e;
			}
		}
		return new EmployeesPage(driver);
	}

	// Leave Requests
	public LeaveRequestsPage doClickLeaveRequests() {
		elementUtils.waitForElementToBeClickable(lnkLeaveRequests, Constants.DEFAULT_WAIT).click();
		return new LeaveRequestsPage(driver);
	}

	public SchedulingPage doClickScheduling() {
		elementUtils.waitForElementToBeClickable(lnkScheduling, Constants.DEFAULT_WAIT).click();
		return new SchedulingPage(driver);
	}

	public void doClickProfileMenu() {
		elementUtils.waitForElementToBeClickable(lnkProfileMenu, Constants.DEFAULT_WAIT).click();
	}

	// Logout
	public boolean isAreYouSureTextDisplayed() {
		return elementUtils.doIsEnabled(txtAreYouSure, Constants.DEFAULT_WAIT);
	}

	public boolean isLogoutConfirmationTextDisplayed() {
		return elementUtils.doIsEnabled(txtLogoutConfirmatio, Constants.DEFAULT_WAIT);
	}

	public boolean isOkButtonClickable() {
		return elementUtils.doIsClickable(btnOk, Constants.SHORT_TIME_OUT_WAIT);
	}

	public boolean isCancelButtonClickable() {
		return elementUtils.doIsClickable(btnCancel, Constants.SHORT_TIME_OUT_WAIT);
	}

	public LoginPage doClickLogout() {
		elementUtils.waitForElementToBeClickable(btnLogout, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnOk, Constants.SHORT_TIME_OUT_WAIT).click();
		return new LoginPage(driver);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public CallsPage doClickCallsTab() {
		elementUtils.waitForElementToBeClickable(tabCalls, Constants.DEFAULT_WAIT).click();
		return new CallsPage(driver);
	}

	public SitesPage doClickSitesTab() {
		elementUtils.waitForElementToBeClickable(tabSites, Constants.DEFAULT_WAIT).click();
		return new SitesPage(driver);
	}

	public CompanySettingsPage doClickCompanySettingsTab() {
		elementUtils.waitForElementToBeClickable(lnkCompanySettings, Constants.DEFAULT_WAIT).click();
		return new CompanySettingsPage(driver);
	}

	public TrainingPage clickOnTrainingTab() {
		elementUtils.waitForElementToBeClickable(lnkTraining, Constants.DEFAULT_WAIT).click();
		return new TrainingPage(driver);
	}

	public AttendancePage doClickAttendance() {
		elementUtils.waitForElementToBeClickable(lnkAttendance, Constants.DEFAULT_WAIT).click();
		return new AttendancePage(driver);
	}

	public ERMPage doClickERM() {
		elementUtils.waitForElementToBeClickable(lnkERM, Constants.DEFAULT_WAIT).click();
		return new ERMPage(driver);
	}

	public TeamSupportPage doClickTeamSupport() {
		elementUtils.waitForElementToBeClickable(lnkTeamSupport, Constants.DEFAULT_WAIT).click();
		return new TeamSupportPage(driver);
	}

	public ApplicantTrackingSystemPage doClickApplicantTrackingSystem() {
		elementUtils.waitForElementToBeClickable(lnkApplicantTrackingSystem, Constants.DEFAULT_WAIT).click();
		return new ApplicantTrackingSystemPage(driver);
	}

	public StatusPage doClickStatus() {
		elementUtils.waitForElementToBeClickable(lnkStatus, Constants.DEFAULT_WAIT).click();
		return new StatusPage(driver);
	}

	public MessageOfTheWeekPage doClickMessageOfTheWeek() {
		elementUtils.waitForElementToBeClickable(lnkMessageOfTheWeek, Constants.DEFAULT_WAIT).click();
		return new MessageOfTheWeekPage(driver);
	}

	public FleetManagementPage doClickFleetManagement() {
		elementUtils.waitForElementToBeClickable(lnkFleetManagement, Constants.DEFAULT_WAIT).click();
		return new FleetManagementPage(driver);
	}

	public PayrollPage doClickPayroll() {
		elementUtils.waitForElementToBeClickable(lnkPayroll, Constants.DEFAULT_WAIT).click();
		return new PayrollPage(driver);
	}

	public InvoicePage doClickInvoice() {
		elementUtils.waitForElementToBeClickable(lnkInvoice, Constants.DEFAULT_WAIT).click();
		return new InvoicePage(driver);
	}

}
