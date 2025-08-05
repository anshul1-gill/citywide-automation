package com.dits.citywide.constants;

public class PatrolConstants {

	// Welcome Text
	public static final String WELCOME_TEXT = "Hope you are doing well. Lets begin your shift, remember shift also includes breaks please dont hesitate for one !!";

// HR Management 
	// Leavve Request Data
	public static final String LEAVE_TYPE = "Study";

	public static final String LEAVE_FROM_MONTH = "Aug";
	public static final String LEAVE_FROM_YEAR = "2025";
	public static final String LEAVE_FROM_DATE = "6";

	public static final String LEAVE_TO_MONTH = "Aug";
	public static final String LEAVE_TO_YEAR = "2025";
	public static final String LEAVE_TO_DATE = "6";

	public static final String LEAVE_START_TIME = "04:30";
	public static final String LEAVE_END_TIME = "05:30";

	public static final String LEAVE_DESCRIPTION = "Need to attend a workshop on urban planning and development.";

	// Edit Leave Request Data
	public static final String EDIT_LEAVE_TYPE = "Sick leave";

	public static final String EDIT_LEAVE_FROM_MONTH = "Sep";
	public static final String EDIT_LEAVE_FROM_YEAR = "2025";
	public static final String EDIT_LEAVE_FROM_DATE = "21";

	public static final String EDIT_LEAVE_TO_MONTH = "Sep";
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

}
