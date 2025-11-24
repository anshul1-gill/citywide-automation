package com.dits.citywide.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	private static String expandMonthName(String month) {
		if (month == null)
			return "";
		String m = month.trim().toLowerCase();
		switch (m) {
		case "jan":
			return "January";
		case "feb":
			return "February";
		case "mar":
			return "March";
		case "apr":
			return "April";
		case "may":
			return "May";
		case "jun":
			return "June";
		case "jul":
			return "July";
		case "aug":
			return "August";
		case "sep":
			return "September";
		case "oct":
			return "October";
		case "nov":
			return "November";
		case "dec":
			return "December";
		default:
			return month; // assume already full
		}
	}

	// public static void selectDatePrevious(WebDriver driver, String expMonth,
	// String expYear, String day) {
	//
	// int dayInt = Integer.parseInt(day);
	// if (dayInt < 1 || dayInt > 31) {
	// System.out.println("Wrong date passed: " + day);
	// return;
	// }
	//
	// String actMonth = driver.findElement(By.className("ant-picker-month-btn")).getText();
	// String actYear = driver.findElement(By.className("ant-picker-year-btn")).getText();
	//
	// while (!actMonth.equalsIgnoreCase(expMonth) || !actYear.equalsIgnoreCase(expYear)) {
	// driver.findElement(By.className("ant-picker-prev-icon")).click();
	// actMonth = driver.findElement(By.className("ant-picker-month-btn")).getText();
	// actYear = driver.findElement(By.className("ant-picker-year-btn")).getText();
	// }
	//
	// // Select only enabled, valid dates
	// String dayXpath = "//td[@class='ant-picker-cell ant-picker-cell-in-view']/div[text()='" + day + "']";
	// driver.findElement(By.xpath(dayXpath)).click();
	// }

	public static void selectDatePrevious(WebDriver driver, String expMonth, String expYear, String day) {
		// Expand abbreviation to full month name to match calendar UI
		expMonth = expandMonthName(expMonth);

		int dayInt = Integer.parseInt(day);
		if (dayInt < 1 || dayInt > 31) {
			System.out.println("Wrong date passed: " + day);
			throw new IllegalArgumentException("Invalid day for DOB: " + day);
		}

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			// Step 1: Click year button to open year picker
			WebElement yearBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("ant-picker-year-btn")));
			yearBtn.click();
			// Debug: Print calendar popup HTML after clicking year
			WebElement calendarPanel = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ant-picker-panel")));
			System.out.println("[Calendar Debug] Calendar panel HTML after year click: " + calendarPanel.getAttribute("outerHTML"));
			try {
				java.nio.file.Files.write(java.nio.file.Paths.get("/home/ditsdev151/Desktop/AutomationCitywide/citywide-automation/target/surefire-reports/calendar_debug.html"), calendarPanel.getAttribute("outerHTML").getBytes());
			} catch (Exception fileEx) {
				System.out.println("[Calendar Debug] Could not write calendar HTML to file: " + fileEx.getMessage());
			}
			// Step 2: Select the desired year
			String yearXpath = "//div[contains(@class,'ant-picker-year-panel')]//td/div[text()='" + expYear + "']";
			WebElement yearCell = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(yearXpath)));
			yearCell.click();
			// Step 3: Try to select the desired month using month picker
			boolean monthSelected = false;
			try {
				// Check if month button exists before clicking
				java.util.List<WebElement> monthBtns = driver.findElements(By.className("ant-picker-month-btn"));
				if (!monthBtns.isEmpty()) {
					WebElement monthBtn = wait.until(ExpectedConditions.elementToBeClickable(monthBtns.get(0)));
					monthBtn.click();
					String monthXpath = "//div[contains(@class,'ant-picker-month-panel')]//td/div[text()='" + expMonth + "']";
					WebElement monthCell = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(monthXpath)));
					monthCell.click();
					monthSelected = true;
				} else {
					System.out.println("[Calendar Debug] Month button not found, falling back to month-by-month navigation.");
				}
			} catch (Exception e) {
				System.out.println("[Calendar Debug] Exception in month picker: " + e.getMessage());
				// Fallback debug output
				try {
					WebElement panel = driver.findElement(By.className("ant-picker-panel"));
					String html = panel.getAttribute("outerHTML");
					System.out.println("[Calendar Debug] Calendar panel HTML when month button not found: " + html);
					java.nio.file.Files.write(java.nio.file.Paths.get("/home/ditsdev151/Desktop/AutomationCitywide/citywide-automation/target/surefire-reports/calendar_debug.html"), html.getBytes());
				} catch (Exception ex) {
					System.out.println("[Calendar Debug] Could not get calendar panel HTML: " + ex.getMessage());
				}
			}
			if (!monthSelected) {
				// Fallback: Try to select the month cell in year panel immediately if no navigation icon
				java.util.List<WebElement> prevIcons = driver.findElements(By.className("ant-picker-prev-icon"));
				if (prevIcons.isEmpty()) {
					String monthCellXpath = "//td[contains(@class,'ant-picker-cell-in-view')]//div[text()='" + expMonth.substring(0, 3) + "']";
					java.util.List<WebElement> monthCells = driver.findElements(By.xpath(monthCellXpath));
					if (!monthCells.isEmpty()) {
						monthCells.get(0).click();
					} else {
						// Debug: Capture calendar HTML if month cell is missing
						try {
							WebElement panel = driver.findElement(By.className("ant-picker-panel"));
							String html = panel.getAttribute("outerHTML");
							System.out.println("[Calendar Debug] Calendar panel HTML when month cell not found: " + html);
							java.nio.file.Files.write(java.nio.file.Paths.get("/home/ditsdev151/Desktop/AutomationCitywide/citywide-automation/target/surefire-reports/calendar_debug.html"), html.getBytes());
						} catch (Exception ex) {
							System.out.println("[Calendar Debug] Could not get calendar panel HTML: " + ex.getMessage());
						}
						throw new AssertionError("Could not find month cell for calendar navigation.");
					}
				} else {
					// Fallback: Navigate month-by-month until the desired month is reached
					String actMonth = "";
					java.util.List<WebElement> monthBtns = driver.findElements(By.className("ant-picker-month-btn"));
					java.util.List<WebElement> headerBtns = driver.findElements(By.xpath("//div[contains(@class,'ant-picker-header-view')]/button"));
					if (!monthBtns.isEmpty()) {
						actMonth = monthBtns.get(0).getText();
					} else {
						if (!headerBtns.isEmpty()) {
							actMonth = headerBtns.get(0).getText();
						} else {
							System.out.println("[Calendar Debug] Could not find month button or header button for current month.");
							throw new AssertionError("Could not determine current month in calendar.");
						}
					}
					int maxSteps = 24; // 2 years worth of months
					int steps = 0;
					while (!actMonth.equalsIgnoreCase(expMonth) && steps < maxSteps) {
						prevIcons = driver.findElements(By.className("ant-picker-prev-icon"));
						WebElement prevButton = wait.until(ExpectedConditions.visibilityOf(prevIcons.get(0)));
						wait.until(ExpectedConditions.elementToBeClickable(prevButton));
						try {
							prevButton.click();
						} catch (ElementNotInteractableException | org.openqa.selenium.TimeoutException e) {
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", prevButton);
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", prevButton);
							Thread.sleep(500); // Give time for UI to update
						}
						// Re-check current month after navigation
						monthBtns = driver.findElements(By.className("ant-picker-month-btn"));
						headerBtns = driver.findElements(By.xpath("//div[contains(@class,'ant-picker-header-view')]/button"));
						if (!monthBtns.isEmpty()) {
							actMonth = monthBtns.get(0).getText();
						} else if (!headerBtns.isEmpty()) {
							actMonth = headerBtns.get(0).getText();
						} else {
							System.out.println("[Calendar Debug] Could not find month button or header button for current month after navigation.");
							throw new AssertionError("Could not determine current month in calendar after navigation.");
						}
						steps++;
					}
					if (steps >= maxSteps) {
						throw new AssertionError("Month navigation exceeded max steps. Possible infinite loop or wrong DOB month.");
					}
				}
			}
			// Step 4: Select the desired day
			String dayXpath = "//td[contains(@class,'ant-picker-cell') and contains(@class,'ant-picker-cell-in-view')]/div[text()='" + day + "']";
			WebElement dateElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dayXpath)));
			wait.until(ExpectedConditions.visibilityOf(dateElement));
			wait.until(ExpectedConditions.elementToBeClickable(dateElement));
			try {
				dateElement.click();
			} catch (ElementNotInteractableException | org.openqa.selenium.TimeoutException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateElement);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateElement);
				Thread.sleep(500); // Give time for UI to update
			}
		} catch (Exception e) {
			System.out.println("Exception while selecting date: " + e.getMessage());
			e.printStackTrace();
			throw new AssertionError("Failed to select DOB: " + expMonth + " " + expYear + " " + day + ". Reason: " + e.getMessage());
		}
	}

	// Single Calender

	public static void selectDateNext(WebDriver driver, String expMonth, String expYear, String day) {
		// Expand abbreviation to full month name to match calendar UI
		expMonth = expandMonthName(expMonth);

		int dayInt = Integer.parseInt(day);
		if (dayInt < 1 || dayInt > 31) {
			System.out.println("Wrong date passed: " + day);
			return;
		}

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			String actMonth = driver.findElement(By.className("ant-picker-month-btn")).getText();
			String actYear = driver.findElement(By.className("ant-picker-year-btn")).getText();

			while (!actMonth.equalsIgnoreCase(expMonth) || !actYear.equalsIgnoreCase(expYear)) {
				WebElement nextButton = wait
						.until(ExpectedConditions.presenceOfElementLocated(By.className("ant-picker-next-icon")));

				try {
					wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
				} catch (ElementNotInteractableException e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
				}

				actMonth = driver.findElement(By.className("ant-picker-month-btn")).getText();
				actYear = driver.findElement(By.className("ant-picker-year-btn")).getText();
			}

			// Select only enabled, valid dates
			String dayXpath = "//td[@class='ant-picker-cell ant-picker-cell-in-view']/div[text()='" + day + "']";
			WebElement dateElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dayXpath)));

			try {
				wait.until(ExpectedConditions.elementToBeClickable(dateElement)).click();
			} catch (ElementNotInteractableException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateElement);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateElement);
			}

		} catch (Exception e) {
			System.out.println("Exception while selecting date: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Multiple Calender
	public static void selectNextDateMultipleCalenderOnSamePage(WebDriver driver, String expMonth, String expYear,
			String day) {
		// Expand abbreviation to full month name to match calendar UI
		expMonth = expandMonthName(expMonth);

		int dayInt = Integer.parseInt(day);
		if (dayInt < 1 || dayInt > 31) {
			System.out.println("Wrong date passed: " + day);
			return;
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Handle dual calendar layout (To/From logic)
		String monthBtnXpath;
		String yearBtnXpath;

		if (isElementPresent(driver, "(//div[@class='ant-picker-header-view']/button)[3]")) {
			monthBtnXpath = "(//div[@class='ant-picker-header-view']/button)[3]";
			yearBtnXpath = "(//div[@class='ant-picker-header-view']/button)[4]";
		} else {
			monthBtnXpath = "(//div[@class='ant-picker-header-view']/button)[1]";
			yearBtnXpath = "(//div[@class='ant-picker-header-view']/button)[2]";
		}

		String actMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(monthBtnXpath))).getText().trim();
		String actYear = driver.findElement(By.xpath(yearBtnXpath)).getText().trim();
		// Normalize actMonth to full month name for comparison
		actMonth = expandMonthName(actMonth);
		System.out.println("DEBUG: actMonth='" + actMonth + "', expMonth='" + expMonth + "'");
		System.out.println("DEBUG: actYear='" + actYear + "', expYear='" + expYear + "'");

		// Navigate until month and year match
		int safetyCounter = 0; // Prevent infinite loop
		while (!actMonth.equalsIgnoreCase(expMonth) || !actYear.equalsIgnoreCase(expYear)) {
			if (++safetyCounter > 50) {
				System.out.println("ERROR: Calendar navigation exceeded 50 iterations. Breaking to avoid infinite loop.");
				break;
			}
			try {
				WebElement nextBtn;
				if (isElementPresent(driver, "(//button[@aria-label='Next month (PageDown)']/span)[2]")) {
					nextBtn = driver.findElement(By.xpath("(//button[@aria-label='Next month (PageDown)']/span)[2]"));
				} else {
					nextBtn = driver.findElement(By.xpath("(//button[@aria-label='Next month (PageDown)']/span)[1]"));
				}
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextBtn);
			} catch (Exception e) {
				System.out.println("Error clicking next year: " + e.getMessage());
				return;
			}
			actMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(monthBtnXpath))).getText().trim();
			actYear = driver.findElement(By.xpath(yearBtnXpath)).getText().trim();
			// Normalize actMonth to full month name for comparison
			actMonth = expandMonthName(actMonth);
			System.out.println("DEBUG: actMonth='" + actMonth + "', expMonth='" + expMonth + "'");
			System.out.println("DEBUG: actYear='" + actYear + "', expYear='" + expYear + "'");
		}

		// Updated day selection logic using both potential date elements
		String xpath1 = "(//td[@class='ant-picker-cell ant-picker-cell-in-view']/div[text()='" + day + "'])[1]";
		String xpath2 = "(//td[@class='ant-picker-cell ant-picker-cell-in-view']/div[text()='" + day + "'])[2]";

		WebElement dayElement;
		try {
			dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));
		} catch (TimeoutException e) {
			System.out.println("First calendar not clickable, trying second calendar...");
			dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath2)));
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dayElement);
	}

	// Helper method to check if element exists
	private static boolean isElementPresent(WebDriver driver, String xpath) {
		try {
			return driver.findElements(By.xpath(xpath)).size() > 0;
		} catch (Exception e) {
			return false;
		}
	}

}