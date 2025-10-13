package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddDepartmentTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void testAddDepartment() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnDepartmentTab();
		softAssert.assertTrue(hrConfigurationsPage.isAddDepartmentButtonVisible(),
				"Add Department button is not visible");
		hrConfigurationsPage.clickOnAddDepartmentButton();
		hrConfigurationsPage.fillAddDepartmentForm(CompanySettingsConstant.DEPARTMENT_NAME);
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.ADD_DEPARTMENT_SUCCESS_MESSAGE, "Department was not added successfully");
		hrConfigurationsPage.clickOnDepartmentTab();
		softAssert.assertEquals(hrConfigurationsPage.getDepartmentNameData(), CompanySettingsConstant.DEPARTMENT_NAME,
				"Department name does not match");

		softAssert.assertAll();
	}

}
