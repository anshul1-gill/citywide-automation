package com.dits.citywide.tests.operationhub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.OperationsHubConstant;

public class SitesPostOrdersDeleteAssignmentAndCheckpointTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

//	@Test
//	public void deleteAssignmentAndCheckpointToPostOrdersSiteTest() throws InterruptedException {
//
//		Thread.sleep(2000);
//		sitesPage = dashboardPage.doClickSitesTab();
//		sitesPage.searchSite(HRManagementConstants.SITE);
//
//		Thread.sleep(2000);
//		sitesPage.clickEditSite();
//		sitesPage.clickPostOrders();
//		softAssert.assertEquals(sitesPage.getAssignmentsText(), "Assignments");
//		sitesPage.clickDeleteAssignmentByName(OperationsHubConstant.ASSIGNMENT_NAME);
//		sitesPage.clickOkButton();
//		softAssert.assertEquals(sitesPage.getSuccessMessage(), OperationsHubConstant.DELETE_ASSIGNMENT_SUCCESS_MESSAGE);
//
//		sitesPage.clickCheckPointThatOpensNewTab();
//		softAssert.assertEquals(sitesPage.getHeadingCheckPoint(), "Guard Tour Checkpoints");
//		sitesPage.clickDeleteCheckpointByName(OperationsHubConstant.CHECKPOINT_NAME);
//		sitesPage.clickOkButton();
//		softAssert.assertEquals(sitesPage.getSuccessMessage(), OperationsHubConstant.DELETE_CHECKPOINT_SUCCESS_MESSAGE);
//
//		softAssert.assertAll();
//	}

	@Test
	public void deleteAssignmentAndCheckpointToPostOrdersSiteTest() throws InterruptedException {

		Thread.sleep(2000);
		sitesPage = dashboardPage.doClickSitesTab();
		sitesPage.searchSite(HRManagementConstants.SITE);

		Thread.sleep(2000);
		sitesPage.clickEditSite();
//		sitesPage.clickPostOrders();

		softAssert.assertEquals(sitesPage.getAssignmentsText(), "Assignments");

		
		if (sitesPage.isDeleteAssignmentPresent(OperationsHubConstant.ASSIGNMENT_NAME)) {
			sitesPage.clickDeleteAssignmentByName(OperationsHubConstant.ASSIGNMENT_NAME);
			sitesPage.clickOkButton();
			softAssert.assertEquals(sitesPage.getSuccessMessage(),
					OperationsHubConstant.DELETE_ASSIGNMENT_SUCCESS_MESSAGE);
		} else {
			System.out.println("Delete Assignment is not present for: " + OperationsHubConstant.ASSIGNMENT_NAME);
			//softAssert.fail("Delete Assignment is not present!");
		}

		sitesPage.clickCheckPointThatOpensNewTab();
		softAssert.assertEquals(sitesPage.getHeadingCheckPoint(), "Guard Tour Checkpoints");

		if (sitesPage.isDeleteCheckpointPresent(OperationsHubConstant.CHECKPOINT_NAME)) {
			sitesPage.clickDeleteCheckpointByName(OperationsHubConstant.CHECKPOINT_NAME);
			sitesPage.clickOkButton();
			softAssert.assertEquals(sitesPage.getDeleteCheckpointSuccessMessage(),
					OperationsHubConstant.DELETE_CHECKPOINT_SUCCESS_MESSAGE);
		} else {
			System.out.println("Delete Checkpoint is not present for: " + OperationsHubConstant.CHECKPOINT_NAME);
			//softAssert.fail("Delete Checkpoint is not present!");
		}

		softAssert.assertAll();
	}

}
