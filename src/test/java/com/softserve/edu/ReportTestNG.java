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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportTestNG {
	private static WebDriver driver;
	private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
	private String screenImagePath;
	private String htmlTextPath;

	private void takeScreenShot() throws IOException {
		String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
		screenImagePath = this.getClass().getResource("/").getPath();
		screenImagePath = screenImagePath.replace("target/test-classes/", currentTime + "_screenshot.png");
		screenImagePath = screenImagePath.substring(1);
		System.out.println("screenImagePath = " + screenImagePath);
		htmlTextPath = this.getClass().getResource("/").getPath();
		htmlTextPath = htmlTextPath.replace("target/test-classes/", currentTime + "_screenshot.html");
		htmlTextPath = htmlTextPath.substring(1);
		System.out.println("htmlTextPath = " + htmlTextPath);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(screenImagePath));
		String htmlText = driver.getPageSource();
		//FileUtils.writeStringToFile(new File(System.getenv().get("USERPROFILE") + "\\Downloads\\screenshot.html"), htmlText);
		Path path = Paths.get(htmlTextPath);
		Files.write(path, htmlText.getBytes(), StandardOpenOption.CREATE);
	}
	
	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
		// WebDriverManager.firefoxdriver().setup();
	}

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownAfterClass() throws Exception {
		Thread.sleep(1000); // For Presentation Only
		driver.quit();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver.get("http://taqc-opencart.epizy.com/");
		Thread.sleep(1000); // For Presentation Only
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		Reporter.setCurrentTestResult(result);
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>@AfterMethod Non Conditional.</FONT><BR>", true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 3</FONT><BR>", 3, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 5</FONT><BR>", 5);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 7</FONT><BR>", 7, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 9</FONT><BR>", 9, true);
		if (!result.isSuccess()) {
			Reporter.log("<BR><BR><FONT SIZE='4' COLOR='RED'>ALARM TEST FAIL " + result.getName()
			        + "</FONT><BR>", true);
			Reporter.log("<br><p>Screenshot</p>");
			takeScreenShot();
//				Reporter.log("<br><p><a href='d:\\screenshot.png'>Source Code</a> filename is d:\\Screenshot.png</p>");	
			Reporter.log("<br><div><image style=\"max-width:55%\" src=\"" + screenImagePath
					+ "\" alt=\"could not take screen shot\" /></div>");
			// Add Screenshot, etc.
		}
		// logout, get(urlLogout), delete cookie, delete cache
	}

	@DataProvider
	public Object[][] searchData() {
		return new Object[][] { { "EUR", "mac" }, };
	}

	@Test(dataProvider = "searchData")
	public void findByXPath(String currency, String searchItem) throws Exception {
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>Only Report.</FONT><BR>");
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>Non Conditional.</FONT><BR>", true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 2 FATAL</FONT><BR>", 2, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 3 ERROR</FONT><BR>", 3, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 5 WARNING</FONT><BR>", 5);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 7 INFO</FONT><BR>", 7, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 9 TRACE</FONT><BR>", 9, true);
		// Precondition
		// Choose Curency
		driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//button[@name='" + currency + "']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		// Type Search Field
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).clear();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(searchItem);
		Thread.sleep(1000); // For Presentation Only
		//
		// Click Search Button
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Check
		WebElement axe = driver.findElement(By.xpath("//div[contains(@class,'product-layout')]//a[text()='MacBook']"));
		WebElement price = axe.findElement(By.xpath("./../following-sibling::p[@class='price']"));
		Assert.assertTrue(price.getText().contains("472.33"));
		Assert.assertTrue(false);
		//
		// Return to Previous State
		driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
		Thread.sleep(1000); // For Presentation Only
	}

}