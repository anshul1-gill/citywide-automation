package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteFederalHolidayTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteFederalHolidayTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		holidaysPage = companySettingsPage.clickHolidaysLink();
		holidaysPage.clickDeleteHolidayButton(CompanySettingsConstant.HOLIDAY_EDIT_NAME);

		softAssert.assertEquals(holidaysPage.getDeleteConfirmationMessage(),
				CompanySettingsConstant.DELETE_HOLIDAY_CONFIRMATION_MESSAGE,
				"Delete holiday confirmation message is not displayed");
		holidaysPage.doClickOkDeleteHolidayButton();
		softAssert.assertTrue(holidaysPage.isDeleteSuccessMessageDisplayed(),
				"Federal holiday is not deleted successfully");

		softAssert.assertAll();
	}

}
