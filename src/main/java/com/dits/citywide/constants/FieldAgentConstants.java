package com.dits.citywide.constants;

public class FieldAgentConstants {

	// Welcome Text
	public static final String WELCOME_TEXT = "Hope you are doing well. Lets begin your shift, remember shift also includes breaks please dont hesitate for one !!";

// HR Management 
	// Leavve Request Data
	// Staging data
	public static final String LEAVE_TYPE = "Marriage leave";

	// Live data
	// public static final String LEAVE_TYPE = "Vacation";

	public static final String LEAVE_FROM_MONTH = "Oct";
	public static final String LEAVE_FROM_YEAR = "2025";
	public static final String LEAVE_FROM_DATE = "29";

	public static final String LEAVE_TO_MONTH = "Oct";
	public static final String LEAVE_TO_YEAR = "2025";
	public static final String LEAVE_TO_DATE = "30";

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

// --- Add New Incident Report ---
	// Basic Info
	public static final String SITE_NUMBER = "Richmond";
	public static final String INCIDENT_DATE_TIME = "09/12/2025 09:40";
	public static final String REPORT_NUMBER = "2509120945009";
	public static final String INCIDENT_ACTIVITY_CODE = "10-17";
	public static final String DISCOVER_DATE_TIME = "09/05/2025 10:30";
	public static final String REPORTED_DATE_TIME = "09/06/2025 9:30";

	// Police Section
	public static final String POLICE_OFFICER_NAME = "Officer Mark Stevens";
	public static final String POLICE_OFFICER_BADGE = "P4521";
	public static final String POLICE_UNIT = "Unit 12";
	public static final String POLICE_INCIDENT_NUMBER = "POL12345";
	public static final String POLICE_ARRIVAL_TIME = "09:50";
	public static final String POLICE_DEPARTURE_TIME = "10:30";

	// Fire Section
	public static final String FIRE_DEPARTMENT_NAME = "Riverside Fire Dept";
	public static final String FIRE_ENGINE = "Engine 4";
	public static final String FIRE_INCIDENT_NUMBER = "FIR67890";
	public static final String FIRE_ARRIVAL_TIME = "09:55";
	public static final String FIRE_DEPARTURE_TIME = "10:20";

	// Medic Section
	public static final String MEDIC_TEAM_NAME = "Riverside EMS";
	public static final String MEDIC_UNIT = "Medic 7";
	public static final String MEDIC_INCIDENT_NUMBER = "MED3344";
	public static final String MEDIC_ARRIVAL_TIME = "09:50";
	public static final String MEDIC_DEPARTURE_TIME = "10:30";

	// Other Section
	public static final String OTHER_AGENCY_NAME = "Utility Company";
	public static final String OTHER_CONTACT_PHONE = "8005559001";
	public static final String OTHER_VEHICLE = "Truck #21";
	public static final String OTHER_INCIDENT_NUMBER = "OTH9988";
	public static final String OTHER_ARRIVAL_TIME = "10:05";
	public static final String OTHER_DEPARTURE_TIME = "10:45";

	// Reporting Person
	public static final String REPORTING_PERSON_NAME = "Michael Roberts";
	public static final String REPORTING_PERSON_DOB = "09/02/2022";
	public static final String REPORTING_PERSON_PHONE = "9095551122";
	public static final String REPORTING_PERSON_WORK_PHONE = "9095551123";
	public static final String REPORTING_PERSON_STREET_NUM = "500";
	public static final String REPORTING_PERSON_STREET_NAME = "Oak St";
	public static final String REPORTING_PERSON_UNIT = "Suite 201";
	public static final String REPORTING_PERSON_CITY = "Riverside";
	public static final String REPORTING_PERSON_STATE = "CA";
	public static final String REPORTING_PERSON_ZIP = "92507";

