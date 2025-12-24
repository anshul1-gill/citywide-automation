package com.dits.citywide.constants;

public class SchedulingConstant {

	public static final String ASSIGN_SHIFT = "Assign to Employee";
	public static final String START_TIME = "09:00";
	public static final String END_TIME = "17:00";
	public static final String SCHEDULED_BREAK = "Lunch Break";
	public static final String ADD_NOTES = "Assigned shift for Richmond. Be punctual and report issues to your supervisor immediately.";
	public static final String SUCCESS_MESSAGE_ADD_SHIFT = "Shift added successfully";

	// Patrol data
	public static final String ASSIGN_SHIFT_PATROL = "Assign to Employee";
	public static final String SCHEDULED_BREAK_PATROL = "Lunch Break";
	public static final String START_TIME_PATROL = "01:30";
	public static final String END_TIME_PATROL = "10:30";
	public static final String ADD_NOTES_PATROL = "Assigned shift for patrol. Ensure to follow the route and report any incidents.";

	// Admin/Dispatch data
	public static final String AGENT_TYPE_ADMIN = "Admin/Dispatch";
	public static final String AGENT_TYPE_STATIONARY = "Stationary";
	public static final String ASSIGN_SHIFT_ADMIN = "Assign to Employee";
	public static final String START_TIME_ADMIN = "09:00";
	public static final String END_TIME_ADMIN = "17:00";
	public static final String SCHEDULED_BREAK_ADMIN = "Lunch Break";
	public static final String ADD_NOTES_ADMIN = "Assigned shift for Admin/Dispatch. Coordinate with field teams.";

	// Shift Date
	public static final String ADD_SHIFT_DATE = "23";

	// Confirmation Message
	public static final String ARE_YOU_SURE = "Are you sure?";
	public static final String ACTION_WILL_PUBLISH_SHIFTS = "This action will publish shifts";
	public static final String SUCCESS_PUBLISH_MESSAGE = "Shifts published successfully!";

	// Update Shift data
	public static final String UPDATED_START_TIME = "10:00";
	public static final String UPDATED_END_TIME = "18:00";
	public static final String UPDATED_BREAK = "Training Break - 45min (Unpaid)";
	public static final String UPDATED_NOTES = "Updated shift - changed time and break. Ensure to follow the new schedule.";
	public static final String SUCCESS_MESSAGE_UPDATE_SHIFT = "Shift updated successfully";

	// Copy Paste Shift data
	public static final String COPY_SOURCE_DATE = "16"; // Source date for copy
	public static final String COPY_TARGET_DATE = "18"; // Target date for paste
	public static final String COPY_PASTE_EMPLOYEE_ID = "1147"; // Patrol agent for copy/paste test

	// Drag and Drop Shift data
	public static final String DRAG_DROP_EMPLOYEE_ID = "1172"; // Field agent for drag/drop test
	public static final String DRAG_SOURCE_DATE = "16"; // Source date for drag
	public static final String DRAG_TARGET_DATE = "17"; // Target date for drop
	public static final String SUCCESS_MESSAGE_DELETE_SHIFT = "Shift deleted successfully!";
}
