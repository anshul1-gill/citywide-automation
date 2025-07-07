package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteWCClassCodeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteWCClassCodeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnWCClassCodeTab();
		hrConfigurationsPage.clickDeleteWCClassCodeButton(CompanySettingsConstant.WC_CLASS_CODE_UPDATED_NAME);
		hrConfigurationsPage.confirmDeleteWCClassCode();
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.WC_CLASS_CODE_DELETE_SUCCESS_MESSAGE,
				"WC Class Code was not deleted successfully");

		softAssert.assertAll();
	}

}
