package com.softserve.edu.pageobject.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FilterContainer {
    private final String Filter_COMPONENT_CSSSELECTOR = ".custom-chip.global-tag";

    private WebDriver driver;
    //
    private List<WebElement> filters;
    
    public FilterContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        filters = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(Filter_COMPONENT_CSSSELECTOR))) {
            filters.add(current);
        }
    }

    // Page Object

    // Functional
    public void clickOnFilterByName(String filter) {
        for (WebElement element : filters) {
            if (element.getText().toUpperCase().contains(filter)) {
                element.click();
            }
        }
    }

    public void unclickFilters(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(".main-header"))).perform();
        for (WebElement currentFilter : filters) {
            if (currentFilter.getAttribute("class").contains("global-tag-clicked")) {
                currentFilter.click();
            }
        }
    }

    public FilterContainer clickOnFiltersPair(String firstFilter, String secondFilter){
        clickOnFilterByName(firstFilter);
        clickOnFilterByName(secondFilter);
        return this;
    }

    // Business Logic

}