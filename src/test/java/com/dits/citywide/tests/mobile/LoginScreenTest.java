package com.dits.citywide.tests.mobile;

import org.testng.annotations.Test;

import com.dits.citywide.basetest.BaseMobileTest;
import com.dits.citywide.constants.MobileConstants;
import com.dits.citywide.mobile.LoginScreen;

public class LoginScreenTest extends BaseMobileTest {

	@Test
	public void loginTestAndroid() throws InterruptedException {
		LoginScreen loginScreen = new LoginScreen(driver);

		loginScreen.searchAndProceed(MobileConstants.ORG_NAME);

		softAssert.assertTrue(loginScreen.isLoginScreenDisplayed(), "Login screen is not displayed");
		softAssert.assertTrue(loginScreen.isInfoButtonDisplayed(), "Info button is not displayed");
		softAssert.assertTrue(loginScreen.isRememberMeCheckboxDisplayed(), "Remember Me checkbox is not displayed");
		softAssert.assertTrue(loginScreen.isSwitchToOrganizationLinkDisplayed(),
				"Switch to Organization link is not displayed");

		loginScreen.login(prop.getProperty("employeeID"), prop.getProperty("employeePassword"));

		softAssert.assertTrue(loginScreen.isLoginSuccessful(), "Login was not successful");
		softAssert.assertAll();
	}
}
