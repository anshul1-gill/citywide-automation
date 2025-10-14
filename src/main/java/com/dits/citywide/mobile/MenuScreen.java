package com.dits.citywide.mobile;

import org.openqa.selenium.By;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.AppElementUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class MenuScreen {

	AppiumDriver driver;
	AppElementUtils appElementUtils;

	private By txtMenuHeading = AppiumBy.androidUIAutomator("new UiSelector().text(\"Menu\")");

	private By txtProfileHeading = AppiumBy.androidUIAutomator("new UiSelector().text(\"Profile\").instance(0)");
	private By btnProfile = AppiumBy.accessibilityId("Profile");

	private By txtHeadingHrManagement = AppiumBy.androidUIAutomator("new UiSelector().text(\"HR Management\")");
	private By btnLeaveRequest = AppiumBy.accessibilityId("Leave Requests");
	private By btnMyCourse = AppiumBy.accessibilityId("My Courses");

	private By txtHeadingSettings = AppiumBy.androidUIAutomator("new UiSelector().text(\"Operations Hub\")");
	private By btnParkingCitation = AppiumBy.accessibilityId("Parking Citation");
	private By btnTrespassNotices = AppiumBy.accessibilityId("Trespass Notices");
	private By btnFieldInterviews = AppiumBy.accessibilityId("Field Interviews");
	private By btnIncidentReports = AppiumBy.accessibilityId("Incident Reports");
	private By btnCalls = AppiumBy.accessibilityId("Calls");
	private By btnMessageOfTheWeek = AppiumBy.accessibilityId("Message of the week");

	private By txtHeadingSchedule = AppiumBy.androidUIAutomator("new UiSelector().text(\"Schedule\")");
	private By btnMySchedule = AppiumBy.accessibilityId("My Schedule");

	private By txtHeadingSupportAndAbout = AppiumBy.androidUIAutomator("new UiSelector().text(\"Support & About\")");
	private By btnTermsAndPolicies = AppiumBy.accessibilityId("Terms and Policies");

	private By txtFontSize = AppiumBy.androidUIAutomator("new UiSelector().text(\"Font Size\")");
	private By txtSmall = AppiumBy.androidUIAutomator("new UiSelector().text(\"S\")");
	private By txtMedium = AppiumBy.androidUIAutomator("new UiSelector().text(\"M\")");
	private By txtLarge = AppiumBy.androidUIAutomator("new UiSelector().text(\"L\")");

	private By txtHeadingThemeMode = AppiumBy.androidUIAutomator("new UiSelector().text(\"Theme Mode\")");
	private By btnLightMode = AppiumBy.accessibilityId("Light Mode");
	private By btnDarkMode = AppiumBy.accessibilityId("Dark Mode");
	private By btnRedMode = AppiumBy.accessibilityId("Red Mode");

	private By btnLogout = AppiumBy.accessibilityId("Logout");

	public MenuScreen(AppiumDriver driver) {
		this.driver = driver;
		appElementUtils = new AppElementUtils(driver);
	}

	public boolean isMenuHeadingDisplayed() {
		return appElementUtils.doIsDisplayed(txtMenuHeading, Constants.DEFAULT_WAIT);
	}

	public boolean isProfileHeadingDisplayed() {
		return appElementUtils.doIsDisplayed(txtProfileHeading, Constants.DEFAULT_WAIT);
	}

	public boolean isProfileButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnProfile, Constants.DEFAULT_WAIT);
	}

	public boolean isProfileButtonEnabled() {
		return appElementUtils.doIsEnabled(btnProfile, Constants.DEFAULT_WAIT);
	}

	public boolean isProfileButtonClickable() {
		return appElementUtils.doIsClickable(btnProfile, Constants.DEFAULT_WAIT);
	}

	public ProfileScreen tapProfile() {
		appElementUtils.doClickWithWait(btnProfile, Constants.DEFAULT_WAIT);
		return new ProfileScreen(driver);
	}

	public boolean isHrManagementHeadingDisplayed() {
		return appElementUtils.doIsDisplayed(txtHeadingHrManagement, Constants.DEFAULT_WAIT);
	}

	public boolean isLeaveRequestButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnLeaveRequest, Constants.DEFAULT_WAIT);
	}

	public boolean isLeaveRequestButtonEnabled() {
		return appElementUtils.doIsEnabled(btnLeaveRequest, Constants.DEFAULT_WAIT);
	}

	public boolean isLeaveRequestButtonClickable() {
		return appElementUtils.doIsClickable(btnLeaveRequest, Constants.DEFAULT_WAIT);
	}

	public LeaveRequestScreen tapLeaveRequest() {
		appElementUtils.doClickWithWait(btnLeaveRequest, Constants.DEFAULT_WAIT);
		return new LeaveRequestScreen(driver);
	}

	public boolean isMyCourseButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnMyCourse, Constants.DEFAULT_WAIT);
	}

	public boolean isMyCourseButtonEnabled() {
		return appElementUtils.doIsEnabled(btnMyCourse, Constants.DEFAULT_WAIT);
	}

	public boolean isMyCourseButtonClickable() {
		return appElementUtils.doIsClickable(btnMyCourse, Constants.DEFAULT_WAIT);
	}

	public MyCourseScreen tapMyCourse() {
		appElementUtils.doClickWithWait(btnMyCourse, Constants.DEFAULT_WAIT);
		return new MyCourseScreen(driver);
	}

	public boolean isSettingsHeadingDisplayed() {
		return appElementUtils.doIsDisplayed(txtHeadingSettings, Constants.DEFAULT_WAIT);
	}

	public boolean isParkingCitationButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnParkingCitation, Constants.DEFAULT_WAIT);
	}

	public boolean isParkingCitationButtonEnabled() {
		return appElementUtils.doIsEnabled(btnParkingCitation, Constants.DEFAULT_WAIT);
	}

	public boolean isParkingCitationButtonClickable() {
		return appElementUtils.doIsClickable(btnParkingCitation, Constants.DEFAULT_WAIT);
	}

	public ParkingCitationScreen tapParkingCitation() {
		appElementUtils.doClickWithWait(btnParkingCitation, Constants.DEFAULT_WAIT);
		return new ParkingCitationScreen(driver);
	}

	public boolean isTrespassNoticesButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnTrespassNotices, Constants.DEFAULT_WAIT);
	}

	public boolean isTrespassNoticesButtonEnabled() {
		return appElementUtils.doIsEnabled(btnTrespassNotices, Constants.DEFAULT_WAIT);
	}

	public boolean isTrespassNoticesButtonClickable() {
		return appElementUtils.doIsClickable(btnTrespassNotices, Constants.DEFAULT_WAIT);
	}

	public TrespassNoticesScreen tapTrespassNotices() {
		appElementUtils.doClickWithWait(btnTrespassNotices, Constants.DEFAULT_WAIT);
		return new TrespassNoticesScreen(driver);
	}

	public boolean isFieldInterviewsButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnFieldInterviews, Constants.DEFAULT_WAIT);
	}

	public boolean isFieldInterviewsButtonEnabled() {
		return appElementUtils.doIsEnabled(btnFieldInterviews, Constants.DEFAULT_WAIT);
	}

	public boolean isFieldInterviewsButtonClickable() {
		return appElementUtils.doIsClickable(btnFieldInterviews, Constants.DEFAULT_WAIT);
	}

	public FieldInterviewsScreen tapFieldInterviews() {
		appElementUtils.doClickWithWait(btnFieldInterviews, Constants.DEFAULT_WAIT);
		return new FieldInterviewsScreen(driver);
	}

	public boolean isIncidentReportsButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnIncidentReports, Constants.DEFAULT_WAIT);
	}

	public boolean isIncidentReportsButtonEnabled() {
		return appElementUtils.doIsEnabled(btnIncidentReports, Constants.DEFAULT_WAIT);
	}

	public boolean isIncidentReportsButtonClickable() {
		return appElementUtils.doIsClickable(btnIncidentReports, Constants.DEFAULT_WAIT);
	}

	public IncidentReportsScreen tapIncidentReports() {
		appElementUtils.doClickWithWait(btnIncidentReports, Constants.DEFAULT_WAIT);
		return new IncidentReportsScreen(driver);
	}

	public boolean isCallsButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnCalls, Constants.DEFAULT_WAIT);
	}

	public boolean isCallsButtonEnabled() {
		return appElementUtils.doIsEnabled(btnCalls, Constants.DEFAULT_WAIT);
	}

	public boolean isCallsButtonClickable() {
		return appElementUtils.doIsClickable(btnCalls, Constants.DEFAULT_WAIT);
	}

	public CallsScreen tapCalls() {
		appElementUtils.doClickWithWait(btnCalls, Constants.DEFAULT_WAIT);
		return new CallsScreen(driver);
	}

	public boolean isMessageOfTheWeekButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnMessageOfTheWeek, Constants.DEFAULT_WAIT);
	}

	public boolean isMessageOfTheWeekButtonEnabled() {
		return appElementUtils.doIsEnabled(btnMessageOfTheWeek, Constants.DEFAULT_WAIT);
	}

	public boolean isMessageOfTheWeekButtonClickable() {
		return appElementUtils.doIsClickable(btnMessageOfTheWeek, Constants.DEFAULT_WAIT);
	}

	public MessageOfTheWeekScreen tapMessageOfTheWeek() {
		appElementUtils.doClickWithWait(btnMessageOfTheWeek, Constants.DEFAULT_WAIT);
		return new MessageOfTheWeekScreen(driver);
	}

	public boolean isScheduleHeadingDisplayed() {
		return appElementUtils.doIsDisplayed(txtHeadingSchedule, Constants.DEFAULT_WAIT);
	}

	public boolean isMyScheduleButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnMySchedule, Constants.DEFAULT_WAIT);
	}

	public boolean isMyScheduleButtonEnabled() {
		return appElementUtils.doIsEnabled(btnMySchedule, Constants.DEFAULT_WAIT);
	}

	public boolean isMyScheduleButtonClickable() {
		return appElementUtils.doIsClickable(btnMySchedule, Constants.DEFAULT_WAIT);
	}

	public MyScheduleScreen tapMySchedule() {
		appElementUtils.doClickWithWait(btnMySchedule, Constants.DEFAULT_WAIT);
		return new MyScheduleScreen(driver);
	}

	public boolean isSupportAndAboutHeadingDisplayed() {
		return appElementUtils.doIsDisplayed(txtHeadingSupportAndAbout, Constants.DEFAULT_WAIT);
	}

	public boolean isTermsAndPoliciesButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnTermsAndPolicies, Constants.DEFAULT_WAIT);
	}

	public boolean isTermsAndPoliciesButtonEnabled() {
		return appElementUtils.doIsEnabled(btnTermsAndPolicies, Constants.DEFAULT_WAIT);
	}

	public boolean isTermsAndPoliciesButtonClickable() {
		return appElementUtils.doIsClickable(btnTermsAndPolicies, Constants.DEFAULT_WAIT);
	}

	public TermsAndPoliciesScreen tapTermsAndPolicies() {
		appElementUtils.doClickWithWait(btnTermsAndPolicies, Constants.DEFAULT_WAIT);
		return new TermsAndPoliciesScreen(driver);
	}

	public boolean isFontSizeTextDisplayed() {
		return appElementUtils.doIsDisplayed(txtFontSize, Constants.DEFAULT_WAIT);
	}

	public boolean isSmallFontSizeOptionDisplayed() {
		return appElementUtils.doIsDisplayed(txtSmall, Constants.DEFAULT_WAIT);
	}

	public boolean isMediumFontSizeOptionDisplayed() {
		return appElementUtils.doIsDisplayed(txtMedium, Constants.DEFAULT_WAIT);
	}

	public boolean isLargeFontSizeOptionDisplayed() {
		return appElementUtils.doIsDisplayed(txtLarge, Constants.DEFAULT_WAIT);
	}

	public void selectFontSize(String size) {
		switch (size.toLowerCase()) {
		case "small":
			appElementUtils.doClickWithWait(txtSmall, Constants.DEFAULT_WAIT);
			break;
		case "medium":
			appElementUtils.doClickWithWait(txtMedium, Constants.DEFAULT_WAIT);
			break;
		case "large":
			appElementUtils.doClickWithWait(txtLarge, Constants.DEFAULT_WAIT);
			break;
		default:
			throw new IllegalArgumentException("Invalid font size: " + size);
		}
	}

	public boolean isThemeModeHeadingDisplayed() {
		return appElementUtils.doIsDisplayed(txtHeadingThemeMode, Constants.DEFAULT_WAIT);
	}

	public boolean isLightModeOptionDisplayed() {
		return appElementUtils.doIsDisplayed(btnLightMode, Constants.DEFAULT_WAIT);
	}

	public boolean isDarkModeOptionDisplayed() {
		return appElementUtils.doIsDisplayed(btnDarkMode, Constants.DEFAULT_WAIT);
	}

	public boolean isRedModeOptionDisplayed() {
		return appElementUtils.doIsDisplayed(btnRedMode, Constants.DEFAULT_WAIT);
	}

	public void selectThemeMode(String mode) {
		switch (mode.toLowerCase()) {
		case "light":
			appElementUtils.doClickWithWait(btnLightMode, Constants.DEFAULT_WAIT);
			break;
		case "dark":
			appElementUtils.doClickWithWait(btnDarkMode, Constants.DEFAULT_WAIT);
			break;
		case "red":
			appElementUtils.doClickWithWait(btnRedMode, Constants.DEFAULT_WAIT);
			break;
		default:
			throw new IllegalArgumentException("Invalid theme mode: " + mode);
		}
	}

	public boolean isLogoutButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnLogout, Constants.DEFAULT_WAIT);
	}

	public boolean isLogoutButtonEnabled() {
		return appElementUtils.doIsEnabled(btnLogout, Constants.DEFAULT_WAIT);
	}

	public boolean isLogoutButtonClickable() {
		return appElementUtils.doIsClickable(btnLogout, Constants.DEFAULT_WAIT);
	}

	public LoginScreen tapLogout() {
		appElementUtils.doClickWithWait(btnLogout, Constants.DEFAULT_WAIT);
		return new LoginScreen(driver);
	}

}
