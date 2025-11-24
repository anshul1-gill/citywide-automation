package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.OperationsHubConstant;

public class PatrolAgentCallActionTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void callActionPatrolAgentTest() throws InterruptedException {
		Thread.sleep(2000); // allow initial overlays to settle
		fieldAgentCallsPage = patrolStartShiftPage.doClickCallsTab();

		fieldAgentCallsPage.doClickCallAction(prop.getProperty("patrolCallId"));
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
		fieldAgentCallsPage.addNotesAndSave(OperationsHubConstant.NOTES);
		fieldAgentCallsPage.closeCallActionPopup();

		softAssert.assertAll();
	}
}
