package com.softserve.edu.pageobject.engine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWrapper {
    
    public static final long IMPLICITLY_WAIT_SECONDS = 10L;
    public static final long EXPLICITLY_WAIT_SECONDS = 10L;

    public static void setDefaultImplicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
    }
    
    public static void setCustomImplicitlyWait(WebDriver driver, long implicitlyWait) {
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
    }
    
    public static void setEmptyImplicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
    
    
    public static void  invisibilityOfElementLocated​Wait(WebDriver driver, By locator) {
        setEmptyImplicitlyWait(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);  // TODO
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        setDefaultImplicitlyWait(driver);
    }

}
