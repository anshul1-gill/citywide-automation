package com.dits.citywide.tests.operationhub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.OperationsHubConstant;
import com.dits.citywide.pages.fieldagent.FieldAgentCallsPage;
import com.dits.citywide.pages.operationhub.OperationsHubHomePage;
import com.dits.citywide.pages.fieldagent.FieldAgentStartShiftPage;

public class CloseCallTest extends BaseTest {
	
	private FieldAgentStartShiftPage fieldAgentStartShiftPage;
	private FieldAgentCallsPage operationsHubCallsPage;
	
	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		fieldAgentStartShiftPage = new FieldAgentStartShiftPage(driver);
	}

	@Test
	public void closeCallFieldAgentTest() throws InterruptedException {
		Thread.sleep(2000);
		operationsHubCallsPage = fieldAgentStartShiftPage.doClickCallsTab();
		// search the call created earlier (call id is stored in properties)
		operationsHubCallsPage.searchCall(prop.getProperty("callid"));
		// open call action for the searched call and perform close/cleared
		operationsHubCallsPage.doClickCallAction(prop.getProperty("callid"));
		operationsHubCallsPage.doClickExpandCollapseAssignedUnits();
		
		Thread.sleep(10000);
		operationsHubCallsPage.doClickClose();
		softAssert.assertEquals(operationsHubCallsPage.getSuccessMessageText(),
				OperationsHubConstant.CALL_CLOSED_SUCCESSFULLY,
				"Success message after closing the call does not match.");
//		operationsHubCallsPage.closeCallActionPopup();

		softAssert.assertAll();
	}

}