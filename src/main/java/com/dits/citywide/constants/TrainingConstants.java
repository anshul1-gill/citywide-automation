package com.dits.citywide.constants;

public class TrainingConstants {

	// Category Constants
	public static final String CATEGORY_NAME = "Automation Testing Category";
	public static final String ADDED_CATEGORY_SUCCESS_MESSAGE = "Category added successfully";

	public static final String CATEGORY_NAME_UPDATED = "Automation Testing Updated ";
	public static final String UPDATED_CATEGORY_SUCCESS_MESSAGE = "Category updated successfully";

	public static final String CATEGORY_NAME_DELETED = "Category deleted successfully!";

	// Certificate Constants
	public static final String CERTIFICATE_HEADING = "Certificates";
	public static final String CERTIFICATE_NAME = "Automation Testing Certificate Name";
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
	public static final String COURSE_NAME = "Automation Testing Course Name";
	public static final String CERTIFICATE = CERTIFICATE_NAME;
	public static final String CATEGORY = CATEGORY_NAME;
	public static final String PAYMENT_TYPE = "Paid";
	public static final String ASSIGNMENT_DURATION = "4";
	public static final String DEADLINE_TYPE = "Days";
	public static final String COMPLITION_DEADLINE = "30";
	public static final String COURSE_DESCRIPTION = "This is a test course description.";
	public static final String ASSESSMENT = "Yes";
	public static final String INSTRUCTOR = "Guest";
	public static final String INSTRUCTOR_NAME = "John Doe";
	public static final String COURSE_EVALUATOR = "763";
	public static final String REQUIRES_COURSE_COMPLETION_TO_SCHEDULE = "Yes";

	// Module Constants
	public static final String MODULE_NAME = "Module 1";
	public static final String MODULE_DURATION = "00:30";
	public static final String MODULE_CONTENT = "This is a test module content.";
	public static final String MODULE_FILE_PATH = System.getProperty("user.home")
			+ "/Downloads/automation_test_file.pdf";
	public static final String MODULE_FILE_NAME = "https://www.google.com";

	public static final String MODULE_ADDED_SUCCESS_MESSAGE = "Module created successfully";
	public static final String MODULE_UPDATED_SUCCESS_MESSAGE = "Module updated successfully";
	public static final String MODULE_DELETED_SUCCESS_MESSAGE = "Module deleted successfully";

	public static final String ASSESSMENT_CREATED_SUCCESS_MESSAGE = "Assessment added successfully";
	public static final String QUESTION_ADDED_SUCCESS_MESSAGE = "Question added successfully";

	public static final String COURSE_DELETED_SUCCESS_MESSAGE = "Course deleted successfully";

	public static final String COURSE_PUBLISHED_SUCCESS_MESSAGE = "Published course successfully";

	// Assessment Constants
	public static final String ASSESSMENT_NAME = "Automation Testing Assessment";
	public static final String ASSESSMENT_DURATION = "00:30";
	public static final String ASSESSMENT_MODULE = MODULE_NAME;
	public static final String ASSESSMENT_REMARKS = "Scoring";
	public static final String ASSESSMENT_TOTAL_POINTS = "10";
	public static final String ASSESSMENT_MINIMUM_POINTS = "5";
	public static final String METHOD_OF_ASSESSMENT = "Points";

	// Questionnaire Constants
	public static final String QUESTIONNAIRE_TYPE = "Input Text Field";
	public static final String QUESTION_SCORE = "10";
	public static final String ENTER_QUESTION_1 = "What is the goal of employee training?";
	public static final String ENTER_PREDEFINED_ANSWER_1 = "To improve job skills and performance";
	public static final String ENTER_QUESTION_2 = "What is e-learning?";
	public static final String ENTER_PREDEFINED_ANSWER_2 = "Training delivered through digital platforms";

	// Course Assign
	public static final String SELECTED_COURSE_PURPOSE = "Training";
	public static final String ASSIGN_COURSE_SUCCESS_MESSAGE = "Course assigned successfully";

	public static final String YOUR_ASSESSMENT_IS_STARTED = "Your assessment is started.";

	public static final String YOUR_ASSESSMENT_IS_SUBMITTED = "Your assessment has been submitted successfully.";

	public static final String COURSE_STATUS_ATTEMPTED = "Attempted";

	// Assessment Results

	public static final String ASSESSMENT_RESULTS_HEADING = "Assessment Results";

	public static final String ASSESSMENT_SEARCH_BY_STATUS = "Attempted";

	public static final String PREDICTED_ANSWERS = "Right";

	public static final String ASSESSMENT_EVALUATED_SUCCESS_MESSAGE = "Assessment evaluated successfully";

	public static final String CANDIDATE_SUCCESSFULLY_COMPLETED_COURSE = "The candidate has successfully completed the course.";
	public static final String CERTIFICATE_GENERATED_SUCCESS_MESSAGE = "The certificate has been successfully issued to the candidate.";

}
