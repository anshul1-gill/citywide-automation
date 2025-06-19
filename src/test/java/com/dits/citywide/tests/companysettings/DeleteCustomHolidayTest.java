package com.dits.citywide.tests.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteCustomHolidayTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteCustomHolidayTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		holidaysPage = companySettingsPage.clickHolidaysLink();
		holidaysPage.clickDeleteHolidayButton(CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_NAME);
		holidaysPage.doClickOkDeleteHolidayButton();

		softAssert.assertEquals(holidaysPage.getDeleteConfirmationMessage(),
				CompanySettingsConstant.DELETE_HOLIDAY_CONFIRMATION_MESSAGE);
		softAssert.assertTrue(holidaysPage.isDeleteSuccessMessageDisplayed(),
				"Delete holiday confirmation popup is not displayed");

		softAssert.assertAll();
	}

}
