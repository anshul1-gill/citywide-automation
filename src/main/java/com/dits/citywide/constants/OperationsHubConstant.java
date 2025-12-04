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
	
	public static final String CALL_CLOSED_SUCCESSFULLY = "Call has been closed successfully";


	public static final String NOTES = "Assignment completed";

	// New Officer Report Entry
	public static final String ARRIVE_DATE = "01/15/2025"; // MM/DD/YYYY
	public static final String ARRIVE_TIME = "13:30";
	public static final String DEPART_DATE = "11/22/2025";
	public static final String DEPART_TIME = "19:30";

	public static final String ACTIVITY_CODE = "10-17";
	public static final String SUBACTIVITY_CODE = "187";

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
		public static final String COVERAGE_TYPE = "Hospital Security - Stationary/Single Site";
		public static final List<String> ASSIGNMENT_DAYS_OF_WEEK = List.of("Monday", "Tuesday", "Wednesday", "Thursday",
				"Friday", "Saturday", "Sunday");
		
		//Patrol Agent data 
		public static final String PATROL_AGENT_ASSIGNMENT_NAME = "Patrol Agent Auto Test Assignment";
		public static final String PATROL_AGENT_ASSIGNMENT_TEMPLATE = "Automation template";
		public static final String PATROL_AGENT_COVERAGE_TYPE = "Richmond - Mobile/Multiple Sites";
		
		
		public static final String ASSIGNMENT_TIME = "22:00";
		public static final String SNITCH_TIME = "23:39";

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
		public static final String SITE_NAME = " North Z Downtown ";
		// public static final String AGENCY_BEAT = "1212";
		public static final String AGENCY_BEAT = "1212, 333, 558, TESTB321";
		public static final String ASSIGN_OFFICER ="RS250-Jakob Crist";
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
		
		//----------Property Access------------
		public static final String GATE_CODE = "7834";
		public static final String ALARM_ARM_CODE = "ARM-8745";
		public static final String ALARM_UNARM_CODE = "UNARM-1023";
		public static final String ALARM_NOTES = "Located near back entrance gate";
		public static final String LOCKBOX_CODE = "LBX-2201";
		public static final String LOCKBOX_NOTES = "Located near back entrance gate";
		
		// -------- Parking Enforcement --------
		public static final String TOW_COMPANY = "RapidTow Services";
		public static final String TOW_PHONE = "(555) 234 - 7890";
		public static final String TOW_NOTES = "Available 24/7 for site emergencies";
		public static final String PARKING_ENFORCEMENT_NOTES = "All visitor vehicles must display a valid parking pass; violators will be ticketed.";
		
		//---------Site Reports------
		public static final String Site_Reports = "A site report provides a detailed overview of activities,"
				+ " incidents, and security at a specific location, helping law enforcement plan, monitor, and analyze operations.";
		
		//----OverallSiteCoverage------
		public static final String Overall_Coverage = "An overall site description provides a comprehensive overview of a location, "
				+ "including its layout, security features, usage, and risk factors. It helps law enforcement officers, security personnel, "
				+ "and planners understand and manage the site effectively.";
		
		// -------- Mobile/Multiple Sites --------
		public static final String MOBILE_COVERAGE_NAME = "Mobile Patrol 1";
		public static final String MOBILE_SERVICE_TYPE = "165";  // mobile option value
		public static final String MOBILE_BILLING_TYPE ="Weekly";
		public static final String MOBILE_BILLING_RATE = "150";
		public static final String HOLIDAY_RATE = "200";
		public static final String COVERAGE_END_DATE = "10/09/20236";

		public static final String MOBILE_DAY_START_TIME = "01:00am";
		public static final String MOBILE_DAY_END_TIME = "09:00pm";

		public static final String MOBILE_DAY_HITS = "5";
		public static final String MOBILE_SWING_HITS = "3";
		public static final String MOBILE_NIGHT_HITS = "2";

		public static final String MOBILE_DAY_NOTES = "Day coverage notes";
		public static final String MOBILE_SWING_NOTES = "Swing coverage notes";
		public static final String MOBILE_NIGHT_NOTES = "Night coverage notes";

		
		
		// -------- Stationary/Single Site --------
		public static final String STATIONARY_COVERAGE_NAME = "Hospital Security";
		public static final String STATIONARY_SERVICE_TYPE = "ATM Guard";
		public static final String STATIONARY_COVERAGE_END="09/30/2025";
		public static final String STATIONARY_BILLING_TYPE ="Weekly";
		public static final String BILLING_RATE = "120";
		public static final String HOLIDAY_BILLING_RATE = "180";
		public static final String POST_RATE = "50";
		public static final String ALLOWANCE_RATE = "30";
		public static final String ALLOWANCE_TYPE = "20";

		public static final String STATIONARY_START_TIME = "04:00am";
		public static final String STATIONARY_END_TIME = "12:00pm";

		public static final String STATIONARY_DAY_NOTES = "Day shift notes";
		public static final String STATIONARY_SWING_NOTES = "Swing shift notes";
		public static final String STATIONARY_NIGHT_NOTES = "Night shift notes";

		
		// ------------------ Site Area Tab -------------------------
		public static final String SITE_AREA_NAME = "Main Lobby";
		public static final String SITE_DOOR_GATE_COUNT = "4";
		public static final String SITE_AREA_NOTES = "This area includes main entrance and lobby security monitoring.";

		public static final String SITE_LOCKUP_TIME = "2:00am"; 
		public static final String SITE_UNLOCK_TIME = "10:00pm"; 
		
		// ------------------ Temporary Post Order -------------------------
