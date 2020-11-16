package com.softserve.edu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }
    
    @Test
    public void testGoogle() throws Exception {
//        System.setProperty("webdriver.chrome.driver",
//                "./lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new InternetExplorerDriver();
        //Thread.sleep(1000); // For Presentation Only
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        // driver.navigate().to("http://www.google.com");
        //Thread.sleep(1000); // For Presentation Only
        //
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!" + Keys.ENTER);
        System.out.println("1. Page title is: " + driver.getTitle());
        //element.sendKeys("Cheese!");
        //Thread.sleep(2000); // For Presentation Only
        //
        //element.submit();
        // System.out.println("1. Page title is: " + driver.getTitle());
        driver.findElement(By.partialLinkText("Cheese - Wikipedia"));
        //WebElement check = driver.findElement(By.partialLinkText("Cheese - Wikipedia"));
        //System.out.println("Check = " + check.getText());
        //Thread.sleep(1000); // For Presentation Only
        String strTitle = driver.getTitle();
        System.out.println("2. Page title is: " + strTitle);
        System.out.println("2. Page title is: " + driver.getTitle());
        //
        // driver.findElement(By.cssSelector("a[href*='en.wikipedia.org/wiki/Cheese']")).click();
        driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
        //Thread.sleep(2000); // For Presentation Only
        System.out.println("3. Page title is: " + driver.getTitle());
        //
        WebElement actual = driver.findElement(By.id("siteSub"));
        Assert.assertEquals("From Wikipedia, the free encyclopedia", actual.getText());
        //
        //driver.findElement(By.cssSelector(".mw-headlinee"));
        List<WebElement> headline = driver.findElements(By.cssSelector(".mw-headline"));
        System.out.println("headline.size() = " + headline.size());
        //System.out.println("Etymology;  headline.get(0).getText() = " + headline.get(0).getText());
        //
        ((JavascriptExecutor) driver).executeScript("alert('hello');"); 
        Thread.sleep(2000); // For Presentation Only
        driver.switchTo().alert().accept();
        Thread.sleep(1000); // For Presentation Only
        // driver.close();
        driver.quit();
    }

}
