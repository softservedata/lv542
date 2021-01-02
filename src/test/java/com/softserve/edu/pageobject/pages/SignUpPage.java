package com.softserve.edu.pageobject.pages;

import com.softserve.edu.pageobject.engine.BrowserTabUtils;
import com.softserve.edu.pageobject.engine.WaitWrapper;
import com.softserve.edu.pageobject.pages.mailforregistration.EmailTenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage implements Attributes, BrowserTabUtils {
    public static final String EMAIL_IS_REQUIRED_EXPECTED_MESSAGE = "Email is required";
    public static final String USERNAME_IS_REQUIRED_EXPECTED_MESSAGE = "User name is required";
    public static final String PASSWORD_IS_REQUIRED_EXPECTED_MESSAGE = "Password is required";
    public static final String CONFIRM_PASSWORD_IS_REQUIRED_MESSAGE = "Password is required";

    protected final String SIGN_UP_BUTTON_IS_DISABLED_MESSAGE = "Submit Button Is Disabled. Empty field(s)";

    public static final Logger logger = LoggerFactory.getLogger(SignUpPage.class);

    private WebDriver driver;

    private WebElement signUpEmailField;
    private WebElement signUpUsernameField;
    private WebElement signUpPasswordField;
    private WebElement signUpConfirmPasswordField;
    private WebElement buttonSignUp;
    private WebElement buttonSignUpWithGoogle;
    private WebElement buttonClose;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        signUpEmailField = driver.findElement(By.id("email"));
        signUpUsernameField = driver.findElement(By.id("firstName"));
        signUpPasswordField = driver.findElement(By.id("password"));
        signUpConfirmPasswordField = driver.findElement(By.id("repeatPassword"));
        buttonSignUp = driver.findElement(By.cssSelector("form button.primary-global-button"));
        buttonSignUpWithGoogle = driver.findElement(By.cssSelector("button.google-sign-in"));
        buttonClose = driver.findElement(By.cssSelector("a.close-modal-window"));
    }

    public WebElement getSignUpEmailField() {
        return signUpEmailField;
    }

    public String getSignUpEmailFieldText() {
        return getSignUpEmailField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSignUpEmailField() {
        getSignUpEmailField().clear();
    }

    public void clickSignUpEmailField() {
        getSignUpEmailField().click();
    }

    public void typeSignUpEmailField(String text) {
        getSignUpEmailField().sendKeys(text);
    }

    public WebElement getSignUpUsernameField() {
        return signUpUsernameField;
    }

    public String getSignUpUsernameFieldText() {
        return getSignUpUsernameField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSignUpUsernameField() {
        getSignUpUsernameField().clear();
    }

    public void clickSignUpUsernameField() {
        getSignUpUsernameField().click();
    }

    public void typeSignUpUsernameField(String text) {
        getSignUpUsernameField().sendKeys(text);
    }

    public WebElement getSignUpPasswordField() {
        return signUpPasswordField;
    }

    public String getSignUpPasswordFieldText() {
        return getSignUpPasswordField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSignUpPasswordField() {
        getSignUpPasswordField().clear();
    }

    public void clickSignUpPasswordField() {
        getSignUpPasswordField().click();
    }

    public void typeSignUpPasswordField(String text) {
        getSignUpPasswordField().sendKeys(text);
    }

    public WebElement getSignUpConfirmPasswordField() {
        return signUpConfirmPasswordField;
    }

    public String getSignUpConfirmPasswordFieldText() {
        return getSignUpConfirmPasswordField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSignUpConfirmPasswordField() {
        getSignUpConfirmPasswordField().clear();
    }

    public void clickSignUpConfirmPasswordField() {
        getSignUpConfirmPasswordField().click();
    }

    public void typeSignUpConfirmPasswordField(String text) {
        getSignUpConfirmPasswordField().sendKeys(text);
    }

    public WebElement getButtonSignUp() {
        if (!buttonSignUp.isEnabled()) {
            logger.error(SIGN_UP_BUTTON_IS_DISABLED_MESSAGE);
            throw new RuntimeException(SIGN_UP_BUTTON_IS_DISABLED_MESSAGE);
        }
        return buttonSignUp;
    }

    public String getButtonSignUpText() {
        return getButtonSignUp().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clickButtonSignUp() {
        getButtonSignUp().click();
    }

    //TODO signUpGoogleButton

    public WebElement getButtonClose() {
        return buttonClose;
    }

    public void clickButtonClose() {
        getButtonClose().click();
    }

    public WebElement getSignUpEmailValidator() {
        return driver.findElement(By.cssSelector("input#email + div div"));
    }

    public String getSignUpEmailValidatorText() {
        return getSignUpEmailValidator().getText();
    }

    public WebElement getSignUpUsernameValidator() {
        return driver.findElement(By.cssSelector("input#firstName + div div"));
    }

    public String getSignUpUsernameValidatorText() {
        return getSignUpUsernameValidator().getText();
    }

    public WebElement getSignUpPasswordValidator() {
        return driver.findElement(By.xpath("//*[@class='error-message ng-star-inserted']"));
    }

    public String getSignUpPasswordValidatorText() {
        return getSignUpPasswordValidator().getText();
    }

    public WebElement getSignUpConfirmPasswordValidator() {
        return driver.findElement(By.xpath("//*[@class='error-message ng-star-inserted']"));
    }

    public String getSignUpConfirmPasswordValidatorText() {
        return getSignUpConfirmPasswordValidator().getText();
    }

    private void fillSignUpEmailField(String email) {
        clickSignUpEmailField();
        clearSignUpEmailField();
        typeSignUpEmailField(email);
    }

    private void fillSignUpUsernameField(String username) {
        clickSignUpUsernameField();
        clearSignUpUsernameField();
        typeSignUpUsernameField(username);
    }

    private void fillSignUpPasswordField(String password) {
        clickSignUpPasswordField();
        clearSignUpPasswordField();
        typeSignUpPasswordField(password);
    }

    private void fillSignUpConfirmPasswordField(String password) {
        clickSignUpConfirmPasswordField();
        clearSignUpConfirmPasswordField();
        typeSignUpConfirmPasswordField(password);
    }

    private void fillCredentials(User user) {
        fillSignUpEmailField(user.getEmail());
        fillSignUpUsernameField(user.getName());
        fillSignUpPasswordField(user.getPassword());
        fillSignUpConfirmPasswordField(user.getPassword());
        clickButtonSignUp();
    }

    // Business Logic
    public SignInPage successfulSignUp(User user) {
        List<String> windowHandles = new ArrayList<>();
        String currentTabHandle = getCurrentTabHandle(driver);
        openNewTab(driver, 1);
        windowHandles.add(currentTabHandle);
        switchToAnotherTab(driver, windowHandles);
        EmailTenPage emailTenPage = new EmailTenPage(driver);
        user.setEmail(emailTenPage.getMailAddressText());
        switchToTab(driver, currentTabHandle);
        fillCredentials(user);
        //
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WaitWrapper.waitForInvisibilityOfElementLocated(driver, By.cssSelector("a.close-modal-window"));
        //
        emailTenPage.switchToEmailTenPage().confirmEmail();
        switchToTab(driver, currentTabHandle);
        //WaitWrapper.waitForInvisibilityOfElementLocated(driver, By.cssSelector("a.close-modal-window"));
        closeAllTab(driver, currentTabHandle);
        logger.info("User registered: " + user);
        new TopPart(driver) {}.openSignInPage();
        return new SignInPage(driver);
    }

    public SignUpPage unsuccessfulSignUp(User invalidUser) {
        fillCredentials(invalidUser);
        return new SignUpPage(driver);
    }

    public TopPart closeLogin() {
        clickButtonClose();
        return new TopPart(driver) {};
    }
}

