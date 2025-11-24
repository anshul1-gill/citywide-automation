package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.OperationsHubConstant;

public class FieldAgentCallActionTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void callActionFieldAgentTest() throws InterruptedException {
		Thread.sleep(2000);
		fieldAgentCallsPage = fieldAgentStartShiftPage.doClickCallsTab();
//		fieldAgentCallsPage.doClickAddPatrolLogsForCall("callid");
		
		

		
		fieldAgentCallsPage.doClickCallAction(prop.getProperty("callid"));
		fieldAgentCallsPage.doClickExpandCollapseAssignedUnits();
		fieldAgentCallsPage.doClickEnroute();
		softAssert.assertEquals(fieldAgentCallsPage.getSuccessMessageText(),
				OperationsHubConstant.OFFICER_ENROUTE_SUCCESSFULLY,
				"Success message after going enroute does not match.");
		fieldAgentCallsPage.doClickArrive();
		softAssert.assertEquals(fieldAgentCallsPage.getSuccessMessageText(),
				OperationsHubConstant.OFFICER_ARRIVED_SUCCESSFULLY, "Success message after arriving does not match.");
		fieldAgentCallsPage.doClickCleared();
		softAssert.assertEquals(fieldAgentCallsPage.getSuccessMessageText(),
				OperationsHubConstant.OFFICER_CLEARED_SUCCESSFULLY,
				"Success message after clearing the call does not match.");
		fieldAgentCallsPage.doClickExpandCollapseCallNotes();
		// softAssert.assertTrue(fieldAgentCallsPage.isCallNotesVisible(), "Call Notes
		// section is not visible.");
		fieldAgentCallsPage.addNotesAndSave(OperationsHubConstant.NOTES);
		fieldAgentCallsPage.closeCallActionPopup();

		softAssert.assertAll();
	}


}