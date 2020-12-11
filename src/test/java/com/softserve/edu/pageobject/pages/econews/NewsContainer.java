package com.softserve.edu.pageobject.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;

public class NewsContainer {
    private final String NEWS_COMPONENT_XPATH = "//li[@class = 'gallery-view-li-active ng-star-inserted']";

    private WebDriver driver;
    private int countOfFoundItems;
    private final int MAX_SCROLL_COUNT = 60;

    private List<NewsComponent> newsComponents;

    public NewsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        countOfFoundItems = Integer.parseInt(
                driver.findElement(By.xpath("//app-remaining-count//p")).getText().replaceAll("[^0-9]", ""));
        // READ ALL COMPONENT by Scroll
        scrollNews();
        newsComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(NEWS_COMPONENT_XPATH))) {
            newsComponents.add(new NewsComponent(current));
        }
    }

    // Page Object

    public List<NewsComponent> getNewsComponents() {
        return newsComponents;
    }

    // Functional

    public int getNewsComponentsCount() {
        return getNewsComponents().size();
    }

    public List<String> getNewsComponentTitles() {
        List<String> newsComponentTitles = new ArrayList<>();
        for (NewsComponent current : getNewsComponents()) {
            newsComponentTitles.add(current.getTitleText());
        }
        return newsComponentTitles;
    }

    public boolean checkFiltersWithNews(String firstFilter, String secondFilter) {
        boolean result = true;
        for (NewsComponent component : newsComponents
        ) {
            if (!component.checkIfLablesCorrespondToFilter(firstFilter) &&
                    !component.checkIfLablesCorrespondToFilter(secondFilter)) {
                result = false;
                //break;
            }
        }
        return result;
    }

    public void scrollNews()
    {
        List<WebElement> actualNews = driver.findElements(By.className("list-gallery"));
        int currentScrollIndex = 0;
        while (actualNews.size() < countOfFoundItems && currentScrollIndex < MAX_SCROLL_COUNT) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
            actualNews = driver.findElements(By.className("list-gallery"));
            currentScrollIndex++;
        }
    }

    protected NewsComponent getNewsComponentByTitle(String title) {
        NewsComponent result = null;
        for (NewsComponent current : getNewsComponents()) {
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
        // TODO +++++++++++++++++++ Content
        return getNewsComponentByTitle(title).getTitleText();
    }

    // TODO Get other filters, date, content


    // TODO Change to Product
    public void clickNewsComponentContentByTitle(String title) {
        // TODO +++++++++++++++++++
        getNewsComponentByTitle(title).clickTitle();
    }

    // TODO Click

    // TODO  READ ALL COMPONENT

    // Business Logic

}
