package com.dits.citywide.constants;

/**
 * Constants dedicated to the React Add New Site flow on the Dev server.
 * Keep values deterministic and human-readable. Use CSV for multi-selects.
 * If uniqueness is needed, append a short timestamp in the test, not here.
 */
public class ConversionSiteData {

    // Dev environment URL for React module
    public static final String DEV_URL = "https://dev-cw.ditstekcloud.com/"; // replace if needed

    // ===== General Details =====
    public static final String SITE_NAME = "Laguna Beach Resort";
    public static final String AGENCY_BEAT_CSV = "BT-401,BT-403,Beat-76";
    public static final String ASSIGN_OFFICER_CSV = "RS361 - Mara Heller"; // can be CSV or single
    public static final String CALL_RESPONSE = "24/7";
    public static final String SERVICE_START_TIME = "12:00";
    public static final String SERVICE_END_TIME = "06:00";

    public static final boolean SITE_TYPE_STATIONARY = true;
    public static final boolean SITE_TYPE_MOBILE = true;
    public static final boolean ADMIN_DISPATCH = true;
    public static final boolean PAY_POST_RATE = true;
    public static final boolean REPORT_APPROVAL_NEEDED = true;
    public static final boolean PDF_REPORT_NEEDED = true;

    public static final String REPORT_TIME = "07:00 PM";
    public static final String CLIENT_EMAIL = "olivia@brownenterprises.com";

    public static final String POLICE_AGENCIES_CSV = "TEST WEBDEV POLICE,San Diego Police Agency,";
    public static final String FIRE_AGENCIES_CSV = "Firewood agency , TESTWEB";
    public static final String MEDICAL_AGENCIES_CSV = "Test agency by web,";
    public static final String OTHER_AGENCIES_CSV = "OTHER WEBDEV,PLUMBER AGENCY ";
    public static final String ACCOUNT_MANAGER = "Tom Admin";

    // ===== Address =====
    public static final String SITE_STREET_NUMBER = "123";
    public static final String SITE_STREET_NAME = "Main Street";
    public static final String SITE_CITY = "New York";
    public static final String SITE_STATE = "NY";
    public static final String SITE_ZIP_CODE = "10001";

    // ===== Geofencing =====
    public static final String GEOFENCE_RADIUS_TYPE = "Feet";
    public static final String GEOFENCE_RADIUS_VALUE = "160";

    // ===== Main Contact =====
    public static final String CONTACT_FIRST_NAME = "Olivia";
    public static final String CONTACT_LAST_NAME = "Brown";
    public static final String MAIN_CONTACT_PHONE = "5454667364";
    public static final String CONTACT_MOBILE = "9876543210";
    public static final String CONTACT_FAX = "1234567890";
    public static final String CONTACT_EMAIL = "olivia@brownenterprises.com";

    // ===== Site Contact =====
    public static final String SITE_CONTACT_JOB_TITLE = "Manager";
    public static final String SITE_CONTACT_NAME = "Smith";
    public static final String SITE_CONTACT_PHONE = "1231231234";

    // ===== Page 2: Property Access =====
    public static final String GATE_CODE = "1234";
    public static final String ALARM_CODE_ARM = "5678";
    public static final String ALARM_CODE_UNARM = "8765";
    public static final String ALARM_NOTES = "Alarm panel is located near the main entrance";
    public static final String LOCK_BOX_CODE = "9999";
    public static final boolean LOCK_BOX_REQUIRED = true;
    public static final String LOCK_BOX_NOTES = "Lock box is behind the front desk";

    // ===== Page 3: Parking Enforcement =====
    public static final String TOW_COMPANY_NAME = "City Towing Services";
    public static final String TOW_COMPANY_PHONE = "5551234567";
    public static final boolean TOW_REQUIREMENT = true;
    public static final String TOWING_NOTES = "Tow unauthorized vehicles after 10 PM";
    public static final boolean PARKING_ENFORCEMENT_REQUIRED = true;
    public static final String PARKING_ENFORCEMENT_NOTES = "Enforce parking regulations in visitor lot";

    // ===== Page 4: Security Report =====
    public static final String REPORT_INSTRUCTIONS = "Submit daily activity report by 8 AM. Include all incidents.";

    // ===== Page 5: Overall Site Coverage =====
    public static final String OVERALL_SITE_COVERAGE_NOTES = "Full coverage required 24/7. Priority on main building.";

    // ===== Page 6: Stationary Coverage =====
    public static final String STATIONARY_COVERAGE_NAME = "Main Entrance Post";
    public static final String STATIONARY_SERVICE_TYPE = "Security Guard";
    public static final String STATIONARY_BILLING_TYPE = "Hourly";
    public static final String STATIONARY_USD_RATE = "25.00";
    public static final String STATIONARY_HOLIDAY_RATE = "37.50";
    public static final String STATIONARY_START_TIME = "08:00";
    public static final String STATIONARY_END_TIME = "16:00";
    public static final String STATIONARY_DAY_NOTES = "Day shift: Monitor main entrance";
    public static final String STATIONARY_SWING_NOTES = "Swing shift: Patrol parking areas";
    public static final String STATIONARY_NIGHT_NOTES = "Night shift: Secure all entrances";

