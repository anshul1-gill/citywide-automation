package com.dits.citywide.pages.patrol;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;
import java.time.Duration;

public class PatrolVehicleInspectionPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    public By getVehicleNumber(String vehicleNumber) {
        String xpath = String.format("//label[normalize-space()='%s']", vehicleNumber);
        return By.xpath(xpath);
    }

    private By txtboxStartingMiles = By.xpath("//input[@id='starting_miles']");
    private By dataSelectedVehicleId = By
            .xpath("(//h2[normalize-space()='Selected vehicle id:']/following-sibling::div)[1]");
    private By txtboxEndingMiles = By.xpath("//input[@id='verify_miles']");
    private By btnNext = By.xpath("//a[normalize-space()='Next']");

    // Standard Vehicle Inspection
    private By checkboxFluidsCheck = By.cssSelector("label[for='fluid_check']");
    private By valuesFluidsCheck = By.xpath("//input[@id='fluid_check']/../following-sibling::ul//label");
    private By checkboxTiresCheck = By.cssSelector("label[for='tires_check']");
    private By valuesTiresCheck = By.xpath("//input[@id='tires_check']/../following-sibling::ul//label");
    private By checkboxLightsCheck = By.cssSelector("label[for='lights_check']");
    private By valuesLightsCheck = By.xpath("//input[@id='lights_check']/../following-sibling::ul//label");
    private By checkboxEquipmentCheck = By.cssSelector("label[for='equipment_check']");
    private By valuesEquipmentCheck = By.xpath("//input[@id='equipment_check']/../following-sibling::ul//label");
    private By checkboxDamageCheck = By.cssSelector("label[for='damage_check']");
    private By valuesDamageCheck = By.xpath("//input[@id='damage_check']/../following-sibling::ul//label");
    // FLUIDS ADDED
    private By txtboxOil = By.cssSelector("#fluids_added_oil_qts");
    private By txtboxCoolant = By.cssSelector("#fluids_added_coolant_qts");
    private By txtboxTran = By.cssSelector("#fluids_added_trans_qts");
    // DAMAGE DESCRIPTION
    private By txtboxOldDamage = By.cssSelector("#problems_damage_old");
    private By txtboxNewDamage = By.cssSelector("#problems_damage_new");
    // PROBLEMS
    private By txtboxTireProblems = By.cssSelector("#problems_tires");
    private By txtboxLightProblems = By.cssSelector("#problems_lights");
    private By txtboxEquipmentProblems = By.cssSelector("#problems_equipment");

    private By uploadFrontImage = By.xpath("(//input[@type='file'])[1]");
    private By uploadBackImage = By.xpath("(//input[@type='file'])[2]");

    private By btnCompleteVehicleInspection = By.xpath("//button[normalize-space()='Complete Vehicle Inspection']");

    public PatrolVehicleInspectionPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    // Standard Vehicle Inspection
    public void doClickVehicleNumberDynamic(String vehicleNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Improved locator strategy: look for specific text in label, td, or div using
        // dot (.) for nested text
        String xpath = "//*[self::label or self::td or self::div][contains(.,'" + vehicleNumber + "')]";
        By vehicleLocator = By.xpath(xpath);

        try {
            // Wait for presence
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(vehicleLocator));
            // Scroll to it
            elementUtils.scrollIntoView(element);
            // Wait for clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));
            // Use Actions click for better compatibility
            elementUtils.doClickWithActions(element);
        } catch (Exception e) {
            System.out.println("Failed to click vehicle " + vehicleNumber + ". Retrying with broader search...");
            try {
                // Fallback: Generic text search using dot (.)
                By genericLocator = By.xpath("//*[contains(.,'" + vehicleNumber + "')]");

                // Filter to ensure we don't pick up huge containers (like Body)
                // Actually, rely on elementToBeClickable to pick something interactive
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(genericLocator));
                elementUtils.scrollIntoView(element);
                elementUtils.doClickWithActions(element);
            } catch (Exception ex) {
                // Collect and print available items for debugging
                try {
                    List<WebElement> labels = driver.findElements(By.tagName("label"));
                    String available = labels.stream().map(WebElement::getText).collect(Collectors.joining(", "));
                    System.out.println("Available labels on page: " + available);
                } catch (Exception logEx) {
                    System.out.println("Could not log available items.");
                }
                throw new RuntimeException("Could not find or click vehicle number: " + vehicleNumber, ex);
            }
        }

        // Verify selection
        verifyVehicleSelected(vehicleNumber);
    }

    private void verifyVehicleSelected(String vehicleTextOrDigits) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(
                dataSelectedVehicleId, "Select Vehicle")));
        } catch (Exception e) {
            // proceed to read and assert
        }
        WebElement vehicleIdElement = elementUtils.waitForElementVisible(dataSelectedVehicleId, Constants.DEFAULT_WAIT);
        String raw = vehicleIdElement.getText().trim();
        String core = vehicleTextOrDigits.replaceAll("[^A-Za-z0-9]", "");
        String rawCore = raw.replaceAll("[^A-Za-z0-9]", "");
        if (raw.equalsIgnoreCase("Select Vehicle") || !(raw.contains(vehicleTextOrDigits) || rawCore.contains(core))) {
            throw new RuntimeException("Vehicle selection failed. Expected to include: " + vehicleTextOrDigits + ", but got: " + raw);
        }
    }

    public String getStartingMilesValue() {
        WebElement startingMilesElement = elementUtils.waitForElementVisible(txtboxStartingMiles,
                Constants.DEFAULT_WAIT);
        return startingMilesElement.getAttribute("value");
    }

    public String getSelectedVehicleId() {
        WebElement vehicleIdElement = elementUtils.waitForElementVisible(dataSelectedVehicleId, Constants.DEFAULT_WAIT);
        String raw = vehicleIdElement.getText().trim();
        if (raw.equalsIgnoreCase("Select Vehicle"))
            return raw;
        String digits = raw.replaceAll("[^0-9]", "");
        return digits.isEmpty() ? raw : digits;
    }

    public void enterEndingMiles(String miles) {
        WebElement endingMilesElement = elementUtils.waitForElementVisible(txtboxEndingMiles, Constants.DEFAULT_WAIT);
        endingMilesElement.clear();
        endingMilesElement.sendKeys(miles);
    }

    public void clickNextButton() {
        elementUtils.waitForElementToBeClickable(btnNext, Constants.DEFAULT_WAIT).click();
    }

    public void clickFluidCheck() {
        elementUtils.waitForElementToBeClickable(checkboxFluidsCheck, Constants.DEFAULT_WAIT).click();
    }

    public List<String> getFluidCheckValues() {
        List<WebElement> fluidElements = elementUtils.waitsForElementsVisible(valuesFluidsCheck,
                Constants.DEFAULT_WAIT);
        return fluidElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickTiresCheck() {
        elementUtils.waitForElementToBeClickable(checkboxTiresCheck, Constants.DEFAULT_WAIT).click();
    }

    public List<String> getTiresCheckValues() {
        List<WebElement> tireElements = elementUtils.waitsForElementsVisible(valuesTiresCheck, Constants.DEFAULT_WAIT);
        return tireElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickLightsCheck() {
        elementUtils.waitForElementToBeClickable(checkboxLightsCheck, Constants.DEFAULT_WAIT).click();
    }

    public List<String> getLightsCheckValues() {
        List<WebElement> lightElements = elementUtils.waitsForElementsVisible(valuesLightsCheck,
                Constants.DEFAULT_WAIT);
        return lightElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickEquipmentCheck() {
        elementUtils.waitForElementToBeClickable(checkboxEquipmentCheck, Constants.DEFAULT_WAIT).click();
    }

    public List<String> getEquipmentCheckValues() {
        List<WebElement> equipmentElements = elementUtils.waitsForElementsVisible(valuesEquipmentCheck,
                Constants.DEFAULT_WAIT);
        return equipmentElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickDamageCheck() {
        elementUtils.waitForElementToBeClickable(checkboxDamageCheck, Constants.DEFAULT_WAIT).click();
    }

    public List<String> getDamageCheckValues() {
        List<WebElement> damageElements = elementUtils.waitsForElementsVisible(valuesDamageCheck,
                Constants.DEFAULT_WAIT);
        return damageElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void fillFluidsAdded(String oil, String coolant, String tran) {
        elementUtils.waitForElementVisible(txtboxOil, Constants.DEFAULT_WAIT).sendKeys(oil);
        elementUtils.waitForElementVisible(txtboxCoolant, Constants.DEFAULT_WAIT).sendKeys(coolant);
        elementUtils.waitForElementVisible(txtboxTran, Constants.DEFAULT_WAIT).sendKeys(tran);
    }

    public void fillDamageDescription(String oldDamage, String newDamage) {
        elementUtils.waitForElementVisible(txtboxOldDamage, Constants.DEFAULT_WAIT).sendKeys(oldDamage);
        elementUtils.waitForElementVisible(txtboxNewDamage, Constants.DEFAULT_WAIT).sendKeys(newDamage);
    }

    public void fillProblems(String tireProblems, String lightProblems, String equipmentProblems)
            throws InterruptedException {
        elementUtils.waitForElementVisible(txtboxTireProblems, Constants.DEFAULT_WAIT).sendKeys(tireProblems);
        elementUtils.waitForElementVisible(txtboxLightProblems, Constants.DEFAULT_WAIT).sendKeys(lightProblems);
        elementUtils.waitForElementVisible(txtboxEquipmentProblems, Constants.DEFAULT_WAIT).sendKeys(equipmentProblems);
    }

    public void uploadFrontImage(String imagePath) {
        elementUtils.uploadFile(uploadFrontImage, imagePath);
    }

    public void uploadBackImage(String imagePath) {
        elementUtils.uploadFile(uploadBackImage, imagePath);
    }

    public void clickCompleteVehicleInspection() throws InterruptedException {
    	Thread.sleep(4000); // brief wait to ensure any prior actions are settled
        elementUtils.waitForElementToBeClickable(btnCompleteVehicleInspection, Constants.DEFAULT_WAIT).click();
    }

    /**
     * Selects the first available alphanumeric vehicle number dynamically.
     * It scans labels, table cells, and divs, picks the first text that contains
     * at least 3 alphanumeric characters, clicks it, and verifies selection.
     *
     * @return the vehicle identifier text that was clicked
     */
    public String selectAnyVehicle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> candidates;
        try {
            candidates = driver.findElements(By.tagName("label"));
            if (candidates == null || candidates.isEmpty()) {
                List<WebElement> tds = driver.findElements(By.tagName("td"));
                List<WebElement> divs = driver.findElements(By.tagName("div"));
                candidates = new java.util.ArrayList<>();
                candidates.addAll(tds);
                candidates.addAll(divs);
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to gather vehicle elements", e);
        }

        String chosen = null;
        WebElement toClick = null;
        for (WebElement el : candidates) {
            try {
                if (!el.isDisplayed()) continue;
                String text = el.getText();
                if (text == null) continue;
                text = text.trim();
                if (text.matches(".*[A-Za-z0-9].*") && text.replaceAll("[^A-Za-z0-9]", "").length() >= 3) {
                    if (text.equalsIgnoreCase("Select Vehicle")) continue;
                    chosen = text;
                    // Prefer clicking input linked via 'for'
                    String forAttr = null;
                    try { forAttr = el.getAttribute("for"); } catch (Exception ignore) {}
                    if (forAttr != null && !forAttr.isEmpty()) {
                        try {
                          WebElement input = driver.findElement(By.id(forAttr));
                          elementUtils.scrollIntoView(input);
                          wait.until(ExpectedConditions.elementToBeClickable(input));
                          elementUtils.doClickWithActions(input);
                          toClick = input;
                        } catch (Exception findInputEx) {
                          toClick = el;
                        }
                    } else {
                        toClick = el;
                    }
                    break;
                }
            } catch (Exception ignore) {}
        }

        if (toClick == null || chosen == null) {
            List<WebElement> any = driver.findElements(By.xpath("//*[contains(text(),'')]"));
            for (WebElement el : any) {
                try {
                    if (!el.isDisplayed()) continue;
                    String text = el.getText();
                    if (text == null) continue;
                    text = text.trim();
                    if (text.matches(".*[A-Za-z0-9].*") && text.replaceAll("[^A-Za-z0-9]", "").length() >= 3 && !text.equalsIgnoreCase("Select Vehicle")) {
                        chosen = text;
                        toClick = el;
                        break;
                    }
                } catch (Exception ignore) {}
            }
        }

        if (toClick == null || chosen == null) {
            throw new RuntimeException("No alphanumeric vehicle entry found to select.");
        }

        try {
            elementUtils.scrollIntoView(toClick);
            wait.until(ExpectedConditions.elementToBeClickable(toClick));
            elementUtils.doClickWithActions(toClick);
        } catch (Exception clickEx) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toClick);
            } catch (Exception jsEx) {
                throw new RuntimeException("Failed to click chosen vehicle element: " + chosen, jsEx);
            }
        }

        verifyVehicleSelected(chosen);
        return chosen;
    }

}