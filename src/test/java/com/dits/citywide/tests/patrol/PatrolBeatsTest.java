package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class PatrolBeatsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void patrolBeatsTest() throws InterruptedException {

		patrolStartShiftPage.handleMessageOfTheWeek();
		patrolStartShiftPage.handlePassdownOfTheDay();
		patrolBeatsPage = patrolStartShiftPage.clickOnPatrolBeatsTab();

		softAssert.assertTrue(patrolBeatsPage.isViewSitesButtonDisplayed(), "View Sites button should be displayed");
		softAssert.assertTrue(patrolBeatsPage.isViewButtonDisplayed(), "View button should be displayed");
		//softAssert.assertTrue(patrolBeatsPage.isCheckOutButtonDisplayed(), "Check Out button should be displayed");

		softAssert.assertTrue(patrolBeatsPage.getBeatName().contains(HRManagementConstants.BEAT),
				"Beat name should contain " + HRManagementConstants.BEAT);
		softAssert.assertEquals(patrolBeatsPage.getNumberOfSites(), "6");
		softAssert.assertEquals(patrolBeatsPage.getSwiftType(), "Swing");
		patrolBeatsPage.clickOnViewSites();
		softAssert.assertEquals(patrolBeatsPage.getTotalCountOfSites(), "6");

		patrolBeatsPage.clickOnViewBeat();

		softAssert.assertAll();
	}

}
