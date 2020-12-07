package com.softserve.edu.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn implements Attributes {
    
    protected final String INVALID_EMAIL_PASSWORD_MESSAGE = "Submit Button is Disabled. Invalid Email or Password";

    private WebDriver driver;
    //
    private WebElement email;
    private WebElement password;
    private WebElement buttonSubmit;
    private WebElement buttonGoole;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        email = driver.findElement(By.id("email"));
        password = driver.findElement(By.id("password"));
        buttonSubmit = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonGoole = driver.findElement(By.cssSelector("button.google-sign-in"));
    }

    // Page Object

    // email
    public WebElement getEmail() {
        return email;
    }

    public String getEmailText() {
        return getEmail().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearEmail() {
        getEmail().clear();
    }

    public void clickEmail() {
        getEmail().click();
    }

    public void typeEmail(String text) {
        getEmail().sendKeys(text);
    }

    // password
    public WebElement getPassword() {
        return password;
    }

    public String getPasswordText() {
        return getPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearPassword() {
        getPassword().clear();
    }

    public void clickPassword() {
        getPassword().click();
    }

    public void typePassword(String text) {
        getPassword().sendKeys(text);
    }

    // buttonSubmit
    public WebElement getButtonSubmit() {
        if (buttonSubmit.isDisplayed()) {
            // TODO Deevelop Custom Exception
            throw new RuntimeException(INVALID_EMAIL_PASSWORD_MESSAGE);
        }
        return buttonSubmit;
    }

    public String getButtonSubmitText() {
        return getButtonSubmit().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clickButtonSubmit() {
        getButtonSubmit().click();
    }

    // buttonGoole
    public WebElement getButtonGoole() {
        return buttonGoole;
    }

    public String getButtonGooleText() {
        return getButtonGoole().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clickButtonGoole() {
        getButtonGoole().click();
    }

    // Functional

    // Business Logic
}
