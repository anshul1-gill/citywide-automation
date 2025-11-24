package com.dits.citywide.tests.operationhub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.OperationsHubConstant;

public class AddNewPatrolCallTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        // If a dedicated patrol login exists, replace doLogin with it.
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(groups = {"createPatrolCall"})
    public void addNewPatrolCallTest() throws InterruptedException {
        Thread.sleep(4000);
        callsPage = dashboardPage.doClickCallsTab();

        callsPage.doClickAddNewCallButton();
        // Use patrol site constant instead of field agent SITE
        callsPage.fillAddNewCallForm(OperationsHubConstant.OFFICER_RECEIVED_VIA,
                HRManagementConstants.PATROL_SITE,
                OperationsHubConstant.ACTIVITY_CODE ,
				OperationsHubConstant.SUBACTIVITY_CODE);

        callsPage.fillReportingPersonForm(
                OperationsHubConstant.REPORTING_PERSON_FIRST_NAME,
                OperationsHubConstant.REPORTING_PERSON_LAST_NAME,
                OperationsHubConstant.REPORTING_PERSON_PHONE_NUMBER,
                OperationsHubConstant.REPORTING_PERSON_DEMEANOR
        );

        callsPage.doClickSameAsAboveAddress();
        callsPage.doClickCollapseSuspectDescription();

        callsPage.fillSuspectDescriptionForm(
                OperationsHubConstant.SUSPECT_NAME,
                OperationsHubConstant.SUSPECT_GENDER,
                OperationsHubConstant.SUSPECT_RACE,
                OperationsHubConstant.SUSPECT_HAIR_TYPE,
                OperationsHubConstant.SUSPECT_HAIR_COLOR,
                OperationsHubConstant.SUSPECT_EYE_COLOR,
                OperationsHubConstant.SUSPECT_HEIGHT,
                OperationsHubConstant.SUSPECT_BUILD,
                OperationsHubConstant.SUSPECT_WEIGHT,
                OperationsHubConstant.SUSPECT_AGE,
                OperationsHubConstant.SUSPECT_CLOTHING_WORN,
                OperationsHubConstant.SUSPECT_LAST_KNOWN_DIRECTION
        );

        callsPage.fillCallDescription(OperationsHubConstant.CALL_DESCRIPTION);

        // Select patrol available unit by patrol employee ID
        callsPage.selectAvailableUnits(prop.getProperty("patrolID"),"Primary");

        callsPage.doClickSaveAddNewCall();
        Thread.sleep(2000);

        softAssert.assertTrue(callsPage.isOpenCallsTabDisplayed(), "Open Calls tab not displayed.");
        softAssert.assertTrue(callsPage.isClosedCallsTabDisplayed(), "Closed Calls tab not displayed.");
        softAssert.assertEquals(callsPage.getActivityCode(), OperationsHubConstant.ACTIVITY_CODE, "Activity code mismatch.");
        // Debug line for patrol site
        String actualPatrolSite = callsPage.getSite();
        String expectedPatrolSite = HRManagementConstants.PATROL_SITE;
        // Normalize by removing spaces and making lowercase
        String normalizedActual = actualPatrolSite.replaceAll("\\s+", "").toLowerCase();
        String normalizedExpected = expectedPatrolSite.replaceAll("\\s+", "").toLowerCase();
        System.out.println("DEBUG: Normalized expected patrol site: " + normalizedExpected + ", Normalized actual patrol site: " + normalizedActual);
        softAssert.assertTrue(normalizedActual.contains(normalizedExpected), "Patrol site mismatch.");
        softAssert.assertTrue(callsPage.getAssignedTo().contains(prop.getProperty("patrolID")), "Assigned officer mismatch.");

        String callId = callsPage.getCallId(prop.getProperty("patrolID"));
        System.out.println(callId);
        driverFactory.updatePropertyValue("patrolCallId", callId);

        softAssert.assertAll();
    }
}