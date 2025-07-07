package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddAllowanceTypeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addAllowanceTypeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnAllowanceTypeTab();
		hrConfigurationsPage.clickOnAddAllowanceTypeButton();
		hrConfigurationsPage.fillAddAllowanceTypeForm(CompanySettingsConstant.ALLOWANCE_TYPE_NAME);
		softAssert.assertEquals(hrConfigurationsPage.getSuccessMessage(),
				CompanySettingsConstant.ADD_ALLOWANCE_TYPE_SUCCESS_MESSAGE,
				"Allowance Type was not added successfully");
		hrConfigurationsPage.clickOnAllowanceTypeTab();
		softAssert.assertEquals(hrConfigurationsPage.getAllowanceTypeData(),
				CompanySettingsConstant.ALLOWANCE_TYPE_NAME, "Allowance Type data does not match the expected value");

		softAssert.assertAll();
	}

}
