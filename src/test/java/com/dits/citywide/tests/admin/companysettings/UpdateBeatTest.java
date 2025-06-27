package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateBeatTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateBeatTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		beatsPage = companySettingsPage.clickBeatsLink();
		beatsPage.clickEditBeatButton(CompanySettingsConstant.BEAT_ID);
		beatsPage.updateBeat(CompanySettingsConstant.BEAT_EDIT_ID, CompanySettingsConstant.BEAT_EDIT_NAME,
				CompanySettingsConstant.BEAT_EDIT_SHIFT_TYPE, CompanySettingsConstant.BEAT_EDIT_NUMBER_OF_SITES);
		beatsPage.clickUpdateBeatButton();

		softAssert.assertTrue(beatsPage.isBeatsPageVisible(), "Beats page is not displayed.");
		softAssert.assertTrue(beatsPage.isAddNewBeatsButtonVisible(), "Add New Beats button is not visible.");

		softAssert.assertEquals(beatsPage.getDataBeatId(),
				CompanySettingsConstant.BEAT_EDIT_ID + " - " + CompanySettingsConstant.BEAT_EDIT_NAME,
				"Beat ID does not match.");
		softAssert.assertEquals(beatsPage.getDataShiftType(), CompanySettingsConstant.BEAT_EDIT_SHIFT_TYPE,
				"Shift Type does not match.");
		beatsPage.clickViewSiteButton();
		softAssert.assertTrue(beatsPage.getDataSiteName().contains(CompanySettingsConstant.BEAT_EDIT_NUMBER_OF_SITES),
				"Site name does not contain expected partial text.");

		softAssert.assertAll();
	}

}
