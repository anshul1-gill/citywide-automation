package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class AddReasonERMTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addReasonERMTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		ermPage = dashboardPage.doClickERM();
		ermSettingsPage = ermPage.clickSettings();
		softAssert.assertEquals(ermSettingsPage.getHeadingText(), "Settings", "Settings heading text mismatch");
		ermSettingsPage.clickTabReason();
		ermSettingsPage.clickAddReason();
		softAssert.assertEquals(ermSettingsPage.getHeadingTextAddReason(), "Add Reason",
				"Add Reason heading text mismatch");
		ermSettingsPage.fillAddReasonForm(HRManagementConstants.REASON_CATEGORY, HRManagementConstants.REASON_TYPE);
		ermSettingsPage.clickSaveButton();
		softAssert.assertEquals(ermSettingsPage.getSuccessMessage(), HRManagementConstants.REASON_ADDED_SUCCESS_MESSAGE,
				"Success message mismatch");
		ermSettingsPage.searchReasonCategory(HRManagementConstants.REASON_CATEGORY);
		softAssert.assertEquals(ermSettingsPage.getReasonType(), HRManagementConstants.REASON_TYPE,
				"Reason type mismatch");
		softAssert.assertEquals(ermSettingsPage.getReasonCategory(), HRManagementConstants.REASON_CATEGORY,
				"Reason category mismatch");
		softAssert.assertTrue(ermSettingsPage.getCreatedBy().contains(prop.getProperty("email")),
				"Created by user mismatch");
		softAssert.assertAll();
	}

}
