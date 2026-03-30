package com.dits.citywide.constants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * ATS Test Constants with DYNAMIC data generation.
 *
 * Values that must match existing system dropdown options stay static.
 * Values that the test CREATES (names, titles, etc.) get a unique suffix
 * so every run produces fresh data without manual changes.
 */
public class ATSConstants {

    // ── Unique suffix for this run (random alphabetic) ──
    private static final Random RANDOM = new Random();
    private static final String RUN_ID = generateAlphaId(4);

    private static String generateAlphaId(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char) ('A' + RANDOM.nextInt(26)));
        }
        return sb.toString();
    }

    // ============================================================
    //  Settings - Job Post Form
    // ============================================================
    public static final String JOB_FORM_NAME = "CorrOfficer" + RUN_ID;

    // Settings - Source Type  (static → must match existing dropdown)
    public static final String SOURCE_TYPE_NAME = "Referral" + RUN_ID;

    // Settings - Skill/Qualification
    public static final String SKILL_QUALIFICATION_NAME = "GeneralEdu" + RUN_ID;

    // ============================================================
    //  Job Post Form
    // ============================================================
    public static final String JOB_TITLE = "Dispatch" + RUN_ID;

    // These SELECT from existing system dropdowns → keep static
    public static final String JOB_DEPARTMENT = "HR";
    public static final String JOB_LOCATION = "Riverside";
    public static final String JOB_EMPLOYMENT_TYPE = "Full time shift";

    // Dynamic future date (30 days from today)
    public static final String JOB_END_DATE = LocalDate.now()
            .plusDays(30)
            .format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

    public static final String JOB_QUALIFICATIONS = "Advance Educational Development";
    public static final String JOB_EXPERIENCE = "2 years";
    public static final String JOB_OPENINGS = String.valueOf(RANDOM.nextInt(5) + 1);
    public static final String JOB_SALARY_RANGE = "40000 - 60000";

    // Dropdown selections → static
    public static final String JOB_STATUS = "Published";
    public static final String JOB_MODE = "Remote";

    // Must match the form created in Settings step
    public static final String JOB_FORM_SELECT = JOB_FORM_NAME;

    public static final String JOB_DESCRIPTION = "Hiring for dispatch position - run " + RUN_ID;
    public static final String JOB_TITLE_SEARCH = JOB_TITLE;

    // Pre-Screening Questions
    public static final String SCREENING_QUESTION_1 = "Are you legally authorized to work in the United States?";
    public static final String SCREENING_QUESTION_2 = "Do you have any prior criminal convictions?";

    // ============================================================
    //  Candidate Info
    // ============================================================
    private static final String[] FIRST_NAMES = {"James", "Sarah", "Michael", "Emily", "David", "Anna", "Robert", "Lisa", "John", "Maria"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Wilson", "Taylor"};

    public static final String CANDIDATE_FIRSTNAME = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
    public static final String CANDIDATE_LASTNAME = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)] + RUN_ID;
    public static final String CANDIDATE_EMAIL = "candidate" + System.currentTimeMillis() + "@ditstek.com";
    public static final String CANDIDATE_PHONE = "1" + String.format("%09d", RANDOM.nextInt(999999999));

    // Must match the job title created in this run
    public static final String CANDIDATE_POSITIONS = JOB_TITLE;

    // Dropdown selections → static
    public static final String CANDIDATE_SOURCE = "Referral";
    public static final String CANDIDATE_SKILLS = "MCA";
    public static final String CANDIDATE_EMPLOYEE = "Dallas Police Department (DPD)";
    public static final String CANDIDATE_ROLE = "Deputy Chief";
    public static final String CANDIDATE_STATUS = "Sourced";

    public static final String CANDIDATE_RESUME_FILE_PATH = System.getProperty("user.dir") + "/src/test/resource/testdata/sample.pdf";

    // ============================================================
    //  Interview
    // ============================================================
    public static final String INTERVIEW_DATE = LocalDate.now()
            .plusDays(7)
            .format(DateTimeFormatter.ofPattern("M/d/yyyy"));

    public static final String TIME_SLOT = "45 Minutes";
    public static final String INTERVIEW_START = "05:45";
    public static final String INTERVIEW_MODE = "Walk In";
    public static final String INTERVIEW_ADDRESS = "D-210 Ditstek";
    public static final String INTERVIEWER_NAME = "Jack Smith";
    public static final String INTERVIEWER_NOTES = "The candidate has cleared the Interview.";

    // ============================================================
    //  Offer
    // ============================================================
    public static final String OFFER_EXPIRE_DATE = LocalDate.now()
            .plusDays(14)
            .format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

    public static final String OFFER_SUBJECT = "DISPATCH POSITION - " + RUN_ID;
    public static final String OFFER_NOTES = "Hi Candidate, You have successfully cleared the interview";

    // ============================================================
    //  Rejection / Blacklist
    // ============================================================
    public static final String REJECTION_REASON = "Candidate did not meet criteria.";
    public static final String BLACKLISTED_REASON = "Bad candidate";

    // ============================================================
    //  ATS Public Job Link
    // ============================================================
    public static final String ATS_PUBLIC_JOB_LINK = "https://stage.commandhubsolutions.com/chs-jobs/ddc87469-0f00-4d22-8d14-bd52ba0a7679";

    // Apply Through Link - Applicant Data
    public static final String LINK_APPLICANT_FIRSTNAME = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
    public static final String LINK_APPLICANT_LASTNAME = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)] + RUN_ID;
    public static final String LINK_APPLICANT_BIRTHDATE = "01/15/1995";
    public static final String LINK_APPLICANT_ALT_EMAIL = "alt" + System.currentTimeMillis() + "@ditstek.com";
    public static final String LINK_APPLICANT_PHONE = "1" + String.format("%09d", RANDOM.nextInt(999999999));
    public static final String LINK_APPLICANT_ALT_PHONE = "1" + String.format("%09d", RANDOM.nextInt(999999999));
    public static final String LINK_EMERGENCY_NAME = "Emergency Contact " + RUN_ID;
    public static final String LINK_EMERGENCY_PHONE = "1" + String.format("%09d", RANDOM.nextInt(999999999));
    public static final String LINK_EMERGENCY_RELATION = "Spouse";

    // Residence Address
    public static final String LINK_RESIDENCE_STREET = "123 Main St";
    public static final String LINK_RESIDENCE_STREET_NAME = "Apt 4B";
    public static final String LINK_RESIDENCE_STNO = "Suite 100";
    public static final String LINK_RESIDENCE_ZIPCODE = "75001";

    // Driver License
    public static final String LINK_DRIVER_STATE = "Texas";
    public static final String LINK_DRIVER_LICENSE_NUMBER = String.format("%014d", Math.abs(RANDOM.nextLong() % 100000000000000L));
    public static final String LINK_DRIVER_ISSUE_DATE = LocalDate.now()
            .minusYears(2)
            .format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    public static final String LINK_DRIVER_EXPIRY_DATE = LocalDate.now()
            .plusYears(3)
            .format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
}
