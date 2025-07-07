package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeletedAllowanceTypeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteAllowanceTypeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnAllowanceTypeTab();
		softAssert.assertTrue(hrConfigurationsPage.isAllowanceTypeHeadingVisible(),
				"Allowance Type heading is not visible");
		hrConfigurationsPage.deleteAllowanceType(CompanySettingsConstant.ALLOWANCE_TYPE_UPDATED_NAME);
		hrConfigurationsPage.clickOkDeleteButton();
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.ALLOWANCE_TYPE_DELETE_SUCCESS_MESSAGE,
				"Allowance Type was not deleted successfully");

		softAssert.assertAll();
	}

}
