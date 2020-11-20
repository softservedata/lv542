package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlacesTest {
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
	
	@BeforeSuite(groups = {"method1", "method2", "method3", "method4", "method5"})
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }
    
    @BeforeClass(groups = {"method1", "method2", "method3", "method4", "method5"})
    @Parameters(value = "implicitly_wait_seconds")
    public void beforeClass(long implicitly_wait_seconds) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(implicitly_wait_seconds, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    @AfterClass(alwaysRun = true, groups = {"method1", "method2", "method3", "method4", "method5"})
    public void afterClass() {
        driver.quit();
    }
    
    @BeforeMethod(groups = {"method1", "method2", "method3", "method4", "method5"})
    @Parameters(value = "url")
    public void beforeMethod(String url) {
        driver.get(url);
    }
    
    @AfterMethod(groups = {"method1", "method2", "method3", "method4", "method5"})
    public void afterMethod(ITestResult result) {
    	if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
            driver.manage().deleteAllCookies();
        }
    }
    
    @Test(groups = "method1")
    @Parameters(value = "text")
    public void checkSearchField(String text) throws Exception {
    	driver.findElement(By.cssSelector("#control_panel > input")).click();
        driver.findElement(By.cssSelector("#control_panel > input")).clear();
        presentationSleep();
        driver.findElement(By.cssSelector("#control_panel > input")).sendKeys(text);
        presentationSleep();
    }
    
    @Test(groups = "method2")
    public void checkPlace() throws Exception {
    	//driver.findElement(By.xpath("/html/body/app-root/div[2]/app-map/div/div/div[1]/div/div[2]/table/tbody/tr[2]"));
    }
    
    @Test(groups = "method3")
    public void checkDiscountRate() throws Exception {
    	presentationSleep();
    	driver.findElement(By.id("filter_btn")).click();
    	presentationSleep();
    	driver.findElement(By.id("apply_filter_btn")).click();
    	presentationSleep();
    }
    
    @Test(groups = "method4")
    public void checkIsNowOpen() throws Exception {
    	presentationSleep();
    	driver.findElement(By.id("filter_btn")).click();
    	presentationSleep();
    	driver.findElement(By.id("is_open_checkbox")).click();
    	presentationSleep();
    	driver.findElement(By.id("apply_filter_btn")).click();
    	presentationSleep();
    }
    
    @Test(groups = "method5")
    @Parameters(value = "number")
    public void checkDistance(String number) throws Exception {
    	presentationSleep();
    	driver.findElement(By.id("filter_btn")).click();
    	presentationSleep();
    	driver.findElement(By.cssSelector("#filtering_layout > input")).sendKeys(number);
    	presentationSleep();
    	driver.findElement(By.id("apply_filter_btn")).click();
    	presentationSleep(2);
    }
}
