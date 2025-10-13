package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateEmploymentTypeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateEmploymentTypeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnEmploymentTypeTab();
		hrConfigurationsPage.clickEditEmploymentTypeButton(CompanySettingsConstant.EMPLOYMENT_TYPE_NAME);
		softAssert.assertTrue(hrConfigurationsPage.isUpdateEmploymentTypeButtonVisible(),
				"Update Employment Type button is not visible");
		hrConfigurationsPage.updateEmploymentType(CompanySettingsConstant.EMPLOYMENT_TYPE_EDIT_NAME);
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.EMPLOYMENT_TYPE_UPDATE_SUCCESS_MESSAGE,
				"Employment Type was not updated successfully");
		softAssert.assertEquals(hrConfigurationsPage.getEmploymentTypeData(), CompanySettingsConstant.EMPLOYMENT_TYPE_EDIT_NAME,
				"Employment Type data does not match the expected value");

		softAssert.assertAll();
	}

}
