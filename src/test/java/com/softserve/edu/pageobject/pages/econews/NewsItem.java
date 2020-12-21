package com.softserve.edu.pageobject.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewsItem {

    private WebElement newsItem;
    private List<WebElement> filters;
    private WebElement title;
    private WebElement content;
    private WebElement date;
    List<WebElement> listLabels;

    public NewsItem(WebElement newsItem) {
        this.newsItem = newsItem;
        initElements();
    }

    private void initElements() {
        listLabels = newsItem.findElements(By.cssSelector(".ul-eco-buttons.ng-star-inserted"));
    }

    public WebElement getNewsItem() {
        return newsItem;
    }

    public List<WebElement> getNewsLables() {
        return listLabels;
    }

    public WebElement getTitle() {
        return title;
    }

    public String getTitleText() {
        return getTitle().getText().trim();
    }

    public void openNewsItem() {
        getTitle().click();
        // TODO : should return NewsItemPage
    }

    public List<String> getListOfNewsLables() {
        List<String> elementsLabels = new ArrayList<>();
        for (int k = 0; k < listLabels.size(); k++) {
            elementsLabels.add(listLabels.get(k).getText().toLowerCase());
        }
        return elementsLabels;
    }

    public boolean areLablesCorrespondToFilter(String filter) {
        List<String> elementLables = getListOfNewsLables();
        return elementLables.contains(filter.toLowerCase());
    }
}
