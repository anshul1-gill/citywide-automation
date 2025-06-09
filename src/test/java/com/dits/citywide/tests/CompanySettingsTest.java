package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class CompanySettingsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void companySettingsTest() {

		companySettingsPage = dashboardPage.doClickCompanySettingsTab();

		softAssert.assertTrue(companySettingsPage.isCompanyDetailsVisible(), "Company Details link is not visible");
		softAssert.assertTrue(companySettingsPage.isRiversideVisible(), "Riverside link is not visible");
		softAssert.assertTrue(companySettingsPage.isBranchListingVisible(), "Branch Listing link is not visible");
		softAssert.assertTrue(companySettingsPage.isServiceTypesVisible(), "Service Types link is not visible");
		softAssert.assertTrue(companySettingsPage.isRolesAndPermissionVisible(),
				"Roles & Permission link is not visible");
		softAssert.assertTrue(companySettingsPage.isRankOrPositionVisible(), "Rank/Position link is not visible");
		softAssert.assertTrue(companySettingsPage.isBreaksVisible(), "Breaks link is not visible");
		softAssert.assertTrue(companySettingsPage.isHolidaysVisible(), "Holidays link is not visible");
		softAssert.assertTrue(companySettingsPage.isLeavesVisible(), "Leaves link is not visible");
		softAssert.assertTrue(companySettingsPage.isActivityCodeVisible(), "Activity Code link is not visible");
		softAssert.assertTrue(companySettingsPage.isActivityTemplatesVisible(),
				"Activity Templates link is not visible");
		softAssert.assertTrue(companySettingsPage.isAssignmentTemplatesVisible(),
				"Assignment Templates link is not visible");
		softAssert.assertTrue(companySettingsPage.isViolationsVisible(), "Violations link is not visible");
		softAssert.assertTrue(companySettingsPage.isBeatsVisible(), "Beats link is not visible");
		softAssert.assertTrue(companySettingsPage.isMassEmailVisible(), "Mass Email link is not visible");
		softAssert.assertTrue(companySettingsPage.isSystemLogsVisible(), "System Logs link is not visible");
		softAssert.assertTrue(companySettingsPage.isNotificationsVisible(), "Notifications link is not visible");
		softAssert.assertTrue(companySettingsPage.isHRConfigurationsVisible(), "HR Configurations link is not visible");
		softAssert.assertTrue(companySettingsPage.isSystemConfigurationsVisible(),
				"System Configurations link is not visible");
		softAssert.assertTrue(companySettingsPage.isRespondingAgenciesVisible(),
				"Responding Agencies link is not visible");

		softAssert.assertAll();
	}

}
