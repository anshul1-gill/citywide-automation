package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateAllowanceTypeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateAllowanceTypeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnAllowanceTypeTab();
		softAssert.assertTrue(hrConfigurationsPage.isAllowanceTypeHeadingVisible(),
				"Allowance Type heading is not visible");
		hrConfigurationsPage.clickEditAllowanceTypeButton(CompanySettingsConstant.ALLOWANCE_TYPE_NAME);
		softAssert.assertTrue(hrConfigurationsPage.updateAllownaceButtonVisible(),
				"Allowance Type form is not visible for editing");
		hrConfigurationsPage.updateAllowanceType(CompanySettingsConstant.ALLOWANCE_TYPE_UPDATED_NAME);

		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.ALLOWANCE_TYPE_UPDATE_SUCCESS_MESSAGE,
				"Allowance Type was not updated successfully");
		hrConfigurationsPage.clickOnAllowanceTypeTab();
		softAssert.assertEquals(hrConfigurationsPage.getAllowanceTypeData(),
				CompanySettingsConstant.ALLOWANCE_TYPE_UPDATED_NAME,
				"Allowance Type data does not match the expected value");

		softAssert.assertAll();
	}

}
