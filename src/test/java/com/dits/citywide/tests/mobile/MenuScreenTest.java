package com.dits.citywide.tests.mobile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.basetest.BaseMobileTest;
import com.dits.citywide.constants.MobileConstants;
import com.dits.citywide.mobile.HomeScreen;
import com.dits.citywide.mobile.LoginScreen;
import com.dits.citywide.mobile.MenuScreen;
import com.dits.citywide.mobile.ReportsScreen;

public class MenuScreenTest extends BaseMobileTest {

	HomeScreen homeScreen;
	ReportsScreen reportsScreen;
	MenuScreen menuScreen;

	@BeforeMethod
	public void login() throws InterruptedException {
		LoginScreen loginScreen = new LoginScreen(driver);
		reportsScreen = new ReportsScreen(driver);
		loginScreen.searchAndProceed(MobileConstants.ORG_NAME);
		homeScreen = loginScreen.login(prop.getProperty("employeeID"), prop.getProperty("employeePassword"));
	}

	@Test
	public void menuScreenTest() throws InterruptedException {
		homeScreen.handleMessageOfTheWeek();
		menuScreen = homeScreen.clickOnMoreTab();

		// Menu Heading
		softAssert.assertTrue(menuScreen.isMenuHeadingDisplayed(), "Menu screen is not displayed");

		// Profile
		softAssert.assertTrue(menuScreen.isProfileHeadingDisplayed(), "Profile heading is not displayed");
		softAssert.assertTrue(menuScreen.isProfileButtonDisplayed(), "Profile button is not displayed");
		softAssert.assertTrue(menuScreen.isProfileButtonEnabled(), "Profile button is not enabled");
		softAssert.assertTrue(menuScreen.isProfileButtonClickable(), "Profile button is not clickable");

		// HR Management
		softAssert.assertTrue(menuScreen.isHrManagementHeadingDisplayed(), "HR Management heading is not displayed");
		softAssert.assertTrue(menuScreen.isLeaveRequestButtonDisplayed(), "Leave Request button is not displayed");
		softAssert.assertTrue(menuScreen.isLeaveRequestButtonEnabled(), "Leave Request button is not enabled");
		softAssert.assertTrue(menuScreen.isLeaveRequestButtonClickable(), "Leave Request button is not clickable");

		// My Courses
		softAssert.assertTrue(menuScreen.isMyCourseButtonDisplayed(), "My Courses button is not displayed");
		softAssert.assertTrue(menuScreen.isMyCourseButtonEnabled(), "My Courses button is not enabled");
		softAssert.assertTrue(menuScreen.isMyCourseButtonClickable(), "My Courses button is not clickable");

		// Operations Hub
		softAssert.assertTrue(menuScreen.isSettingsHeadingDisplayed(), "Operations Hub heading is not displayed");
		softAssert.assertTrue(menuScreen.isParkingCitationButtonDisplayed(),
				"Parking Citation button is not displayed");
		softAssert.assertTrue(menuScreen.isParkingCitationButtonEnabled(), "Parking Citation button is not enabled");
		softAssert.assertTrue(menuScreen.isParkingCitationButtonClickable(),
				"Parking Citation button is not clickable");
		softAssert.assertTrue(menuScreen.isTrespassNoticesButtonDisplayed(),
				"Trespass Notices button is not displayed");
		softAssert.assertTrue(menuScreen.isTrespassNoticesButtonEnabled(), "Trespass Notices button is not enabled");
		softAssert.assertTrue(menuScreen.isTrespassNoticesButtonClickable(),
				"Trespass Notices button is not clickable");
		softAssert.assertTrue(menuScreen.isFieldInterviewsButtonDisplayed(),
				"Field Interviews button is not displayed");
		softAssert.assertTrue(menuScreen.isFieldInterviewsButtonEnabled(), "Field Interviews button is not enabled");
		softAssert.assertTrue(menuScreen.isFieldInterviewsButtonClickable(),
				"Field Interviews button is not clickable");
		softAssert.assertTrue(menuScreen.isIncidentReportsButtonDisplayed(),
				"Incident Reports button is not displayed");
		softAssert.assertTrue(menuScreen.isIncidentReportsButtonEnabled(), "Incident Reports button is not enabled");
		softAssert.assertTrue(menuScreen.isIncidentReportsButtonClickable(),
				"Incident Reports button is not clickable");
		softAssert.assertTrue(menuScreen.isCallsButtonDisplayed(), "Calls button is not displayed");
		softAssert.assertTrue(menuScreen.isCallsButtonEnabled(), "Calls button is not enabled");
		softAssert.assertTrue(menuScreen.isCallsButtonClickable(), "Calls button is not clickable");
		softAssert.assertTrue(menuScreen.isMessageOfTheWeekButtonDisplayed(),
				"Message of the Week button is not displayed");
		softAssert.assertTrue(menuScreen.isMessageOfTheWeekButtonEnabled(),
				"Message of the Week button is not enabled");
		softAssert.assertTrue(menuScreen.isMessageOfTheWeekButtonClickable(),
				"Message of the Week button is not clickable");

		// Schedule
		softAssert.assertTrue(menuScreen.isScheduleHeadingDisplayed(), "Schedule heading is not displayed");
		softAssert.assertTrue(menuScreen.isMyScheduleButtonDisplayed(), "My Schedule button is not displayed");
		softAssert.assertTrue(menuScreen.isMyScheduleButtonEnabled(), "My Schedule button is not enabled");
		softAssert.assertTrue(menuScreen.isMyScheduleButtonClickable(), "My Schedule button is not clickable");

		// Support & About
		softAssert.assertTrue(menuScreen.isSupportAndAboutHeadingDisplayed(),
				"Support & About heading is not displayed");
		softAssert.assertTrue(menuScreen.isTermsAndPoliciesButtonDisplayed(),
				"Terms and Policies button is not displayed");
		softAssert.assertTrue(menuScreen.isTermsAndPoliciesButtonEnabled(), "Terms and Policies button is not enabled");
		softAssert.assertTrue(menuScreen.isTermsAndPoliciesButtonClickable(),
				"Terms and Policies button is not clickable");

		// Font Size
		softAssert.assertTrue(menuScreen.isFontSizeTextDisplayed(), "Font Size text is not displayed");
		softAssert.assertTrue(menuScreen.isSmallFontSizeOptionDisplayed(), "Small font size option is not displayed");
		softAssert.assertTrue(menuScreen.isMediumFontSizeOptionDisplayed(), "Medium font size option is not displayed");
		softAssert.assertTrue(menuScreen.isLargeFontSizeOptionDisplayed(), "Large font size option is not displayed");

		// Theme Mode
		softAssert.assertTrue(menuScreen.isThemeModeHeadingDisplayed(), "Theme Mode heading is not displayed");
		softAssert.assertTrue(menuScreen.isLightModeOptionDisplayed(), "Light Mode option is not displayed");
		softAssert.assertTrue(menuScreen.isDarkModeOptionDisplayed(), "Dark Mode option is not displayed");
		softAssert.assertTrue(menuScreen.isRedModeOptionDisplayed(), "Red Mode option is not displayed");

		// Logout
		softAssert.assertTrue(menuScreen.isLogoutButtonDisplayed(), "Logout button is not displayed");
		softAssert.assertTrue(menuScreen.isLogoutButtonEnabled(), "Logout button is not enabled");
		softAssert.assertTrue(menuScreen.isLogoutButtonClickable(), "Logout button is not clickable");

		softAssert.assertAll();
	}

}
