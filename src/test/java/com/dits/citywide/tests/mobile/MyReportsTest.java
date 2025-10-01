package com.dits.citywide.tests.mobile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.basetest.BaseMobileTest;
import com.dits.citywide.constants.MobileConstants;
import com.dits.citywide.mobile.HomeScreen;
import com.dits.citywide.mobile.LoginScreen;
import com.dits.citywide.mobile.ReportsScreen;

public class MyReportsTest extends BaseMobileTest {

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
	public void myReportsTest() throws InterruptedException {
		homeScreen.handleMessageOfTheWeek();
		reportsScreen = homeScreen.clickOnReportsTab();
		softAssert.assertTrue(reportsScreen.isReportsHeadingDisplayed(), "Reports screen is not displayed");
//		reportsScreen.clickOnMenuButton();
//		softAssert.assertTrue(reportsScreen.isPreFlightReportButtonDisplayed(),
//				"Pre-Flight Report button is not displayed");
//		reportsScreen.tapPreFlightReportButton();
//		softAssert.assertTrue(reportsScreen.isConfirmationMessageDisplayed(), "Confirmation message is not displayed");
//		reportsScreen.tapOkButton();
//		softAssert.assertTrue(reportsScreen.isMyReportsTabDisplayed(), "My Reports tab is not displayed");
		Thread.sleep(2000);
//		reportsScreen.slideFirstPreflightReport();
//		reportsScreen.tapEditReportButton();
//		softAssert.assertTrue(reportsScreen.isHeadingUpdateOfficerReportEntryDisplayed(),
//				"Update Officer Report Entry heading is not displayed");

		reportsScreen.tapAddNewReportButton();
		reportsScreen.fillReportForm(MobileConstants.SITE_NAME, MobileConstants.ACTIVITY_CODE, MobileConstants.CALL_ID,
				MobileConstants.ADDRESS, MobileConstants.REPORT_DESCRIPTION);
		softAssert.assertAll();
	}

}
