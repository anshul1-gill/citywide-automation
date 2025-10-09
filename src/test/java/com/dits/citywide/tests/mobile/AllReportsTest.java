package com.dits.citywide.tests.mobile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.basetest.BaseMobileTest;
import com.dits.citywide.constants.MobileConstants;
import com.dits.citywide.mobile.HomeScreen;
import com.dits.citywide.mobile.LoginScreen;
import com.dits.citywide.mobile.ReportsScreen;

public class AllReportsTest extends BaseMobileTest {

	HomeScreen homeScreen;
	ReportsScreen reportsScreen;

	@BeforeMethod
	public void login() throws InterruptedException {
		LoginScreen loginScreen = new LoginScreen(driver);
		reportsScreen = new ReportsScreen(driver);
		loginScreen.searchAndProceed(MobileConstants.ORG_NAME);
		homeScreen = loginScreen.login(prop.getProperty("employeeID"), prop.getProperty("employeePassword"));
	}

	@Test(description = "Verify All Reports tab functionality")
	public void allReportsTest() throws InterruptedException {
		homeScreen.handleMessageOfTheWeek();
		reportsScreen = homeScreen.clickOnReportsTab();
		softAssert.assertTrue(reportsScreen.isReportsHeadingDisplayed(), "Reports screen is not displayed");
		reportsScreen.clickOnAllReportsTab();
		softAssert.assertTrue(reportsScreen.isSearchBoxInAllReportsTabDisplayed(),
				"Search box in All Reports tab is not displayed");
		reportsScreen.enterTextInSearchBox("10-17");
		softAssert.assertTrue(reportsScreen.isAddReportButtonInAllReportsTabDisplayed(),
				"Add Report button in All Reports tab is not displayed");
		Thread.sleep(2000);
		reportsScreen.tapFilterButton();
		softAssert.assertTrue(reportsScreen.isSelectDateRangeTextDisplayed(),
				"Select Date Range text is not displayed");
		reportsScreen.tapClearAllFiltersButton();
		reportsScreen.tapSearchAllFiltersButton();

		softAssert.assertAll();
	}

}
