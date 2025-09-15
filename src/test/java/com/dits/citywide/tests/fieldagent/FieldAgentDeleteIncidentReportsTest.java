package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class FieldAgentDeleteIncidentReportsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void deleteIncidentReportTest() throws InterruptedException {
		// Navigate to Incident Reports page
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentIncidentReportsPage = fieldAgentStartShiftPage.clickOnIncidentReportFormLink();

		fieldAgentIncidentReportsPage.searchIncidentReport(prop.getProperty("employeeID"));
		fieldAgentIncidentReportsPage.deleteIncidentReport(prop.getProperty("incidentReportID"));
		softAssert.assertEquals(fieldAgentIncidentReportsPage.isSuccessMessageDisplayed(),
				"Incident deleted successfully.");
//		fieldAgentIncidentReportsPage.searchIncidentReport(prop.getProperty("incidentReportID"));
//		softAssert.assertEquals(fieldAgentIncidentReportsPage.getNoRecordFoundMessage(), "Records found");

	}

}
