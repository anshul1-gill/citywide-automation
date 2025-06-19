package com.dits.citywide.tests.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateLeaveTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateLeaveTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		leavesPage = companySettingsPage.clickLeavesLink();
		leavesPage.clickEditHolidayButton(CompanySettingsConstant.LEAVE_NAME);
		softAssert.assertTrue(leavesPage.isUpdateLeaveHeaderVisible(), "Update Leave header is not visible.");
		leavesPage.updateLeaveForm(CompanySettingsConstant.LEAVE_EDIT_NAME,
				CompanySettingsConstant.LEAVE_EDIT_NUMBER_OF_DAYS, CompanySettingsConstant.LEAVE_EDIT_DESCRIPTION);
		leavesPage.submitUpdateLeaveForm();

		softAssert.assertTrue(leavesPage.isLeavesPageHeaderVisible(), "Leaves page header is not visible.");
		softAssert.assertEquals(leavesPage.getDataLeaveName(), CompanySettingsConstant.LEAVE_EDIT_NAME,
				"Updated leave name does not match.");
		softAssert.assertEquals(leavesPage.getDataNumberOfDays(), CompanySettingsConstant.LEAVE_EDIT_NUMBER_OF_DAYS,
				"Number of days does not match.");
		softAssert.assertEquals(leavesPage.getDataDescription(), CompanySettingsConstant.LEAVE_EDIT_DESCRIPTION,
				"Updated leave description does not match.");

		softAssert.assertAll();
	}

}
