package com.softserve.edu.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInBlock {

    private WebDriver driver;
    private WebElement signInButton;
    private WebElement signUpButton;

    public LogInBlock(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        signInButton = driver.findElement(By.cssSelector("li[class*='sign-in'] a"));
        signUpButton = driver.findElement(By.cssSelector("li[class*='sign-up'] div"));
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public String getSignInButtonText() {
        return getSignInButton().getText();
    }

    public void clickSignIn() {
        getSignInButton().click();
    } //TODO naming; return

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public String getSignUpButtonText() {
        return getSignUpButton().getText();
    }

    public void clickSignUp() {
        getSignUpButton().click();
    } //TODO naming; return
}
