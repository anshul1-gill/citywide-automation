package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddAgencyTypeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addAgencyTypeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		respondingAgenciesPage = companySettingsPage.clickRespondingAgenciesLink();
		softAssert.assertTrue(respondingAgenciesPage.isRespondingAgenciesPageVisible(),
				"Responding Agencies page is not visible");
		softAssert.assertTrue(respondingAgenciesPage.isAddAgencyTypeButtonVisible(),
				"Add Agency Type button is not visible");
		respondingAgenciesPage.clickAddAgencyTypeButton();
		respondingAgenciesPage.fillAddAgencyTypeForm(CompanySettingsConstant.AGENCY_TYPE_NAME);
		softAssert.assertEquals(respondingAgenciesPage.getSuccessMessage(),
				CompanySettingsConstant.ADD_AGENCY_TYPE_SUCCESS_MESSAGE,
				"Add Agency Type success message is not as expected");
		
		softAssert.assertAll();
	}

}
