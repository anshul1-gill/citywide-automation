package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddWCClassCodeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addWCClassCodeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnWCClassCodeTab();
		hrConfigurationsPage.clickOnAddWCClassCodeButton();
		hrConfigurationsPage.fillAddWCClassCodeForm(CompanySettingsConstant.WC_CLASS_CODE_NAME);
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.ADD_WC_CLASS_CODE_SUCCESS_MESSAGE, "WC Class Code was not added successfully");
		softAssert.assertEquals(hrConfigurationsPage.getWCClassCodeData(), CompanySettingsConstant.WC_CLASS_CODE_NAME,
				"WC Class Code data does not match the expected value");

		softAssert.assertAll();
	}

}
