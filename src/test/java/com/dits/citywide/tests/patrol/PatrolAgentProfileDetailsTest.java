package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.LinkedHashMap;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.PatrolAgentConstants;
import com.dits.citywide.pages.fieldagent.FieldAgentProfileDetailsPage;
import com.dits.citywide.pages.patrol.PatrolStartShiftPage;
import com.dits.citywide.constants.HRManagementConstants;

public class PatrolAgentProfileDetailsTest extends BaseTest {
    private PatrolStartShiftPage patrolStartShiftPage;
    private FieldAgentProfileDetailsPage fieldAgentProfileDetailsPage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void verifyAllPatrolAgentProfileTabs() {
        patrolStartShiftPage.clickOnHRManagementMenu();
        fieldAgentProfileDetailsPage = patrolStartShiftPage.clickOnProfile();

        // Select Officer using Patrol-specific HRManagementConstants
        String officerFullName = HRManagementConstants.FIRST_NAME_PATROL + " " +
                                 HRManagementConstants.MIDDLE_NAME_PATROL + " " +
                                 HRManagementConstants.LAST_NAME_PATROL;

        patrolStartShiftPage.selectUserByName(officerFullName);

        /** ---------------- PERSONAL INFORMATION TAB ---------------- */
        Map<String, String> personalInfoFields = new LinkedHashMap<>();
        personalInfoFields.put("Officer", officerFullName); // Add badge number if needed
        personalInfoFields.put("Email Address", prop.getProperty("patrolPrimaryEmail"));
        personalInfoFields.put("Email (Primary)", prop.getProperty("patrolPrimaryEmail"));
        personalInfoFields.put("Email (Alternate)", prop.getProperty("patrolSecondaryEmail"));
        personalInfoFields.put("Gender", HRManagementConstants.GENDER_PATROL);
        personalInfoFields.put("Branches", HRManagementConstants.BRANCHES);
        personalInfoFields.put("Phone (Primary)", HRManagementConstants.PRIMARY_PHONE_NUMBER);
        personalInfoFields.put("Phone (Alternate)", HRManagementConstants.ALTERNATE_PHONE_NUMBER);
        personalInfoFields.put("Emergency contact name", HRManagementConstants.EMERGENCY_NAME);
        personalInfoFields.put("Phone (Emergency)", HRManagementConstants.EMERGENCY_PHONE_NUMBER);
        personalInfoFields.put("Notes", HRManagementConstants.PERSONAL_INFO_NOTES);

        fieldAgentProfileDetailsPage.validatePersonalInformationTab(personalInfoFields);

        /** ---------------- EMPLOYMENT INFORMATION TAB ---------------- */
        fieldAgentProfileDetailsPage.validateEmploymentInformationTab(getEmploymentFields());

        /** ---------------- PERMITS TAB ---------------- */
        fieldAgentProfileDetailsPage.validatePermitsTab(getPermitFields());

        /** ---------------- PAY INFO TAB ---------------- */
        fieldAgentProfileDetailsPage.validatePayInfoTab(getPayInfoFields());

        /** ---------------- ADDITIONAL DOCUMENTS TAB ---------------- */
        fieldAgentProfileDetailsPage.validateAdditionalDocumentsTab(getAdditionalDocFields());

        /** ---------------- REFERENCES TAB ---------------- */
        fieldAgentProfileDetailsPage.validateReferencesTab(getReferenceFields());

        /** ---------------- AVAILABLE TIMES TAB ---------------- */
        fieldAgentProfileDetailsPage.validateAvailableTimesTab(getAvailableTimesFields());

        /** ---------------- TRAINING TAB ---------------- */
        fieldAgentProfileDetailsPage.validateTrainingTab(getTrainingFields());

        /** ---------------- COMMENTS TAB ---------------- */
        fieldAgentProfileDetailsPage.validateCommentsTab();

        softAssert.assertAll();
    }

    // --- STUBS AND PLACEHOLDERS TO FIX COMPILATION ERRORS ---
    private void verifyTabFields(Map<String, String> fields) {
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            String fieldName = entry.getKey();
            String expectedValue = entry.getValue();
            String actualValue = fieldAgentProfileDetailsPage.getFieldValue(fieldName);
            softAssert.assertEquals(actualValue, expectedValue, "Mismatch for field: " + fieldName);
        }
    }

    private Map<String, String> getPermitFields() {
        Map<String, String> permitFields = new LinkedHashMap<>();
        permitFields.put("Permit Number", HRManagementConstants.DRIVER_LICENSE_NUMBER);
        permitFields.put("Permit State", HRManagementConstants.DRIVER_LICENSE_STATE);
        return permitFields;
    }

    private Map<String, String> getEmploymentFields() {
        Map<String, String> employmentFields = new LinkedHashMap<>();
        employmentFields.put("Position", HRManagementConstants.ROLE_PATROL);
        employmentFields.put("Rank", HRManagementConstants.RANK_PATROL);
        employmentFields.put("Employment Status", HRManagementConstants.EMPLOYMENT_STATUS);
        employmentFields.put("Hire Date", HRManagementConstants.EMPLOYMENT_HIRE_DATE + "-" + HRManagementConstants.EMPLOYMENT_HIRE_MONTH + "-" + HRManagementConstants.EMPLOYMENT_HIRE_YEAR);
        employmentFields.put("Employment Type", HRManagementConstants.EMPLOYMENT_TYPE);
        employmentFields.put("Department Type", HRManagementConstants.DEPARTMENT_TYPE);
        employmentFields.put("Notes", HRManagementConstants.EMPLOYMENT_NOTES);
        return employmentFields;
    }

    private Map<String, String> getPayInfoFields() {
        Map<String, String> payInfoFields = new LinkedHashMap<>();
        payInfoFields.put("Pay Rate", PatrolAgentConstants.PAY_RATE);
        return payInfoFields;
    }

    private Map<String, String> getAdditionalDocFields() {
        Map<String, String> docFields = new LinkedHashMap<>();
        docFields.put("Document Name", HRManagementConstants.CLASS_CODE);
        docFields.put("Document Date", HRManagementConstants.CLASS_CODE_DATE + "-" + HRManagementConstants.CLASS_CODE_MONTH + "-" + HRManagementConstants.CLASS_CODE_YEAR);
        return docFields;
    }

    private Map<String, String> getReferenceFields() {
        Map<String, String> referenceFields = new LinkedHashMap<>();
        referenceFields.put("Reference Name", HRManagementConstants.EMERGENCY_NAME);
        referenceFields.put("Reference Phone", HRManagementConstants.EMERGENCY_PHONE_NUMBER);
        referenceFields.put("Reference Relationship", HRManagementConstants.EMERGENCY_RELATIONSHIP);
        return referenceFields;
    }

    private Map<String, String> getAvailableTimesFields() {
        Map<String, String> availableTimesFields = new LinkedHashMap<>();
        availableTimesFields.put("Available Day", "Monday"); // Example static value, update if dynamic
        return availableTimesFields;
    }

    private Map<String, String> getTrainingFields() {
        Map<String, String> trainingFields = new LinkedHashMap<>();
        trainingFields.put("Training Name", HRManagementConstants.BEAT);
        return trainingFields;
    }
}