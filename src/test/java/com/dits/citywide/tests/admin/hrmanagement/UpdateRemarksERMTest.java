package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class UpdateRemarksERMTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateRemarksERMTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		ermPage = dashboardPage.doClickERM();
		ermSettingsPage = ermPage.clickSettings();
		softAssert.assertEquals(ermSettingsPage.getHeadingText(), "Settings", "Settings heading text mismatch");
		ermSettingsPage.searchRemarkCategory(HRManagementConstants.REMARKS_CATEGORY);
		ermSettingsPage.clickEditButton();
		softAssert.assertEquals(ermSettingsPage.getHeadingTextAddRemarks(), "Update Remarks",
				"Updated Remarks heading text mismatch");
		ermSettingsPage.fillUpdatedRemarkForm(HRManagementConstants.UPDATED_REMARKS_CATEGORY,
				HRManagementConstants.UPDATED_REMARKS_TYPE);
		ermSettingsPage.clickUpdateButton();
		softAssert.assertEquals(ermSettingsPage.getSuccessMessage(),
				HRManagementConstants.REMARKS_UPDATED_SUCCESS_MESSAGE, "Success message mismatch");
		ermSettingsPage.searchRemarkCategory(HRManagementConstants.UPDATED_REMARKS_CATEGORY);
		softAssert.assertEquals(ermSettingsPage.getRemarkType(), HRManagementConstants.UPDATED_REMARKS_TYPE,
				"Remark type mismatch");
		softAssert.assertEquals(ermSettingsPage.getRemarkCategory(), HRManagementConstants.UPDATED_REMARKS_CATEGORY,
				"Remark category mismatch");
		softAssert.assertTrue(ermSettingsPage.getCreatedBy().contains(prop.getProperty("email")),
				"Created by user mismatch");
		softAssert.assertAll();
	}

}
