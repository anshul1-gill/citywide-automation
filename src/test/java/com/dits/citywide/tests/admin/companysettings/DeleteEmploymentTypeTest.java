package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteEmploymentTypeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteEmploymentTypeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnEmploymentTypeTab();
		hrConfigurationsPage.clickDeleteEmploymentTypeButton(CompanySettingsConstant.EMPLOYMENT_TYPE_EDIT_NAME);
		hrConfigurationsPage.confirmDeleteEmploymentType();
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.EMPLOYMENT_TYPE_DELETE_SUCCESS_MESSAGE,
				"Employment Type was not deleted successfully");

		softAssert.assertAll();
	}

}
