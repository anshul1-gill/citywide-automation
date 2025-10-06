package com.dits.citywide.tests.mobile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.basetest.BaseMobileTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.MobileConstants;
import com.dits.citywide.mobile.HomeScreen;
import com.dits.citywide.mobile.LoginScreen;
import com.dits.citywide.mobile.ReportsScreen;

public class StartShiftFieldAgentAndroidTest extends BaseMobileTest {
	HomeScreen homeScreen;
	ReportsScreen reportsScreen;

	@BeforeMethod
	public void login() throws InterruptedException {
		LoginScreen loginScreen = new LoginScreen(driver);
		reportsScreen = new ReportsScreen(driver);
		loginScreen.searchAndProceed(MobileConstants.ORG_NAME);
		homeScreen = loginScreen.login(prop.getProperty("employeeID"), prop.getProperty("employeePassword"));
		// homeScreen = loginScreen.login("1001", prop.getProperty("employeePassword"));
	}

	@Test
	public void startShiftTest() throws InterruptedException {
		homeScreen.handleMessageOfTheWeek();
		softAssert.assertTrue(homeScreen.isOpenShiftsBoxDisplayed(), "Open Shifts box is not displayed");
		softAssert.assertTrue(homeScreen.isAssignedShiftsBoxDisplayed(), "Assigned Shifts box is not displayed");
		softAssert.assertTrue(homeScreen.isCompletedShiftsBoxDisplayed(), "Completed Shifts box is not displayed");
		softAssert.assertTrue(homeScreen.isConfirmAndRejectMultpleShiftButtonDisplayed(),
				"Confirm/Reject Multiple Shifts button is not displayed");
		homeScreen.tapStartShiftButton();
		softAssert.assertTrue(homeScreen.isWelcomeTextDisplayed(), "Welcome text is not displayed");
		softAssert.assertTrue(homeScreen.isDescriptionTextDisplayed(), "Description text is not displayed");
		softAssert.assertTrue(homeScreen.getSiteName().contains(HRManagementConstants.SITE),
				"Site name is not correct");
		reportsScreen = homeScreen.tapStartShift();
		softAssert.assertTrue(reportsScreen.isReportsHeadingDisplayed(), "Reports screen is not displayed");
		softAssert.assertAll();
	}

}
