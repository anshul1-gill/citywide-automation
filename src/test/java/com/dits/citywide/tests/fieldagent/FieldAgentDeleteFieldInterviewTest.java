package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class FieldAgentDeleteFieldInterviewTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void DeleteFieldInterviewTest() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentFieldInterviewPage = fieldAgentStartShiftPage.clickOnFieldInterviewFormLink();

		// fieldAgentFieldInterviewPage.searchFieldInterview(prop.getProperty("employeeID"));

		fieldAgentFieldInterviewPage.deleteFieldInterview(prop.getProperty("fieldInterviewID"));
		softAssert.assertEquals(fieldAgentFieldInterviewPage.getSucessMessage(),
				("Field Interview deleted successfully."));
		softAssert.assertTrue(fieldAgentFieldInterviewPage.isSearchBoxDisplayed(), "Searchbox Not displayed");

//		fieldAgentFieldInterviewPage.searchFieldInterview(prop.getProperty("employeeID"));
//		softAssert.assertTrue(fieldAgentFieldInterviewPage.getNoRecordFoundMessage().contains("No records found"));

		softAssert.assertAll();
	}

}
