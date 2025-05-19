package com.dits.citywide.tests;

import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void loginTest() throws InterruptedException {

		softAssert.assertTrue(loginPage.isCompanyLogoHeaderDisplayed(), "Company logo in the header is not displayed");
		softAssert.assertTrue(loginPage.isCompanyLogoBodyDisplayed(), "Company logo in the body is not displayed");

		softAssert.assertTrue(loginPage.isCompanyLogoHeaderNotBroken(),
				"Company logo in the header is broken or not loading correctly");
		softAssert.assertTrue(loginPage.isCompanyLogoBodyNotBroken(),
				"Company logo in the body is broken or not loading correctly");

		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));

		softAssert.assertTrue(dashboardPage.isDashboardTextDisplayed());

		softAssert.assertAll();
	}

}
