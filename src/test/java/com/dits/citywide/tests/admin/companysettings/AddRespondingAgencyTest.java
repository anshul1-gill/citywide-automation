package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddRespondingAgencyTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addRespondingAgencyTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		respondingAgenciesPage = companySettingsPage.clickRespondingAgenciesLink();
		softAssert.assertTrue(respondingAgenciesPage.isRespondingAgenciesPageVisible(),
				"Responding Agencies page is not visible");
		respondingAgenciesPage.clickAgenciesTab();
		softAssert.assertTrue(respondingAgenciesPage.isAddAgencyButtonVisible(), "Add Agency button is not visible");
		respondingAgenciesPage.clickAddAgencyButton();
		respondingAgenciesPage.fillAddAgencyForm(CompanySettingsConstant.AGENCY_TYPE,
				CompanySettingsConstant.AGENCY_NAME, CompanySettingsConstant.AGENCY_CONTACT_NUMBER,
				CompanySettingsConstant.AGENCY_ALTERNATE_PHONE_NUMBER, CompanySettingsConstant.AGENCY_LIAISON_OFFICER);
		respondingAgenciesPage.clickSaveButton();
		softAssert.assertEquals(respondingAgenciesPage.getSuccessMessage(),
				CompanySettingsConstant.ADD_AGENCY_SUCCESS_MESSAGE, "Agency was not added successfully");
		softAssert.assertEquals(respondingAgenciesPage.getAgencyName(), CompanySettingsConstant.AGENCY_NAME,
				"Agency name does not match");
		softAssert.assertEquals(respondingAgenciesPage.getAgencyType(), CompanySettingsConstant.AGENCY_TYPE,
				"Agency type does not match");

		softAssert.assertAll();

	}
}
