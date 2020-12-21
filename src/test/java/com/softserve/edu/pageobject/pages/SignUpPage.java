package com.softserve.edu.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;

public class SignUpPage implements Attributes {
    protected final String INVALID_EMAIL_MESSAGE = "Sign Up Button is Disabled. Invalid Email";
    protected final String INVALID_USERNAME_MESSAGE = "Sign Up Button is Disabled. Invalid Username";
    protected final String INVALID_PASSWORD_MESSAGE = "Submit Button is Disabled. Invalid Password";
    protected final String INVALID_CONFIRM_PASSWORD_MESSAGE = "Submit Button is Disabled. Invalid Confirmed Password";
    protected final String INVALID_EMAIL_PASSWORD_MESSAGE = "Submit Button Disable. Invalid Email or Password";

    private WebDriver driver;

    private WebElement signUpEmail;
    private WebElement signUpUsername;
    private WebElement signUpPassword;
    private WebElement signUpConfirmPassword;
    private WebElement buttonSignUp;
    private WebElement buttonSignUpWithGoogle;
    private WebElement buttonClose;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        signUpEmail = driver.findElement(By.id("email"));
        signUpUsername = driver.findElement(By.id("firstName"));
        signUpPassword = driver.findElement(By.id("password"));
        signUpConfirmPassword = driver.findElement(By.id("repeatPassword"));
        buttonSignUp = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonSignUpWithGoogle = driver.findElement(By.cssSelector("button.google-sign-in"));
        buttonClose = driver.findElement(By.cssSelector("a.close-modal-window"));
    }

    public WebElement getSignUpEmail() {
        return signUpEmail;
    }

    public String getSignUpEmailText() {
        return getSignUpEmail().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSignUpEmail() {
        getSignUpEmail().clear();
    }

    public void clickSignUpEmail() {
        getSignUpEmail().click();
    }

    public void typeSignUpEmail(String text) {
        getSignUpEmail().sendKeys(text);
    }

    public WebElement getSignUpUsername() {
        return signUpUsername;
    }

    public String getSignUpUsernameText() {
        return getSignUpUsername().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSignUpUsername() {
        getSignUpUsername().clear();
    }

    public void clickSignUpUsername() {
        getSignUpUsername().click();
    }

    public void typeSignUpUsername(String text) {
        getSignUpUsername().sendKeys(text);
    }

    public WebElement getSignUpPassword() {
        return signUpPassword;
    }

    public String getSignUpPasswordText() {
        return getSignUpPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSignUpPassword() {
        getSignUpPassword().clear();
    }

    public void clickSignUpPassword() {
        getSignUpPassword().click();
    }

    public void typeSignUpPassword(String text) {
        getSignUpPassword().sendKeys(text);
    }

    public WebElement getSignUpConfirmPassword() {
        return getSignUpConfirmPassword();
    }

    public String getSignUpConfirmPasswordText() {
        return getSignUpConfirmPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSignUpConfirmPassword() {
        getSignUpConfirmPassword().clear();
    }

    public void clickSignUpConfirmPassword() {
        getSignUpConfirmPassword().click();
    }

    public void typeSignUpConfirmPassword(String text) {
        getSignUpConfirmPassword().sendKeys(text);
    }

    // buttonSubmit
    public WebElement getButtonSignUp() {
        //System.out.println("buttonSignUp.isDisplayed() = " + buttonSignUp.isDisplayed());
        //System.out.println("buttonSignUp.isEnabled() = " + buttonSignUp.isEnabled());
        if (!buttonSignUp.isEnabled()) {
            //TODO Develop Custom Exception
            throw new RuntimeException(INVALID_EMAIL_PASSWORD_MESSAGE);
        }
        return buttonSignUp;
    }
}