	// Victim - 1
	public static final String VICTIM_NAME = "Laura Smith";
	public static final String VICTIM_DOB = "09/02/1992";
	public static final String VICTIM_PHONE = "9515552233";
	public static final String VICTIM_WORK_PHONE = "9515552234";
	public static final String VICTIM_GENDER = "Female";
	public static final String VICTIM_RACE = "Hispanic";
	public static final String VICTIM_EYES = "Hazel";
	public static final String VICTIM_HAIR_TYPE = "Straight";
	public static final String VICTIM_HAIR_COLOR = "Blonde";
	public static final String VICTIM_HEIGHT = "7' 5";
	public static final String VICTIM_BUILD = "Average";
	public static final String VICTIM_WEIGHT = "140";

	// Victim - 1 Address
	public static final String VICTIM_STREET_NUM = "100";
	public static final String VICTIM_STREET_NAME = "Main St";
	public static final String VICTIM_UNIT = "U5";
	public static final String VICTIM_CITY = "Middletown";
	public static final String VICTIM_STATE = "CA";
	public static final String VICTIM_ZIP = "92507";
	// Victim - 1 Vehicle
	public static final String VICTIM_VEHICLE_YEAR = "2020";
	public static final String VICTIM_VEHICLE_MAKE = "Honda";
	public static final String VICTIM_VEHICLE_MODEL = "Civic";
	public static final String VICTIM_VEHICLE_COLOR = "Blue";
	public static final String VICTIM_VEHICLE_LICENSE = "7ABC123";
	public static final String VICTIM_VEHICLE_STATE = "CA";

	// Witness - 1
	public static final String WITNESS_NAME = "John Lee";
	public static final String WITNESS_DOB = "11/03/1987";
	public static final String WITNESS_PHONE = "5625558899";
	public static final String WITNESS_WORK_PHONE = "5625558800";
	public static final String WITNESS_GENDER = "Male";
	public static final String WITNESS_RACE = "Black";
	public static final String WITNESS_EYES = "Brown";
	public static final String WITNESS_HAIR_TYPE = "Long";
	public static final String WITNESS_HAIR_COLOR = "Black";
	public static final String WITNESS_HEIGHT = "7' 10";
	public static final String WITNESS_BUILD = "Heavy";
	public static final String WITNESS_WEIGHT = "160";

	// Witness - 1 Address
	public static final String WITNESS_STREET_NUM = "200";
	public static final String WITNESS_STREET_NAME = "Pine St";
	public static final String WITNESS_UNIT = "Unit 3";
	public static final String WITNESS_CITY = "Riverside";
	public static final String WITNESS_STATE = "CA";
	public static final String WITNESS_ZIP = "92507";
	// Witness - 1 Vehicle
	public static final String WITNESS_VEHICLE_YEAR = "2021";
	public static final String WITNESS_VEHICLE_MAKE = "Honda";
	public static final String WITNESS_VEHICLE_MODEL = "Civic";
	public static final String WITNESS_VEHICLE_COLOR = "Gray";
	public static final String WITNESS_VEHICLE_LICENSE = "XYZ789";
	public static final String WITNESS_VEHICLE_STATE = "CA";

	// Suspect - 1
	public static final String SUSPECT_NAME = "Carlos Hernandez";
	public static final String SUSPECT_DOB = "09/02/2022";
	public static final String SUSPECT_PHONE = "9876543210";
	public static final String SUSPECT_WORK_PHONE = "N/A";
	public static final String SUSPECT_GENDER = "Male";
	public static final String SUSPECT_RACE = "Hispanic";
	public static final String SUSPECT_EYES = "Brown";
	public static final String SUSPECT_HAIR_TYPE = "Curly";
	public static final String SUSPECT_HAIR_COLOR = "Sandy";
	public static final String SUSPECT_HEIGHT = "7' 5";
	public static final String SUSPECT_BUILD = "Medium";
	public static final String SUSPECT_WEIGHT = "175";

	// Suspect - 1 Address
	public static final String SUSPECT_STREET_NUM = "300";
	public static final String SUSPECT_STREET_NAME = "Maple Ave";
	public static final String SUSPECT_UNIT = "Apt 10";
	public static final String SUSPECT_CITY = "Mickleton";
	public static final String SUSPECT_STATE = "CA";
	public static final String SUSPECT_ZIP = "92507";
	// Suspect - 1 Vehicle
	public static final String SUSPECT_VEHICLE_YEAR = "2020";
	public static final String SUSPECT_VEHICLE_MAKE = "Ford";
	public static final String SUSPECT_VEHICLE_MODEL = "Focus";
	public static final String SUSPECT_VEHICLE_COLOR = "Black";
	public static final String SUSPECT_VEHICLE_LICENSE = "LMN456";
	public static final String SUSPECT_VEHICLE_STATE = "CA";

