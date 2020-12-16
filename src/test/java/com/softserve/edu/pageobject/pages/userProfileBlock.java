package com.softserve.edu.pageobject.pages;

import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userProfileBlock {

    private WebDriver driver;
    private WebElement profilePopUp;
    private WebElement settings;
    private WebElement signOut;

    public userProfileBlock(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        profilePopUp = driver.findElement(By.xpath("//li[@class='tertiary-global-button']//a"));
        settings = driver.findElement(By.cssSelector("div#user-avatar-wrapper li.tertiary-global-button + li > a"));
        signOut = driver.findElement(By.cssSelector("div#user-avatar-wrapper li.tertiary-global-button + li + li > a"));
    }

    public WebElement getProfilePopUp() {
        return profilePopUp;
    }

    public String getProfileText() {
        return profilePopUp.getText().trim();
    }

    public void openProfilePopUp() {
        profilePopUp.click();
    }

    public boolean isDisplayedSettings() {
        return settings.isDisplayed();
    }

    public WebElement getSettings() {
        if (!isDisplayedSettings()) {
            openProfilePopUp();
        }
        return settings;
    }

    public void openUserSettingsPage() {
        getSettings().click();
        //TODO create UserSettingsPage class
        //TODO return userSettingsPage
    }

    public boolean isDisplayedSignOut() {
        return getSignOut().isDisplayed();
    }

    public WebElement getSignOut() {
        if (!isDisplayedSignOut()) {
            openProfilePopUp();
        }
        return signOut;
    }

    public void clickSignOut() {
        getSignOut().click();
    }
}
