package com.dits.citywide.constants;

import java.util.List;

public class CompanySettingsConstant {

	// Add Break Data
	public static final String BREAK_NAME = "Lunch Break Test";
	public static final String BREAK_DURATION = "45min";
	public static final String PAYMENT_TYPE = "Paid";
	public static final String ACTIVITY_CODE = "CODE 8";
	public static final String BREAK_DESCRIPTION = "Lunch break for employees during work hours";

	// Update Break Data
	public static final String BREAK_EDIT_NAME = "Lunch Break Test Updated";
	public static final String BREAK_EDIT_DURATION = "30min";
	public static final String PAYMENT_EDIT_TYPE = "Unpaid";
	public static final String ACTIVITY_EDIT_CODE = "CODE 7";
	public static final String BREAK_EDIT_DESCRIPTION = "Updated lunch break description for employees";

	// Add Holiday Data - Federal Holiday
	public static final String HOLIDAY_NAME = "Martin Luther King Jr Day";
	public static final String START_TIME = "09:30";
	public static final String END_TIME = "23:59";
	public static final String RECURRING = "Yes";
	public static final String PAYMENT_HOLIDAY_TYPE = "Paid";
	public static final String HOLIDAY_DESCRIPTION = "This is a test federal holiday description.";

	// Update Holiday Data
	public static final String HOLIDAY_EDIT_NAME = "Martin Luther King Jr Day";
	public static final String HOLIDAY_EDIT_START_TIME = "10:00";
	public static final String HOLIDAY_EDIT_END_TIME = "22:00";
	public static final String HOLIDAY_EDIT_RECURRING = "No";
	public static final String HOLIDAY_EDIT_PAYMENT_TYPE = "Unpaid";
	public static final String HOLIDAY_EDIT_DESCRIPTION = "Updated description for the federal holiday.";

	public static final String DELETE_HOLIDAY_CONFIRMATION_MESSAGE = "This action will permanently delete the holiday.";

	// Add Holiday Data - Custome Holiday
	public static final String CUSTOM_HOLIDAY_NAME = "Custom Holiday Test";
	public static final String CUSTOM_HOLIDAY_START_DATE = "06/15/2025"; // Format: MM/dd/yyyy
	public static final String CUSTOM_HOLIDAY_START_TIME = "08:00";
	public static final String CUSTOM_HOLIDAY_END_TIME = "17:00";
	public static final String CUSTOM_HOLIDAY_RECURRING = "No";
	public static final String CUSTOM_HOLIDAY_PAYMENT_TYPE = "Unpaid";
	public static final String CUSTOM_HOLIDAY_DESCRIPTION = "This is a test custom holiday description.";

	// Update Custom Holiday
	public static final String CUSTOM_HOLIDAY_EDIT_NAME = "Custom Holiday Test Updated";
	public static final String CUSTOM_HOLIDAY_EDIT_START_DATE = "06/14/2025"; // Format: MM/dd/yyyy
	public static final String CUSTOM_HOLIDAY_EDIT_START_TIME = "09:00";
	public static final String CUSTOM_HOLIDAY_EDIT_END_TIME = "18:00";
	public static final String CUSTOM_HOLIDAY_EDIT_RECURRING = "Yes";
	public static final String CUSTOM_HOLIDAY_EDIT_PAYMENT_TYPE = "Unpaid";
	public static final String CUSTOM_HOLIDAY_EDIT_DESCRIPTION = "Updated description for the custom holiday.";

	// Add Leave Data
	public static final String LEAVE_NAME = "Vacation Leave";
	public static final String NUMBER_OF_DAYS = "10";
	public static final String LEAVE_DESCRIPTION = "Annual vacation leave for employees";

	// Update Leave Data
	public static final String LEAVE_EDIT_NAME = "Vacation Leave Updated";
	public static final String LEAVE_EDIT_NUMBER_OF_DAYS = "12";
	public static final String LEAVE_EDIT_DESCRIPTION = "Updated annual vacation leave description for employees";

	// Add Activity Template Data
	public static final String ACTIVITY_TEMPLATE_NAME = "Activity Template Test";
	public static final String ACTIVITY_CODE_NAME = "10-16";
	public static final String QUESTION_TYPE = "LARGE TEXT AREA";
	public static final String QUESTION_TEXT = "What are your goals for this year?";

	// Add Beats Data
	public static final String BEAT_ID = "B001";
	public static final String BEAT_NAME = "Downtown Beat";
	public static final String SHIFT_TYPE = "Night";
	public static final String NUMBER_OF_SITES = "Richmond";

	// Update Beats Data

