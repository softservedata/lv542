package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrolleTest {
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    
    private void takeScreenShot(WebDriver driver) throws IOException {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./" + currentTime + "_screenshot.png"));
    }
    
    private void takePageSource(WebDriver driver) throws IOException {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String pageSource = driver.getPageSource();
        byte[] strToBytes = pageSource.getBytes();
        Path path = Paths.get("./" + currentTime + "_source.html");
        Files.write(path, strToBytes, StandardOpenOption.CREATE);
    }
    
    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }
    
    @Test
    public void checkScroll() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000); // For Presentation Only
        //
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //
        driver.get("https://selenium.dev/downloads/");
        Thread.sleep(2000); // For Presentation Only
        //
        WebElement linkProject = driver.findElement(By.cssSelector("div.button-container a"));
        //
        /*
        // Scrolling by Action class
        Actions action = new Actions(driver);       
        action.moveToElement(linkProject).perform();
        Thread.sleep(2000); // For Presentation Only
        */
        // /*
        // Scrolling by JavaScript injection
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkProject);
        Thread.sleep(2000); // For Presentation Only
        takeScreenShot(driver);
        takePageSource(driver);
        // */
        Thread.sleep(4000); // For Presentation Only
        driver.quit();
    }
}
