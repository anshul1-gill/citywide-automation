package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.ATSConstants;
import com.dits.citywide.pages.admin.ApplicantTrackingSystemPage;
import com.dits.citywide.utilities.RandomEmailGenerator;

public class AdminATSTest extends BaseTest {

    private ApplicantTrackingSystemPage atsPage;

    @Test(priority = 1)
    public void createNewATSJobWorkflowTest() throws InterruptedException {

        // Login (only needed for admin workflow)
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));

        // Navigate to ATS Module
        dashboardPage.doClickHRManagement();
        Thread.sleep(4000);
        atsPage = dashboardPage.doClickApplicantTrackingSystem();

        // ================================
        // 🔹 Step 1: Settings Tab
        // ================================
        atsPage.openSettingsTab(ATSConstants.JOB_FORM_NAME);
        atsPage.addSourceType(ATSConstants.SOURCE_TYPE_NAME);

        atsPage.addQualification(ATSConstants.JOB_QUALIFICATIONS);
        // atsPage.addSkill(ATSConstants.SKILL_QUALIFICATION_NAME);

        // ================================
        // 🔹 Step 2: Job Posting Tab
        // ================================
        atsPage.openJobPostingTab();
        atsPage.createJobPost(
                ATSConstants.JOB_TITLE, // title
                ATSConstants.JOB_DEPARTMENT, // department
                ATSConstants.JOB_LOCATION, // branch/location
                ATSConstants.JOB_EMPLOYMENT_TYPE, // employmentType
                ATSConstants.JOB_END_DATE, // endDate
                ATSConstants.JOB_QUALIFICATIONS, // reqSkill
                ATSConstants.JOB_EXPERIENCE, // expLevel
                ATSConstants.JOB_OPENINGS, // openings
                ATSConstants.JOB_SALARY_RANGE, // salaryRange
                ATSConstants.JOB_STATUS, // jobStatus
                ATSConstants.JOB_MODE, // jobMode
                ATSConstants.JOB_FORM_SELECT, // form
                ATSConstants.JOB_DESCRIPTION, // jobDesc
                ATSConstants.JOB_TITLE_SEARCH, // searchTitle
                ATSConstants.SCREENING_QUESTION_1,
                ATSConstants.SCREENING_QUESTION_2);

        // ================================
        // 🔹 Step 3: Applicants Tab
        // ================================
        atsPage.openApplicantsTab();
        atsPage.addApplicant(
                ATSConstants.CANDIDATE_FIRSTNAME,
                ATSConstants.CANDIDATE_LASTNAME,
                RandomEmailGenerator.generateRandomEmailForUser(),
                ATSConstants.CANDIDATE_PHONE,
                ATSConstants.CANDIDATE_POSITIONS,
                ATSConstants.CANDIDATE_SOURCE,
                ATSConstants.CANDIDATE_SKILLS,
                ATSConstants.CANDIDATE_EMPLOYEE,
                ATSConstants.CANDIDATE_ROLE,
                ATSConstants.CANDIDATE_STATUS,
                ATSConstants.CANDIDATE_RESUME_FILE_PATH);
        atsPage.screenApplicant();
        atsPage.InterviewTab(
                ATSConstants.TIME_SLOT,
                ATSConstants.INTERVIEW_START,
                ATSConstants.INTERVIEW_MODE,
                ATSConstants.INTERVIEW_ADDRESS,
                RandomEmailGenerator.generateRandomEmailForUser(),
                ATSConstants.INTERVIEWER_NAME

        );

        // ================================
        // 🔹 Step 5: Send Offer Tab
        // ================================
        atsPage.SendOfferTab();
        atsPage.sendOffer(
                ATSConstants.OFFER_EXPIRE_DATE,
                ATSConstants.OFFER_SUBJECT,
                ATSConstants.OFFER_NOTES);

        atsPage.rejectCandidate(ATSConstants.REJECTION_REASON);
        atsPage.openRejectedTab(ATSConstants.BLACKLISTED_REASON);

        atsPage.ArchivedTab();
    }

    // ============================================================
    // 🔹 Priority Test 1: Verify Job Postings Visible on Public Link
    // ============================================================
    @Test(priority = 2)
    public void verifyJobPostingsVisibleOnPublicLink() throws InterruptedException {
        atsPage = new ApplicantTrackingSystemPage(driver);

        boolean isVisible = atsPage.verifyJobPostingsVisible(driver, ATSConstants.ATS_PUBLIC_JOB_LINK);
        assert isVisible : "❌ Job postings are NOT visible on the public link!";
        System.out.println("✅ Job postings are visible on the public link.");
    }

    // ============================================================
    // 🔹 Priority Test 2: Apply for Job Through Public Link
    // ============================================================
    @Test(priority = 3)
    public void applyForJobThroughPublicLink() throws InterruptedException {
        atsPage = new ApplicantTrackingSystemPage(driver);

        // Navigate to public job link
        driver.get(ATSConstants.ATS_PUBLIC_JOB_LINK);
        Thread.sleep(5000);

        // Click Apply on first job posting
        atsPage.clickApplyOnFirstJob();

        // Fill and submit the application form
        atsPage.applyThroughLink(
                ATSConstants.LINK_APPLICANT_FIRSTNAME,
                ATSConstants.LINK_APPLICANT_LASTNAME,
                ATSConstants.LINK_APPLICANT_BIRTHDATE,
                RandomEmailGenerator.generateRandomEmailForUser(),
                ATSConstants.LINK_APPLICANT_ALT_EMAIL,
                ATSConstants.LINK_APPLICANT_PHONE,
                ATSConstants.LINK_APPLICANT_ALT_PHONE,
                ATSConstants.LINK_EMERGENCY_NAME,
                ATSConstants.LINK_EMERGENCY_PHONE,
                ATSConstants.LINK_EMERGENCY_RELATION,
                ATSConstants.LINK_RESIDENCE_STREET,
                ATSConstants.LINK_RESIDENCE_STREET_NAME,
                ATSConstants.LINK_RESIDENCE_STNO,
                ATSConstants.LINK_RESIDENCE_ZIPCODE,
                ATSConstants.LINK_DRIVER_STATE,
                ATSConstants.LINK_DRIVER_LICENSE_NUMBER,
                ATSConstants.LINK_DRIVER_ISSUE_DATE,
                ATSConstants.LINK_DRIVER_EXPIRY_DATE,
                ATSConstants.CANDIDATE_RESUME_FILE_PATH);

        System.out.println("✅ Successfully applied for job through public link.");
    }
}