	public static final String BEAT_EDIT_ID = "B002";
	public static final String BEAT_EDIT_NAME = "Uptown Beat";
	public static final String BEAT_EDIT_SHIFT_TYPE = "Daytime";
	public static final String BEAT_EDIT_NUMBER_OF_SITES = "Houston";

	public static final String DELETED_BEAT_SUCCESS_MESSAGE = "Beat deleted successfully";

	// Add Violation Data
	public static final String VIOLATION_NAME = "Speeding Violation";
	public static final String VIOLATION_DESCRIPTION = "Exceeding the speed limit by more than 20 mph";
	public static final String VIOLATION_BRANCH = "Riverside";

	public static final String ADD_VIOLATION_SUCCESS_MESSAGE = "Citation Violation added successfully";

	public static final String VIOLATION_EDIT_NAME = "Speeding Violation Updated";
	public static final String VIOLATION_EDIT_DESCRIPTION = "Exceeding the speed limit by more than 30 mph";
	public static final String VIOLATION_EDIT_BRANCH = "Downtown";

	public static final String UPDATE_VIOLATION_SUCCESS_MESSAGE = "Parking violation updated successfully";

	public static final String DELETE_VIOLATION_SUCCESS_MESSAGE = "Violation deleted successfully]";

	// Add Charges Data
	public static final String CHARGE_CODE = "CHG001";
	public static final String CHARGE_DESCRIPTION = "Charge for parking violations exceeding 30 minutes";
	public static final String ADD_CHARGE_SUCCESS_MESSAGE = "Charge code added successfully";

	public static final String CHARGE_EDIT_CODE = "CHG002";
	public static final String CHARGE_EDIT_DESCRIPTION = "Updated charge for parking violations exceeding 30 minutes";

	public static final String UPDATE_CHARGE_SUCCESS_MESSAGE = "Charge code updated successfully";

	public static final String DELETE_CHARGE_SUCCESS_MESSAGE = "Charge code deleted successfully";

	// Add new template data
	public static final String ACTIVITY_TEMPLATE_NAME_TEST = "Activity Template Test";
	public static final String ACTIVITY_CODE_TEST = "Prisoner";
	public static final String QUESTION_TYPE_TEST = "LARGE TEXT AREA";
	public static final String QUESTION_TEXT_TEST = "What are your goals for this year?";

	public static final String ADD_NEW_TEMPLATE_CONTENT = "Sample Template Content";
	public static final String ACTIVITY_TEMPLATE_SUCCESS_MESSAGE = "Activity template added successfully";

	// Update Template Data

	public static final String QUESTION_TYPE_UPDATED = "SINGLE LINE TEXT";
	public static final String QUESTION_TEXT_UPDATED = "Updated question text for the activity template";

	// Responding Agencies Data
	public static final String AGENCY_TYPE_NAME = "Fire Department";
	public static final String ADD_AGENCY_TYPE_SUCCESS_MESSAGE = "Agency type added successfully";

	// Update Agency Type Data
	public static final String AGENCY_TYPE_NAME_UPDATED = "Fire Department Updated";
	public static final String UPDATE_AGENCY_TYPE_SUCCESS_MESSAGE = "Agency type updated successfully";

	public static final String DELETE_AGENCY_TYPE_SUCCESS_MESSAGE = "Agency type deleted successfully";

	// Add Agency Data

	public static final String AGENCY_TYPE = "Fire";
	public static final String AGENCY_NAME = "City Fire Department";
	public static final String AGENCY_CONTACT_NUMBER = "123456789";
	public static final String AGENCY_ALTERNATE_PHONE_NUMBER = "987654321";
	public static final String AGENCY_LIAISON_OFFICER = "John Doe";

	public static final String ADD_AGENCY_SUCCESS_MESSAGE = "Agency added successfully";

	// Update Agency Data
	public static final String AGENCY_TYPE_UPDATED = "Other";
	public static final String AGENCY_NAME_UPDATED = "City Fire Department Updated";
	public static final String AGENCY_CONTACT_NUMBER_UPDATED = "1234567890";
	public static final String AGENCY_ALTERNATE_PHONE_NUMBER_UPDATED = "0987654321";
	public static final String AGENCY_LIAISON_OFFICER_UPDATED = "Jane Doe";

	public static final String UPDATE_AGENCY_SUCCESS_MESSAGE = "Agency updated successfully";

	public static final String DELETE_AGENCY_SUCCESS_MESSAGE = "Agency deleted successfully";

	// HR Configurations Data
	// Add Notification Type Data
	public static final String NOTIFICATION_TYPE_NAME = "New Employee Onboarding";
	public static final String EMPLOYEE_NAME = "John Smith";
	public static final String NOTIFICATION_EMAILS = "john@yopmail.com";

