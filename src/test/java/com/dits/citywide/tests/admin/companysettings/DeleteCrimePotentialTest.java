package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteCrimePotentialTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteCrimePotentialTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		violationsPage = companySettingsPage.clickViolationsLink();
		softAssert.assertTrue(violationsPage.isViolationsPageVisible());
		violationsPage.clickCrimeTab();
		violationsPage.clickDeleteCrimeButton(CompanySettingsConstant.CRIME_EDIT_NAME);
		violationsPage.clickOkDeleteBreakButton();
		softAssert.assertEquals(violationsPage.getSuccessMessage(), CompanySettingsConstant.DELETE_CRIME_SUCCESS_MESSAGE, "Crime Potential deleted successfully");
		softAssert.assertAll();
	}
}
