package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleTest {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }
    
    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }
    
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        presentationSleep(); // For Presentation ONLY
        // driver.close();
        driver.quit();
    }
    
    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }
    
    @AfterMethod
    public void afterMethod() {
        presentationSleep(); // For Presentation ONLY
        // logout; clear cache; delete cookie; delete session;
        // Save Screen;
    }
    
    @Test
    public void checkWebElement() throws Exception {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.cssSelector("a[href*='route=account/login']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // /*
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("hahaha");
        String content = driver.findElement(By.id("input-email")).getAttribute("value");
        System.out.println("content email = " + content);
        presentationSleep(); // For Presentation ONLY
        //
        // Refresh some webelements
        driver.navigate().refresh();
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.id("input-email")).sendKeys("bebebe");
        presentationSleep(); // For Presentation ONLY
        // */
        /*
        WebElement email = driver.findElement(By.id("input-email"));
        //
        email.click();
        email.clear();
        email.sendKeys("hahaha");
        String content = email.getAttribute("value");
        System.out.println("content email = " + content);
        presentationSleep(); // For Presentation ONLY
        //
        // Refresh some webelements
        driver.navigate().refresh();
        presentationSleep(); // For Presentation ONLY
        //
        email.sendKeys("bebebe");
        presentationSleep(); // For Presentation ONLY
        */
        //
        //driver.findElement(By.id("input-email")).sendKeys("password");
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("password");
        content = driver.findElement(By.id("input-password")).getAttribute("value");
        System.out.println("content password = " + content);
        presentationSleep(); // For Presentation ONLY
    }
    
}
