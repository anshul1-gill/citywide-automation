package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteBeatTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteBeatTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		beatsPage = companySettingsPage.clickBeatsLink();
		beatsPage.clickDeleteBeatButton(CompanySettingsConstant.BEAT_EDIT_ID);
		beatsPage.clickOkDeleteBreakButton();
		softAssert.assertEquals(beatsPage.getDeleteSuccessMessage(),
				CompanySettingsConstant.DELETED_BEAT_SUCCESS_MESSAGE);
		softAssert.assertTrue(beatsPage.isBeatsPageVisible(), "Beats page is not displayed.");
		softAssert.assertTrue(beatsPage.isAddNewBeatsButtonVisible(), "Add New Beats button is not visible.");
		softAssert.assertAll();
	}

}
