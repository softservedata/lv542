package com.softserve.edu.pageobject.pages.econews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;

import com.softserve.edu.pageobject.pages.TopPart;

public class EconewsPage extends TopPart {

    private WebElement mainHeader;
    private NewsSection newsSection;
    private FilterBlock filterBlock;

    public EconewsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        mainHeader = driver.findElement(By.cssSelector("h1.main-header"));
        filterBlock = new FilterBlock(driver);
        newsSection = new NewsSection(driver);
    }

    public WebElement getMainHeader() {
        return mainHeader;
    }

    public String getMainHeaderText() {
        return getMainHeader().getText().trim();
    }

    public EconewsPage activateTwoFilterItems(String firstFilter, String secondFilter) {
        createFilterBlock().activateTwoFilterItems(firstFilter, secondFilter);
        return this;
    }

    public FilterBlock createFilterBlock() {
        filterBlock = new FilterBlock(driver);
        return filterBlock;
    }

    public NewsSection createNewsSection() {
        newsSection = new NewsSection(driver);
        return newsSection;
    }

    public EconewsPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new EconewsPage(driver);
    }

}