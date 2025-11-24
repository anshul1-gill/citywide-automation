package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateCrimePotentialTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateCrimePotentialTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		violationsPage = companySettingsPage.clickViolationsLink();
		softAssert.assertTrue(violationsPage.isViolationsPageVisible());
		violationsPage.clickCrimeTab();
		violationsPage.clickEditCrimeButton(CompanySettingsConstant.CRIME_NAME);
		violationsPage.updateCrime(CompanySettingsConstant.CRIME_EDIT_NAME, CompanySettingsConstant.CRIME_EDIT_DESCRIPTION);
		violationsPage.clickUpdateCrimeButton();
		softAssert.assertEquals(violationsPage.getSuccessMessage(), CompanySettingsConstant.UPDATE_CRIME_SUCCESS_MESSAGE, "Crime Potential updated successfully");
		softAssert.assertEquals(violationsPage.getCrimeName(), CompanySettingsConstant.CRIME_EDIT_NAME);
		softAssert.assertEquals(violationsPage.getCrimeDescription(), CompanySettingsConstant.CRIME_EDIT_DESCRIPTION);
		softAssert.assertAll();
	}
}
