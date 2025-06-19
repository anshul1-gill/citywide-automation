package com.dits.citywide.tests.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddCustomHolidayTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addCustomHolidayTest() throws InterruptedException {

		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		holidaysPage = companySettingsPage.clickHolidaysLink();
		holidaysPage.doClickAddHolidayButton();
		softAssert.assertTrue(holidaysPage.isHolidayPageDisplayed(), "Add Holiday page is not displayed");
		holidaysPage.doClickAddCustomHolidayButton();
		// Fill in custom holiday details
		holidaysPage.fillCustomHolidayDetails(CompanySettingsConstant.CUSTOM_HOLIDAY_NAME,
				CompanySettingsConstant.CUSTOM_HOLIDAY_START_DATE, CompanySettingsConstant.CUSTOM_HOLIDAY_START_TIME,
				CompanySettingsConstant.CUSTOM_HOLIDAY_END_TIME, CompanySettingsConstant.CUSTOM_HOLIDAY_RECURRING,
				CompanySettingsConstant.CUSTOM_HOLIDAY_PAYMENT_TYPE,
				CompanySettingsConstant.CUSTOM_HOLIDAY_DESCRIPTION);

		holidaysPage.doClickSubmitCustomHolidayButton();

		softAssert.assertTrue(holidaysPage.isHolidayPageTitleDisplayed(), "Holiday page title is not displayed");

		// Validate the entered data
		softAssert.assertEquals(holidaysPage.getDataHolidayName(), CompanySettingsConstant.CUSTOM_HOLIDAY_NAME,
				"Custom holiday name does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayStartDate(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_START_DATE, "Custom holiday start date does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayStartTime(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_START_TIME, "Custom holiday start time does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayEndTime(), CompanySettingsConstant.CUSTOM_HOLIDAY_END_TIME,
				"Custom holiday end time does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayRecurring(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_RECURRING, "Custom holiday recurring does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayPaymentType(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_PAYMENT_TYPE, "Custom holiday payment type does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayDescription(),
				CompanySettingsConstant.CUSTOM_HOLIDAY_DESCRIPTION, "Custom holiday description does not match");

		softAssert.assertAll();
	}

}
