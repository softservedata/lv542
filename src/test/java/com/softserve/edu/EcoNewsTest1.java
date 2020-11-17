package com.softserve.edu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class EcoNewsTest1 {
    private WebDriver driver = null;
    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        //browser instance
        driver = new ChromeDriver();
    }
    @AfterSuite
    public void afterSuite() {
        driver.close();
        driver.quit();
    }

    @Test
    public void testIsEcoNewsPageClickable() throws InterruptedException {
        //browser instance
        String greenCityHomePageUrl = "https://ita-social-projects.github.io/GreenCityClient/#/welcome";
        //
        driver.get(greenCityHomePageUrl);
        //find eco new tab and click
        driver.findElement(By.partialLinkText("Eco news")).click();
        //get header by class name
        WebElement actualEcoNewsHeader = driver.findElement(By.className("main-header"));
        Assert.assertEquals("Eco news", actualEcoNewsHeader.getText());

    }
    @Test
    public void testFilterByElement() throws InterruptedException {
        String greenCityEcoNewsPageUrl = "https://ita-social-projects.github.io/GreenCityClient/#/news";
        driver.get(greenCityEcoNewsPageUrl);
        //get filter by element
        String actualFilterByElement = driver.findElement(By.className("flex-container")).getText();

        List<WebElement> listOfElements = driver.findElements(By.xpath("//ul/a[@class='ng-star-inserted']/li[1]"));
        System.out.println(listOfElements.size());
        System.out.println(listOfElements.get(0).getText());
        for (WebElement filter : listOfElements) {
            filter.click();
            Thread.sleep(1000);
//            System.out.println("Filter name" + filter.getText());

//            List<WebElement> listOfFoundItems = driver.findElements(By.xpath("//div[@class='ul-eco-buttons ng-star-inserted']"));
//            for (WebElement foundItem : listOfFoundItems) {
//                System.out.println("Found element " + foundItem.getText());
//                foundItem.click();
//                Thread.sleep(1000);
//                String newsTitle = driver.findElement(By.xpath("//div[@class='news-title word-wrap']")).getText();
//                System.out.println("News Title");
//            }
        }


//        System.out.println("el " + listOfElements.toString());

    }
}
