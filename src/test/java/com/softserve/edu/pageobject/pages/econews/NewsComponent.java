package com.softserve.edu.pageobject.pages.econews;

import java.util.ArrayList;
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
    List<WebElement> listLabels;

    public NewsComponent(WebElement newsItem) {
        this.newsItem = newsItem;
        initElements();
    }

    private void initElements() {
        // init elements
        listLabels = newsItem.findElements(By.cssSelector(".ul-eco-buttons.ng-star-inserted"));
        //title = newsItem.findElement(By.cssSelector("???"));
    }

    // Page Object
    public WebElement getNewsItem() {
        return newsItem;
    }

    public List<WebElement> getNewsLables() {
        return listLabels;
    }

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
    public List<String> lablesToString() {
        List<String> elementsLabels = new ArrayList<>();
        for (int k = 0; k < listLabels.size(); k++) {
            elementsLabels.add(listLabels.get(k).getText().toUpperCase());
        }
        return  elementsLabels;
    }

    public boolean checkIfLablesCorrespondToFilter(String filter){
        List<String> elementLables = lablesToString();
        return elementLables.contains(filter);
    }

    // Business Logic

}
