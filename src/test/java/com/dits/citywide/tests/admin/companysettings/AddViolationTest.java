package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddViolationTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addViolationTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		violationsPage = companySettingsPage.clickViolationsLink();
		violationsPage.clickAddNewViolationsButton();
		violationsPage.fillAddNewViolationsForm(CompanySettingsConstant.VIOLATION_NAME,
				CompanySettingsConstant.VIOLATION_DESCRIPTION);
		violationsPage.clickSaveButton();

		softAssert.assertEquals(violationsPage.getSuccessMessage(),
				CompanySettingsConstant.ADD_VIOLATION_SUCCESS_MESSAGE, "Add Violation Success Message does not match");

//		softAssert.assertEquals(violationsPage.getBranchName(), CompanySettingsConstant.VIOLATION_BRANCH,
//				"Branch name does not match");
		softAssert.assertEquals(violationsPage.getViolationName(), CompanySettingsConstant.VIOLATION_NAME,
				"Violation name does not match");
		softAssert.assertEquals(violationsPage.getViolationDescription(), CompanySettingsConstant.VIOLATION_DESCRIPTION,
				"Violation description does not match");
		softAssert.assertAll("Add Violation Test Failed");
	}

}
