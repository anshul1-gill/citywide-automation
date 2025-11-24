package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.dits.citywide.utilities.ElementUtils;
import com.dits.citywide.constants.Constants;

public class BranchPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    private By lblHeader = By.xpath("//h4[contains(text(),'Branch')]");
    private By btnBack = By.xpath("//a[normalize-space()='Back']");

    public BranchPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    public boolean isPageLoaded() {
        return elementUtils.doIsDisplayed(lblHeader, Constants.DEFAULT_WAIT);
    }

    public void clickBackButton() {
        elementUtils.waitForElementToBeClickable(btnBack, Constants.DEFAULT_WAIT).click();
    }
}
