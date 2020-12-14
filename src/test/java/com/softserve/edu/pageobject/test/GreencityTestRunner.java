package com.softserve.edu.pageobject.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.softserve.edu.pageobject.engine.WaitWrapper;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class GreencityTestRunner {

    private final String BASE_URL = "url";
    //private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
    //
    private String serverUrl = "https://ita-social-projects.github.io/GreenCityClient/";
    // private WebDriver driver;
    private Map<Long, WebDriver> drivers;

    protected WebDriver getDriver() {
        WebDriver currentWebDriver = drivers.get(Thread.currentThread().getId());
        if (currentWebDriver == null) {
            currentWebDriver = new ChromeDriver();
            //currentWebDriver.manage().timeouts().implicitlyWait(WaitWrapper.IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
            WaitWrapper.setDefaultImplicitlyWait(currentWebDriver);
            //currentWebDriver.manage().window().maximize();
            drivers.put(Thread.currentThread().getId(), currentWebDriver);
        }
        return currentWebDriver;
    }

    @BeforeSuite
    public void beforeSuite() {
        drivers = new HashMap<>();
        WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
    }

    @BeforeClass
    public void beforeClass(ITestContext context) {
        // driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS,
        // TimeUnit.SECONDS);
        // driver.manage().window().maximize();
        for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
            System.out.println("Key: " + entry.getKey() + "  Value: " + entry.getValue());
            if (entry.getKey().toLowerCase().equals(BASE_URL)) {
                serverUrl = entry.getValue();
                break;
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        presentationSleep(); // For Presentation ONLY
        // driver.close();
        // if (driver != null) {
        // driver.quit();
        // };
        for (Map.Entry<Long, WebDriver> currentWebDriver : drivers.entrySet()) {
            if (currentWebDriver.getValue() != null) {
                currentWebDriver.getValue().quit();
            }
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        // driver.get(BASE_URL);
        getDriver().get(serverUrl);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep(); // For Presentation ONLY
        // TODO Logout
        if (!result.isSuccess()) {
            getDriver().manage().deleteAllCookies();
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to
            System.out.println("***Test " + result.getName() + " ERROR");
            takeScreenShot(result.getName());
            // previous state, logout, etc.
        }
        // logout; clear cache; delete cookie; delete session;
        // Save Screen;
    }

    private void takeScreenShot(String name) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        // File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./" + currentTime + "_TestName_" + name + "_screenshot.png"));
        } catch (IOException e) {
            // TODO Add Log;
            e.printStackTrace();
        }
        // log.info("Screenshot was taken");
    }

    // Overload
    protected void presentationSleep() {
        presentationSleep(1);
    }

    // Overload
    protected void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void setWindowSize(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }
    
    protected WelcomePage loadApplication() {
        // return new HomePage(driver);
        return new WelcomePage(getDriver());
    }

}
