package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddChargesTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addChargesTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		violationsPage = companySettingsPage.clickViolationsLink();
		softAssert.assertTrue(violationsPage.isViolationsPageVisible());
		violationsPage.clickChargesTab();
		softAssert.assertTrue(violationsPage.isAddNewChargesButtonVisible());
		violationsPage.clickAddNewChargesButton();
		  violationsPage.fillAddNewChargesForm(CompanySettingsConstant.CHARGE_CODE,
		  CompanySettingsConstant.CHARGE_DESCRIPTION);
		  violationsPage.clickSaveButton();
			softAssert.assertEquals(violationsPage.getSuccessMessage(), CompanySettingsConstant.ADD_CHARGE_SUCCESS_MESSAGE,
					"Charges added successfully");
		softAssert.assertEquals(violationsPage.getChargesName(), CompanySettingsConstant.CHARGE_CODE);
		softAssert.assertEquals(violationsPage.getChargesDescription(), CompanySettingsConstant.CHARGE_DESCRIPTION);
	
	
		softAssert.assertAll();
	}

}