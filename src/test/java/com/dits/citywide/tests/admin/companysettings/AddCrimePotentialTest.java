package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddCrimePotentialTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addCrimePotentialTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		violationsPage = companySettingsPage.clickViolationsLink();
		softAssert.assertTrue(violationsPage.isViolationsPageVisible());
		violationsPage.clickCrimeTab();
		softAssert.assertTrue(violationsPage.isAddNewCrimeButtonVisible());
		violationsPage.clickAddNewCrimeButton();
		violationsPage.fillAddNewCrimeForm(CompanySettingsConstant.CRIME_NAME, CompanySettingsConstant.CRIME_DESCRIPTION);
		violationsPage.clickSaveCrimeButton();
		softAssert.assertEquals(violationsPage.getSuccessMessage(), CompanySettingsConstant.ADD_CRIME_SUCCESS_MESSAGE, "Crime Potential added successfully");
		softAssert.assertEquals(violationsPage.getCrimeName(), CompanySettingsConstant.CRIME_NAME);
		softAssert.assertEquals(violationsPage.getCrimeDescription(), CompanySettingsConstant.CRIME_DESCRIPTION);
		softAssert.assertAll();
	}
}