	public static final String ADD_NOTIFICATION_TYPE_SUCCESS_MESSAGE = "Notification type added successfully";

	// Allowance Type Data
	public static final String ALLOWANCE_TYPE_NAME = "Housing Allowance";
	public static final String ADD_ALLOWANCE_TYPE_SUCCESS_MESSAGE = "Allowance type created successfully";

	public static final String ALLOWANCE_TYPE_UPDATED_NAME = "Housing Allowance Updated";
	public static final String ALLOWANCE_TYPE_UPDATE_SUCCESS_MESSAGE = "Allowance type updated successfully";

	public static final String ALLOWANCE_TYPE_DELETE_SUCCESS_MESSAGE = "Allowance type deleted successfully";

	// Department Data
	public static final String DEPARTMENT_NAME = "Human Resources";
	public static final String ADD_DEPARTMENT_SUCCESS_MESSAGE = "Department added successfully";

	public static final String DEPARTMENT_UPDATED_NAME = "Human Resources Updated";
	public static final String DEPARTMENT_UPDATE_SUCCESS_MESSAGE = "Department updated successfully";

	public static final String DEPARTMENT_DELETE_SUCCESS_MESSAGE = "Department deleted successfully";

	// WC Class Code Data
	public static final String WC_CLASS_CODE_NAME = "Class Code 1234";
	public static final String ADD_WC_CLASS_CODE_SUCCESS_MESSAGE = "WC Class code added successfully";

	public static final String WC_CLASS_CODE_UPDATED_NAME = "Class Code 1234 Updated";
	public static final String WC_CLASS_CODE_UPDATE_SUCCESS_MESSAGE = "WC Class code updated successfully";

	public static final String WC_CLASS_CODE_DELETE_SUCCESS_MESSAGE = "WC class code deleted successfully";

	// Employment Type Data
	public static final String EMPLOYMENT_TYPE_NAME = "Full-Time";
	public static final String ADD_EMPLOYMENT_TYPE_SUCCESS_MESSAGE = "Employment type added successfully";

	public static final String EMPLOYMENT_TYPE_EDIT_NAME = "Full-Time Updated";
	public static final String EMPLOYMENT_TYPE_UPDATE_SUCCESS_MESSAGE = "Employment type updated successfully";

	public static final String EMPLOYMENT_TYPE_DELETE_SUCCESS_MESSAGE = "Employment type deleted successfully";

	// Team Support Template Data
	// Template Info
	public static final String TEMPLATE_NAME = "Patrol Support - Incident Reporting";
	public static final String DEPARTMENT = "Dispatch";
	public static final String ASSIGNED_TO = "843";
	public static final String DECISION_MAKER = "898";
	public static final String STATUS = "Active";
	public static final String DESCRIPTION = "Form for reporting incidents during patrol shifts with required details";

	// Text Input
	public static final String TEXT_INPUT_TO_DISPLAY = "Describe about the incident";
	public static final String TEXT_LABEL_TO_DISPLAY = "Describe the incident or issue faced during patrol?";

	// Number
	public static final String NUMBER_TEXT_TO_DISPLAY = "Enter the Count";
	public static final String NUMBER_LABEL_TO_DISPLAY = "Number of Officers Involved?";

	// Text Area
	public static final String TEXTAREA_TEXT_TO_DISPLAY = "Additional Notes";
	public static final String TEXTAREA_LABEL_TO_DISPLAY = "Additional Notes or Instructions";

	// Dropdown
	public static final String DROPDOWN_TEXT_TO_DISPLAY = "Select support";
	public static final String DROPDOWN_LABEL_TO_DISPLAY = "Type of Support Required";
	public static final List<String> DROPDOWN_OPTIONS = List.of("Medical Emergency", "Backup Request",
			"Vehicle Assistance");

	// Date Field
	public static final String DATE_TEXT_TO_DISPLAY = "Select the date of incident";
	public static final String DATE_LABEL_TO_DISPLAY = "Select the date of incident?";

	// Radio Button
	public static final String RADIO_TEXT_TO_DISPLAY = "Patrol Vehicle Condition";
	public static final String RADIO_LABEL_TO_DISPLAY = "What is the condition of your patrol vehicle before starting the shift?";
	public static final List<String> RADIO_OPTIONS = List.of("Good", "Needs Maintenance", "Not Assigned");

	// Email
	public static final String EMAIL_TEXT_TO_DISPLAY = "Enter your email";
	public static final String EMAIL_LABEL_TO_DISPLAY = "Email Address";

