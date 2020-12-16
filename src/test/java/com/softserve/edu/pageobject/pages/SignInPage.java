package com.softserve.edu.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;

import io.qameta.allure.Step;

public class SignInPage implements Attributes {
    
    protected final String INVALID_EMAIL_PASSWORD_MESSAGE = "Submit Button Disable. Invalid Email or Password";

    private WebDriver driver;
    //
    private WebElement email;
    private WebElement password;
    private WebElement buttonSubmit;
    private WebElement buttonGoole;
    private WebElement buttonClose;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        email = driver.findElement(By.id("email"));
        password = driver.findElement(By.id("password"));
        buttonSubmit = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonGoole = driver.findElement(By.cssSelector("button.google-sign-in"));
        buttonClose = driver.findElement(By.cssSelector("a.close-modal-window"));
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
        //System.out.println("buttonSubmit.isDisplayed() = " + buttonSubmit.isDisplayed());
        //System.out.println("buttonSubmit.isEnabled() = " + buttonSubmit.isEnabled());
        if (!buttonSubmit.isEnabled()) {
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

    // buttonClose
    public WebElement getButtonClose() {
        return buttonClose;
    }

    public void clickButtonClose() {
        getButtonClose().click();
    }
    
    
    // Functional
    
    private void fillEmail(String email) {
        clickEmail();
        clearEmail();
        typeEmail(email);
    }
    
    private void fillPassword(String password) {
        clickPassword();
        clearPassword();
        typePassword(password);
    }
    
    private void fillCredentials(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        clickButtonSubmit();
    }

    // Business Logic
    
    @Step("STEP Successful Login")
    public MyHabitsPage successfulLogin(User user) {
        fillCredentials(user);
        return new MyHabitsPage(driver);
    }
    
    public SignInPage unsuccessfulLogin(User user) {
        fillCredentials(user);
        return new SignInPage(driver);
    }
    
    public TopPart closeLogin() {
        clickButtonClose();
        return new TopPart(driver) {};
    }
    
}
