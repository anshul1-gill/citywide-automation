package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.LinkedHashMap;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.pages.fieldagent.FieldAgentProfileDetailsPage;
import com.dits.citywide.pages.admin.EmployeesPage;

public class AdminProfileTest extends BaseTest {
    private EmployeesPage employeesPage;
    private FieldAgentProfileDetailsPage fieldAgentProfileDetailsPage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        loginPage.doLoginAdmin(prop.getProperty("email"),
                prop.getProperty("password"));
        employeesPage = new EmployeesPage(driver);
    }

    @Test
    public void verifyAllAdminProfileTabs() {
        // Navigate to employee profile (implement navigation as needed)
        fieldAgentProfileDetailsPage = new FieldAgentProfileDetailsPage(driver);
        patrolStartShiftPage.clickOnHRManagementMenu();
        fieldAgentProfileDetailsPage = patrolStartShiftPage.clickOnProfile();


        // Select Admin using available HRManagementConstants
        String adminFullName = HRManagementConstants.FIRST_NAME + " " +
                               HRManagementConstants.MIDDLE_NAME + " " +
                               HRManagementConstants.LAST_NAME;

        /** ---------------- PERSONAL INFORMATION TAB ---------------- */
        Map<String, String> personalInfoFields = new LinkedHashMap<>();
        personalInfoFields.put("Admin", adminFullName); // Add badge number if needed
        personalInfoFields.put("Email Address", prop.getProperty("employeePrimaryEmail"));
        personalInfoFields.put("Email (Primary)", prop.getProperty("employeePrimaryEmail"));
        personalInfoFields.put("Email (Alternate)", prop.getProperty("employeeSecondaryEmail"));
        personalInfoFields.put("Gender", HRManagementConstants.GENDER);
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
        employmentFields.put("Position", HRManagementConstants.ROLE_FIELD);
        employmentFields.put("Rank", HRManagementConstants.RANK);
        employmentFields.put("Employment Status", HRManagementConstants.EMPLOYMENT_STATUS);
        employmentFields.put("Hire Date", HRManagementConstants.EMPLOYMENT_HIRE_DATE + "-" + HRManagementConstants.EMPLOYMENT_HIRE_MONTH + "-" + HRManagementConstants.EMPLOYMENT_HIRE_YEAR);
        employmentFields.put("Employment Type", HRManagementConstants.EMPLOYMENT_TYPE);
        employmentFields.put("Department Type", HRManagementConstants.DEPARTMENT_TYPE);
        employmentFields.put("Notes", HRManagementConstants.EMPLOYMENT_NOTES);
        return employmentFields;
    }

    private Map<String, String> getPayInfoFields() {
        Map<String, String> payInfoFields = new LinkedHashMap<>();
        payInfoFields.put("Pay Rate", "N/A"); // No Admin-specific pay rate available
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