package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class FieldAgentDeleteParkingCitationTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void deleteParkingCitationTest() throws InterruptedException {

		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentParkingCitationPage = fieldAgentStartShiftPage.clickOnParkingCitationFormLink();
		fieldAgentParkingCitationPage.searchParkingCitation(prop.getProperty("employeeID"));
		fieldAgentParkingCitationPage.deleteParkingCitation(prop.getProperty("parkingcitationID"));
		softAssert.assertTrue(fieldAgentParkingCitationPage.isDeleteSuccessMessageDisplayed(),
				"Citation deleted successfully.");
		softAssert.assertAll();
	}

}
