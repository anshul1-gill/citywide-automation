package com.dits.citywide.pages.patrol;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void doClickVehicleNumber(String vehicleNumber) {
        By vehicleLocator = getVehicleNumber(vehicleNumber);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_WAIT));
        int attempts = 0;
        boolean selected = false;
        while (attempts < 3 && !selected) {
            attempts++;
            try {
                WebElement label = elementUtils.waitForElementToBeClickable(vehicleLocator, Constants.DEFAULT_WAIT);
                label.click();
            } catch (Exception e) {
                // JS fallback
                try {
                    WebElement labelJs = driver.findElement(vehicleLocator);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", labelJs);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", labelJs);
                } catch (Exception ignored) {}
            }
            // Verify selection updated
            selected = wait.until(d -> {
                try {
                    String txt = d.findElement(dataSelectedVehicleId).getText().trim();
                    if (txt.equalsIgnoreCase("Select Vehicle")) return false;
                    // Accept either exact match or containing the number
                    return txt.equals(vehicleNumber) || txt.contains(vehicleNumber);
                } catch (Exception ex) {
                    return false;
                }
            });
            System.out.println("Attempt " + attempts + " to select vehicle " + vehicleNumber + ": " + (selected ? "SUCCESS" : "RETRY"));
        }
        if (!selected) {
            throw new RuntimeException("Failed to select vehicle number " + vehicleNumber + " after " + attempts + " attempts");
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
        if (raw.equalsIgnoreCase("Select Vehicle")) return raw;
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

    public void fillProblems(String tireProblems, String lightProblems, String equipmentProblems) throws InterruptedException {
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

    public void clickCompleteVehicleInspection() {
        elementUtils.waitForElementToBeClickable(btnCompleteVehicleInspection, Constants.DEFAULT_WAIT).click();
    }

}
