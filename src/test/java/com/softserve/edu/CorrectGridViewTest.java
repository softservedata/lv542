package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CorrectGridViewTest {
	private final String BASE_URL = "https://ita-social-projects.github.io/GreenCityClient/#/welcome";
    private final Long IMPLICITLY_WAIT_SECONDS =10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;
	 private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
	    
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
//	        driver.close();
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
	    public void checkEcoNewsItemsGridView() {
	    	WebElement gridItem = null;
	    	int newsContentLeftMargin = 0;
	    	Point listImagepPosition = null;
	    	Point newsContentPosition = null;
	    	
	    	driver.findElement(By.cssSelector(".navigation-menu-left a[href *= '/news']")).click();
	    	
	    	if (driver.findElements(By.cssSelector(".btn-tiles.btn-tiles-active") ).size() == 0) {
	    		Assert.assertTrue(false); //**************
	    	}
	    		    	
	    	gridItem = driver.findElement(By.cssSelector(".list > li:first-child"));
	    	newsContentLeftMargin = Integer.parseInt( 
	    			gridItem.findElement(
	    			By.className("list-gallery-content"))
	    			.getCssValue("margin-left")
	    			.replaceAll("[^0-9]", "") 
	    			);
	    	
	    	listImagepPosition = gridItem.findElement(By.className("list-image")).getLocation();
	    	newsContentPosition = gridItem.findElement(By.className("list-gallery-content")).getLocation();	    	
	    	
	    	Assert.assertEquals(listImagepPosition.getX(), newsContentPosition.getX() - newsContentLeftMargin);
	    }
}