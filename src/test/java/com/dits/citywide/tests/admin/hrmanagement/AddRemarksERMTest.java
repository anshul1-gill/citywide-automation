package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class AddRemarksERMTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addRemarksERMTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		ermPage = dashboardPage.doClickERM();
		ermSettingsPage = ermPage.clickSettings();
		softAssert.assertEquals(ermSettingsPage.getHeadingText(), "Settings", "Settings heading text mismatch");
		ermSettingsPage.clickAddRemark();
		softAssert.assertEquals(ermSettingsPage.getHeadingTextAddRemarks(), "Add Remarks",
				"Add Remarks heading text mismatch");
		ermSettingsPage.fillAddRemarkForm(HRManagementConstants.REMARKS_CATEGORY, HRManagementConstants.REMARKS_TYPE);
		ermSettingsPage.clickSaveButton();
		softAssert.assertEquals(ermSettingsPage.getSuccessMessage(),
				HRManagementConstants.REMARKS_ADDED_SUCCESS_MESSAGE, "Success message mismatch");
		ermSettingsPage.searchRemarkCategory(HRManagementConstants.REMARKS_CATEGORY);
		softAssert.assertEquals(ermSettingsPage.getRemarkType(), HRManagementConstants.REMARKS_TYPE,
				"Remark type mismatch");
		softAssert.assertEquals(ermSettingsPage.getRemarkCategory(), HRManagementConstants.REMARKS_CATEGORY,
				"Remark category mismatch");
		softAssert.assertTrue(ermSettingsPage.getCreatedBy().contains(prop.getProperty("email")),
				"Created by user mismatch");
		softAssert.assertAll();
	}

}
