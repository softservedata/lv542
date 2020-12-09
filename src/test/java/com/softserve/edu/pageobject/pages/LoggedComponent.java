package com.softserve.edu.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedComponent {

    private WebDriver driver;
    //
    private WebElement profile;
    private WebElement settings;
    private WebElement signOut;
    //
    // private ProfileComponent profileComponent;

    public LoggedComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        profile = driver.findElement(By.xpath("//li[@class='tertiary-global-button']//a"));
        settings = driver.findElement(By.cssSelector("div#user-avatar-wrapper li.tertiary-global-button + li > a"));
        signOut = driver.findElement(By.cssSelector("div#user-avatar-wrapper li.tertiary-global-button + li + li > a"));
    }

    // Page Object

    // profile
    public WebElement getProfile() {
        return profile;
    }

    public String getProfileText() {
        return getProfile().getText().trim();
    }

    public void clickProfile() {
        getProfile().click();
    }

    // settings
    public boolean isDisplayedSettings() {
        return settings.isDisplayed();
    }
    
    public WebElement getSettings() {
        if (!isDisplayedSettings()) {
            clickProfile();
        }
        return settings;
    }

    public String getSettingsText() {
        return getSettings().getText();
    }

    public void clickSettings() {
        getSettings().click();
    }

    // signOut
    public boolean isDisplayedSignOut() {
        return signOut.isDisplayed();
    }
    
    public WebElement getSignOut() {
        if (!isDisplayedSignOut()) {
            clickProfile();
        }
        return signOut;
    }

    public String getSignOutText() {
        return getSignOut().getText();
    }

    public void clickSignOut() {
        getSignOut().click();
    }

    // Functional

    // Business Logic
}
