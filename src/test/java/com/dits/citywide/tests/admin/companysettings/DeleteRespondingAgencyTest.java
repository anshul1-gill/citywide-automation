package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteRespondingAgencyTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteRespondingAgencyTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		respondingAgenciesPage = companySettingsPage.clickRespondingAgenciesLink();
		softAssert.assertTrue(respondingAgenciesPage.isRespondingAgenciesPageVisible(),
				"Responding Agencies page is not visible");
		respondingAgenciesPage.clickAgenciesTab();
		respondingAgenciesPage.clickDeleteAgencyButton(CompanySettingsConstant.AGENCY_TYPE_UPDATED);
		respondingAgenciesPage.clickOkDeleteButton();
		softAssert.assertEquals(respondingAgenciesPage.getSuccessMessage(),
				CompanySettingsConstant.DELETE_AGENCY_SUCCESS_MESSAGE, "Agency was not deleted successfully");

		softAssert.assertAll();
	}

}
