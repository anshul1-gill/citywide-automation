package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteBreakTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteBreakTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		breaksPage = companySettingsPage.clickBreaksLink();
		breaksPage.clickDeleteBreakButton(CompanySettingsConstant.BREAK_EDIT_NAME);
		softAssert.assertTrue(breaksPage.isDeleteConfirmationMessageDisplayed(),
				"Delete confirmation message is not displayed. Please check the details.");
		breaksPage.clickOkDeleteBreakButton();
		softAssert.assertTrue(breaksPage.isBreakDeletedSuccessfully(),
				"Break was not deleted successfully. Please check the details.");
		softAssert.assertAll();

	}

}
