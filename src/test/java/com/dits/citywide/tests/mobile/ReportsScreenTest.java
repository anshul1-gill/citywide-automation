package com.dits.citywide.tests.mobile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.basetest.BaseMobileTest;
import com.dits.citywide.constants.MobileConstants;
import com.dits.citywide.mobile.HomeScreen;
import com.dits.citywide.mobile.LoginScreen;
import com.dits.citywide.mobile.ReportsScreen;

public class ReportsScreenTest extends BaseMobileTest {

	HomeScreen homeScreen;
	ReportsScreen reportsScreen;

	@BeforeMethod
	public void login() {
		LoginScreen loginScreen = new LoginScreen(driver);
		reportsScreen = new ReportsScreen(driver);
		loginScreen.searchAndProceed(MobileConstants.ORG_NAME);
		homeScreen = loginScreen.login(prop.getProperty("employeeID"), prop.getProperty("employeePassword"));
	}

	@Test
	public void reportsScreenTest() {
		homeScreen.handleMessageOfTheWeek();
		reportsScreen = homeScreen.clickOnReportsTab();
		softAssert.assertTrue(reportsScreen.isReportsHeadingDisplayed(), "Reports heading is not displayed");
		softAssert.assertTrue(reportsScreen.isSearchBoxDisplayed(), "Search box is not displayed");
		softAssert.assertTrue(reportsScreen.isAssignmentsTabDisplayed(), "Assignments tab is not displayed");
		softAssert.assertTrue(reportsScreen.isAllReportsTabDisplayed(), "All Reports tab is not displayed");
		softAssert.assertTrue(reportsScreen.isMyReportsTabDisplayed(), "My Reports tab is not displayed");
		softAssert.assertTrue(reportsScreen.isMenuButtonDisplayed(), "Menu button is not displayed");
		reportsScreen.clickOnMenuButton();
		softAssert.assertTrue(reportsScreen.isSubmitReportButtonDisplayed(), "Submit Report button is not displayed");
		softAssert.assertTrue(reportsScreen.isPreFlightReportButtonDisplayed(),
				"Pre-Flight Report button is not displayed");
		softAssert.assertAll();
	}

}