	// Classification
	public static final boolean EQUIPMENT_FAILURE = true;
	public static final boolean SAFETY_HAZARD = true;
	public static final boolean PROPERTY_DAMAGE = true;
	public static final boolean PERSONAL_INJURY = true;
	public static final boolean CONDUCT = true;
	public static final boolean CRIMINAL_ACT = true;
	public static final boolean MISSING_PERSON = true;
	public static final boolean DEATH = true;
	public static final boolean MAINTENANCE_ISSUE = true;
	public static final boolean ALARM = true;
	public static final boolean FLOOD = true;
	public static final boolean TRAINING = true;

	// public static final String CLASSIFICATION = "Property Damage";

	// Client Notified
	public static final String CLIENT_NOTIFIED_DATE = "09/11/2025 11:15";
	public static final String CLIENT_NOTIFIED_NAME = "Anna Martinez";

	// Incident Description
	public static final String INCIDENT_DESCRIPTION = "An unknown male suspect attempted to start a fire in a dumpster. "
			+ "Security observed smoke and immediately contacted the fire department. "
			+ "Police and EMS also responded. The suspect fled the scene before authorities arrived.";

	// Incident Report Images
	public static final String INCIDENT_IMAGE_PATH = "./src/test/resource/testdata/image.jpeg";

	// Update Incident Report
	// --- Update Incident Report ---
	// Basic Info
	public static final String UPDATE_SITE_NUMBER = "Richmond";
	public static final String UPDATE_INCIDENT_DATE_TIME = "09/15/2025 14:20";
	public static final String UPDATE_INCIDENT_ACTIVITY_CODE = "10-16";
	public static final String UPDATE_DISCOVER_DATE_TIME = "09/10/2025 13:00";
	public static final String UPDATE_REPORTED_DATE_TIME = "09/11/2025 14:00";

	// Police Section
	public static final String UPDATE_POLICE_OFFICER_NAME = "Officer Jane Miller";
	public static final String UPDATE_POLICE_OFFICER_BADGE = "P9876";
	public static final String UPDATE_POLICE_UNIT = "Unit 22";
	public static final String UPDATE_POLICE_INCIDENT_NUMBER = "POL54321";
	public static final String UPDATE_POLICE_ARRIVAL_TIME = "14:30";
	public static final String UPDATE_POLICE_DEPARTURE_TIME = "15:10";

	// Fire Section
	public static final String UPDATE_FIRE_DEPARTMENT_NAME = "San Jose Fire Dept";
	public static final String UPDATE_FIRE_ENGINE = "Engine 8";
	public static final String UPDATE_FIRE_INCIDENT_NUMBER = "FIR12345";
	public static final String UPDATE_FIRE_ARRIVAL_TIME = "14:35";
	public static final String UPDATE_FIRE_DEPARTURE_TIME = "15:00";

	// Medic Section
	public static final String UPDATE_MEDIC_TEAM_NAME = "San Jose EMS";
	public static final String UPDATE_MEDIC_UNIT = "Medic 12";
	public static final String UPDATE_MEDIC_INCIDENT_NUMBER = "MED5566";
	public static final String UPDATE_MEDIC_ARRIVAL_TIME = "14:40";
	public static final String UPDATE_MEDIC_DEPARTURE_TIME = "15:05";

	// Other Section
	public static final String UPDATE_OTHER_AGENCY_NAME = "Electric Company";
	public static final String UPDATE_OTHER_CONTACT_PHONE = "8005551234";
	public static final String UPDATE_OTHER_VEHICLE = "Van #32";
	public static final String UPDATE_OTHER_INCIDENT_NUMBER = "OTH1122";
	public static final String UPDATE_OTHER_ARRIVAL_TIME = "15:15";
	public static final String UPDATE_OTHER_DEPARTURE_TIME = "15:45";

