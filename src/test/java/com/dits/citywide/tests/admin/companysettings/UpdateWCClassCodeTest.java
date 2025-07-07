package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateWCClassCodeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateWCClassCodeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnWCClassCodeTab();
		hrConfigurationsPage.clickEditWCClassCodeButton(CompanySettingsConstant.WC_CLASS_CODE_NAME);
		softAssert.assertTrue(hrConfigurationsPage.isUpdateWCClassCodeButtonVisible(),
				"WC Class Code form is not displayed for editing");
		hrConfigurationsPage.updateWCClassCode(CompanySettingsConstant.WC_CLASS_CODE_UPDATED_NAME);
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.WC_CLASS_CODE_UPDATE_SUCCESS_MESSAGE,
				"WC Class Code was not updated successfully");
		softAssert.assertEquals(hrConfigurationsPage.getWCClassCodeData(),
				CompanySettingsConstant.WC_CLASS_CODE_UPDATED_NAME,
				"WC Class Code data does not match the expected value");

		softAssert.assertAll();
	}

}
