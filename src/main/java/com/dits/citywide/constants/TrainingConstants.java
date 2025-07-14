package com.dits.citywide.constants;

public class TrainingConstants {

	// Category Constants
	public static final String CATEGORY_NAME = "Automation Testing";
	public static final String ADDED_CATEGORY_SUCCESS_MESSAGE = "Category added successfully";

	public static final String CATEGORY_NAME_UPDATED = "Automation Testing Updated";
	public static final String UPDATED_CATEGORY_SUCCESS_MESSAGE = "Category updated successfully";

	public static final String CATEGORY_NAME_DELETED = "Category deleted successfully!";

	// Certificate Constants
	public static final String CERTIFICATE_HEADING = "Certificates";
	public static final String CERTIFICATE_NAME = "Automation Testing Certificate";
	public static final String CERTIFICATE_SERIAL_NUMBER = "1234567890";
	// public static final String CERTIFICATE_FILE_PATH =
	// "/Users/ditsdev/Downloads/automation_test_file.pdf";
	public static final String CERTIFICATE_FILE_PATH = System.getProperty("user.home")
			+ "/Downloads/automation_test_file.pdf";

	public static final String CERTIFICATE_DESCRIPTION = "This is a test certificate description.";

	public static final String ADDED_CERTIFICATE_SUCCESS_MESSAGE = "Certificate added successfully";

	public static final String UPDATED_CERTIFICATE_NAME = "Automation Testing Certificate Updated";
	public static final String UPDATED_SERIAL_NUMBER = "987654321";
	public static final String UPDATED_DESCRIPTION = "This is an updated test certificate description.";
	public static final String UPDATED_CERTIFICATE_SUCCESS_MESSAGE = "Certificate updated successfully";

	public static final String CERTIFICATE_DELETED_SUCCESS_MESSAGE = "Certificate deleted successfully";

	// Course Constants
	// Add New Course data
	public static final String COURSE_NAME = "Automation Testing Course";
	public static final String CERTIFICATE = CERTIFICATE_NAME;
	public static final String CATEGORY = CATEGORY_NAME;
	public static final String PAYMENT_TYPE = "Paid";
	public static final String COURSE_DURATION = "Weeks";
	public static final String COURSE_DURATION_VALUE = "4";
	public static final String COURSE_COMPLETION_TIME = "Days";
	public static final String COURSE_COMPLETION_TIME_VALUE = "30";
	public static final String COURSE_EXPIRATION_DATE = "08/30/2025";
	public static final String COURSE_DESCRIPTION = "This is a test course description.";
	public static final String ASSESSMENT = "Yes";
	public static final String INSTRUCTOR = "Guest";
	public static final String INSTRUCTOR_NAME = "John Doe";
	public static final String COURSE_EVALUATOR = "763";
	public static final String REQUIRES_COURSE_COMPLETION_TO_SCHEDULE = "Yes";

	// Module Constants
	public static final String MODULE_NAME = "Module 1";
	public static final String MODULE_DURATION = "2";
	public static final String MODULE_CONTENT = "This is a test module content.";
	public static final String MODULE_FILE_PATH = System.getProperty("user.home") + "/Downloads/automation_test_file.pdf";
	public static final String MODULE_FILE_NAME = "https://www.google.com";

}
