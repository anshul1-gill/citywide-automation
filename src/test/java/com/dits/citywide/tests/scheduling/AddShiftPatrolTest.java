package com.dits.citywide.tests.scheduling;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class AddShiftPatrolTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addShiftTest() throws InterruptedException {
		Thread.sleep(4000);
		schedulingPage = dashboardPage.doClickScheduling();
		Thread.sleep(2000);
		schedulingPage.clickOnFilters();
		schedulingPage.clickOnServiceTypeCheckbox();
		// Align flow with working patrol test: select site type and beat
		schedulingPage.selectSiteType(HRManagementConstants.SITE_TYPE);
		schedulingPage.selectBeatAndApply(HRManagementConstants.BEAT);
		// Proceed to add shift
		schedulingPage.addShift(SchedulingConstant.ADD_SHIFT_DATE);
		// Use patrol-specific assignment
		schedulingPage.selectAssignShiftForPetrol(SchedulingConstant.ASSIGN_SHIFT_PATROL);
		// Use patrol-specific form fill and patrol ID
		schedulingPage.fillShiftFormPatrol(
		        prop.getProperty("patrolID"),
		        SchedulingConstant.START_TIME_PATROL,
		        SchedulingConstant.END_TIME_PATROL,
		        SchedulingConstant.SCHEDULED_BREAK_PATROL,
		        SchedulingConstant.ADD_NOTES_PATROL
		);

		softAssert.assertEquals(schedulingPage.getSuccessMessageShiftAdded(),
				SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);

		schedulingPage.clickPublishButton();
		softAssert.assertEquals(schedulingPage.getAreYouSureText(), SchedulingConstant.ARE_YOU_SURE);
		softAssert.assertEquals(schedulingPage.getPublishShiftsConfirmationText(),
				SchedulingConstant.ACTION_WILL_PUBLISH_SHIFTS);
		schedulingPage.clickOkButton();
		softAssert.assertEquals(schedulingPage.getSuccessMessageAfterPublish(),
				SchedulingConstant.SUCCESS_PUBLISH_MESSAGE);
	}

}