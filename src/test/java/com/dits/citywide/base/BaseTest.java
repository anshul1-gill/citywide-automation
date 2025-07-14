package com.dits.citywide.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.dits.citywide.driverfactory.DriverFactory;
import com.dits.citywide.pages.admin.ActivityTemplatePage;
import com.dits.citywide.pages.admin.AddEmployeePage;
import com.dits.citywide.pages.admin.ApplyLeavePage;
import com.dits.citywide.pages.admin.BeatsPage;
import com.dits.citywide.pages.admin.BreaksPage;
import com.dits.citywide.pages.admin.CallsPage;
import com.dits.citywide.pages.admin.CertificatesPage;
import com.dits.citywide.pages.admin.CompanySettingsPage;
import com.dits.citywide.pages.admin.CourseCategoriesPage;
import com.dits.citywide.pages.admin.DashboardPage;
import com.dits.citywide.pages.admin.EmployeesPage;
import com.dits.citywide.pages.admin.HRConfigurationsPage;
import com.dits.citywide.pages.admin.HolidaysPage;
import com.dits.citywide.pages.admin.LeaveRequestsPage;
import com.dits.citywide.pages.admin.LeavesPage;
import com.dits.citywide.pages.admin.LoginPage;
import com.dits.citywide.pages.admin.RespondingAgenciesPage;
import com.dits.citywide.pages.admin.SchedulingPage;
import com.dits.citywide.pages.admin.TotalCoursesPage;
import com.dits.citywide.pages.admin.TrainingPage;
import com.dits.citywide.pages.admin.ViewEmployeePage;
import com.dits.citywide.pages.admin.ViolationsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentCallsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentLeaveRequestsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentReportsPage;
import com.dits.citywide.pages.fieldagent.FieldAgentStartShiftPage;

public class BaseTest {

	protected DriverFactory driverFactory;
	protected Properties prop;
	protected WebDriver driver;
	protected SoftAssert softAssert;
	protected LoginPage loginPage;
	protected DashboardPage dashboardPage;
	protected EmployeesPage employeesPage;
	protected AddEmployeePage addEmployeePage;
	protected LeaveRequestsPage leaveRequestsPage;
	protected ApplyLeavePage applyLeavePage;
	protected ViewEmployeePage viewEmployeePage;
	protected SchedulingPage schedulingPage;
	protected FieldAgentStartShiftPage fieldAgentStartShiftPage;
	protected CallsPage callsPage;
	protected FieldAgentCallsPage fieldAgentCallsPage;
	protected FieldAgentReportsPage fieldAgentReportsPage;
	protected CompanySettingsPage companySettingsPage;
	protected BreaksPage breaksPage;
	protected HolidaysPage holidaysPage;
	protected LeavesPage leavesPage;
	protected FieldAgentLeaveRequestsPage fieldAgentLeaveRequestsPage;
	protected BeatsPage beatsPage;
	protected ViolationsPage violationsPage;
	protected ActivityTemplatePage activityTemplatePage;
	protected RespondingAgenciesPage respondingAgenciesPage;
	protected HRConfigurationsPage hrConfigurationsPage;
	protected TrainingPage trainingPage;
	protected CourseCategoriesPage courseCategoriesPage;
	protected CertificatesPage certificatesPage;
	protected TotalCoursesPage totalCoursesPage;

	// @BeforeTest
	@BeforeClass
	public void browserSetUp() {
		driverFactory = new DriverFactory();
		prop = driverFactory.initProperties();
		driver = driverFactory.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}

	// @AfterTest
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
