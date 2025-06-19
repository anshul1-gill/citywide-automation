package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class DashboardPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtDashboard = By.xpath("//li[text()='Dashboard']");
	private By dropdownHRManagement = By
			.xpath("//div[@class='p-2 px-3 text-sm sidebar-container scrollbar-none']//div[1]");
	private By lnkEmployees = By.xpath("//span[text()='Employees']");
	private By lnkLeaveRequests = By.xpath("//span[contains(text(),'Leave Requests')]");
	private By lnkProfileMenu = By.xpath("//i[@class='ml-1 text-xs fa-solid fa-chevron-down']");
	private By lnkScheduling = By.xpath("//span[contains(text(),'Scheduling')]");
	private By lnkCompanySettings = By.xpath("//span[normalize-space()='Company Settings']");

	// Logout
	private By btnLogout = By.id("user-menu-item-2");
	private By btnOk = By.cssSelector(".swal2-confirm.swal2-styled.swal2-default-outline");
	private By btnCancel = By.cssSelector(".swal2-cancel.swal2-styled.swal2-default-outline");

	private By txtAreYouSure = By.id("swal2-title");
	private By txtLogoutConfirmatio = By.id("swal2-html-container");

	private By permissionError = By
			.xpath("//h3[contains(text(),'You may not have the correct permissions to view the page.')]");

	private By tabCalls = By.xpath("//span[contains(text(),'Calls')]");

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
	
	public CompanySettingsPage doClickCompanySettingsTab() {
		elementUtils.waitForElementToBeClickable(lnkCompanySettings, Constants.DEFAULT_WAIT).click();
		return new CompanySettingsPage(driver);
	}


}
