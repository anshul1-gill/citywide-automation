package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.ATSConstants;
import com.dits.citywide.pages.admin.ApplicantTrackingSystemPage;
import com.dits.citywide.utilities.RandomEmailGenerator;

public class AdminATSTest extends BaseTest {

    private ApplicantTrackingSystemPage atsPage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void createNewATSJobWorkflowTest() throws InterruptedException {

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
//        atsPage.addSkill(ATSConstants.SKILL_QUALIFICATION_NAME);
      
        // ================================
        // 🔹 Step 2: Job Posting Tab
        // ================================
        atsPage.openJobPostingTab();
        atsPage.createJobPost(
        	    ATSConstants.JOB_TITLE,          // title
        	    ATSConstants.JOB_DEPARTMENT,     // department
        	    ATSConstants.JOB_LOCATION,       // branch/location
        	    ATSConstants.JOB_EMPLOYMENT_TYPE,// employmentType
        	    ATSConstants.JOB_END_DATE,       // endDate
        	    ATSConstants.JOB_QUALIFICATIONS, // reqSkill
        	    ATSConstants.JOB_EXPERIENCE,     // expLevel
        	    ATSConstants.JOB_OPENINGS,       // openings
        	    ATSConstants.JOB_SALARY_RANGE,   // salaryRange
        	    ATSConstants.JOB_STATUS,         // jobStatus
        	    ATSConstants.JOB_MODE,           // jobMode
        	    ATSConstants.JOB_FORM_SELECT,    // form       
        	    ATSConstants.JOB_DESCRIPTION,    // jobDesc
        	    ATSConstants.JOB_TITLE_SEARCH      // searchTitle
        	);


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
                ATSConstants.CANDIDATE_RESUME_FILE_PATH                  
        );
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
            ATSConstants.OFFER_EXPIRE_DATE ,
            ATSConstants.OFFER_SUBJECT,
            ATSConstants.OFFER_NOTES
        );

        atsPage.rejectCandidate(ATSConstants.REJECTION_REASON);
        atsPage.openRejectedTab(ATSConstants.BLACKLISTED_REASON);
        
        atsPage.ArchivedTab();
    }
}
