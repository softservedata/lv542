package com.softserve.edu.pageobject.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FilterBlock {
    private WebDriver driver;
    private List<WebElement> filters;

    public FilterBlock(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        filters = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(".custom-chip.global-tag"))) {
            filters.add(current);
        }
    }

    public void activateFilterByName(String filter) {
        driver.findElement(By.xpath("//*[contains(text(),  '" + filter + "') " +
                "and @class = 'custom-chip global-tag']")).click();
    }

    public void deactivateAllFilters() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(".main-header"))).perform();
        for (WebElement currentFilter : filters) {
            if (currentFilter.getAttribute("class").contains("global-tag-clicked")) {
                currentFilter.click();
            }
        }
    }

    public FilterBlock getFiltersWitTwoActivatedItems(String firstFilter, String secondFilter) {
        activateFilterByName(firstFilter);
        activateFilterByName(secondFilter);
        return this;
    }

}
