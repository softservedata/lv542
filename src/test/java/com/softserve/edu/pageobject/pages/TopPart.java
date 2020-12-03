package com.softserve.edu.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TopPart {

    protected final String TAG_ATTRIBUTE_VALUE = "value";
    protected final String TAG_ATTRIBUTE_SRC = "src";
    //
    protected WebDriver driver;
    //
    private WebElement econews;
    private WebElement tipsTricks;
    private WebElement places;
    private WebElement about;
    private WebElement myHabits;
    private WebElement language;
    // private WebElement signIn;
    // private WebElement signUp;
    // private WebElement profile;

    public TopPart(WebDriver driver) {
        // super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        econews = driver.findElement(By.cssSelector(""));
        tipsTricks = driver.findElement(By.cssSelector(""));
        places = driver.findElement(By.cssSelector(""));
        about = driver.findElement(By.cssSelector(""));
        myHabits = driver.findElement(By.cssSelector(""));
        language = driver.findElement(By.cssSelector(""));
    }
    
    // Page Object

    // Functional

    // Business Logic

}
