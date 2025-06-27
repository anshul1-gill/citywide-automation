package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateViolationTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateViolationTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		violationsPage = companySettingsPage.clickViolationsLink();
		violationsPage.clickEditViolationButton(CompanySettingsConstant.VIOLATION_NAME);
		violationsPage.updateViolation(CompanySettingsConstant.VIOLATION_EDIT_NAME,
				CompanySettingsConstant.VIOLATION_EDIT_DESCRIPTION, CompanySettingsConstant.VIOLATION_EDIT_BRANCH);
		violationsPage.clickUpdateViolationButton();

		softAssert.assertEquals(violationsPage.getSuccessMessage(),
				CompanySettingsConstant.UPDATE_VIOLATION_SUCCESS_MESSAGE,
				"Update Violation Success Message does not match");

		softAssert.assertEquals(violationsPage.getViolationName(), CompanySettingsConstant.VIOLATION_EDIT_NAME,
				"Violation name does not match after update");
		softAssert.assertEquals(violationsPage.getViolationDescription(),
				CompanySettingsConstant.VIOLATION_EDIT_DESCRIPTION,
				"Violation description does not match after update");

		softAssert.assertAll("Update Violation Test Failed");
	}

}
