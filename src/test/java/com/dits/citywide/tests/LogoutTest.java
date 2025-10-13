package com.dits.citywide.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class LogoutTest extends BaseTest {

	@BeforeMethod
	public void performLogin() {

		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void verifyUserLogoutFunctionality() throws InterruptedException {

		if (prop.getProperty("browser").trim().equalsIgnoreCase("safari")) {
			Thread.sleep(10000);
		}

		dashboardPage.doClickProfileMenu();
		loginPage = dashboardPage.doClickLogout();

		Assert.assertTrue(loginPage.isBadgeOrEmailTextDisplayed());
	}

}
