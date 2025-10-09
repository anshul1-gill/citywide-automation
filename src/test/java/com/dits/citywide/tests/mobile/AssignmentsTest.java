package com.dits.citywide.tests.mobile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.basetest.BaseMobileTest;
import com.dits.citywide.constants.MobileConstants;
import com.dits.citywide.mobile.HomeScreen;
import com.dits.citywide.mobile.LoginScreen;
import com.dits.citywide.mobile.ReportsScreen;

public class AssignmentsTest extends BaseMobileTest {

	HomeScreen homeScreen;
	ReportsScreen reportsScreen;

	@BeforeMethod
	public void login() throws InterruptedException {
		LoginScreen loginScreen = new LoginScreen(driver);
		reportsScreen = new ReportsScreen(driver);
		loginScreen.searchAndProceed(MobileConstants.ORG_NAME);
		homeScreen = loginScreen.login(prop.getProperty("employeeID"), prop.getProperty("employeePassword"));
	}

	@Test
	public void myReportsTest() throws InterruptedException {
		homeScreen.handleMessageOfTheWeek();
		reportsScreen = homeScreen.clickOnReportsTab();
		reportsScreen.clickOnAssignmentsTab();
		reportsScreen.enterTextInSearchBox("Pending");
		Thread.sleep(2000);
		reportsScreen.tapFirstAssignmentTile();
		reportsScreen.fillAssignmentReportForm(MobileConstants.SITE_NAME, MobileConstants.ACTIVITY_CODE,
				MobileConstants.CALL_ID, MobileConstants.ADDRESS, MobileConstants.REPORT_DESCRIPTION);
		reportsScreen.tapCancelReportButton();
	}

}