	// Reporting Person
	public static final String UPDATE_REPORTING_PERSON_NAME = "Sarah Johnson";
	public static final String UPDATE_REPORTING_PERSON_DOB = "01/15/1990";
	public static final String UPDATE_REPORTING_PERSON_PHONE = "4085553344";
	public static final String UPDATE_REPORTING_PERSON_WORK_PHONE = "4085553345";
	public static final String UPDATE_REPORTING_PERSON_STREET_NUM = "600";
	public static final String UPDATE_REPORTING_PERSON_STREET_NAME = "Market St";
	public static final String UPDATE_REPORTING_PERSON_UNIT = "Suite 301";
	public static final String UPDATE_REPORTING_PERSON_CITY = "San Jose";
	public static final String UPDATE_REPORTING_PERSON_STATE = "CA";
	public static final String UPDATE_REPORTING_PERSON_ZIP = "95112";

	// Victim - 1
	public static final String UPDATE_VICTIM_NAME = "Emily Davis";
	public static final String UPDATE_VICTIM_DOB = "02/20/1985";
	public static final String UPDATE_VICTIM_PHONE = "4085554455";
	public static final String UPDATE_VICTIM_WORK_PHONE = "4085554456";
	public static final String UPDATE_VICTIM_GENDER = "Female";
	public static final String UPDATE_VICTIM_RACE = "Asian Or Pacific Islander";
	public static final String UPDATE_VICTIM_EYES = "Green";
	public static final String UPDATE_VICTIM_HAIR_TYPE = "Long";
	public static final String UPDATE_VICTIM_HAIR_COLOR = "Red";
	public static final String UPDATE_VICTIM_HEIGHT = "5' 7";
	public static final String UPDATE_VICTIM_BUILD = "Thin";
	public static final String UPDATE_VICTIM_WEIGHT = "130";

	// Victim - 1 Address
	public static final String UPDATE_VICTIM_STREET_NUM = "150";
	public static final String UPDATE_VICTIM_STREET_NAME = "King St";
	public static final String UPDATE_VICTIM_UNIT = "U10";
	public static final String UPDATE_VICTIM_CITY = "San Jose";
	public static final String UPDATE_VICTIM_STATE = "IN";
	public static final String UPDATE_VICTIM_ZIP = "95113";
	// Victim - 1 Vehicle
	public static final String UPDATE_VICTIM_VEHICLE_YEAR = "2022";
	public static final String UPDATE_VICTIM_VEHICLE_MAKE = "Toyota";
	public static final String UPDATE_VICTIM_VEHICLE_MODEL = "Corolla";
	public static final String UPDATE_VICTIM_VEHICLE_COLOR = "Red";
	public static final String UPDATE_VICTIM_VEHICLE_LICENSE = "8XYZ123";
	public static final String UPDATE_VICTIM_VEHICLE_STATE = "CA";

	// Witness - 1
	public static final String UPDATE_WITNESS_NAME = "David Kim";
	public static final String UPDATE_WITNESS_DOB = "03/10/1980";
	public static final String UPDATE_WITNESS_PHONE = "4085555566";
	public static final String UPDATE_WITNESS_WORK_PHONE = "4085555567";
	public static final String UPDATE_WITNESS_GENDER = "Male";
	public static final String UPDATE_WITNESS_RACE = "White";
	public static final String UPDATE_WITNESS_EYES = "Blue";
	public static final String UPDATE_WITNESS_HAIR_TYPE = "Short";
	public static final String UPDATE_WITNESS_HAIR_COLOR = "Gray";
	public static final String UPDATE_WITNESS_HEIGHT = "6' 0";
	public static final String UPDATE_WITNESS_BUILD = "Athletic";
	public static final String UPDATE_WITNESS_WEIGHT = "170";

