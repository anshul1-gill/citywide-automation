package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteViolationTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteViolationTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		violationsPage = companySettingsPage.clickViolationsLink();
		violationsPage.clickDeleteViolationButton(CompanySettingsConstant.VIOLATION_EDIT_NAME);
		violationsPage.clickOkDeleteBreakButton();
		softAssert.assertEquals(violationsPage.getSuccessMessage(),
				CompanySettingsConstant.DELETE_VIOLATION_SUCCESS_MESSAGE,
				"Delete Violation Success Message does not match");

		softAssert.assertAll("Delete Violation Test Failed");
	}

}
