package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class PatrolAgentAddTrespassNoticesTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"), prop.getProperty("employeePassword"));
    }

    @Test
    public void addTrespassNoticesTest() throws InterruptedException {
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        patrolStartShiftPage.handlePassdownOfTheDay();
        fieldAgentTrespassNoticesPage = patrolStartShiftPage.clickOnTrespassNoticesFormLink();

        fieldAgentTrespassNoticesPage.clickCreateNewTrespassNotice();
        softAssert.assertTrue(fieldAgentTrespassNoticesPage.isClearButtonDisplayed(), "Clear Button is not visible");

        fieldAgentTrespassNoticesPage.fillLocationDetails(
                FieldAgentConstants.TRESPASS_SITE,
                FieldAgentConstants.TRESPASS_DATE_TIME,
                FieldAgentConstants.TRESPASS_ACTIVITY_CODE,
                FieldAgentConstants.TRESPASS_STREET_NUMBER,
                FieldAgentConstants.TRESPASS_STREET_NAME,
                FieldAgentConstants.TRESPASS_UNIT_NUMBER,
                FieldAgentConstants.TRESPASS_CITY,
                FieldAgentConstants.TRESPASS_STATE,
                FieldAgentConstants.TRESPASS_ZIP);

        fieldAgentTrespassNoticesPage.fillTrespasserDetails(
                FieldAgentConstants.TRESSPASS_FIRST_NAME,
                FieldAgentConstants.TRESPASS_MIDDLE_NAME,
                FieldAgentConstants.TRESPASS_LAST_NAME,
                FieldAgentConstants.TRESSPASSER_DL_NUMBER,
                FieldAgentConstants.TRESSPASSER_DL_STATE,
                FieldAgentConstants.TRESSPASSER_DL_EXPIRE_DATE,
                FieldAgentConstants.TRESSPASSER_STREET_NUMBER,
                FieldAgentConstants.TRESSPASSER_STREET_NAME,
                FieldAgentConstants.TRESSPASSER_UNIT_NUMBER,
                FieldAgentConstants.TRESSPASSER_CITY,
                FieldAgentConstants.TRESSPASSER_STATE,
                FieldAgentConstants.TRESSPASSER_ZIP,
                FieldAgentConstants.TRESSPASSER_VEHICLE_YEAR,
                FieldAgentConstants.TRESSPASSER_VEHICLE_MAKE,
                FieldAgentConstants.TRESSPASSER_VEHICLE_MODEL,
                FieldAgentConstants.TRESSPASSER_VEHICLE_COLOR,
                FieldAgentConstants.TRESSPASSER_VEHICLE_PLATE,
                FieldAgentConstants.TRESSPASSER_VEHICLE_STATE,
                FieldAgentConstants.TRESSPASSER_GENDER,
                FieldAgentConstants.TRESSPASS_RACE,
                FieldAgentConstants.TRESSPASS_HAIR_TYPE,
                FieldAgentConstants.TRESSPASS_HAIR_COLOR,
                FieldAgentConstants.TRESSPASS_EYE_COLOR,
                FieldAgentConstants.TRESSPASS_HEIGHT,
                FieldAgentConstants.TRESSPASS_BUILD,
                FieldAgentConstants.TRESSPASS_WEIGHT);

        fieldAgentTrespassNoticesPage.fillTrespassNarrative(
                FieldAgentConstants.TRESPASS_NARRATIVE,
                FieldAgentConstants.TRESPASS_WAS_PD_CONTACTED);

        fieldAgentTrespassNoticesPage.fillTrespassAdvisalImages(FieldAgentConstants.TRESPASS_FILE_PATH);

        fieldAgentTrespassNoticesPage.saveTrespassNotice();
        Thread.sleep(10000);
        softAssert.assertTrue(fieldAgentTrespassNoticesPage.isSearchBoxDisplayed(), "Search box not displayed");

        fieldAgentTrespassNoticesPage.searchTrespassNotice(prop.getProperty("patrolID"));

        softAssert.assertTrue(fieldAgentTrespassNoticesPage.getOfficerName().contains(prop.getProperty("patrolID")), "Officer name does not contain patrol ID");
        softAssert.assertTrue(fieldAgentTrespassNoticesPage.getSiteName().contains(prop.getProperty("site")), "Site name does not match expected site");

        String incidentId = fieldAgentTrespassNoticesPage.getIncidentNumber();
        System.out.println(incidentId);
        driverFactory.updatePropertyValue("trespassNoticesID", incidentId);

        softAssert.assertAll();
    }
}
