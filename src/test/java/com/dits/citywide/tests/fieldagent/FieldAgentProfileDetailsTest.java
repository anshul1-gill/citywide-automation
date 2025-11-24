package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.LinkedHashMap;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.pages.fieldagent.FieldAgentOpenSitesPage;
import com.dits.citywide.pages.fieldagent.FieldAgentStartShiftPage;
import com.dits.citywide.pages.fieldagent.FieldAgentProfileDetailsPage;
import com.dits.citywide.constants.HRManagementConstants;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;

public class FieldAgentProfileDetailsTest extends BaseTest {
    private FieldAgentStartShiftPage fieldAgentStartShiftPage;
    private FieldAgentProfileDetailsPage fieldAgentProfileDetailsPage;


	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

    @Test
    public void verifyAllFieldAgentProfileTabs() {
        fieldAgentStartShiftPage.clickOnHRManagementMenu();
        fieldAgentProfileDetailsPage = fieldAgentStartShiftPage.clickOnProfile();

        // Select Officer
        String officerFullName = HRManagementConstants.FIRST_NAME + " " +
                                 HRManagementConstants.MIDDLE_NAME + " " +
                                 HRManagementConstants.LAST_NAME;

        fieldAgentStartShiftPage.selectUserByName(officerFullName);

        /** ---------------- PERSONAL INFORMATION TAB ---------------- */
        Map<String, String> personalInfoFields = new LinkedHashMap<>();
        // Officer label should contain name and badge number if required
        personalInfoFields.put("Officer", officerFullName); // Add badge number if needed
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
        // For each field, verify the value in the UI matches the expected value
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            String fieldName = entry.getKey();
            String expectedValue = entry.getValue();
            // Assuming FieldAgentProfileDetailsPage has a method getFieldValue(fieldName)
            String actualValue = fieldAgentProfileDetailsPage.getFieldValue(fieldName);
            softAssert.assertEquals(actualValue, expectedValue, "Mismatch for field: " + fieldName);
        }
    }

    private Map<String, String> getPermitFields() {
        Map<String, String> permitFields = new LinkedHashMap<>();
        permitFields.put("Permit Number", HRManagementConstants.PERMIT_NUMBER);
        permitFields.put("Guard Card Issue Date", HRManagementConstants.GUARD_CARD_ISSUE_DATE);
        permitFields.put("Guard Card Expiration Date", HRManagementConstants.GAURD_CARD_EXPIRATION_DATE);
        permitFields.put("Firearms Permit Number", HRManagementConstants.FIREARMS_PERMIT_NUMBER);
        permitFields.put("Firearms Issue Date", HRManagementConstants.FIREARMS_ISSUE_DATE);
        permitFields.put("Firearms Expiration Date", HRManagementConstants.FIREARMS_EXPIRATION_DATE);
        permitFields.put("Baton Permit Number", HRManagementConstants.BATON_PERMIT_NUMBER);
        permitFields.put("Baton Issue Date", HRManagementConstants.BATON_ISSUE_DATE);
        permitFields.put("Baton Expiration Date", HRManagementConstants.BATON_EXPIRATION_DATE);
        permitFields.put("ECD Permit Number", HRManagementConstants.ECD_PERMIT_NUMBER);
        permitFields.put("ECD Issue Date", HRManagementConstants.ECD_ISSUE_DATE);
        permitFields.put("ECD Expiration Date", HRManagementConstants.ECD_EXPIRATION_DATE);
        permitFields.put("OC Spray Permit Number", HRManagementConstants.OC_SPRAY_PERMIT_NUMBER);
        permitFields.put("OC Spray Issue Date", HRManagementConstants.OC_SPRAY_ISSUE_DATE);
        permitFields.put("OC Spray Expiration Date", HRManagementConstants.OC_SPRAY_EXPIRATION_DATE);
        permitFields.put("Other Permit Number", HRManagementConstants.OTHER_PERMIT_NUMBER);
        permitFields.put("Other Permit Issue Date", HRManagementConstants.OTHER_PERMIT_ISSUE_DATE);
        permitFields.put("Other Permit Expiration Date", HRManagementConstants.OTHER_PERMIT_EXPIRATION_DATE);
        return permitFields;
    }

    private Map<String, String> getPayInfoFields() {
        Map<String, String> payInfoFields = new LinkedHashMap<>();
        payInfoFields.put("Employee Pay Rate", HRManagementConstants.EMPLOYEE_PAY_RATE);
        payInfoFields.put("Pay Cycle", HRManagementConstants.PAY_CYCYLE);
        payInfoFields.put("Allowance Rate", HRManagementConstants.ALLOWANCE_RATE);
        payInfoFields.put("Allowance Type", HRManagementConstants.ALLOWANCE_TYPE);
        payInfoFields.put("Commission Name", HRManagementConstants.COMMISSION_NAME);
        payInfoFields.put("Commission Type", HRManagementConstants.COMMISSION_TYPE);
        payInfoFields.put("Commission Rate", HRManagementConstants.COMMISSION_RATE);
        payInfoFields.put("Commission Cycle", HRManagementConstants.COMMISSION_CYCLE);
        payInfoFields.put("Effective Date", HRManagementConstants.EFFECTIVE_DATE);
        return payInfoFields;
    }

    private Map<String, String> getAdditionalDocFields() {
        Map<String, String> docFields = new LinkedHashMap<>();
        docFields.put("Document Name", HRManagementConstants.ADDITIONAL_DOCUMENT_NAME);
        docFields.put("Document Description", HRManagementConstants.ADDITIONAL_DOCUMENT_DESCRIPTION);
        return docFields;
    }

    private Map<String, String> getReferenceFields() {
        Map<String, String> refFields = new LinkedHashMap<>();
        refFields.put("Reference Name", HRManagementConstants.USER_REFERENCES_NAME);
        refFields.put("Reference Relationship", HRManagementConstants.USER_REFERENCES_RELATIONSHIP);
        refFields.put("Reference Title", HRManagementConstants.USER_REFERENCES_TITLE);
        refFields.put("Reference Phone", HRManagementConstants.USER_REFERENCES_PHONE);
        refFields.put("Reference Email", HRManagementConstants.USER_REFERENCES_EMAIL);
        return refFields;
    }

    private Map<String, String> getAvailableTimesFields() {
        Map<String, String> availableTimesFields = new LinkedHashMap<>();
        availableTimesFields.put("Day Shift Start Time", HRManagementConstants.DAY_SHIFT_START_TIME);
        availableTimesFields.put("Day Shift End Time", HRManagementConstants.DAY_SHIFT_END_TIME);
        return availableTimesFields;
    }

    private Map<String, String> getTrainingFields() {
        Map<String, String> trainingFields = new LinkedHashMap<>();
        // Add training fields as per your application, using constants if available
        // Example:
        // trainingFields.put("Training Name", HRManagementConstants.TRAINING_NAME);
        // trainingFields.put("Training Date", HRManagementConstants.TRAINING_DATE);
        return trainingFields;
    }

    private Map<String, String> getEmploymentFields() {
        Map<String, String> employmentFields = new LinkedHashMap<>();
        employmentFields.put("Employment Status", HRManagementConstants.EMPLOYMENT_STATUS);
        employmentFields.put("Hire Month", HRManagementConstants.EMPLOYMENT_HIRE_MONTH);
        employmentFields.put("Hire Year", HRManagementConstants.EMPLOYMENT_HIRE_YEAR);
        employmentFields.put("Hire Date", HRManagementConstants.EMPLOYMENT_HIRE_DATE);
        employmentFields.put("Employment Notes", HRManagementConstants.EMPLOYMENT_NOTES);
        employmentFields.put("Class Code", HRManagementConstants.CLASS_CODE);
        employmentFields.put("Class Code Month", HRManagementConstants.CLASS_CODE_MONTH);
        employmentFields.put("Class Code Year", HRManagementConstants.CLASS_CODE_YEAR);
        employmentFields.put("Class Code Date", HRManagementConstants.CLASS_CODE_DATE);
        employmentFields.put("Employment Type", HRManagementConstants.EMPLOYMENT_TYPE);
        employmentFields.put("Department Type", HRManagementConstants.DEPARTMENT_TYPE);
        return employmentFields;
    }
}