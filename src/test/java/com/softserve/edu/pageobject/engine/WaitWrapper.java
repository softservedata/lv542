package com.softserve.edu.pageobject.engine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public static void setZeroImplicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }


    public static void waitForInvisibilityOfElementLocated(WebDriver driver, By locator) {
        setZeroImplicitlyWait(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        setDefaultImplicitlyWait(driver);
    }

    public static void waitForPresenceOfElementLocated(WebDriver driver) {
        setZeroImplicitlyWait(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement firstSearchResult = driver.findElement(By
                .xpath("//li[@class='gallery-view-li-active ng-star-inserted'][1]//div[@class='list-gallery']//p"));
        //wait until the element changed
        wait.until(ExpectedConditions.stalenessOf(firstSearchResult));
        setDefaultImplicitlyWait(driver);
    }

}