	// Witness - 1 Address
	public static final String UPDATE_WITNESS_STREET_NUM = "250";
	public static final String UPDATE_WITNESS_STREET_NAME = "Park Ave";
	public static final String UPDATE_WITNESS_UNIT = "Unit 5";
	public static final String UPDATE_WITNESS_CITY = "San Jose";
	public static final String UPDATE_WITNESS_STATE = "CA";
	public static final String UPDATE_WITNESS_ZIP = "95114";
	// Witness - 1 Vehicle
	public static final String UPDATE_WITNESS_VEHICLE_YEAR = "2023";
	public static final String UPDATE_WITNESS_VEHICLE_MAKE = "Tesla";
	public static final String UPDATE_WITNESS_VEHICLE_MODEL = "Model 3";
	public static final String UPDATE_WITNESS_VEHICLE_COLOR = "White";
	public static final String UPDATE_WITNESS_VEHICLE_LICENSE = "TES123";
	public static final String UPDATE_WITNESS_VEHICLE_STATE = "CA";

	// Suspect - 1
	public static final String UPDATE_SUSPECT_NAME = "Alex Turner";
	public static final String UPDATE_SUSPECT_DOB = "05/05/1995";
	public static final String UPDATE_SUSPECT_PHONE = "4085556677";
	public static final String UPDATE_SUSPECT_WORK_PHONE = "N/A";
	public static final String UPDATE_SUSPECT_GENDER = "Male";
	public static final String UPDATE_SUSPECT_RACE = "Black";
	public static final String UPDATE_SUSPECT_EYES = "Brown";
	public static final String UPDATE_SUSPECT_HAIR_TYPE = "Curly";
	public static final String UPDATE_SUSPECT_HAIR_COLOR = "Black";
	public static final String UPDATE_SUSPECT_HEIGHT = "5' 11";
	public static final String UPDATE_SUSPECT_BUILD = "Heavy";
	public static final String UPDATE_SUSPECT_WEIGHT = "200";

	// Suspect - 1 Address
	public static final String UPDATE_SUSPECT_STREET_NUM = "350";
	public static final String UPDATE_SUSPECT_STREET_NAME = "Almaden Blvd";
	public static final String UPDATE_SUSPECT_UNIT = "Apt 20";
	public static final String UPDATE_SUSPECT_CITY = "San Jose";
	public static final String UPDATE_SUSPECT_STATE = "CA";
	public static final String UPDATE_SUSPECT_ZIP = "95115";
	// Suspect - 1 Vehicle
	public static final String UPDATE_SUSPECT_VEHICLE_YEAR = "2021";
	public static final String UPDATE_SUSPECT_VEHICLE_MAKE = "Chevrolet";
	public static final String UPDATE_SUSPECT_VEHICLE_MODEL = "Malibu";
	public static final String UPDATE_SUSPECT_VEHICLE_COLOR = "Silver";
	public static final String UPDATE_SUSPECT_VEHICLE_LICENSE = "CHEV456";
	public static final String UPDATE_SUSPECT_VEHICLE_STATE = "AZ";

	// Classification
	public static final boolean UPDATE_EQUIPMENT_FAILURE = false;
	public static final boolean UPDATE_SAFETY_HAZARD = true;
	public static final boolean UPDATE_PROPERTY_DAMAGE = false;
	public static final boolean UPDATE_PERSONAL_INJURY = true;
	public static final boolean UPDATE_CONDUCT = false;
	public static final boolean UPDATE_CRIMINAL_ACT = true;
	public static final boolean UPDATE_MISSING_PERSON = false;
	public static final boolean UPDATE_DEATH = false;
	public static final boolean UPDATE_MAINTENANCE_ISSUE = true;
	public static final boolean UPDATE_ALARM = false;
	public static final boolean UPDATE_FLOOD = false;
	public static final boolean UPDATE_TRAINING = true;

	// Client Notified
	public static final String UPDATE_CLIENT_NOTIFIED_DATE = "09/15/2025 15:30";
	public static final String UPDATE_CLIENT_NOTIFIED_NAME = "Robert Smith";

	// Incident Description
	public static final String UPDATE_INCIDENT_DESCRIPTION = "A suspect was seen tampering with electrical equipment. Fire and EMS responded. The suspect was apprehended by police.";

	// Incident Report Images
	public static final String UPDATE_INCIDENT_IMAGE_PATH = "./src/test/resource/testdata/image.jpeg";

}
