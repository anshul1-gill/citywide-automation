package com.dits.citywide.constants;

public class FieldAgentConstants {

	// Welcome Text
	public static final String WELCOME_TEXT = "Hope you are doing well. Lets begin your shift, remember shift also includes breaks please dont hesitate for one !!";

// HR Management 
	// Leavve Request Data
	// Staging data
	public static final String LEAVE_TYPE = "Study";

	// Live data
	// public static final String LEAVE_TYPE = "Vacation";

	public static final String LEAVE_FROM_MONTH = "Nov";
	public static final String LEAVE_FROM_YEAR = "2025";
	public static final String LEAVE_FROM_DATE = "10";

	public static final String LEAVE_TO_MONTH = "Nov";
	public static final String LEAVE_TO_YEAR = "2025";
	public static final String LEAVE_TO_DATE = "11";

	public static final String LEAVE_START_TIME = "04:30";
	public static final String LEAVE_END_TIME = "05:30";

	public static final String LEAVE_DESCRIPTION = "Need to attend a workshop on urban planning and development.";

	// Edit Leave Request Data
	public static final String EDIT_LEAVE_TYPE = "Sick leave";

	public static final String EDIT_LEAVE_FROM_MONTH = "Nov";
	public static final String EDIT_LEAVE_FROM_YEAR = "2025";
	public static final String EDIT_LEAVE_FROM_DATE = "21";

	public static final String EDIT_LEAVE_TO_MONTH = "Nov";
	public static final String EDIT_LEAVE_TO_YEAR = "2025";
	public static final String EDIT_LEAVE_TO_DATE = "22";

	public static final String EDIT_LEAVE_START_TIME = "06:30";
	public static final String EDIT_LEAVE_END_TIME = "07:30";

	public static final String EDIT_LEAVE_DESCRIPTION = "Need to take a day off due to health issues.";

	public static final String LEAVE_CANCEL_VALIDATION_MESSAGE = "This action will cancel this leave.";

	public static final String LEAVE_CANCEL_CONFIRMATION_MESSAGE = "Leave cancelled successfully";

	public static final String LEAVE_STATUS = "Canceled";

	// Attendance Data
	public static final String SHIFT_START = "01:30";
	public static final String CHECK_IN = "02:02";
	public static final String SHIFT_END = "13:30";
	public static final String CHECK_OUT = "13:30";
	public static final String SHIFT_HOURS = "12:00:00";
	public static final String BREAK_DURATION = "00:30";
	public static final String ACTUAL_BREAK = "00:30";
	public static final String TOTAL_HOURS = "11:28:00";
	public static final String STATUS = "Completed";

	// Start Shift Data
	public static final String REJECTION_REASON = "I am not available for this shift.";
	public static final String SUCCESS_MESSAGE_REJECTED_SHIFT = "Shift rejected successfully!";
	public static final String SUCCESS_MESSAGE_CONFIRM_SHIFT = "Shift confirmed successfully!";

	public static final String SUCCESS_MESSAGE_PREVIOUS_SHIFT_LOGOUT = "Previous Shift Logged out successfully";

	// Passdown Logs Data
	public static final String IMAGE_UPLOAD_SUCCESS_MESSAGE = "Image uploaded successfully!";
	public static final String PASSDOWN_MESSAGE = "Please ensure all equipment is returned by the end of your shift. Report any issues immediately.";
	public static final String PASSDOWN_IMAGE_PATH = "./src/test/resource/testdata/image.jpeg";
	public static final String PASSDOWN_IMAGE_NAME = "Equipment Return Confirmation";
	public static final String IMAGE_DESCRIPTION = "Image of the equipment returned at the end of the shift.";

	// Profile
	// Comments
	public static final String SELECT_RESPONSE = "Agree";

	public static final String REASON_TEXT = "I disagree with the comment. Please review it again.";

	public static final String SUCCESS_MESSAGE_COMMENT_AGREE = "Response submitted successfully";

	// Reports
	public static final String PREFLIGHT_CONFIRMATION_MESSAGE = "This will create 8 reports for your current site.";

	public static final String PREFLIGHT_SUCCESS_MESSAGE = "Pre-flight created successfully";

