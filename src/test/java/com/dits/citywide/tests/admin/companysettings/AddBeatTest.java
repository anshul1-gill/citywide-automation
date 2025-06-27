package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddBeatTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addBeatTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		beatsPage = companySettingsPage.clickBeatsLink();
		beatsPage.clickAddNewBeatsButton();
		beatsPage.fillAddNewBeatsForm(CompanySettingsConstant.BEAT_ID, CompanySettingsConstant.BEAT_NAME,
				CompanySettingsConstant.SHIFT_TYPE, CompanySettingsConstant.NUMBER_OF_SITES);
		beatsPage.clickSubmitAddBeatButton();

		softAssert.assertTrue(beatsPage.isBeatsPageVisible(), "Beats page is not displayed.");
		softAssert.assertTrue(beatsPage.isAddNewBeatsButtonVisible(), "Add New Beats button is not visible.");

		softAssert.assertEquals(beatsPage.getDataBeatId(),
				CompanySettingsConstant.BEAT_ID + " - " + CompanySettingsConstant.BEAT_NAME, "Beat ID does not match.");
		softAssert.assertEquals(beatsPage.getDataShiftType(), CompanySettingsConstant.SHIFT_TYPE,
				"Shift Type does not match.");
		beatsPage.clickViewSiteButton();
		softAssert.assertTrue(beatsPage.getDataSiteName().contains(CompanySettingsConstant.NUMBER_OF_SITES),
				"Site name does not contain expected partial text.");

		softAssert.assertAll();
	}

}
