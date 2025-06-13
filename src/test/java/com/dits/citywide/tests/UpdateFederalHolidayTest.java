package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateFederalHolidayTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateFederalHolidayTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		holidaysPage = companySettingsPage.clickHolidaysLink();
		holidaysPage.clickEditHolidayButton(CompanySettingsConstant.HOLIDAY_NAME);
		softAssert.assertTrue(holidaysPage.isUpdateHolidayPageDisplayed(), "Update Holiday page is not displayed");

		holidaysPage.updateFederalHoliday(CompanySettingsConstant.HOLIDAY_EDIT_NAME,
				CompanySettingsConstant.HOLIDAY_EDIT_START_TIME, CompanySettingsConstant.HOLIDAY_EDIT_END_TIME,
				CompanySettingsConstant.HOLIDAY_EDIT_RECURRING, CompanySettingsConstant.HOLIDAY_EDIT_PAYMENT_TYPE,
				CompanySettingsConstant.HOLIDAY_EDIT_DESCRIPTION);

		holidaysPage.doClickUpdateHolidayButton();

		softAssert.assertTrue(holidaysPage.isHolidayPageTitleDisplayed(), "Holiday page title is not displayed");

		softAssert.assertEquals(holidaysPage.getDataHolidayName(), CompanySettingsConstant.HOLIDAY_EDIT_NAME,
				"Updated holiday name does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayStartTime(), CompanySettingsConstant.HOLIDAY_EDIT_START_TIME,
				"Updated holiday start time does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayEndTime(), CompanySettingsConstant.HOLIDAY_EDIT_END_TIME,
				"Updated holiday end time does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayRecurring(), CompanySettingsConstant.HOLIDAY_EDIT_RECURRING,
				"Updated holiday recurring does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayPaymentType(),
				CompanySettingsConstant.HOLIDAY_EDIT_PAYMENT_TYPE, "Updated holiday payment type does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayDescription(),
				CompanySettingsConstant.HOLIDAY_EDIT_DESCRIPTION, "Updated holiday description does not match");

		softAssert.assertAll();
	}

}
