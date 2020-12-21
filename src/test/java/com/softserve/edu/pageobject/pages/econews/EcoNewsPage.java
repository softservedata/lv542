package com.softserve.edu.pageobject.pages.econews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;

import com.softserve.edu.pageobject.pages.TopPart;

public class EcoNewsPage extends TopPart {

    private WebElement mainHeader;
    private NewsSection newsSection;
    private FilterBlock filterBlock;

    public EcoNewsPage(WebDriver driver) {
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

    public EcoNewsPage activateTwoFilters(String firstFilter, String secondFilter) {
        getFilterBlock().getFiltersWitTwohActivatedItems(firstFilter, secondFilter);
        return this;
    }

    public FilterBlock getFilterBlock() {
        filterBlock = new FilterBlock(driver);
        return filterBlock;
    }

    public NewsSection goToNewsSection() {
        newsSection = new NewsSection(driver);
        return newsSection;
    }

    public EcoNewsPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new EcoNewsPage(driver);
    }

}