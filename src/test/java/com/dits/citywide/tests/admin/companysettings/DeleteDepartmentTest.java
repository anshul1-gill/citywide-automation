package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteDepartmentTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void testDeleteDepartment() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnDepartmentTab();

		hrConfigurationsPage.clickDeleteDepartmentButton(CompanySettingsConstant.DEPARTMENT_UPDATED_NAME);
		hrConfigurationsPage.clickOkDeleteDepartmentButton();
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.DEPARTMENT_DELETE_SUCCESS_MESSAGE, "Department was not deleted successfully");

		softAssert.assertAll();
	}

}
