package com.softserve.edu.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;

public class SignUpPage implements Attributes {

    public final String EMAIL_REQUIRED_EXPECTED_MESSAGE = "Email is required";
    //
    protected final String SUBMIT_DISABLE_MESSAGE = "Submit Button Disable. Empty field(s)";

    private WebDriver driver;
    //
    private WebElement emailField;
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement confirmPasswordField;
    private WebElement signupButton;
    private WebElement signupGooleButton;
    private WebElement closeButton;
    //
//    private WebElement emailValidator;
//    private WebElement usernameValidator;
//    private WebElement passwordValidator;
//    private WebElement confurmValidator;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        // TODO +++++++++++++++++++++++++++++++++
        emailField = driver.findElement(By.id("email"));
        usernameField = driver.findElement(By.cssSelector("button[type='submit']"));
        passwordField = driver.findElement(By.id("password"));
        confirmPasswordField = driver.findElement(By.id("password"));
        signupButton = driver.findElement(By.cssSelector("button[type='submit']"));
        signupGooleButton = driver.findElement(By.cssSelector("button.google-sign-in"));
        closeButton = driver.findElement(By.cssSelector("a.close-modal-window"));
    }

    // Page Object

    // emailField
    public WebElement getEmailField() {
        return emailField;
    }

    public String getEmailFieldText() {
        return getEmailField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearEmailField() {
        getEmailField().clear();
    }

    public void clickEmailField() {
        getEmailField().click();
    }

    public void typeEmailField(String text) {
        getEmailField().sendKeys(text);
    }

    // usernameField
    public WebElement getUsernameField() {
        return usernameField;
    }

    public String getUsernameFieldText() {
        return getUsernameField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearUsernameField() {
        getUsernameField().clear();
    }

    public void clickUsernameField() {
        getUsernameField().click();
    }

    public void typeUsernameField(String text) {
        getUsernameField().sendKeys(text);
    }

    // passwordField
    public WebElement getPasswordField() {
        return passwordField;
    }

    public String getPasswordFieldText() {
        return getPasswordField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearPasswordField() {
        getPasswordField().clear();
    }

    public void clickPasswordField() {
        getPasswordField().click();
    }

    public void typePasswordField(String text) {
        getPasswordField().sendKeys(text);
    }

    // confirmPasswordField
    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public String getConfirmPasswordFieldText() {
        return getConfirmPasswordField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearConfirmPasswordField() {
        getConfirmPasswordField().clear();
    }

    public void clickConfirmPasswordField() {
        getConfirmPasswordField().click();
    }

    public void typeConfirmPasswordField(String text) {
        getConfirmPasswordField().sendKeys(text);
    }

    // signupButton
    public WebElement getSignupButton() {
        // System.out.println("buttonSubmit.isDisplayed() = " +
        // buttonSubmit.isDisplayed());
        // System.out.println("buttonSubmit.isEnabled() = " + buttonSubmit.isEnabled());
        if (!signupButton.isEnabled()) {
            // TODO Deevelop Custom Exception
            throw new RuntimeException(SUBMIT_DISABLE_MESSAGE);
        }
        return signupButton;
    }

    public String getSignupButtonText() {
        return getSignupButton().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clickSignupButton() {
        getSignupButton().click();
    }

    // signupGooleButton
    // TODO

    // closeButton
    public WebElement getCloseButton() {
        return closeButton;
    }

    public void clickCloseButton() {
        getCloseButton().click();
    }

    // emailValidator;
    public WebElement getEmailValidator() {
        return driver.findElement(By.id("***")); //TODO
    }
    
    public String getEmailValidatorText() {
        return getEmailValidator().getText();
    }
    
    // usernameValidator;
    public WebElement getUsernameValidator() {
        return driver.findElement(By.id("***")); //TODO
    }
    
    public String getUsernameValidatorText() {
        return getUsernameValidator().getText();
    }
    
    // passwordValidator;
    public WebElement getPasswordValidator() {
        return driver.findElement(By.id("***")); //TODO
    }
    
    public String getPasswordValidatorText() {
        return getPasswordValidator().getText();
    }
    
    // confurmValidator;
    public WebElement getConfurmValidator() {
        return driver.findElement(By.id("***")); //TODO
    }
    
    public String getConfurmValidatorText() {
        return getConfurmValidator().getText();
    }

    // Functional

    private void fillEmailField(String email) {
        clickEmailField();
        clearEmailField();
        typeEmailField(email);
    }

    private void fillUsernameField(String username) {
        clickUsernameField();
        clearUsernameField();
        typeUsernameField(username);
    }

    private void fillPasswordField(String password) {
        clickPasswordField();
        clearPasswordField();
        typePasswordField(password);
    }

    private void fillConfirmPasswordField(String password) {
        clickConfirmPasswordField();
        clearConfirmPasswordField();
        typeConfirmPasswordField(password);
    }

    private void fillCredentials(User user) {
        fillEmailField(user.getEmail());
        fillUsernameField(user.getName());
        fillPasswordField(user.getPassword());
        fillConfirmPasswordField(user.getPassword());
        clickSignupButton();
    }

    // Business Logic

    public MyHabitsPage successfulSignUp(User user) {
        fillCredentials(user);
        // TODO Confirm email
        return new MyHabitsPage(driver);
    }

    public SignUpPage unsuccessfulSignUp(User invaldUser) {
        fillCredentials(invaldUser);
        return new SignUpPage(driver);
    }

    public TopPart closeLogin() {
        clickCloseButton();
        return new TopPart(driver) {};
    }

}
