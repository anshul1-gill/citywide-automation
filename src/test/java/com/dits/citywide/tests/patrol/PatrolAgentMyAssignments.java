package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.OperationsHubConstant;

public class PatrolAgentMyAssignments extends BaseTest {

	   @BeforeMethod
	    public void performLogin() throws InterruptedException {
	        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
	                prop.getProperty("employeePassword"));
	        fieldAgentStartShiftPage = new com.dits.citywide.pages.fieldagent.FieldAgentStartShiftPage(driver); // Initialize to avoid NullPointerException
	    }


	@Test
	public void myAssignmentsPatrolAgentTest() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentReportsPage = fieldAgentStartShiftPage.clickOnReportsTab();
		fieldAgentReportsPage.clickMyAssignments();
		fieldAgentReportsPage.enterTextInSearchBox(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME);

		String siteName = fieldAgentReportsPage.getSiteNameByAssignment(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME);
		String timeSlot = fieldAgentReportsPage.getTimeSlotByAssignment(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME);
		String snitchTime = fieldAgentReportsPage.getSnitchTimeByAssignment(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME);
		String addedBy = fieldAgentReportsPage.getAddedByByAssignment(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME);
		String status = fieldAgentReportsPage.getStatusByAssignment(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME);

		System.out.println("--- PatrolAgent MyAssignments Checks ---");
		System.out.println("Site Name: " + siteName);
		System.out.println("Time Slot: " + timeSlot);
		System.out.println("Snitch Time: " + snitchTime);
		System.out.println("Added By: " + addedBy);
		System.out.println("Status: " + status);
		System.out.println("----------------------------------------");

		softAssert.assertFalse(siteName == null || siteName.isEmpty(), "Site name should not be empty");
		softAssert.assertFalse(timeSlot == null || timeSlot.isEmpty(), "Time slot should not be empty");
		softAssert.assertFalse(snitchTime == null || snitchTime.isEmpty(), "Snitch time should not be empty");
		softAssert.assertFalse(addedBy == null || addedBy.isEmpty(), "Added by should not be empty");
		softAssert.assertFalse(status == null || status.isEmpty(), "Status should not be empty");
		softAssert.assertTrue(fieldAgentReportsPage.isActionByAssignmentVisible(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME), "Action link is not visible!");
		fieldAgentReportsPage.clickActionByAssignment(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME);
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
		softAssert.assertTrue(fieldAgentReportsPage.isReportPhotoVideoUploadHeadingVisible());
		fieldAgentReportsPage.clickUpdateLogEntry();
		fieldAgentReportsPage.clickOkButton();
		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());
		fieldAgentReportsPage.clickMyAssignments();
		String statusAfter = fieldAgentReportsPage.getStatusByAssignment(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME);
		softAssert.assertFalse(statusAfter == null || statusAfter.isEmpty(), "Status after update should not be empty");

		fieldAgentReportsPage.clickCheckPointsTab();
		String checkpointName = fieldAgentReportsPage.getCheckpointByName(OperationsHubConstant.CHECKPOINT_NAME);
		String checkpointSite = fieldAgentReportsPage.getSiteNameByCheckpoint(OperationsHubConstant.CHECKPOINT_NAME);
		String checkpointType = fieldAgentReportsPage.getCheckpointTypeByName(OperationsHubConstant.CHECKPOINT_NAME);
		System.out.println("Checkpoint Name: " + checkpointName);
		System.out.println("Checkpoint Site: " + checkpointSite);
		System.out.println("Checkpoint Type: " + checkpointType);
		softAssert.assertFalse(checkpointName == null || checkpointName.isEmpty(), "Checkpoint name should not be empty");
		softAssert.assertFalse(checkpointSite == null || checkpointSite.isEmpty(), "Checkpoint site should not be empty");
		softAssert.assertFalse(checkpointType == null || checkpointType.isEmpty(), "Checkpoint type should not be empty");
		softAssert.assertTrue(fieldAgentReportsPage.isViewCheckpointByNameVisible(OperationsHubConstant.CHECKPOINT_NAME), "View link is not visible!");
		softAssert.assertAll();
	}

}