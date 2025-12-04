package com.dits.citywide.listener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import com.dits.citywide.utilities.ScreenshotUtils;
import com.dits.citywide.driverfactory.DriverFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

	private static final String OUTPUT_FOLDER = "./reports/";
	private static final String FILE_NAME = "TestExecutionReport.html";

	private static ExtentReports extent = init();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	private static ExtentReports extentReports;

	private static ExtentReports init() {

		Path path = Paths.get(OUTPUT_FOLDER);

		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		extentReports = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
		reporter.config().setReportName("Citywide Automation Test Results");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("System", "Windows");
		extentReports.setSystemInfo("Author", "Anshul Gill");
		extentReports.setSystemInfo("Team", "Citywide QA Team");
		extentReports.setSystemInfo("Customer Name", "Tom Tamar");
		extentReports.setSystemInfo("Server", "Stage");
		return extentReports;
	}

	@Override
	public synchronized void onStart(ITestContext context) {
		System.out.println("Test Suite started!");

	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Test Suite is ending!"));
		extent.flush();
		test.remove();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName.substring(0, last).lastIndexOf(".");
		String className = qualifiedName.substring(mid + 1, last);

		System.out.println(methodName + " started!");
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());

		extentTest.assignCategory(result.getTestContext().getSuite().getName());
		extentTest.assignCategory(className);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
	}

	public synchronized void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println((methodName + " passed!"));
		test.get().pass("Test passed");
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
	    System.out.println(result.getMethod().getMethodName() + " failed!");

	    // 1) Get exception that caused the failure
	    Throwable throwable = result.getThrowable();
	    String errorMsg = (throwable != null && throwable.getMessage() != null)
	            ? throwable.getMessage()
	            : "No exception message available";

	    // 2) Short readable reason in report
	    test.get().fail("Reason: " + errorMsg);

	    // 3) Full stack trace in report
	    if (throwable != null) {
	        test.get().fail(throwable);
	    }

	    // 4) Screenshot on failure (using your ScreenshotUtils)
	    try {
	        // Get driver from your framework – adjust this line to your actual getter
	        // Example if you have DriverFactory.getDriver():
	        // WebDriver driver = DriverFactory.getDriver();

	        // TODO: replace with your real driver getter
	        org.openqa.selenium.WebDriver driver =
	                com.dits.citywide.driverfactory.DriverFactory.getDriver();

	        String screenshotPath = ScreenshotUtils.captureScreenshot(
	                driver, result.getMethod().getMethodName());

	        if (screenshotPath != null) {
	            test.get().addScreenCaptureFromPath(screenshotPath);
	        }
	    } catch (Exception e) {
	        System.out.println("Unable to attach screenshot: " + e.getMessage());
	    }

	    // 5) End time
	    test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}


	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		String methodName = result.getMethod().getMethodName();
		test.get().skip("Test skipped");
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}