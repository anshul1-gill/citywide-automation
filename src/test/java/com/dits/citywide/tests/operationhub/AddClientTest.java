package com.dits.citywide.tests.operationhub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.ClientConstants;

public class AddClientTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addClientTest() throws InterruptedException {
		clientPage = dashboardPage.doClickClient();
		clientPage.clickAddNewClient();
		clientPage.createNewClient(
			ClientConstants.CLIENT_BADGE_ID,
			ClientConstants.CLIENT_SITES,
			ClientConstants.CLIENT_FIRST_NAME,
			ClientConstants.CLIENT_LAST_NAME,
			ClientConstants.CLIENT_PHONE,
			ClientConstants.CLIENT_EMAIL,
			ClientConstants.CLIENT_PASSWORD,
			ClientConstants.CLIENT_STATUS,
			ClientConstants.CLIENT_ACTIVITY_TRACKING,
			ClientConstants.CLIENT_COMMENTS
		);
		clientPage.clickAddClientButton();

		// Assert that a success message is displayed
		softAssert.assertTrue(clientPage.isSuccessMessageDisplayed(), "Success message not displayed after client creation.");
		// Assert that the client appears in the client list
		softAssert.assertTrue(clientPage.isClientPresent(ClientConstants.CLIENT_EMAIL), "New client is not present in the client list after creation.");
		softAssert.assertAll();
	}
}