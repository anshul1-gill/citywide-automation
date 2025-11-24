package com.dits.citywide.tests.operationhub;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.OperationsHubConstant;

public class SitesPostOrdersAddAssignmentAndCheckpointPatrolAgentTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addAssignmentAndCheckpointToPostOrdersSitePatrolAgentTest() throws InterruptedException {
		// Navigate to Site -> Post Orders
		Thread.sleep(2000);
		sitesPage = dashboardPage.doClickSitesTab();
		sitesPage.searchSite(HRManagementConstants.SITE);

		Thread.sleep(2000);
		sitesPage.clickEditSite();
		sitesPage.clickPostOrders();

		// Fill and Add Assignment for Patrol Agent
		sitesPage.fillAddAssignmentForm(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME,
				OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_TEMPLATE, OperationsHubConstant.PATROL_AGENT_COVERAGE_TYPE,
				OperationsHubConstant.ASSIGNMENT_DAYS_OF_WEEK, OperationsHubConstant.ASSIGNMENT_TIME,
				OperationsHubConstant.SNITCH_TIME);
		sitesPage.clickAddAssignment();

		// Assertions for Assignment
		softAssert.assertEquals(sitesPage.getSuccessMessage(),
				"Assignment \"" + OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME + "\" added successfully.");

		softAssert.assertEquals(sitesPage.getAssignmentName(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME),
				OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME);

		softAssert.assertTrue(sitesPage.getTemplateName(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME)
				.equalsIgnoreCase(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_TEMPLATE), "Template name mismatch!");

		String actualCoverage = sitesPage.getCoverageType(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME).trim();
		String expectedCoverage = OperationsHubConstant.PATROL_AGENT_COVERAGE_TYPE.trim();
		softAssert.assertTrue(
				actualCoverage.startsWith(expectedCoverage) || expectedCoverage.startsWith(actualCoverage),
				"Coverage type mismatch! Expected something like [" + expectedCoverage + "] but found ["
						+ actualCoverage + "]");

		String actualDays = sitesPage.getDaysOfWeek(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME);
		List<String> actualDaysList = Arrays.stream(actualDays.split(",")).map(String::trim).toList();

		softAssert.assertEquals(actualDaysList, OperationsHubConstant.ASSIGNMENT_DAYS_OF_WEEK,
				"Days of week mismatch!");

		softAssert.assertTrue(sitesPage.getAssignmentTimeSlot(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME)
				.startsWith(OperationsHubConstant.ASSIGNMENT_TIME), "Assignment time mismatch!");

		softAssert.assertTrue(
				sitesPage.getAddedBy(OperationsHubConstant.PATROL_AGENT_ASSIGNMENT_NAME).contains(prop.getProperty("email")),
				"Added by mismatch!");

		sitesPage.clickCheckPointThatOpensNewTab();
		softAssert.assertEquals(sitesPage.getHeadingCheckPoint(), "Guard Tour Checkpoints");

		sitesPage.clickAddNewCheckPoint();
		sitesPage.fillCheckPointForm(OperationsHubConstant.CHECKPOINT_NAME,
				OperationsHubConstant.CHECKPOINT_DESCRIPTION, OperationsHubConstant.CHECKPOINT_TYPE);
		sitesPage.clickSave();

		Thread.sleep(2000);
		sitesPage.clickTabScanRules();
		sitesPage.clickAddScanRule();
		sitesPage.fillAddScanRuleForm(OperationsHubConstant.SCAN_TYPE_SCAN_TIME,
				OperationsHubConstant.SCAN_TYPE_SNITCH_TIME, OperationsHubConstant.ASSIGNMENT_DAYS_OF_WEEK);
		sitesPage.clickSaveScanRule();
		softAssert.assertEquals(sitesPage.getScanRuleSuccessMessage(),
				OperationsHubConstant.SCAN_RULE_CREATED_SUCCESS_MESSAGE);

		Thread.sleep(2000);
		sitesPage.clickTabActionsRules();
		sitesPage.clickAddActionRule();
		sitesPage.fillAddActionRuleForm(OperationsHubConstant.ACTION_RULE_PRIORITY,
				OperationsHubConstant.ACTION_RULE_INPUT_TYPE, OperationsHubConstant.ACTION_RULE_DIRECTIVE);
		sitesPage.clickSaveActionRule();
		softAssert.assertEquals(sitesPage.getActionRuleSuccessMessage(),
				OperationsHubConstant.ACTION_RULE_CREATED_SUCCESS_MESSAGE);

		Thread.sleep(10000);
		sitesPage.clickBack();
		softAssert.assertEquals(sitesPage.getHeadingCheckPoint(), "Guard Tour Checkpoints");

		// Assertions for Checkpoint
		softAssert.assertEquals(sitesPage.getCheckpointName(OperationsHubConstant.CHECKPOINT_NAME),
				OperationsHubConstant.CHECKPOINT_NAME);

		softAssert.assertEquals(sitesPage.getCheckpointDescription(OperationsHubConstant.CHECKPOINT_NAME),
				OperationsHubConstant.CHECKPOINT_DESCRIPTION);

		softAssert.assertEquals(sitesPage.getCheckpointType(OperationsHubConstant.CHECKPOINT_NAME),
				OperationsHubConstant.CHECKPOINT_TYPE);

		softAssert.assertTrue(sitesPage.getCheckpointSiteName(OperationsHubConstant.CHECKPOINT_NAME)
				.contains(HRManagementConstants.SITE), "Checkpoint site name mismatch!");

		softAssert.assertAll();
	}
}
