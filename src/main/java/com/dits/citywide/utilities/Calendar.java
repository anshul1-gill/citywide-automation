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

//	public static void selectDatePrevious(WebDriver driver, String expMonth, String expYear, String day) {
//
//		int dayInt = Integer.parseInt(day);
//		if (dayInt < 1 || dayInt > 31) {
//			System.out.println("Wrong date passed: " + day);
//			return;
//		}
//
//		String actMonth = driver.findElement(By.className("ant-picker-month-btn")).getText();
//		String actYear = driver.findElement(By.className("ant-picker-year-btn")).getText();
//
//		while (!actMonth.equalsIgnoreCase(expMonth) || !actYear.equalsIgnoreCase(expYear)) {
//			driver.findElement(By.className("ant-picker-prev-icon")).click();
//			actMonth = driver.findElement(By.className("ant-picker-month-btn")).getText();
//			actYear = driver.findElement(By.className("ant-picker-year-btn")).getText();
//		}
//
//		// Select only enabled, valid dates
//		String dayXpath = "//td[@class='ant-picker-cell ant-picker-cell-in-view']/div[text()='" + day + "']";
//		driver.findElement(By.xpath(dayXpath)).click();
//	}

	public static void selectDatePrevious(WebDriver driver, String expMonth, String expYear, String day) {
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
				WebElement prevButton = wait
						.until(ExpectedConditions.presenceOfElementLocated(By.className("ant-picker-prev-icon")));

				try {
					wait.until(ExpectedConditions.elementToBeClickable(prevButton)).click();
				} catch (ElementNotInteractableException e) {
					// Fallback: Scroll and JavaScript click
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", prevButton);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", prevButton);
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

	// Single Calender

	public static void selectDateNext(WebDriver driver, String expMonth, String expYear, String day) {
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

		String actMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(monthBtnXpath))).getText();
		String actYear = driver.findElement(By.xpath(yearBtnXpath)).getText();

		// Navigate until month and year match
		while (!actMonth.equalsIgnoreCase(expMonth) || !actYear.equalsIgnoreCase(expYear)) {
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

			actMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(monthBtnXpath))).getText();
			actYear = driver.findElement(By.xpath(yearBtnXpath)).getText();
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
