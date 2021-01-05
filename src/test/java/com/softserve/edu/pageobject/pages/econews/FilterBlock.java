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
    private WebElement filterBy;


    public FilterBlock(WebDriver driver) {
        filterBy = driver.findElement(By.xpath("//div[@class='wrapper']/span[. ='Filter by']"));
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
        for (WebElement filterItem : filters) {
            if (filterItem.getText().toUpperCase().contains(filter)) {
                filterItem.click();
            }
        }
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

    public FilterBlock activateTwoFilterItems(String firstFilter, String secondFilter) {
        activateFilterByName(firstFilter);
        activateFilterByName(secondFilter);
        return this;
    }

    public boolean areFilterButtonsPresent(String expectedFilterElement) {
        boolean isButtonPresent = false;
        for (WebElement element : filters) {
            if (element.getText().contains(expectedFilterElement)) {
                isButtonPresent = true;
            }
        }
        return isButtonPresent;
    }

    public String getFilterButtonClass(String expectedFilterElement) {
        String filterButtonClass = "";
        for (WebElement filterButton : filters) {
            if (filterButton.getText().trim().equals(expectedFilterElement)) {
                filterButton.click();
                filterButtonClass = filterButton.getAttribute("class");
            }
        }
        return filterButtonClass;
    }

    public NewsSection activateFilterButtonByName(String expectedFilterElement) {
        for (WebElement filterButton : filters) {
            if (filterButton.getText().trim().equals(expectedFilterElement)) {
                filterButton.click();
            }
        }
        return new NewsSection(driver);
    }

    public EconewsPage deactivateFilterButton() {
        for (WebElement filterButton : filters) {
            if (filterButton.getAttribute("class").equals("custom-chip global-tag global-tag-clicked")) {
                filterButton.click();
            }
        }
        return new EconewsPage(driver);
    }

    public String getFilterByElement() {
        return filterBy.getText();
    }
}