//		public static final String TEMP_POST_ORDER_EXPIRE_DATE = "09/30/2025";
//		public static final String TEMP_POST_ORDER_EXPIRE_TIME = "18:00"; // 6 PM
//		public static final String TEMP_POST_ORDER_TEXT = "All officers must check parking lot hourly for suspicious activity.";

		// -------- Site Doc / Payment Terms -------
		public static final String CLIENT_FIRST_NAME     = "John";
		public static final String CLIENT_LAST_NAME      = "Doe";
		public static final String CLIENT_COMPANY_NAME   = "Citywide Security Services";
		public static final String CLIENT_DISPLAY_NAME   = "John D - Citywide";
		public static final String CLIENT_PHONE_MAIN     = "9876543210";
		public static final String CLIENT_PHONE_MOBILE   = "9123456789";
		public static final String CLIENT_FAX            = "0112345678";
		public static final String CLIENT_EMAIL          = "john.doe@citywide.com";
		public static final String CLIENT_TERMS          = "Net 30 Days";
		public static final String BILLING_CYCLE_OPTION  = "Weekly";
		public static final String BILLING_START_DATE    = "10/10/2025"; // MM-DD-YYYY
		public static final String INVOICE_NUMBER        = "INV-2025-001";
		public static final String CLIENT_STREET_NUMBER  = "123";
		public static final String CLIENT_STREET_NAME    = "Main Street";
		public static final String CLIENT_CITY           = "Los Angeles";
		public static final String CLIENT_STATE          = "AK";         // Alaska
		public static final String CLIENT_ZIPCODE        = "90001";
		public static final String CLIENT_COUNTRY        = "USA";
		
		//--Add Comments --//
		public static final String ADD_COMMENTS          = "Security presence makes the site feel safe and secure.";
		
		public static final String SELECT_DISABLE       = "Show Disable";
		public static final String SELECT_ENAABLE       = "Show Enabled";
		
		//Message of the Week Constants/===============================================================================
		public static final String MESSAGE_TYPE_All = "Select all";   // Example, adjust as needed
	    public static final String MESSAGE_TYPE_MANAGER = "Manager";

	    // Message Subjects
	    public static final String MESSAGE_SUBJECT = "Weekly Update";
	    public static final String MESSAGE_SUBJECT_2 = "System Maintenance";

	    // Message Text
	    public static final String MESSAGE_TEXT = "This is the message of the week for all users.";
	    public static final String MESSAGE_TEXT_2 = "System maintenance will occur this Friday.";
		

		
}