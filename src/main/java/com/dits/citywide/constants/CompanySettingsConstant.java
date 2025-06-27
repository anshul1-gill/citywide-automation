package com.dits.citywide.constants;

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
	public static final String CUSTOM_HOLIDAY_START_DATE = "06/13/2025"; // Format: MM/dd/yyyy
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

	public static final String ADD_VIOLATION_SUCCESS_MESSAGE = "Parking violation added successfully";

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
	
	public static final String DELETE_CHARGE_SUCCESS_MESSAGE = "Charges deleted deleted successfully";
}
