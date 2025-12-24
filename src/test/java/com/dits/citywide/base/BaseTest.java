package com.dits.citywide.base;

import java.util.Properties;

import com.dits.citywide.utilities.PerformanceUtils;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.dits.citywide.driverfactory.DriverFactory;
import com.dits.citywide.pages.admin.ActivityTemplatePage;
import com.dits.citywide.pages.admin.AddEmployeePage;
import com.dits.citywide.pages.admin.ApplicantTrackingSystemPage;
import com.dits.citywide.pages.admin.ApplyLeavePage;
import com.dits.citywide.pages.admin.AssessmentsResultsPage;
import com.dits.citywide.pages.admin.AttendancePage;
import com.dits.citywide.pages.admin.BeatsPage;
import com.dits.citywide.pages.admin.BreaksPage;
import com.dits.citywide.pages.admin.CallsPage;
import com.dits.citywide.pages.admin.CertificatesPage;
import com.dits.citywide.pages.admin.ClientPage;
import com.dits.citywide.pages.admin.CompanySettingsPage;
import com.dits.citywide.pages.admin.CourseCategoriesPage;
import com.dits.citywide.pages.admin.DashboardPage;
import com.dits.citywide.pages.admin.ERMPage;
import com.dits.citywide.pages.admin.ERMRemarksHistoryPage;
import com.dits.citywide.pages.admin.ERMSettingsPage;
import com.dits.citywide.pages.admin.EmployeesPage;
import com.dits.citywide.pages.admin.HRConfigurationsPage;
import com.dits.citywide.pages.admin.HolidaysPage;
import com.dits.citywide.pages.admin.InvoicePage;
import com.dits.citywide.pages.admin.LeaveRequestsPage;
import com.dits.citywide.pages.admin.LeavesPage;
import com.dits.citywide.pages.admin.LoginPage;
import com.dits.citywide.pages.admin.MassEmailPage;
import com.dits.citywide.pages.admin.MessageOfTheWeekPage;
import com.dits.citywide.pages.admin.PassdownLogsPage;
import com.dits.citywide.pages.admin.PayrollPage;
import com.dits.citywide.pages.admin.RespondingAgenciesPage;
import com.dits.citywide.pages.admin.SchedulingPage;
import com.dits.citywide.pages.admin.SitesPage;
import com.dits.citywide.pages.admin.StatusPage;
import com.dits.citywide.pages.admin.TeamSupportTemplatePage;
import com.dits.citywide.pages.admin.TotalCoursesPage;
import com.dits.citywide.pages.admin.TrainingPage;
import com.dits.citywide.pages.admin.UpdateEmployeePage;
import com.dits.citywide.pages.admin.ViewEmployeePage;
import com.dits.citywide.pages.admin.ViolationsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentCallsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentFieldInterviewPage;
import com.dits.citywide.pages.fieldagent.FieldAgentIncidentReportsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentLeaveRequestsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentMyAttendancePage;
import com.dits.citywide.pages.fieldagent.FieldAgentMyCoursesPage;
import com.dits.citywide.pages.fieldagent.FieldAgentParkingCitationPage;
import com.dits.citywide.pages.fieldagent.FieldAgentPassdownLogsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentProfileDetailsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentReportsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentStartShiftPage;
import com.dits.citywide.pages.fieldagent.FieldAgentTeamSupportPage;
import com.dits.citywide.pages.fieldagent.FieldAgentTrespassNoticesPage;
import com.dits.citywide.pages.patrol.PatrolBeatsPage;
import com.dits.citywide.pages.patrol.PatrolLeaveRequestsPage;
import com.dits.citywide.pages.patrol.PatrolStartShiftPage;
import com.dits.citywide.pages.patrol.PatrolVehicleInspectionPage;
import com.dits.citywide.pages.patrol.PatrolAgentPassdownLogsPage;
import com.dits.citywide.pages.admin.RankAndPositionPage;
import com.dits.citywide.pages.admin.AssignmentTemplatePage;
import com.dits.citywide.pages.admin.CompanyDetailsPage;
import com.dits.citywide.pages.admin.BranchPage;
import com.dits.citywide.pages.admin.BranchListingPage;
import com.dits.citywide.pages.admin.RolesPermissionPage;
import com.dits.citywide.pages.admin.MassMailPage;
import com.dits.citywide.pages.admin.SystemLogsPage;
import com.dits.citywide.pages.admin.NotificationsPage;
import com.dits.citywide.pages.admin.SystemConfigPage;



public class BaseTest {
	

