package com.dits.citywide.tests.admin.training;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.TrainingConstants;

public class AssessmentsResultsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void viewAssessmentResultsTest() throws InterruptedException {
		trainingPage = dashboardPage.clickOnTrainingTab();
		assessmentsResultsPage = trainingPage.clickOnAssessmentsResults();
//		softAssert.assertEquals(assessmentsResultsPage.getHeadingAssessmentResults(), "Assessment Results",
//				"Heading of Assessment Results page is not as expected");

		assessmentsResultsPage.selectStatus(TrainingConstants.ASSESSMENT_SEARCH_BY_STATUS);
		assessmentsResultsPage.clickViewDetailsByCourseName(TrainingConstants.COURSE_NAME);
		assessmentsResultsPage.clickOnViewActionByAssessmentName(TrainingConstants.ASSESSMENT_NAME);

		assessmentsResultsPage.clickPreductedAnswer(TrainingConstants.PREDICTED_ANSWERS);
		assessmentsResultsPage.clickSaveAssessmentResult();
		softAssert.assertEquals(assessmentsResultsPage.getCandidateSuccessfullyCompletedCourseText(),
				TrainingConstants.CANDIDATE_SUCCESSFULLY_COMPLETED_COURSE,
				"Certificate successfully issued to candidate text is not as expected");
		softAssert.assertEquals(assessmentsResultsPage.getCertificateSuccessfullyIssuedToCandidateText(),
				TrainingConstants.CERTIFICATE_GENERATED_SUCCESS_MESSAGE,
				"Certificate generated success message is not as expected");

		softAssert.assertAll();
	}

}
