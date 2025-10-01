package com.dits.citywide.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppElementUtils {

	AppiumDriver appiumDriver;

	public AppElementUtils(AppiumDriver appiumDriver) {
		this.appiumDriver = appiumDriver;
	}

	public WebElement getElement(By by) {
		WebElement element = appiumDriver.findElement(by);
		return element;
	}

	public List<WebElement> getElements(By by) {
		return appiumDriver.findElements(by);
	}

	// ---------- Get Text ------------------------------
	public String getText(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
	}

	// ---------- Get Attribute ------------------------------
	public String getAttribute(By by, String attributeName) {
		return getElement(by).getDomAttribute(attributeName);
	}

	// ---------------- Click Function ------------------------------------------
	public void doClick(By by) {
		appiumDriver.findElement(by).click();
	}

	// ---------------- Click Function ------------------------------------------
	public void doClickWithWait(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	// --------------------------- Element Enabled -----------------------------
	public boolean doIsEnabled(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
	}

	// --------------------------- Element Displayed -----------------------------
	public boolean doIsDisplayed(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	}

	// ---------------------------Element Selected----------------------
	public boolean doIsSelected(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected();
	}

	// LondPress Gesture
	public void longPressActionAndroid(WebElement ele) {
		((JavascriptExecutor) appiumDriver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	// Generic functions - Scroll up to last
	public void scrollToEndActionAndroid() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) appiumDriver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down",
							"percent", 1.0),
					"duration", 2000);
		} while (canScrollMore);
	}

	// Scroll to text
	public void scrollToTextAndroid(String text) {
		appiumDriver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
	}

	// Swipe element generic code
	public void swipeActionAndroid(WebElement ele, String direction) {
		((JavascriptExecutor) appiumDriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));
	}

	// DragAndDrop Generic code
	public void dragAndDropActionAndroid(WebElement dragElement, int x_Coordinate, int y_Coordinate) {
		((JavascriptExecutor) appiumDriver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) dragElement).getId(), "endX", 619, "endY", 560));
	}

	// --------------- Element To Be Clickable ---------------
	public WebElement waitForElementToBeClickable(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public boolean doIsClickable(By locator, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public Boolean waitForInvisibilityOfElementLocated(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	// ---------------- Visibility Of Element ---------------------------
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// ---------------- Visibility Of All Element ---------------------------
	public List<WebElement> waitsForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public WebElement waitselementToBeClickableThroughElement(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitselementToBeClickableThroughBy(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	// ------------------------- Send values in TextBox ----------------------------
	public void doSendKeys(By by, String value) {
		getElement(by).sendKeys(value);
	}

	public void doSendKeysWithWait(By by, String value, int timeOut) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(value);
		// getElement(by).sendKeys(value);
	}

	public void doSendKeysWithClear(By by, String value) {
		WebElement ele = getElement(by);
		ele.clear();
		ele.sendKeys(value);
	}

	public void clearFieldvalue(By by) {
		WebElement ele = getElement(by);
		ele.clear();
	}

	public void clickElementWithScroll(By locator, int waitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(waitTimeInSeconds));

		// Wait for the element to be present and scroll into view
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		((JavascriptExecutor) appiumDriver).executeScript("arguments[0].scrollIntoView(true);", element);

		try {
			// Attempt a standard click
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (ElementClickInterceptedException e) {
			// Fallback to JavaScript click if the standard click is intercepted
			((JavascriptExecutor) appiumDriver).executeScript("arguments[0].click();", element);
		}
	}

	public void swipeAndroid() {
		Dimension screenSize = appiumDriver.manage().window().getSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		int startX = screenWidth / 2;
		int startY = (int) (screenHeight * 0.8);
		int endY = (int) (screenHeight * 0.2);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence swipe = new Sequence(finger, 0);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), startX, endY));

		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		appiumDriver.perform(Arrays.asList(swipe));
	}

	public void scrollToTextAndroidNew(String text) {
		appiumDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".setAsVerticalList()" + ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
	}

	public void clickElementWithW3C(WebElement element) {
		// Get element center coordinates
		int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
		int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

		clickByCoordinates(centerX, centerY);
	}

	public void clickByCoordinates(int x, int y) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		appiumDriver.perform(Collections.singletonList(tap));
	}

	public void safeClick(By locator, int timeoutSeconds) {
		try {
			// First try standard click
			WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeoutSeconds));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		} catch (Exception e) {
			// Fallback to W3C Actions click
			WebElement element = appiumDriver.findElement(locator);
			clickElementWithW3C(element);
		}

	}

	// Enhanced swipe: fallback to coordinate-based swipe if element swipe fails
	public void swipeElementLeft(WebElement ele) {
		try {
			// Try element-based swipe first
			((JavascriptExecutor) appiumDriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
					((RemoteWebElement) ele).getId(), "direction", "left", "percent", 0.75));
		} catch (Exception e) {
			// Fallback: swipe by coordinates
			Dimension size = ele.getSize();
			org.openqa.selenium.Point loc = ele.getLocation();
			int startX = loc.getX() + (int) (size.getWidth() * 0.8);
			int endX = loc.getX() + (int) (size.getWidth() * 0.2);
			int y = loc.getY() + size.getHeight() / 2;
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence swipe = new Sequence(finger, 1);
			swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, y));
			swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, y));
			swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			appiumDriver.perform(Arrays.asList(swipe));
		}
	}

	// Swipes on the given element in the specified direction.
	public void swipeElement(WebElement ele, String direction) {
		try {
			((JavascriptExecutor) appiumDriver).executeScript("mobile: swipeGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction", direction));
		} catch (Exception e) {
			Dimension size = ele.getSize();
			org.openqa.selenium.Point loc = ele.getLocation();
			int startX, endX, startY, endY;
			int width = size.getWidth();
			int height = size.getHeight();
			int centerY = loc.getY() + height / 2;
			int centerX = loc.getX() + width / 2;

			switch (direction.toLowerCase()) {
			case "left":
				startX = loc.getX() + width - 10; // near right edge
				endX = loc.getX() + 10; // near left edge
				startY = endY = centerY;
				break;
			case "right":
				startX = loc.getX() + 10; // near left edge
				endX = loc.getX() + width - 10; // near right edge
				startY = endY = centerY;
				break;
			case "up":
				startY = loc.getY() + height - 10; // near bottom edge
				endY = loc.getY() + 10; // near top edge
				startX = endX = centerX;
				break;
			case "down":
				startY = loc.getY() + 10; // near top edge
				endY = loc.getY() + height - 10; // near bottom edge
				startX = endX = centerX;
				break;
			default:
				throw new IllegalArgumentException("Invalid direction: " + direction);
			}

			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence swipe = new Sequence(finger, 1);
			swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
			swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			swipe.addAction(
					finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
			swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			appiumDriver.perform(Arrays.asList(swipe));
		}
	}

	/**
	 * Push a file from the local machine to the device.
	 *
	 * @param localPath  Path to the file on the local machine
	 * @param devicePath Path on the device to push the file to
	 */
	public void pushFileToDevice(String localPath, String devicePath) throws IOException {
		byte[] fileContent = Files.readAllBytes(Paths.get(localPath));
		if (appiumDriver instanceof AndroidDriver) {
			((AndroidDriver) appiumDriver).pushFile(devicePath, fileContent);
		} else {
			throw new UnsupportedOperationException("pushFileToDevice is only supported for AndroidDriver");
		}
	}

	public void doSendKeysWithWait(WebElement element, String text, int timeout) {
		new WebDriverWait(appiumDriver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Scrolls to the given element by swiping up until it is visible or max
	 * attempts reached. Only works reliably for vertically scrollable views.
	 */
	public void scrollToElement(WebElement element) {
		int maxScrolls = 5;
		int scrolls = 0;
		Dimension size = appiumDriver.manage().window().getSize();
		int startX = size.width / 2;
		int startY = (int) (size.height * 0.7);
		int endY = (int) (size.height * 0.3);
		while (scrolls < maxScrolls && !element.isDisplayed()) {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence swipe = new Sequence(finger, 1);
			swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
			swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			swipe.addAction(
					finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
			swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			appiumDriver.perform(Collections.singletonList(swipe));
			scrolls++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException ignored) {
			}
		}
	}

	/**
	 * Retry clicking an element up to maxAttempts times, with a short delay between
	 * attempts. Enhanced: uses W3C Actions API for tap fallback instead of
	 * deprecated TouchAction.
	 */
	public void retryClick(By locator, int wait, int maxAttempts, long retryDelayMillis) {
		int attempts = 0;
		Exception lastException = null;
		while (attempts < maxAttempts) {
			try {
				System.out.println("Attempt " + (attempts + 1) + " to click: " + locator);
				WebElement element = this.waitForElementVisible(locator, wait);
				this.scrollToElement(element); // Ensure element is in view
				try {
					this.doClickWithWait(locator, wait);
					return;
				} catch (Exception clickEx) {
					System.out.println(
							"Standard click failed, trying W3C tap action. Exception: " + clickEx.getMessage());
					// Try W3C Actions API tap as fallback
					try {
						PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
						Sequence tap = new Sequence(finger, 1);
						int centerX = element.getRect().getX() + element.getRect().getWidth() / 2;
						int centerY = element.getRect().getY() + element.getRect().getHeight() / 2;
						tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX,
								centerY));
						tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
						tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
						this.appiumDriver.perform(Collections.singletonList(tap));
						return;
					} catch (Exception tapEx) {
						lastException = tapEx;
						System.out.println("W3C tap action also failed: " + tapEx.getMessage());
					}
				}
			} catch (Exception e) {
				lastException = e;
				System.out.println("Exception in retryClick: " + e.getMessage());
			}
			attempts++;
			if (attempts < maxAttempts) {
				try {
					Thread.sleep(retryDelayMillis);
				} catch (InterruptedException ignored) {
				}
			}
		}
		throw new RuntimeException("Failed to click element after " + maxAttempts + " attempts: " + locator,
				lastException);
	}

	/**
	 * Attempts to click an element using all possible native strategies for Android
	 * apps. Tries: standard click, W3C Actions tap, long press, and retryClick.
	 * Throws if all fail.
	 */
	public void safeNativeClick(By locator, int timeoutSeconds) {
		Exception lastException = null;
		try {
			// First try standard click
			WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeoutSeconds));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			return;
		} catch (Exception e) {
			lastException = e;
		}
		try {
			// Fallback to W3C Actions click (tap by coordinates)
			WebElement element = appiumDriver.findElement(locator);
			clickElementWithW3C(element);
			return;
		} catch (Exception e) {
			lastException = e;
		}
		try {
			// Fallback to long press (Android only)
			WebElement element = appiumDriver.findElement(locator);
			longPressActionAndroid(element);
			return;
		} catch (Exception e) {
			lastException = e;
		}
		try {
			// Fallback to retryClick with 3 attempts and 500ms delay
			retryClick(locator, timeoutSeconds, 3, 500);
			return;
		} catch (Exception e) {
			lastException = e;
		}
		throw new RuntimeException("Failed to click element using all available native methods: " + locator,
				lastException);
	}

	/**
	 * Performs a generic tap action on the center of the element found by the locator.
	 * Uses W3C Actions API for reliability on native Android apps.
	 * @param locator The By locator of the element to tap
	 */
	public void tap(By locator) {
		WebElement element = appiumDriver.findElement(locator);
		int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
		int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		appiumDriver.perform(Collections.singletonList(tap));
	}

}
