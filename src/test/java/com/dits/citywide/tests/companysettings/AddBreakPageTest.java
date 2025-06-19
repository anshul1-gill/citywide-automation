package com.dits.citywide.tests.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddBreakPageTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addBreakPageTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		breaksPage = companySettingsPage.clickBreaksLink();
		breaksPage.doClickAddBreakButton();
		breaksPage.fillAddBreakForm(CompanySettingsConstant.BREAK_NAME, CompanySettingsConstant.BREAK_DURATION,
				CompanySettingsConstant.PAYMENT_TYPE, CompanySettingsConstant.ACTIVITY_CODE,
				CompanySettingsConstant.BREAK_DESCRIPTION);

		softAssert.assertTrue(breaksPage.isBreaksPageDisplayed(),
				"Break was not added successfully. Please check the details.");
		softAssert.assertEquals(breaksPage.getDataBreakName(), CompanySettingsConstant.BREAK_NAME,
				"Break name does not match. Please check the details.");
		softAssert.assertEquals(breaksPage.getDataBreakDuration(), CompanySettingsConstant.BREAK_DURATION,
				"Break duration does not match. Please check the details.");
		softAssert.assertEquals(breaksPage.getDataBreakPaymentType(), CompanySettingsConstant.PAYMENT_TYPE,
				"Break payment type does not match. Please check the details.");
		softAssert.assertEquals(breaksPage.getDataBreakDescription(), CompanySettingsConstant.BREAK_DESCRIPTION,
				"Break description does not match. Please check the details.");
		softAssert.assertAll();
	}

}
