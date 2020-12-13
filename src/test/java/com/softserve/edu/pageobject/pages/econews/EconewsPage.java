package com.softserve.edu.pageobject.pages.econews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.TopPart;

public class EconewsPage extends TopPart {

    private WebElement mainHeader;
    //
    private NewsContainer newsContainer;
    private FilterContainer filterContainer;

    public EconewsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        mainHeader = driver.findElement(By.cssSelector("h1.main-header"));
        filterContainer = new FilterContainer(driver);
        newsContainer = new NewsContainer(driver);
    }

    // Page Object

    // mainHeader
    public WebElement getMainHeader() {
        return mainHeader;
    }

    public String getMainHeaderText() {
        return getMainHeader().getText().trim();
    }

    public EconewsPage clickOnFilterContainer(String firstFilter, String secondFilter) {
        createFilterContainer().clickOnFiltersPair(firstFilter, secondFilter);
        return this;
    }

    public FilterContainer createFilterContainer() {
        filterContainer = new FilterContainer(driver);
        return filterContainer;
    }

    public NewsContainer createNewsContainer() {
        newsContainer = new NewsContainer(driver);
        return newsContainer;
    }


    // Functional

    // Business Logic

}