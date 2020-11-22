package com.softserve.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilterTest {
	private final String BASE_URL = "https://ita-social-projects.github.io/GreenCityClient/#/news";
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
    
//    @AfterMethod
//    public void afterMethod() {
//        presentationSleep(); // For Presentation ONLY
//        
//        // logout; clear cache; delete cookie; delete session;
//        // Save Screen;
//    }
    
    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep(); // For Presentation ONLY
        // logout;
        // Save Screen;
        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to;
            // previous state, logout, etc.
            //takeScreenShot(testName);
            //takePageSource(testName);
            driver.manage().deleteAllCookies(); // clear cache; delete cookie; delete session;
        }
        //driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        
    }
    
    @DataProvider
	public Object[][] getCoupleTestFilterData() {
		return new Object[][] {
//			{0, 1, "EVENTS", "ADS"},
//			{0, 2, "ADS", "NEWS"},
//			{0, 3, "ADS", "EDUCATION"},
//			{0, 4, "ADS", "INITIATIVES"},
			{0, 5, "ADS", "LIFEHACKS"},
//			{1, 2, "EVENTS", "NEWS"},
//			{1, 3, "EVENTS", "EDUCATION"},
//			{1, 4, "EVENTS", "INITIATIVES"},
//			{1, 5, "EVENTS", "LIFEHACKS"},
//			{2, 3, "NEWS", "EDUCATION"},
//			{2, 4, "NEWS", "INITIATIVES"},
//			{2, 5, "NEWS", "LIFEHACKS"},
//			{3, 4, "EDUCATION", "INITIATIVES"},
//			{3, 5, "EDUCATION", "LIFEHACKS"},
//			{4, 5, "INITIATIVES", "LIFEHACKS"},
		 };
	}
		
	@Test(dataProvider = "getCoupleTestFilterData")
    public void checkWebElement(int filter1, int filter2, String label1, String label2) throws Exception {
    	List<WebElement> webElements = driver.findElements(By.cssSelector(".custom-chip.global-tag"));
    	
//    	presentationSleep();
//    	webElements.get(filter1).click();
//    	presentationSleep();
//    	webElements.get(filter2).click();

    	List<WebElement> linkProjects = null;
    	Actions action = new Actions(driver);        
    	action.click(webElements.get(filter1));
    	action.click(webElements.get(filter2));
    	
        do {
            action.moveToElement(driver.findElement(By.cssSelector(".links"))).perform();
        	Thread.sleep(2000);
        	linkProjects = driver.findElements(By.className("description"));
        	System.out.println("linkProjects.size() = " + linkProjects.size());
        }while(linkProjects.size()==0);
            
    	List<WebElement> listNews = driver.findElements(By.className("list-gallery"));
    	String expected1 = label1;
    	String expected2 = label2;
    	List<WebElement> listLabels = driver.findElements(By.cssSelector(".ul-eco-buttons.ng-star-inserted"));
    	boolean result = true;
    	
    	for (int i = 0; i < listNews.size(); i++) {
    		List<WebElement> myListLabels = listNews.get(i).findElements(By.cssSelector(".ul-eco-buttons.ng-star-inserted"));    		
			List<String> elementsLabels = new ArrayList<String>();
    		for(int j = 0; j<myListLabels.size(); j++)
    		{
    			elementsLabels.add(myListLabels.get(j).getText().toUpperCase());
    		}
    		if(!elementsLabels.contains(expected1) && !elementsLabels.contains(expected2))
    		{
    			result = false;
    		}
    		
		}

    	System.out.println("SIZE = " + listNews.size());
    	System.out.println("SIZE = " + listLabels.size());
    	System.out.println("RESULT = " + result);
    	
    	presentationSleep();
    	webElements.get(filter1).click();
    	presentationSleep();
    	webElements.get(filter2).click();
    	presentationSleep();
    	
    	Assert.assertTrue(result); 


	}
}
