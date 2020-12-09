package com.softserve.edu.pageobject.pages.econews;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewsComponent {

    private WebElement newsItem;
    //
    private List<WebElement> filters;
    private WebElement title;
    private WebElement content;
    private WebElement date;

    public NewsComponent(WebElement newsItem) {
        this.newsItem = newsItem;
        initElements();
    }

    private void initElements() {
        // init elements
        title = newsItem.findElement(By.cssSelector("???"));
    }

    // Page Object

    public WebElement getNewsItem() {
        return newsItem;
    }

    // filters

    // title
    public WebElement getTitle() {
        return title;
    }

    public String getTitleText() {
        return getTitle().getText().trim();
    }

    public void clickTitle() {
        getTitle().click();
    }

    // text

    // date

    // Functional

    // Business Logic

}
