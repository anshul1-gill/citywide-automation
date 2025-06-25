package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteLeaveTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteLeaveTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		leavesPage = companySettingsPage.clickLeavesLink();
		leavesPage.clickDeleteLeaveButton(CompanySettingsConstant.LEAVE_EDIT_NAME);

		softAssert.assertTrue(leavesPage.isDeleteConfirmationMessageVisible(),
				"Delete confirmation message is not visible.");
		leavesPage.confirmDeleteLeave();
		softAssert.assertTrue(leavesPage.isDeleteSuccessMessageVisible(),
				"Delete success message is not visible after deletion.");

		softAssert.assertAll();
	}

}
