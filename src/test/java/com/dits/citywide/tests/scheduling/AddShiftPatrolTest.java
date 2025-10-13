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
		Thread.sleep(10000);
		schedulingPage = dashboardPage.doClickScheduling();
		Thread.sleep(2000);

		schedulingPage.selectBeatAndApply(HRManagementConstants.BEAT);
		schedulingPage.addShift(SchedulingConstant.ADD_SHIFT_DATE);
		schedulingPage.selectAssignShiftForPetrol(SchedulingConstant.ASSIGN_SHIFT);
		schedulingPage.fillShiftFormPatrol(prop.getProperty("patrolID"), SchedulingConstant.START_TIME_PATROL,
				SchedulingConstant.END_TIME_PATROL, SchedulingConstant.SCHEDULED_BREAK,
				SchedulingConstant.ADD_NOTES_PATROL);

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
