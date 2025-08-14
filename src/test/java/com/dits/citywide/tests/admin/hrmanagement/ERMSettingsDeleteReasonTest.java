package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class ERMSettingsDeleteReasonTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteReasonSettingsERMTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		ermPage = dashboardPage.doClickERM();
		ermSettingsPage = ermPage.clickSettings();
		softAssert.assertEquals(ermSettingsPage.getHeadingText(), "Settings", "Settings heading text mismatch");
		ermSettingsPage.clickTabReason();
		ermSettingsPage.searchReasonCategory(HRManagementConstants.UPDATED_REASON_CATEGORY);
		ermSettingsPage.clickDeleteButton();
		ermSettingsPage.clickOkButton();
		softAssert.assertEquals(ermSettingsPage.getSuccessMessage(),
				HRManagementConstants.REASON_DELETE_CONFIRMATION_MESSAGE, "Success message mismatch after deletion");
		softAssert.assertAll();
	}

}
