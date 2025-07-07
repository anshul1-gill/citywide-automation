package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateAgencyTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateAgencyTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		respondingAgenciesPage = companySettingsPage.clickRespondingAgenciesLink();
		softAssert.assertTrue(respondingAgenciesPage.isRespondingAgenciesPageVisible(),
				"Responding Agencies page is not visible");
		respondingAgenciesPage.clickAgenciesTab();
		respondingAgenciesPage.clickEditAgencyButton(CompanySettingsConstant.AGENCY_NAME);

		respondingAgenciesPage.fillUpdateAgencyForm(CompanySettingsConstant.AGENCY_TYPE_UPDATED,
				CompanySettingsConstant.AGENCY_NAME_UPDATED, CompanySettingsConstant.AGENCY_CONTACT_NUMBER_UPDATED,
				CompanySettingsConstant.AGENCY_ALTERNATE_PHONE_NUMBER_UPDATED,
				CompanySettingsConstant.AGENCY_LIAISON_OFFICER_UPDATED);
		respondingAgenciesPage.clickUpdateButton();
		softAssert.assertEquals(respondingAgenciesPage.getSuccessMessage(),
				CompanySettingsConstant.UPDATE_AGENCY_SUCCESS_MESSAGE, "Agency was not updated successfully");
		softAssert.assertEquals(respondingAgenciesPage.getAgencyName(), CompanySettingsConstant.AGENCY_NAME_UPDATED,
				"Updated agency name does not match");
		softAssert.assertEquals(respondingAgenciesPage.getAgencyType(), CompanySettingsConstant.AGENCY_TYPE_UPDATED,
				"Updated agency type does not match");

		softAssert.assertAll();
	}

}