	public static final String NO_DATA_FOUND_TEXT = "No Data Found";

	// Team Support
	public static final String SUBJECT_NAME = "Patrol Support - Incident Reporting";
	public static final String MESSAGE = "I would like to report an incident of abuse that I witnessed during my shift.";

	public static final String EXPLAIN_INCIDENCE = "Witnessed verbal abuse towards a colleague by a customer.";

	public static final String Name_OR_Badge = "John Doe / Badge 1234";

	public static final String INCIDENCE_DATE = "11/22/2025";

	// Forms
	// Parking Citation
	public static final String SITE = "Richmond";
	public static final String DATE_TIME = "09/08/2025 10:00";
	public static final String ACTIVITY_CODE = "10-16";
	public static final String VIN_NUMBER = "1HGBH41JXMN109186";
	public static final String LICENSE_NO = "ABC123";
	public static final String SELECT_STATE = "CA";
	public static final String EXPIRE_DATE = "September 2025";
	public static final String VEHICLE_COLOR = "Red";
	public static final String YEAR = "2020";
	public static final String VEHICLE_MAKE = "AUDI";
	public static final String VEHICLE_MODEL = "A6";
	public static final String VIOLATION = "Wrong Turn-wrong turn description";
	public static final String ADDITIONAL_DETAILS = "Parked in a no-parking zone.";
	public static final String FILE_PATH = "./src/test/resource/testdata/image.jpeg";

	// Impounded Fields
	public static final String IMPOUNDED_DATE_TIME = "09/08/2025";
	public static final String TOWING_COMPANY = "ABC Towing Services";

	// Update Parking Citation
	public static final String UPDATED_SITE = "Richmond";
	public static final String UPDATE_DATE_TIME = "09/09/2025 11:30";
	public static final String UPDATE_ACTIVITY_CODE = "10-17";
	public static final String UPDATE_VIN_NUMBER = "12345";
	public static final String UPDATE_LICENSE_NO = "XYZ789";
	public static final String UPDATE_STATE = "NY";
	public static final String UPDATE_EXPIRE_DATE = "October 2025";
	public static final String UPDATE_VEHICLE_COLOR = "Blue";
	public static final String UPDATE_YEAR = "2021";
	public static final String UPDATE_VEHICLE_MAKE = "BMW";
	public static final String UPDATE_VEHICLE_MODEL = "330I";
	public static final String UPDATE_VIOLATION = "Assault and battery-This is Crime Violation";
	public static final String UPDATE_ADDITIONAL_DETAILS = "Parked in a loading zone.";
	public static final String UPDATE_FILE_PATH = "./src/test/resource/testdata/image.jpeg";

	public static final String UPDATED_IMPOUNDED_DATE_TIME = "10/08/2025";
	public static final String UPDATED_TOWING_COMPANY = "XYZ Towing Services";

	// Trespass Notices
	// Fill Location Details
	public static final String TRESPASS_SITE = "Richmond";
	public static final String TRESPASS_DATE_TIME = "09/09/2025 10:00";
	public static final String TRESPASS_INCIDENT_NUMBER = "54321";
	public static final String TRESPASS_ACTIVITY_CODE = "10-16";
	public static final String TRESPASS_STREET_NUMBER = "123";
	public static final String TRESPASS_STREET_NAME = "Main St";
	public static final String TRESPASS_UNIT_NUMBER = "A1";
	public static final String TRESPASS_CITY = "Springfield";
	public static final String TRESPASS_STATE = "CA";
	public static final String TRESPASS_ZIP = "90001";

	// Fill Trespasser Details
	public static final String TRESSPASS_FIRST_NAME = "John";
	public static final String TRESPASS_MIDDLE_NAME = "M";
	public static final String TRESPASS_LAST_NAME = "Doe";

	public static final String TRESSPASSER_DL_NUMBER = "D1234567";
	public static final String TRESSPASSER_DL_STATE = "CA";
	public static final String TRESSPASSER_DL_EXPIRE_DATE = "12/31/2025";

