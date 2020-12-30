package com.softserve.rest.test;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.softserve.rest.business.GuestLogic;

public abstract class GreencityRestTestRunner {
	
	public static final String BASE_SERVER_URL = "https://greencity.azurewebsites.net";
	//
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@BeforeClass
    public void beforeClass(ITestContext context) {
        // driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS,
        // TimeUnit.SECONDS);
        // driver.manage().window().maximize();
        for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
            System.out.println("Key: " + entry.getKey() + "  Value: " + entry.getValue());
        }
    }

	@AfterMethod
    public void afterMethod(ITestResult result) {
        if (!result.isSuccess()) {
            // Save to log, prepare report, Return to
            logger.error("***Test " + result.getName() + " ERROR");
            // previous state, logout, etc.
        }
        // logout; clear cache; delete cookie; delete session;
    }
	
	protected GuestLogic loadApplication() {
        // return new HomePage(driver);
        return new GuestLogic();
    }
}
