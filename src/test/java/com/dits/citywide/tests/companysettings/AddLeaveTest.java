package com.dits.citywide.tests.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddLeaveTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addLeaveTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		leavesPage = companySettingsPage.clickLeavesLink();
		leavesPage.clickAddLeaveButton();
		leavesPage.fillLeaveForm(CompanySettingsConstant.LEAVE_NAME, CompanySettingsConstant.NUMBER_OF_DAYS,
				CompanySettingsConstant.LEAVE_DESCRIPTION);
		leavesPage.submitLeaveForm();

		softAssert.assertTrue(leavesPage.isAddLeaveButtonVisible(), "Add Leave button is not visible.");
		softAssert.assertEquals(leavesPage.getDataLeaveName(), CompanySettingsConstant.LEAVE_NAME,
				"Leave name does not match.");
		softAssert.assertEquals(leavesPage.getDataNumberOfDays(), CompanySettingsConstant.NUMBER_OF_DAYS,
				"Number of days does not match.");
		softAssert.assertEquals(leavesPage.getDataDescription(), CompanySettingsConstant.LEAVE_DESCRIPTION,
				"Leave description does not match.");

		softAssert.assertTrue(leavesPage.isLeavesPageHeaderVisible(), "Leaves page header is not visible.");

		softAssert.assertAll();
	}

}