	public static final String TRESSPASSER_STREET_NUMBER = "456";
	public static final String TRESSPASSER_STREET_NAME = "Elm St";
	public static final String TRESSPASSER_UNIT_NUMBER = "B2";
	public static final String TRESSPASSER_CITY = "Springfield";
	public static final String TRESSPASSER_STATE = "CA";
	public static final String TRESSPASSER_ZIP = "90001";
	public static final String TRESSPASSER_VEHICLE_YEAR = "2020";
	public static final String TRESSPASSER_VEHICLE_MAKE = "BMW";
	public static final String TRESSPASSER_VEHICLE_MODEL = "A6";
	public static final String TRESSPASSER_VEHICLE_COLOR = "Blue";
	public static final String TRESSPASSER_VEHICLE_PLATE = "XYZ789";
	public static final String TRESSPASSER_VEHICLE_STATE = "CA";
	public static final String TRESSPASSER_GENDER = "Male";
	public static final String TRESSPASS_RACE = "White";
	public static final String TRESSPASS_HAIR_TYPE = "Curly";
	public static final String TRESSPASS_HAIR_COLOR = "Brown";
	public static final String TRESSPASS_EYE_COLOR = "Blue";
	public static final String TRESSPASS_HEIGHT = "5'10";
	public static final String TRESSPASS_BUILD = "Athletic";
	public static final String TRESSPASS_WEIGHT = "180";

	// Trespass Narrative
	public static final String TRESPASS_NARRATIVE = "Trespassing without permission";
	public static final String TRESPASS_WAS_PD_CONTACTED = "Yes";

	public static final String TRESPASS_FILE_PATH = "./src/test/resource/testdata/image.jpeg";

	// Update Trespass Notice
	public static final String UPDATED_TRESPASS_SITE = "Richmond";
	public static final String UPDATED_TRESPASS_DATE_TIME = "09/10/2025 11:30";
	public static final String UPDATED_TRESPASS_ACTIVITY_CODE = "10-17";
	public static final String UPDATED_TRESPASS_STREET_NUMBER = "456";
	public static final String UPDATED_TRESPASS_STREET_NAME = "Oak St";
	public static final String UPDATED_TRESPASS_UNIT_NUMBER = "B2";
	public static final String UPDATED_TRESPASS_CITY = "Springfield";
	public static final String UPDATED_TRESPASS_STATE = "CA";
	public static final String UPDATED_TRESPASS_ZIP = "90002";

	// Add Field Interview
	// Person Description
	public static final String FIELD_INTERVIEW_PERSON_RACE = "Hispanic";
	public static final String FIELD_INTERVIEW_PERSON_GENDER = "Male";
	public static final String FIELD_INTERVIEW_PERSON_HAIR_TYPE = "Curly";
	public static final String FIELD_INTERVIEW_PERSON_HAIR = "Red";
	public static final String FIELD_INTERVIEW_PERSON_EYES = "Brown";
	public static final String FIELD_INTERVIEW_PERSON_HEIGHT = "5'11";
	public static final String FIELD_INTERVIEW_PERSON_BUILD = "Average";

	// Vehicle Details
	public static final String FIELD_INTERVIEW_VEHICLE_LICENSE_STATE = "LA";
	public static final String FIELD_INTERVIEW_VEHICLE_TYPE = "Sports Car";

	// Crime Potentials
	public static final String FIELD_INTERVIEW_CRIME_POTENTIAL_1 = "Robbery";
	public static final String FIELD_INTERVIEW_CRIME_POTENTIAL_2 = "Crime murder test";

	// --- Add New Field Interview ---

	// Basic Info
	public static final String FIELD_INTERVIEW_SITE_NUMBER = "Richmond";
	public static final String FIELD_INTERVIEW_INTERVIEW_DATE_TIME = "09/09/2025 12:30"; // MM/DD/YYYY HH:MM
	public static final String FIELD_INTERVIEW_NIP = "25091023154007";
	public static final String FIELD_INTERVIEW_ACTIVITY_CODE = "10-17";
	public static final String FIELD_INTERVIEW_LAST_NAME = "Johnson";
	public static final String FIELD_INTERVIEW_MIDDLE_NAME = "Michael";
	public static final String FIELD_INTERVIEW_FIRST_NAME = "David";
	public static final String FIELD_INTERVIEW_NICKNAME = "DJ";
	public static final String FIELD_INTERVIEW_PHONE_NUMBER = "9876543210";
	public static final String FIELD_INTERVIEW_DL_ID_NUMBER = "D1234567";
	public static final String FIELD_INTERVIEW_DL_ID_STATE = "CA";

