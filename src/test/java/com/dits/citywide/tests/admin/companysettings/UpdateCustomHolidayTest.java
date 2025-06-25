package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateCustomHolidayTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateCustomHolidayTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		holidaysPage = companySettingsPage.clickHolidaysLink();
		holidaysPage.clickEditHolidayButton(CompanySettingsConstant.CUSTOM_HOLIDAY_NAME);
		softAssert.assertTrue(holidaysPage.isUpdateHolidayPageDisplayed(), "Update Holiday page is not displayed");

		holidaysPage.updateCustomHoliday(CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_NAME,
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_START_DATE,
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_START_TIME,
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_END_TIME,
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_RECURRING,
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_PAYMENT_TYPE,
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_DESCRIPTION);

		holidaysPage.doClickUpdateHolidayButton();

		softAssert.assertTrue(holidaysPage.isHolidayPageTitleDisplayed(), "Holiday page title is not displayed");

		softAssert.assertEquals(holidaysPage.getDataHolidayName(), CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_NAME,
				"Updated holiday name does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayStartDate(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_START_DATE, "Updated holiday start date does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayStartTime(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_START_TIME, "Updated holiday start time does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayEndTime(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_END_TIME, "Updated holiday end time does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayRecurring(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_RECURRING, "Updated holiday recurring does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayPaymentType(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_PAYMENT_TYPE,
				"Updated holiday payment type does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayDescription(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_EDIT_DESCRIPTION, "Updated holiday description does not match");

		softAssert.assertAll();
	}

}
