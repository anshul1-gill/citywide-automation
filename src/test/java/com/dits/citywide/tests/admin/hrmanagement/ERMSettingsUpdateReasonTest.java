package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class ERMSettingsUpdateReasonTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateReasonSettingsERMTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		ermPage = dashboardPage.doClickERM();
		ermSettingsPage = ermPage.clickSettings();
		softAssert.assertEquals(ermSettingsPage.getHeadingText(), "Settings", "Settings heading text mismatch");
		ermSettingsPage.clickTabReason();
		ermSettingsPage.searchReasonCategory(HRManagementConstants.REASON_CATEGORY);
		ermSettingsPage.clickEditButton();
		softAssert.assertEquals(ermSettingsPage.getHeadingTextAddReason(), "Update Reason",
				"Update Reason heading text mismatch");
		ermSettingsPage.fillUpdatedReasonForm(HRManagementConstants.UPDATED_REASON_CATEGORY,
				HRManagementConstants.UPDATED_REMARKS_TYPE);
		ermSettingsPage.clickUpdateButton();
		softAssert.assertEquals(ermSettingsPage.getSuccessMessage(),
				HRManagementConstants.REASON_UPDATED_SUCCESS_MESSAGE, "Success message mismatch after update");

		ermSettingsPage.searchReasonCategory(HRManagementConstants.UPDATED_REASON_CATEGORY);
		softAssert.assertEquals(ermSettingsPage.getReasonType(), HRManagementConstants.UPDATED_REMARKS_TYPE,
				"Updated reason type mismatch");
		softAssert.assertEquals(ermSettingsPage.getReasonCategory(), HRManagementConstants.UPDATED_REASON_CATEGORY,
				"Updated reason category mismatch");
		softAssert.assertAll();
	}

}
