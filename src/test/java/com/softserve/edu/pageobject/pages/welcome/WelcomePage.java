package com.softserve.edu.pageobject.pages.welcome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.TopPart;

public class WelcomePage extends TopPart {
    
    public static final String HEADER_LEFT_ATTRIBUTE = "button primary-global-button";

    private WebElement headerLeft;
    private WebElement buttonStart;

    public WelcomePage(WebDriver driver) {
        super(driver);
        initElements();
        //System.out.println("***WelcomePage Created");
    }

    private void initElements() {
        // init elements
        headerLeft = driver.findElement(By.cssSelector("div#header-left h1"));
        buttonStart = driver.findElement(By.cssSelector("#header .button.primary-global-button"));
    }

    // Page Object

    // headerLeft
    public WebElement getHeaderLeft() {
        return headerLeft;
    }

    public String getHeaderLeftText() {
        return getHeaderLeft().getText().trim();
    }
    
    // buttonStart
    public WebElement getButtonStart() {
        return buttonStart;
    }

    public String getButtonStartText() {
        return getButtonStart().getText().trim();
    }

    public String getButtonStartAttributeClass() {
        return getButtonStart().getAttribute(TAG_ATTRIBUTE_CLASS);
    }

    public void clickButtonStart() {
        getButtonStart().click();
        // TODO
    }

    // Functional

    // Business Logic

}
