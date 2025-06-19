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
	public void callActionTest() throws InterruptedException {
		Thread.sleep(2000);
		fieldAgentCallsPage = fieldAgentStartShiftPage.doClickCallsTab();
		fieldAgentCallsPage.doClickCallAction(prop.getProperty("callid"));
		fieldAgentCallsPage.doClickEnroute();
		softAssert.assertEquals(fieldAgentCallsPage.getSuccessMessageText(),
				OperationsHubConstant.OFFICER_ENROUTE_SUCCESSFULLY);
		fieldAgentCallsPage.doClickArrive();
		softAssert.assertEquals(fieldAgentCallsPage.getSuccessMessageText(),
				OperationsHubConstant.OFFICER_ARRIVED_SUCCESSFULLY);
		fieldAgentCallsPage.doClickCleared();
		softAssert.assertEquals(fieldAgentCallsPage.getSuccessMessageText(),
				OperationsHubConstant.OFFICER_CLEARED_SUCCESSFULLY);
		softAssert.assertTrue(fieldAgentCallsPage.isCallNotesVisible());
		fieldAgentCallsPage.addNotesAndSave(OperationsHubConstant.NOTES);
		fieldAgentCallsPage.closeCallActionPopup();

		softAssert.assertAll();
	}

}
