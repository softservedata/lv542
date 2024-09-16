package com.softserve.edu.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;

public class SignInPage implements Attributes {

    protected final String INVALID_EMAIL_PASSWORD_MESSAGE = "Submit Button Disable. Invalid Email or Password";

    private WebDriver driver;
    //
    private WebElement signInEmail;
    private WebElement signInPassword;
    private WebElement buttonSignIn;
    private WebElement buttonSignInWithGoogle;
    private WebElement buttonClose;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        signInEmail = driver.findElement(By.id("email"));
        signInPassword = driver.findElement(By.id("password"));
        buttonSignIn = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonSignInWithGoogle = driver.findElement(By.cssSelector("button.google-sign-in"));
        buttonClose = driver.findElement(By.cssSelector("a.close-modal-window"));
    }

    // Page Object

    // email
    public WebElement getSignInEmail() {
        return signInEmail;
    }

    public String getSignInEmailText() {
        return getSignInEmail().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSignInEmail() {
        getSignInEmail().clear();
    }

    public void clickSignInEmail() {
        getSignInEmail().click();
    }

    public void typeSignInEmail(String text) {
        getSignInEmail().sendKeys(text);
    }

    // password
    public WebElement getSignInPassword() {
        return signInPassword;
    }

    public String getSignInPasswordText() {
        return getSignInPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSignInPassword() {
        getSignInPassword().clear();
    }

    public void clickSignInPassword() {
        getSignInPassword().click();
    }

    public void typeSignInPassword(String text) {
        getSignInPassword().sendKeys(text);
    }

    // buttonSubmit
    public WebElement getButtonSignIn() {
        //System.out.println("buttonSignIn.isDisplayed() = " + buttonSignIn.isDisplayed());
        //System.out.println("buttonSignIn.isEnabled() = " + buttonSignIn.isEnabled());
        if (!buttonSignIn.isEnabled()) {
            //TODO Develop Custom Exception
            throw new RuntimeException(INVALID_EMAIL_PASSWORD_MESSAGE);
        }
        return buttonSignIn;
    }

    public String getButtonSignInText() {
        return getButtonSignIn().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clickButtonSignIn() {
        getButtonSignIn().click();
    }

    //buttonSignInWithGoogle
    public WebElement getButtonSignInWithGoogle() {
        return buttonSignInWithGoogle;
    }

    public String getButtonSignInWithGoogleText() {
        return getButtonSignInWithGoogle().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clickButtonSignInWithGoogle() {
        getButtonSignInWithGoogle().click();
    }

    // buttonClose
    public WebElement getButtonClose() {
        return buttonClose;
    }

    public void clickButtonClose() {
        getButtonClose().click();
    }


    // Functional

    private void fillSignInEmail(String email) {
        clickSignInEmail();
        clearSignInEmail();
        typeSignInEmail(email);
    }

    private void fillSignInPassword(String password) {
        clickSignInPassword();
        clearSignInPassword();
        typeSignInPassword(password);
    }

    private void fillCredentials(User user) {
        fillSignInEmail(user.getEmail());
        fillSignInPassword(user.getPassword());
        clickButtonSignIn();
    }
    // Business Logic
    public MyHabitsPage successfulLogin(User user) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
