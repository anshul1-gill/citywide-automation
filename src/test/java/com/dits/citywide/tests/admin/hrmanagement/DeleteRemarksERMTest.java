package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class DeleteRemarksERMTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteRemarksERMTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		ermPage = dashboardPage.doClickERM();
		ermSettingsPage = ermPage.clickSettings();
		softAssert.assertEquals(ermSettingsPage.getHeadingText(), "Settings", "Settings heading text mismatch");
		ermSettingsPage.searchRemarkCategory(HRManagementConstants.UPDATED_REMARKS_CATEGORY);
		ermSettingsPage.clickDeleteButton();
		ermSettingsPage.clickOkButton();
		softAssert.assertEquals(ermSettingsPage.getSuccessMessage(),
				HRManagementConstants.REMARKS_DELETE_CONFIRMATION_MESSAGE, "Success message mismatch");
		softAssert.assertAll();
	}

}
