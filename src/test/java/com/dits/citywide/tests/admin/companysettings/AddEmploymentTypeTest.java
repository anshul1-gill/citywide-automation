package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddEmploymentTypeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addEmploymentTypeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnEmploymentTypeTab();
		hrConfigurationsPage.clickOnAddEmploymentTypeButton();
		hrConfigurationsPage.fillAddEmploymentTypeForm(CompanySettingsConstant.EMPLOYMENT_TYPE_NAME);
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.ADD_EMPLOYMENT_TYPE_SUCCESS_MESSAGE,
				"Employment Type was not added successfully");
		softAssert.assertEquals(hrConfigurationsPage.getEmploymentTypeData(),
				CompanySettingsConstant.EMPLOYMENT_TYPE_NAME, "Employment Type data does not match the expected value");

		softAssert.assertAll();
	}

}
