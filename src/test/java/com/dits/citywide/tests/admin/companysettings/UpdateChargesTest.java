package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateChargesTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateChargesTest() {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		violationsPage = companySettingsPage.clickViolationsLink();
		violationsPage.clickChargesTab();
		violationsPage.clickEditViolationButton(CompanySettingsConstant.CHARGE_CODE);

		violationsPage.updateCharges(CompanySettingsConstant.CHARGE_EDIT_CODE,
				CompanySettingsConstant.CHARGE_EDIT_DESCRIPTION);
		violationsPage.clickUpdateChargesButton();

		softAssert.assertEquals(violationsPage.getSuccessMessage(),
				CompanySettingsConstant.UPDATE_CHARGE_SUCCESS_MESSAGE, "Charges updated successfully");
		violationsPage.clickChargesTab();
		softAssert.assertEquals(violationsPage.getChargesName(), "Updated Charge Code");
		softAssert.assertEquals(violationsPage.getChargesDescription(), "Updated Charge Description");

		softAssert.assertAll();
	}

}
