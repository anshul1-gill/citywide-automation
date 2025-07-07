package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateDepartmentTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void testUpdateDepartment() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnDepartmentTab();
		softAssert.assertTrue(hrConfigurationsPage.isAddDepartmentButtonVisible(),
				"Add Department button is not visible");
		hrConfigurationsPage.clickEditDepartmentButton(CompanySettingsConstant.DEPARTMENT_NAME);
		softAssert.assertTrue(hrConfigurationsPage.updateDepartmentButtonVisible(),
				"Update Department button is not visible");
		hrConfigurationsPage.updateDepartmentName(CompanySettingsConstant.DEPARTMENT_UPDATED_NAME);
		hrConfigurationsPage.clickOnDepartmentTab();
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.DEPARTMENT_UPDATE_SUCCESS_MESSAGE, "Department was not updated successfully");

		softAssert.assertAll();
	}

}
