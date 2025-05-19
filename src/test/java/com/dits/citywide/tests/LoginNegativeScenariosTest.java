package com.dits.citywide.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class LoginNegativeScenariosTest extends BaseTest {

	@Test(dataProvider = "invalidLoginData")
	public void verifyLoginErrorMessagesTest(String email, String password, List<String> expectedErrors)
			throws InterruptedException {

		loginPage.verifyLoginValidationErrorMessage(email, password);

		List<String> actualErrors = loginPage.getAllErrorMessages();
		System.out.println("Actual Error Messages: " + actualErrors);
		System.out.println("Expected Error Messages: " + expectedErrors);

		Assert.assertEqualsNoOrder(actualErrors.toArray(), expectedErrors.toArray(), "Error messages do not match!");
	}

	@DataProvider
	public Object[][] invalidLoginData() {
		return new Object[][] {

				{ "#001", "Amit@123456767", Arrays.asList("These credentials do not match our records.") },
				{ "#000000000", "12345678", Arrays.asList("These credentials do not match our records.") },
				{ "amit@hotmail.com", "Amit@123456767", Arrays.asList("These credentials do not match our records.") },
				{ "", "",
						Arrays.asList("Please enter your Badge# or Email Address.",
								"The password field is required.") },
				{ "#001", "", Arrays.asList("The password field is required.") },
				{ "", "12345678", Arrays.asList("Please enter your Badge# or Email Address.") } };
	}
}
