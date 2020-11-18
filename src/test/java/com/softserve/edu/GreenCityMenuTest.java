package com.softserve.edu;

import org.testng.annotations.Test;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NamedMethodGenerator;

import io.github.bonigarcia.wdm.WebDriverManager;
import sun.print.resources.serviceui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.awt.List;
import java.awt.MenuItem;
import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.hc.core5.http.nio.support.AbstractAsyncResponseConsumer;
import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList.Member2.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class GreenCityMenuTest {
	final String TEST_SITE_URL = "https://ita-social-projects.github.io/GreenCityClient/";
	private WebDriver driver;

	@DataProvider(name = "getMenuFunctionalTestData")
	public Object[][] getMenuFunctionalTestData() {
		return csvToStringsListReader("menuFunctionalTestData.csv");
	}

	@BeforeSuite
	public void BeforeSuite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(TEST_SITE_URL);
	}

	@Test(dataProvider = "getMenuFunctionalTestData")
	public void testMenuFunctionality(String menuItem, String pageTitle) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText(menuItem)).click();
		assertEquals(driver.getTitle(), pageTitle);
	}
	
	//@Test
	//public void testCSSElements() {
	//	String text = driver.getPageSource();

	    //Pattern pattern = Pattern.compile("margin[-,a-z]*:( )+([0-9]+px( )*)+;");
	    //System.out.println("---------");
	    //System.out.println(text.substring(pattern.matcher(text).start(), pattern.matcher(text).end()));

	//}


	@AfterSuite
	public void afterSuite() {
        driver.quit();
	}
	
//---------------------------------------------------------------------------------------------------------------
	
	/**
	 * Method implements CSV rows splitter.
	 * 
	 * @param line      a string from CSV file
	 * @param delimiter CSV cells delimiter
	 * @return a List of CSV cells
	 */
	private ArrayList<String> getRecordFromLine(String line, String delimiter) {
		ArrayList<String> values = new ArrayList<>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(delimiter);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}

	/**
	 * Method implements data provider for reading test data from CSV for testNG
	 * 
	 * @param csvFile path to data source
	 * @return two-dimensional array of Objects (Arguments)
	 */
	private Object[][] csvToStringsListReader(String csvFile) {
		csvFile = AppTest.class.getResource("/" + csvFile).getPath();
		ArrayList<Object[]> listOfItems = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(csvFile))) {
			System.out.println("Reading file: " + csvFile);
			while (scanner.hasNextLine()) {
				listOfItems.add(getRecordFromLine(scanner.nextLine(), ",").toArray());
			}
		} catch (IOException e) {
			System.out.println("File reading error.");
		}
		Object[][] arrayOfItems = new Object[listOfItems.size()][];
		return listOfItems.toArray(arrayOfItems);
	}

}
