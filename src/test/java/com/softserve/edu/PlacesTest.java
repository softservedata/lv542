package com.softserve.edu;

import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlacesTest {
	private final String BASE_URL = "https://ita-social-projects.github.io/GreenCityClient/#/map";
	private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
	private final Long IMPLICITLY_WAIT_SECONDS = 10L;
	private final Long ONE_SECOND_DELAY = 1000L;
	private WebDriver driver;
	
	private void takeScreenShot(String name) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./screenshots/" + currentTime + "_TC_" + name + "_screenshot.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void takePageSource(String name) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String pageSource = driver.getPageSource();
        byte[] strToBytes = pageSource.getBytes();
        Path path = Paths.get("./screenshots/" + currentTime + "_TC_" + name + "_source.html");
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

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

	@DataProvider
	public Object[][] dataProviderCheckSearchField() {
		return new Object[][] { { "Malevych" }, };
	}

	@DataProvider
	public Object[][] dataProviderCheckDistance() {
		return new Object[][] { 
			{ "0,5" },
//			{ "3" },
//			{ "10" },
		};
	}

	@BeforeSuite()
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass()
	public void beforeClass() {
		Map<String, Object> preferences = new HashMap<>();
		preferences.put("profile.default_content_setting_values.geolocation", 2);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", preferences);
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	@BeforeMethod()
	public void beforeMethod() {
		driver.get(BASE_URL);
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) {
		if (!result.isSuccess()) {
			String testName = result.getName();
			System.out.println("***TC error, name = " + testName + " ERROR");
			takeScreenShot(testName);
            takePageSource(testName);
		}
		driver.manage().deleteAllCookies();
	}

//	public void changeMarkerLocation() {
//		// List<WebElement> elements = driver.findElements(By.cssSelector("div:has(>
//		// img[src='assets/img/icon/blue-dot.png'])"));
//		// System.out.println(elements.size());
//		List<WebElement> elements = driver
//				.findElements(By.xpath("//img[@src='assets/img/icon/blue-dot.png']/parent::*"));
//		WebElement element1 = elements.get(0);
//		WebElement element2 = elements.get(1);
//		((JavascriptExecutor) driver).executeScript(
//				"arguments[0].setAttribute('style', 'width: 32px; height: 32px; overflow: hidden; left: 0px; top: 100px; z-index: 1')",
//				element1);
//		((JavascriptExecutor) driver).executeScript(
//				"arguments[0].setAttribute('style', 'width: 32px; height: 32px; overflow: hidden; position: absolute; opacity: 0.0001; cursor: pointer; touch-action: none; left: 0px; top: 100px; z-index: 1;')",
//				element2);
//	}
//
//	public void moveOnMap() {
//		WebElement element = driver.findElement(By.xpath("//div[@tabindex and @style]/div[1]"));
//		((JavascriptExecutor) driver).executeScript(
//				"arguments[0].setAttribute('style', 'z-index: 1; position: absolute; left: 50%; top: 50%; width: 100%; transform: translate(0px, 500px);')",
//				element);
//	}
//
//	public void changeZoom() {
//		WebElement element = driver.findElement(By.xpath("//agm-map/div"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy('100', '0')", element);
//	}
//
//	public void increaseZoom(int amount) {
//		WebElement element = driver.findElement(By.xpath("//button[@title='Увеличить']"));
//		for (int i = 0; i < amount; i++) {
//			element.click();
//		}
//	}
//
//	public void reduceZoom(int amount) {
//		WebElement element = driver.findElement(By.xpath("//button[@title='Уменьшить']"));
//		for (int i = 0; i < amount; i++) {
//			element.click();
//		}
//	}
//
//	public void setupGoogleMaps() {
//		presentationSleep();
//		reduceZoom(4);
//		presentationSleep();
//	}
	
//	@Test()
	public void test() throws Exception {
		presentationSleep(5);
	}

//	@Test(dataProvider = "dataProviderCheckSearchField")
	public void checkSearchField(String text) throws Exception {
		driver.findElement(By.cssSelector("#control_panel > input")).click(); // Search Field
		driver.findElement(By.cssSelector("#control_panel > input")).clear(); // Search Field
		presentationSleep(2);
		driver.findElement(By.cssSelector("#control_panel > input")).sendKeys(text); // Search Field
		presentationSleep(2);
		driver.findElement(By.xpath("//td[.='Malevych ']"));
		driver.findElement(By.id("gmimap3"));
		presentationSleep(2);
	}
	
//	@Test()
	public void checkPlace() throws Exception {
        driver.findElement(By.xpath("//td[.='Forum ']")).click();
        driver.findElement(By.id("gmimap0"));
		presentationSleep(2);
		driver.findElement(By.xpath("//button[.='Show all']")).click(); // Show All
		presentationSleep(2);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//td[.='Victoria Gardens ']")).click();
		driver.findElement(By.id("gmimap1"));
		presentationSleep(2);
	}

//	@Test()
	public void checkDiscountRate() throws Exception {
		driver.findElement(By.id("filter_btn")).click(); // Filter By
		presentationSleep(2);
		WebElement element = driver.findElement(By.cssSelector("span[class*='pointer-max']")); // Discount Rate
		Actions action = new Actions(driver);       
        action.dragAndDropBy(element, -148, 0).perform();
		presentationSleep(2);
		driver.findElement(By.id("apply_filter_btn")).click(); // Apply
		presentationSleep(2);
		driver.findElement(By.xpath("//td[.='Victoria Gardens ']"));
		presentationSleep(2);
	}

//	@Test()
	public void checkIsNowOpen() throws Exception {
		driver.findElement(By.id("filter_btn")).click(); // Filter By
		presentationSleep(2);
		driver.findElement(By.id("is_open_checkbox")).click(); // Is Now Open
		presentationSleep(2);
		driver.findElement(By.id("apply_filter_btn")).click(); // Apply
		presentationSleep(2);
		driver.findElement(By.xpath("//td[.='Forum ']"));
		driver.findElement(By.xpath("//td[.='Victoria Gardens ']"));
		driver.findElement(By.xpath("//td[.='Pravda ']"));
		driver.findElement(By.xpath("//td[.='Malevych ']"));
		driver.findElement(By.xpath("//td[.='Kryivka ']"));
		presentationSleep(2);
	}

	@Test(dataProvider = "dataProviderCheckDistance")
	public void checkDistance(String number) throws Exception {
		driver.findElement(By.id("filter_btn")).click(); // Filter By
		presentationSleep(2);
		driver.findElement(By.cssSelector("#filtering_layout > input")).sendKeys(number); // Distance
		presentationSleep(2);
		driver.findElement(By.id("apply_filter_btn")).click(); // Apply
		presentationSleep(2);
		driver.findElement(By.xpath("//td[.='Pravda ']"));
		driver.findElement(By.xpath("//td[.='Kryivka ']"));
		presentationSleep(2);
	}
}
