package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteRespondingAgencyTypeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteRespondingAgencyTypeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		respondingAgenciesPage = companySettingsPage.clickRespondingAgenciesLink();
		softAssert.assertTrue(respondingAgenciesPage.isRespondingAgenciesPageVisible(),
				"Responding Agencies page is not visible");
		respondingAgenciesPage.clickDeleteAgencyTypeButton(CompanySettingsConstant.AGENCY_TYPE_NAME_UPDATED);
		respondingAgenciesPage.clickOkDeleteButton();
		softAssert.assertEquals(respondingAgenciesPage.getSuccessMessage(),
				CompanySettingsConstant.DELETE_AGENCY_TYPE_SUCCESS_MESSAGE,
				"Delete Agency Type success message is not as expected");

		softAssert.assertAll();
	}

}
