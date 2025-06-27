package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteChargesTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteChargesTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		violationsPage = companySettingsPage.clickViolationsLink();
		violationsPage.clickChargesTab();
		violationsPage.clickDeleteViolationButton(CompanySettingsConstant.CHARGE_EDIT_CODE);
		violationsPage.clickOkDeleteBreakButton();
		softAssert.assertEquals(violationsPage.getSuccessMessage(),
				CompanySettingsConstant.DELETE_CHARGE_SUCCESS_MESSAGE, "Charges deleted successfully");

		softAssert.assertAll();
	}

}