	// File Upload
	public static final String FILEUPLOAD_TEXT_TO_DISPLAY = "Upload Patrol Shift Assistance Document";
	public static final String FILEUPLOAD_LABEL_TO_DISPLAY = "Attach supporting file for Patrol Shift Assistance (PDF only)";
	public static final String TEMPLATE_SUCCESS_MESSAGE = "Template created successfully";
	
	// Activity Code Constants
	public static final String ACTIVITY_CODE_NAMES = "Test Activity Code";
	public static final String ACTIVITY_CODE_DESCRIPTION = "Test Description for Activity Code";
	public static final String ACTIVITY_CODE_PRIORITY = "High";
	
	public static final String ACTIVITY_CODE_EDIT_NAME = "Updated Patrol Response";
	public static final String ACTIVITY_CODE_EDIT_DESCRIPTION = "Updated description for patrol response code.";
	public static final String ACTIVITY_CODE_EDIT_PRIORITY = "Low";
	
	public static final String DELETED_ACTIVITY_CODE_SUCCESS_MESSAGE = "Record deleted successfully.";
	
	//-----------ServiceTypeName-----------
	public static final String SERVICE_TYPE_NAME = "Standard Patrol Service";
	public static final String SERVICE_TYPE_CODE = "SP001";
	public static final String SERVICE_TYPE_DESCRIPTION = "This service type covers standard patrol operations for urban areas";
	
	// ---------- Service Type (Update Test Data) ----------
	public static final String SERVICE_TYPE_EDIT_NAME = "Emergency Response Service Updated";
	public static final String SERVICE_TYPE_EDIT_CODE = "ERS-UPD";
	public static final String SERVICE_TYPE_EDIT_DESCRIPTION = "Updated description for Emergency Response Service type.";

	
    // --------- Service Status Dropdown ----------
    public static final String STATUS_NO = "No";
    public static final String STATUS_YES = "Yes";

    // --------- Main Service Dropdown ----------
    public static final String SERVICE_MOBILE_MULTIPLE_SITES = "Mobile/Multiple Sites";
    public static final String SERVICE_STATIONARY_SINGLE_SITE = "Stationary/Single Site";

    // --------- Department Dropdown ----------
    public static final String DEPT_ADMIN = "Admin";
    public static final String DEPT_DISPATCH = "Dispatch";
    public static final String DEPT_PATROL = "Patrol";
    public static final String DEPT_FIELD = "Field";
    
    public static final String RANK_NAME = "Senior Officer";
    public static final String RANK_ORDER = "19";
    public static final String UPDATED_RANK_NAME = "Senior Sergeant";
    public static final String UPDATED_RANK_ORDER = "20";

    
 // ==============================
 // Rank & Position Constants
 // ==============================
    public static final String RANK_BRANCH_SELECTALL = "Select all";
 public static final String RANK_BRANCH_RIVERSIDE = "Riverside";
 public static final String RANK_BRANCH_SAN_DIEGO = "Sandiego";
 
 public static final String ASSIGNMENT_TEMPLATE_NAME = "Security Site Check Template";
 public static final String UPDATED_TEMPLATE_NAME = "Updated Security Site Check Template";

 // Dropdown options
 public static final String ASSIGNMENT_ACTIVITY_CODE = "10-1 - Receiving Poorly";
 public static final String BRANCH_NAME = "Riverside";
 public static final String ASSIGNMENT_QUESTION_TYPE = "PHOTO UPLOAD";

 // Question and Description
 public static final String ASSIGNMENT_QUESTION_TEXT = "Is the site perimeter secured?";
 public static final String DESCRIPTION_TEXT = "This question ensures guards check all site entry points.";
 
 public static final String UPDATED_ASSIGNMENT_NAME = "Updated Night Patrol Routine";

 public static final String UPDATED_ACTIVITY_CODE = "10-23 - Stand By";
 public static final String UPDATED_QUESTION_TYPE = "LARGE TEXT AREA";
 public static final String UPDATED_QUESTION = "Is the perimeter secure after inspection?";
 public static final String UPDATED_DESCRIPTION = "Ensure the updated procedure covers all checkpoints.";

	// Add FI-Crime Potential Data
	public static final String CRIME_NAME = "Crime Potential Test";
	public static final String CRIME_DESCRIPTION = "Potential crime for testing purposes";
	public static final String ADD_CRIME_SUCCESS_MESSAGE = "FI - Crime Potential added successfully";

	public static final String CRIME_EDIT_NAME = "Crime Potential Test Updated";
	public static final String CRIME_EDIT_DESCRIPTION = "Updated potential crime for testing purposes";
	public static final String UPDATE_CRIME_SUCCESS_MESSAGE = "FI - Crime Potential updated successfully";

	public static final String DELETE_CRIME_SUCCESS_MESSAGE = "FI - Crime Potential deleted successfully";

}
