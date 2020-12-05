package com.softserve.edu.diana;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcoNewsPageTest {
    private final String BASE_URL = "https://ita-social-projects.github.io/GreenCityClient/#/news";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;
    private final int MAX_SCROLL_COUNT = 60;

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
        driver.quit();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
    	 /* to unclick active filters */
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(".main-header"))).perform();
        List<WebElement> filters = driver.findElements(By.cssSelector(".custom-chip.global-tag"));
        for (WebElement currentFilter : filters) {
            if (currentFilter.getAttribute("class").contains("global-tag-clicked")) {
                currentFilter.click();
            }
        }

        if (!result.isSuccess()) {
            driver.manage().deleteAllCookies();
        }
    }
    
    
    
    @DataProvider
    public Object[][] getFilterTestData() {
        return new Object[][]{
                {"EVENTS", "ADS"},
                {"ADS", "NEWS"},
                {"ADS", "EDUCATION"},
                {"ADS", "INITIATIVES"},
                {"ADS", "LIFEHACKS"},
                {"EVENTS", "NEWS"},
                {"EVENTS", "EDUCATION"},
                {"EVENTS", "INITIATIVES"},
                {"EVENTS", "LIFEHACKS"},
                {"NEWS", "EDUCATION"},
                {"NEWS", "INITIATIVES"},
                {"NEWS", "LIFEHACKS"},
                {"EDUCATION", "INITIATIVES"},
                {"EDUCATION", "LIFEHACKS"},
                {"INITIATIVES", "LIFEHACKS"},
        };
    }




    /**
     * Test design technique: Pairwise Testing
     *
     * @param filter1 - the first filter
     * @param filter2 - the second filter
     *                Pair combination of 6 filters = 15 tests
     *                Steps:
     *                * 1) Choose Filters
     *                * 2) Find all News
     *                * 4) Check labels
     */
    @Test(dataProvider = "getFilterTestData")
    public void verifyFilterCoupleTest(String firstFilter, String secondFilter) throws Exception {
    	driver.get(BASE_URL);

        //choosing filters
        List<WebElement> webElements = driver.findElements(By.cssSelector(".custom-chip.global-tag"));
        for (WebElement element : webElements) {
            if (element.getText().toUpperCase().contains(firstFilter) || element.getText().toUpperCase().contains(secondFilter)) {
                element.click();
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title-list word-wrap']")));
                driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
            }
        }

        int countOfFoundItems = Integer.parseInt(
                driver.findElement(By.xpath("//app-remaining-count//p")).getText().replaceAll("[^0-9]", ""));

        //scrolling till all news will be found
        List<WebElement> actualNews = driver.findElements(By.className("list-gallery"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        int currentScrollIndex = 0;
        while (actualNews.size() < countOfFoundItems && currentScrollIndex < MAX_SCROLL_COUNT) {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", actualNews.get(actualNews.size() - 1));
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
            actualNews = driver.findElements(By.className("list-gallery"));
            currentScrollIndex++;
        }

        //checking news labels
        boolean isLabelsCorrect = true;
        List<WebElement> listNews = driver.findElements(By.className("list-gallery"));
        for (int i = 0; i < listNews.size(); i++) {
            List<WebElement> listLabels = listNews.get(i).findElements(By.cssSelector(".ul-eco-buttons.ng-star-inserted"));
            List<String> elementsLabels = new ArrayList<>();
            for (int k = 0; k < listLabels.size(); k++) {
                elementsLabels.add(listLabels.get(k).getText().toUpperCase());
            }
            if (!elementsLabels.contains(firstFilter) && !elementsLabels.contains(secondFilter)) {
                isLabelsCorrect = false;
            }
        }
        Assert.assertTrue(isLabelsCorrect);
    }

}