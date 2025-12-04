package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class PatrolAgentAddParkingCitationTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"), prop.getProperty("employeePassword"));
    }

    @Test
    public void AddParkingCitationTestPatrol() throws InterruptedException {
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        patrolStartShiftPage.handlePassdownOfTheDay();
        fieldAgentParkingCitationPage = patrolStartShiftPage.clickOnParkingCitationFormLink();
        softAssert.assertTrue(fieldAgentParkingCitationPage.isClearButtonDisplayed(), "Clear Button not visible");

        fieldAgentParkingCitationPage.fillParkingCitationForm(
                FieldAgentConstants.SITE,
                FieldAgentConstants.DATE_TIME,
                FieldAgentConstants.ACTIVITY_CODE,
                FieldAgentConstants.VIN_NUMBER,
                FieldAgentConstants.LICENSE_NO,
                FieldAgentConstants.SELECT_STATE,
                FieldAgentConstants.EXPIRE_DATE,
                FieldAgentConstants.VEHICLE_COLOR,
                FieldAgentConstants.YEAR,
                FieldAgentConstants.VEHICLE_MAKE,
                FieldAgentConstants.VEHICLE_MODEL,
                FieldAgentConstants.VIOLATION,
                FieldAgentConstants.ADDITIONAL_DETAILS);

        fieldAgentParkingCitationPage.clickOnImpoundedFields();
        softAssert.assertTrue(fieldAgentParkingCitationPage.isImpoundedFieldsDisplayed(), "Impounded Fields not visible");

        fieldAgentParkingCitationPage.fillImpoundedFields(
                FieldAgentConstants.IMPOUNDED_DATE_TIME,
                FieldAgentConstants.TOWING_COMPANY);

        fieldAgentParkingCitationPage.parkingCitationImagesUpload(FieldAgentConstants.FILE_PATH);
        fieldAgentParkingCitationPage.saveParkingCitation();

        Thread.sleep(10000);
        softAssert.assertTrue(fieldAgentParkingCitationPage.isSearchBoxDisplayed(), "Search box not displayed");

        fieldAgentParkingCitationPage.searchParkingCitation(prop.getProperty("patrolID"));

        softAssert.assertTrue(fieldAgentParkingCitationPage.getOfficerName().contains(prop.getProperty("patrolID")), "Officer name mismatch");
        softAssert.assertTrue(fieldAgentParkingCitationPage.getSiteName().contains(HRManagementConstants.SITE), "Site name mismatch");

        String incidentId = fieldAgentParkingCitationPage.getIncidentNumber();
        System.out.println(incidentId);
        driverFactory.updatePropertyValue("parkingcitationID", incidentId);

        softAssert.assertAll();
    }
}
