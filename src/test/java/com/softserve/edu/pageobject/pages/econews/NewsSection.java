package com.softserve.edu.pageobject.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;

public class NewsSection {

    private WebDriver driver;
    private int countOfFoundItems;
    private final int MAX_SCROLL_COUNT = 60;

    private List<NewsItem> newsItems;

    public NewsSection(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        countOfFoundItems = Integer.parseInt(
                driver.findElement(By.xpath("//app-remaining-count//p")).getText().replaceAll("[^0-9]", ""));
        scrollNewsUntilPageLoaded();
        newsItems = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath("//li[@class = 'gallery-view-li-active ng-star-inserted']"))) {
            newsItems.add(new NewsItem(current));
        }
    }

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }

    public int getNewsItemsCount() {
        return getNewsItems().size();
    }

    public List<String> getNewsItemsTitles() {
        List<String> newsItemsTitles = new ArrayList<>();
        for (NewsItem current : getNewsItems()) {
            newsItemsTitles.add(current.getTitleText());
        }
        return newsItemsTitles;
    }

    public boolean areNewsSortedByFilters(String firstFilter, String secondFilter) {
        boolean isNewsItemCorrespondsToFilters = true;
        for (NewsItem component : newsItems
        ) {
            if (!component.areLablesCorrespondToFilter(firstFilter) &&
                    !component.areLablesCorrespondToFilter(secondFilter)) {
                isNewsItemCorrespondsToFilters = false;
                //break;
            }
        }
        return isNewsItemCorrespondsToFilters;
    }

    public void scrollNewsUntilPageLoaded() {
        List<WebElement> actualNews = driver.findElements(By.className("list-gallery"));
        int currentScrollIndex = 0;
        while (actualNews.size() < countOfFoundItems && currentScrollIndex < MAX_SCROLL_COUNT) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
            actualNews = driver.findElements(By.className("list-gallery"));
            currentScrollIndex++;
        }
    }

    protected NewsItem getNewsItemsByTitle(String title) {
        NewsItem result = null;
        for (NewsItem current : getNewsItems()) {
            if (current.getTitleText().toLowerCase()
                    .equals(title.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // TODO Develop Custom Exception
            // Use String.format(); final
            throw new RuntimeException("News Title: " + title + " not Found.");
        }
        return result;
    }

    public String getNewsComponentContentByTitle(String title) {
        // TODO Content
        return getNewsItemsByTitle(title).getTitleText();
    }

    // TODO Get other filters, date, content


    // TODO Change to Product
    public void clickNewsComponentContentByTitle(String title) {
        // TODO
        getNewsItemsByTitle(title).openNewsItem();
    }

    // TODO  READ ALL COMPONENT
}
