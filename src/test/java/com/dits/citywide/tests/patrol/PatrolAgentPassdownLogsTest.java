package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.PatrolConstants;
import com.dits.citywide.pages.patrol.PatrolAgentPassdownLogsPage;

public class PatrolAgentPassdownLogsTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void PatrolAgentNewPassdown() throws InterruptedException {
        patrolStartShiftPage.handleMessageOfTheWeek();
        patrolStartShiftPage.handlePassdownOfTheDay();
        patrolAgentPassdownLogsPage = patrolStartShiftPage.clickOnPassdownLogsTab();
        patrolAgentPassdownLogsPage.clickAddPassdownLog();
        patrolAgentPassdownLogsPage.searchSiteName(HRManagementConstants.SITE);
        patrolAgentPassdownLogsPage.enterMessage(PatrolConstants.PASSDOWN_MESSAGE);
        patrolAgentPassdownLogsPage.uploadImage(PatrolConstants.PASSDOWN_IMAGE_PATH);
//        patrolAgentPassdownLogsPage.clickUploadImage();
        
//        softAssert.assertEquals(patrolAgentPassdownLogsPage.imageUploadSuccessMessage(),
//                PatrolConstants.IMAGE_UPLOAD_SUCCESS_MESSAGE, "Image upload success message mismatch");
        patrolAgentPassdownLogsPage.enterImageName(PatrolConstants.PASSDOWN_IMAGE_NAME);
        patrolAgentPassdownLogsPage.enterImageDescription(PatrolConstants.IMAGE_DESCRIPTION);
        patrolAgentPassdownLogsPage.clickSavePassdown();

        softAssert.assertTrue(patrolAgentPassdownLogsPage.isAddPassdownLogButtonDisplayed(),
                "Add Passdown Log button not displayed after saving");
        softAssert.assertTrue(patrolAgentPassdownLogsPage.getDataSiteName().contains(HRManagementConstants.SITE),
                "Saved site name mismatch");
        softAssert.assertEquals(patrolAgentPassdownLogsPage.getDataMessage(), PatrolConstants.PASSDOWN_MESSAGE,
                "Saved passdown message mismatch");

        softAssert.assertAll();
    }
}
