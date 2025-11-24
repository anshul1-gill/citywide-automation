package com.dits.citywide.Client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.pages.admin.DashboardPage;
import com.dits.citywide.utilities.ElementUtils;

public class ClientloginPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    private By txtboxEmail = By.id("email");
    private By txtboxPassword = By.id("password");
    private By btnSignIn = By.xpath("//button[@type='submit']");

    public ClientloginPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    public DashboardPage doLogin(String email, String password) {
        elementUtils.waitForElementVisible(txtboxEmail, Constants.DEFAULT_WAIT).sendKeys(email);
        elementUtils.waitForElementVisible(txtboxPassword, Constants.DEFAULT_WAIT).sendKeys(password);
        elementUtils.waitForElementToBeClickable(btnSignIn, Constants.DEFAULT_WAIT).click();
        return new DashboardPage(driver);
    }
}