package com.dits.citywide.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.dits.citywide.driverfactory.DriverFactory;
import com.dits.citywide.pages.AddEmployeePage;
import com.dits.citywide.pages.ApplyLeavePage;
import com.dits.citywide.pages.BreaksPage;
import com.dits.citywide.pages.CallsPage;
import com.dits.citywide.pages.CompanySettingsPage;
import com.dits.citywide.pages.DashboardPage;
import com.dits.citywide.pages.EmployeesPage;
import com.dits.citywide.pages.FieldAgentCallsPage;
import com.dits.citywide.pages.FieldAgentReportsPage;
import com.dits.citywide.pages.FieldAgentStartShiftPage;
import com.dits.citywide.pages.HolidaysPage;
import com.dits.citywide.pages.LeaveRequestsPage;
import com.dits.citywide.pages.LoginPage;
import com.dits.citywide.pages.SchedulingPage;
import com.dits.citywide.pages.ViewEmployeePage;

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

	@BeforeTest
	public void browserSetUp() {
		driverFactory = new DriverFactory();
		prop = driverFactory.initProperties();
		driver = driverFactory.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