    // ===== Page 7: Mobile Patrol Coverage =====
    public static final String MOBILE_COVERAGE_NAME = "Perimeter Patrol";
    public static final String MOBILE_SERVICE_TYPE = "Field";
    public static final String MOBILE_BILLING_TYPE = "Per Visit";
    public static final String MOBILE_USD_RATE = "15.00";
    public static final String MOBILE_HOLIDAY_RATE = "22.50";
    public static final String MOBILE_START_TIME = "22:00";
    public static final String MOBILE_END_TIME = "06:00";
    public static final String MOBILE_DAY_HITS = "2";
    public static final String MOBILE_SWING_HITS = "3";
    public static final String MOBILE_NIGHT_HITS = "4";
    public static final String MOBILE_DAY_NOTES = "Check all parking lots";
    public static final String MOBILE_SWING_NOTES = "Focus on building perimeter";
    public static final String MOBILE_NIGHT_NOTES = "Full property patrol";

    // ===== Page 8: Admin Coverage =====
    public static final String ADMIN_COVERAGE_NAME = "Admin Support";
    public static final String ADMIN_SERVICE_TYPE = "Admin site";
    public static final String ADMIN_START_TIME = "09:00";
    public static final String ADMIN_END_TIME = "17:00";
    public static final String ADMIN_DAY_NOTES = "Handle visitor check-in";
    public static final String ADMIN_SWING_NOTES = "Process visitor logs";
    public static final String ADMIN_NIGHT_NOTES = "N/A";

    // ===== Page 9: Temporary Post Order =====
    public static final String TEMP_ORDER_NOTES = "All officers must check parking lot hourly for suspicious activity.";
    public static final String TEMP_ORDER_EXPIRE_DATE = "01/20/2026"; // MM/dd/yyyy
    public static final String TEMP_ORDER_EXPIRE_TIME = "18:00"; // optional, 24h format

    // ===== Page 10: Site Area =====
    public static final String SITE_AREA_NAME = "Main Building";
    public static final String SITE_DOOR_COUNT = "12";
    public static final String SITE_AREA_NOTES = "Primary building with 3 floors";

    // ===== Page 11: Post Orders =====
    public static final String POST_ORDER_TEXT = "Officers must check in at main desk upon arrival";
    public static final String PROBLEM_AREAS = "Parking lot B has poor lighting";
    public static final String CHECKPOINT_NAME = "Main Entrance";
    public static final String CHECKPOINT_DESCRIPTION = "Front entrance checkpoint";
    public static final String CHECKPOINT_TYPE = "QR Code";
    public static final String SCAN_TIME = "00:30";
    public static final String SNITCH_TIME = "5";
    public static final String ACTIVE_DAYS = "Monday"; // Days dropdown
    public static final String ACTION_PRIORITY = "1";
    public static final String ACTION_INPUT_TYPE = "Text";
    public static final String ACTION_DIRECTIVE = "Report any suspicious activity";
    public static final String CHECKPOINT_ADDRESS = "123 Main Street, New York, NY";
    public static final String CHECKPOINT_RADIUS = "100";

    // Assignment fields
    public static final String ASSIGNMENT_NAME = "Patrol Assignment";
    public static final String ASSIGNMENT_TEMPLATE = "Automation template";
    public static final String ASSIGNMENT_COVERAGE_TYPE = "Mobile/Multiple Sites";
    public static final String ASSIGNMENT_COVERAGE_NAME = "Perimeter Patrol";
    public static final String ASSIGNMENT_DAYS_OF_WEEK = "Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday";
    public static final String ASSIGNMENT_TIME = "08:00";
    public static final String ASSIGNMENT_SNITCH_TIME = "10";

    // ===== Page 14: Site Doc/Payment Terms =====
    public static final String CLIENT_FIRST_NAME = "John";
    public static final String CLIENT_LAST_NAME = "Doe";
    public static final String CLIENT_COMPANY_NAME = "Brown Enterprises";
    public static final String CLIENT_DISPLAY_NAME = "Brown Ent.";
    public static final String CLIENT_MAIN_PHONE = "5559876543";
    public static final String CLIENT_MOBILE_PHONE = "5551112222";
    public static final String CLIENT_EMAIL_BILLING = "billing@brownenterprises.com";
    public static final String CLIENT_FAX = "5553334444";
    public static final String CLIENT_TERMS = "Net 30";
    public static final String BILLING_CYCLE = "Monthly";
    public static final String BILLING_INVOICE_NUMBER = "INV-001";
    public static final String BILLING_STREET_NUMBER = "500";
    public static final String BILLING_STREET_NAME = "Corporate Blvd";
    public static final String BILLING_CITY = "New York";
    public static final String BILLING_STATE = "NY";
    public static final String BILLING_ZIP_CODE = "10002";
    public static final String BILLING_COUNTRY = "USA";

    // ===== Page 15: Feedback Comments =====
    public static final String FEEDBACK_COMMENTS = "Site setup completed. Ready for operations.";
}