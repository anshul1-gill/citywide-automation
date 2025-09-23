package com.dits.citywide.base;

import java.util.Properties;

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
import com.dits.citywide.pages.fieldagent.FieldAgentProfileDetailsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentReportsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentStartShiftPage;
import com.dits.citywide.pages.fieldagent.FieldAgentTeamSupportPage;
import com.dits.citywide.pages.fieldagent.FieldAgentTrespassNoticesPage;
import com.dits.citywide.pages.fieldagent.FieldAgentParkingCitationPage;
import com.dits.citywide.pages.fieldagent.FieldAgentPassdownLogsPage;
import com.dits.citywide.pages.patrol.PatrolBeatsPage;
import com.dits.citywide.pages.patrol.PatrolLeaveRequestsPage;
import com.dits.citywide.pages.patrol.PatrolStartShiftPage;
import com.dits.citywide.pages.patrol.PatrolVehicleInspectionPage;

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

	@BeforeClass
	public void browserSetUp() {
		driverFactory = new DriverFactory();
		prop = driverFactory.initProperties();
		driver = driverFactory.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