	// Address
	public static final String FIELD_INTERVIEW_ADDRESS_STREET_NUM = "123";
	public static final String FIELD_INTERVIEW_ADDRESS_STREET_NAME = "Main St";
	public static final String FIELD_INTERVIEW_ADDRESS_UNIT = "12B";
	public static final String FIELD_INTERVIEW_ADDRESS_CITY = "Los Angeles";
	public static final String FIELD_INTERVIEW_ADDRESS_STATE = "CA";
	public static final String FIELD_INTERVIEW_ADDRESS_ZIP = "90001";

	// Residence Address
	public static final String FIELD_INTERVIEW_RESIDENCE_STREET_NUM = "45";
	public static final String FIELD_INTERVIEW_RESIDENCE_STREET_NAME = "Sunset Blvd";
	public static final String FIELD_INTERVIEW_RESIDENCE_UNIT = "Apt 22";
	public static final String FIELD_INTERVIEW_RESIDENCE_CITY = "Los Angeles";
	public static final String FIELD_INTERVIEW_RESIDENCE_STATE = "AL";
	public static final String FIELD_INTERVIEW_RESIDENCE_ZIP = "90002";

	// Person Description
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_RACE = "Hispanic";
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_GENDER = "Male";
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_HAIR_TYPE = "Curly";
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_HAIR = "Red";
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_EYES = "Brown";
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_HEIGHT = "7' 1";
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_BUILD = "Average";
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_WEIGHT = "175 lbs";
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_DOB = "01/15/1990"; // MM/DD/YYYY
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_ODDITIES = "Scar on left arm";
	public static final String FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_CLOTHING = "Blue jeans and white shirt";

	// Vehicle Details
	public static final String FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_LICENSE_PLATE = "LA12345";
	public static final String FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_LICENSE_STATE = "LA";
	public static final String FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_MODEL = "Mustang GT";
	public static final String FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_COLOR = "Red";
	public static final String FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_YEAR = "2022";
	public static final String FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_MAKE = "BMW";
	public static final String FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_TYPE = "Sports Car";

	// Companion - 1
	public static final String FIELD_INTERVIEW_COMPANION_NAME = "Robert Lee";
	public static final String FIELD_INTERVIEW_COMPANION_ADDRESS = "789 Hill Rd, Los Angeles, CA 90003";
	public static final String FIELD_INTERVIEW_COMPANION_GENDER = "Male";
	public static final String FIELD_INTERVIEW_COMPANION_RACE = "Black";
	public static final String FIELD_INTERVIEW_COMPANION_EYES = "Blue";
	public static final String FIELD_INTERVIEW_COMPANION_HEIGHT = "7' 5";
	public static final String FIELD_INTERVIEW_COMPANION_HAIR_TYPE = "Straight";
	public static final String FIELD_INTERVIEW_COMPANION_HAIR = "Black";
	public static final String FIELD_INTERVIEW_COMPANION_BUILD = "Medium";
	public static final String FIELD_INTERVIEW_COMPANION_WEIGHT = "165 lbs";
	public static final String FIELD_INTERVIEW_COMPANION_PHONE = "9876501122";
	public static final String FIELD_INTERVIEW_COMPANION_WORK_PHONE = "9876503344";

	// Report
	public static final String FIELD_INTERVIEW_REPORT_DESCRIPTION = "Suspect observed near parking lot, acting suspicious, possible robbery attempt.";

	// Crime Potentials
	public static final String FIELD_INTERVIEW_CRIME_POTENTIALS_CRIME_POTENTIAL_1 = "Robbery";
	public static final String FIELD_INTERVIEW_CRIME_POTENTIALS_CRIME_POTENTIAL_2 = "Crime murder test";

	// Field Interview Images
	public static final String FIELD_INTERVIEW_INTERVIEW_IMAGE_PATH = "./src/test/resource/testdata/image.jpeg";

}
