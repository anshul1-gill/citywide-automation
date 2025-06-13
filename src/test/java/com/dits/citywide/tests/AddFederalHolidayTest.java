package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddFederalHolidayTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addBreakPageTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		holidaysPage = companySettingsPage.clickHolidaysLink();
		holidaysPage.doClickAddHolidayButton();
		softAssert.assertTrue(holidaysPage.isHolidayPageDisplayed(), "Add Holiday page is not displayed");
		holidaysPage.fillFederalHolidayDetails(CompanySettingsConstant.HOLIDAY_NAME, CompanySettingsConstant.START_TIME,
				CompanySettingsConstant.END_TIME, CompanySettingsConstant.RECURRING,
				CompanySettingsConstant.PAYMENT_HOLIDAY_TYPE, CompanySettingsConstant.HOLIDAY_DESCRIPTION);
		holidaysPage.doClickSubmitAddHolidayButton();

		softAssert.assertTrue(holidaysPage.isHolidayPageTitleDisplayed(), "Holiday page title is not displayed");

		softAssert.assertEquals(holidaysPage.getDataHolidayName(), CompanySettingsConstant.HOLIDAY_NAME,
				"Holiday name does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayStartTime(), CompanySettingsConstant.START_TIME,
				"Holiday start time does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayEndTime(), CompanySettingsConstant.END_TIME,
				"Holiday end time does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayRecurring(), CompanySettingsConstant.RECURRING,
				"Holiday recurring does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayPaymentType(), CompanySettingsConstant.PAYMENT_HOLIDAY_TYPE,
				"Holiday payment type does not match");
		softAssert.assertEquals(holidaysPage.getDataHolidayDescription(), CompanySettingsConstant.HOLIDAY_DESCRIPTION,
				"Holiday description does not match");

		softAssert.assertAll();
	}

}