	public DriverFactory driverFactory;
	public Properties prop;
	public WebDriver driver;
	public SoftAssert softAssert;
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public EmployeesPage employeesPage;
	public AddEmployeePage addEmployeePage;
	public LeaveRequestsPage leaveRequestsPage;
	public ApplyLeavePage applyLeavePage;
	public ViewEmployeePage viewEmployeePage;
	public SchedulingPage schedulingPage;
	public FieldAgentStartShiftPage fieldAgentStartShiftPage;
	public CallsPage callsPage;
	public FieldAgentCallsPage fieldAgentCallsPage;
	public FieldAgentReportsPage fieldAgentReportsPage;
	public CompanySettingsPage companySettingsPage;
	public BreaksPage breaksPage;
	public HolidaysPage holidaysPage;
	public LeavesPage leavesPage;
	public FieldAgentLeaveRequestsPage fieldAgentLeaveRequestsPage;
	public BeatsPage beatsPage;
	public ViolationsPage violationsPage;
	public ActivityTemplatePage activityTemplatePage;
	public RespondingAgenciesPage respondingAgenciesPage;
	public HRConfigurationsPage hrConfigurationsPage;
	public TrainingPage trainingPage;
	public CourseCategoriesPage courseCategoriesPage;
	public CertificatesPage certificatesPage;
	public TotalCoursesPage totalCoursesPage;
	public FieldAgentMyCoursesPage fieldAgentMyCoursesPage;
	public AssessmentsResultsPage assessmentsResultsPage;
	public AttendancePage attendancePage;
	public FieldAgentMyAttendancePage fieldAgentMyAttendancePage;
	public FieldAgentPassdownLogsPage fieldAgentPassdownLogsPage;
	public PatrolStartShiftPage patrolStartShiftPage;
	public PatrolBeatsPage patrolBeatsPage;
	public PatrolVehicleInspectionPage patrolVehicleInspectionPage;
	public PatrolAgentPassdownLogsPage patrolAgentPassdownLogsPage; // Added new patrol agent passdown page object
	public UpdateEmployeePage updateEmployeePage;
	public ERMPage ermPage;
	public ERMSettingsPage ermSettingsPage;
	public ERMRemarksHistoryPage ermRemarksHistoryPage;
	public FieldAgentProfileDetailsPage fieldAgentProfileDetailsPage;
	public PatrolLeaveRequestsPage patrolLeaveRequestsPage;
	public SitesPage sitesPage;
	public FieldAgentTeamSupportPage fieldAgentTeamSupportPage;
	public TeamSupportTemplatePage teamSupportTemplatePage;
	public FieldAgentParkingCitationPage fieldAgentParkingCitationPage;
	public FieldAgentTrespassNoticesPage fieldAgentTrespassNoticesPage;
	public FieldAgentFieldInterviewPage fieldAgentFieldInterviewPage;
	public FieldAgentIncidentReportsPage fieldAgentIncidentReportsPage;
	public ApplicantTrackingSystemPage applicantTrackingSystemPage;
	public PassdownLogsPage passdownLogsPage;
	public StatusPage statusPage;
	public MessageOfTheWeekPage messageOfTheWeekPage;
	public PayrollPage payrollPage;
	public InvoicePage invoicePage;
	public MassEmailPage massEmailPage;
	public RankAndPositionPage rankAndPositionPage;
	public AssignmentTemplatePage assignmentTemplatePage;
	public CompanyDetailsPage companyDetailsPage;
	public BranchPage branchPage;
	public BranchListingPage branchListingPage;
	public RolesPermissionPage rolesPermissionPage;
	public MassMailPage massMailPage;
	public SystemLogsPage systemLogsPage;
	public NotificationsPage notificationsPage;
	public SystemConfigPage systemConfigPage;
	public ClientPage clientPage; // restored missing field for AddClientTest
	public PerformanceUtils performanceUtils;

	

	@BeforeClass
	public void browserSetUp() {
		driverFactory = new DriverFactory();
		prop = driverFactory.initProperties();
		driver = driverFactory.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
		 performanceUtils = new PerformanceUtils(driver);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	public void captureAndLogPagePerformance(String pageName) {

	    long pageLoadTime = performanceUtils.getPageLoadTimeInSeconds();
	    long domLoadTime = performanceUtils.getDomContentLoadTimeInSeconds();

	    System.out.println("=======================================");
	    System.out.println("📊 PAGE PERFORMANCE METRICS");
	    System.out.println("📄 Page Name      : " + pageName);
	    System.out.println("⏱ Page Load Time : " + pageLoadTime + " sec");
	    System.out.println("⚙ DOM Load Time  : " + domLoadTime + " sec");

	    if (pageLoadTime <= com.dits.citywide.constants.Constants.PAGE_LOAD_PASS) {
	        System.out.println("✅ STATUS : PASS (Fast Rendering)");
	    } 
	    else if (pageLoadTime <= com.dits.citywide.constants.Constants.PAGE_LOAD_WARNING) {
	        System.out.println("⚠️ STATUS : WARNING (Needs Optimization)");
	    } 
	    else {
	        System.out.println("❌ STATUS : FAIL (Critical Performance Issue)");
	    }

	    System.out.println("=======================================");
	}

	
	
}
