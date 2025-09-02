package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateBreakTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateBreakTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		breaksPage = companySettingsPage.clickBreaksLink();
		breaksPage.clickEditBreakButton(CompanySettingsConstant.BREAK_NAME);
		breaksPage.updateBreakForm(CompanySettingsConstant.BREAK_EDIT_NAME, CompanySettingsConstant.BREAK_EDIT_DURATION,
				CompanySettingsConstant.PAYMENT_EDIT_TYPE, CompanySettingsConstant.ACTIVITY_EDIT_CODE,
				CompanySettingsConstant.BREAK_EDIT_DESCRIPTION);

		softAssert.assertTrue(breaksPage.isBreaksPageDisplayed(),
				"Break was not updated successfully. Please check the details.");

		softAssert.assertEquals(breaksPage.getDataBreakName(), CompanySettingsConstant.BREAK_EDIT_NAME,
				"Break name does not match. Please check the details.");
		softAssert.assertEquals(breaksPage.getDataBreakDuration(), CompanySettingsConstant.BREAK_EDIT_DURATION,
				"Break duration does not match. Please check the details.");
		softAssert.assertEquals(breaksPage.getDataBreakPaymentType(), CompanySettingsConstant.PAYMENT_EDIT_TYPE,
				"Break payment type does not match. Please check the details.");
		softAssert.assertEquals(breaksPage.getDataBreakDescription(), CompanySettingsConstant.BREAK_EDIT_DESCRIPTION,
				"Break description does not match. Please check the details.");
		softAssert.assertAll();
	}
}
