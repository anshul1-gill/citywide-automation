package com.dits.citywide.constants;

import java.util.List;

public class OperationsHubConstant {

	public static final String OFFICER_RECEIVED_VIA = "Call-In";

	public static final String REPORTING_PERSON_FIRST_NAME = "Tom";
	public static final String REPORTING_PERSON_LAST_NAME = "Cruise";
	public static final String REPORTING_PERSON_PHONE_NUMBER = "9876543210";
	public static final String REPORTING_PERSON_DEMEANOR = "Agitated";

	public static final String CALL_CREATED_SUCCESSFULLY = "Call Created Successfully.";

	// Suspect Description
	public static final String SUSPECT_NAME = "John Doe";
	public static final String SUSPECT_GENDER = "Male";
	public static final String SUSPECT_RACE = "White";
	public static final String SUSPECT_HAIR_TYPE = "Short";
	public static final String SUSPECT_HAIR_COLOR = "Red";
	public static final String SUSPECT_EYE_COLOR = "Blue";
	public static final String SUSPECT_HEIGHT = "7' 3";
	public static final String SUSPECT_BUILD = "Thin";
	public static final String SUSPECT_WEIGHT = "180";
	public static final String SUSPECT_AGE = "30";
	public static final String SUSPECT_CLOTHING_WORN = "Black Jacket";
	public static final String SUSPECT_LAST_KNOWN_DIRECTION = "North";

	// Calls Description
	public static final String CALL_DESCRIPTION = "This is a test call description for the suspect.";

	// Calls Success Message
	public static final String OFFICER_ENROUTE_SUCCESSFULLY = "Officer Enroute.";
	public static final String OFFICER_ARRIVED_SUCCESSFULLY = "Officer Arrived.";
	public static final String OFFICER_CLEARED_SUCCESSFULLY = "Officer Cleared.";

	public static final String NOTES = "Assignment completed";

	// New Officer Report Entry
	public static final String ARRIVE_DATE = "01/15/2025"; // MM/DD/YYYY
	public static final String ARRIVE_TIME = "13:30";
	public static final String DEPART_DATE = "11/22/2025";
	public static final String DEPART_TIME = "19:30";

	public static final String ACTIVITY_CODE = "10-17";

	public static final String STREET_NUMBER = "12";
	public static final String STREET_NAME = "East 10th Street";
	public static final String APARTMENT_NUMBER = "08";
	public static final String CITY = "Manhattan";
	public static final String STATE = "New York";
	public static final String ZIP_CODE = "10003";
	public static final String DESCRIPTION = "Assignment completed";

	public static final String REPORT_PHOTO_VIDEO_LINK = "./src/test/resource/testdata/image.jpeg";
	public static final String FILE_NAME = "File 1";
	public static final String FILE_DESCRIPTION = "Description 1";

	public static final String REPORT_CONFRIMATION_MESSAGE = "You want to save this report without any photo";

	// All Report
	public static final String START_SHIFT_ACTIVITY_CODE = "SS";
	public static final String END_SHIFT_ACTIVITY_CODE = "EOS";

	// Sites
	// Post Orders
	public static final String ASSIGNMENT_NAME = "Auto test assignment";
	public static final String ASSIGNMENT_TEMPLATE = "Automation template";
	public static final String COVERAGE_TYPE = "Fire - Stationary/Single Site";
	public static final List<String> ASSIGNMENT_DAYS_OF_WEEK = List.of("Monday", "Tuesday", "Wednesday", "Thursday",
			"Friday", "Saturday", "Sunday");
	public static final String ASSIGNMENT_TIME = "04:00";
	public static final String SNITCH_TIME = "15";

	public static final String CHECKPOINT_NAME = "Auto test checkpoint";
	public static final String CHECKPOINT_DESCRIPTION = "Auto test checkpoint description";
	public static final String CHECKPOINT_TYPE = "QR Code";

	public static final String SUCCESS_MESSAGE_CHECKPOINT_ADDED = "Checkpoint added successfully";

	public static final String DELETE_ASSIGNMENT_SUCCESS_MESSAGE = "Task deleted.";

	public static final String DELETE_CHECKPOINT_SUCCESS_MESSAGE = "Checkpoint deleted successfully";

	public static final String CHECKPOINT_SCAN_TIME = "03:00";

	public static final String SCAN_TYPE_SCAN_TIME = "03:00";
	public static final String SCAN_TYPE_SNITCH_TIME = "00:15";

	public static final String ACTION_RULE_PRIORITY = "4";
	public static final String ACTION_RULE_INPUT_TYPE = "Video";
	public static final String ACTION_RULE_DIRECTIVE = "Call-In";

	public static final String SCAN_RULE_CREATED_SUCCESS_MESSAGE = "Scan rule created successfully";
	public static final String ACTION_RULE_CREATED_SUCCESS_MESSAGE = "Action rule created successfully";

	// Sites
	// Site Details Tab
	public static final String BRANCH_NAME = "Riverside";
	public static final String SITE_NAME = "Automation site";
	// public static final String AGENCY_BEAT = "1212";
	public static final String AGENCY_BEAT = "1212, 333, 558, TESTB321";
	public static final String CALL_RESPONSE = "24/7";
	public static final String SERVICE_TIME = "12:00 - 06:00";
	public static final String SITE_COVERAGE_TYPE = "24/7";
	public static final String REPORT_TIME = "07:00 PM";
	public static final String POLICE_AGENCIES = "TEST WEBDEV POLICE, POLICE ONE";
	public static final String FIRE_AGENCIES = "Firewood agency, TESTWEB";
	public static final String MEDICAL_AGENCIES = "Medical emergency, medic (55)";
	public static final String OTHER_AGENCIES = "Other testing, PLUMBER AGENCY";
	public static final String QUALIFICATIONS = "Baton, Driver License, ECD, Firearms, OC";
	public static final String ACCOUNT_MANAGER = "Tom Admin";

	// -------- Site Address --------
	public static final String SITE_STREET_NUMBER = "123";
	public static final String SITE_STREET_NAME = "Main Street";
	public static final String SITE_CITY = "New York";
	public static final String SITE_STATE = "NY";
	public static final String SITE_ZIP_CODE = "10001";

	// ------- Geofencing -------------
	public static final String GEOFENCE_NAME = "Feet";
	public static final String GEOFENCE_ADDRESS = "160";

	// -------- Main Contact --------
	public static final String CONTACT_FIRST_NAME = "Olivia";
	public static final String CONTACT_LAST_NAME = "Brown";
	public static final String MAIN_CONTACT_PHONE = "5454667364";
	public static final String MOBILE = "9876543210";
	public static final String FAX = "1234567890";
	public static final String CONTACT_EMAIL = "olivia@brownenterprises.com";

	// -------- Site Contacts --------
	public static final String JOB_TITLE = "Manager";
	public static final String NEW_CONTACT_NAME = "Smith";
	public static final String NEW_CONTACT_PHONE = "1231231234";

}
