package com.softserve.edu.pageobject.pages.econews;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterContainer {
    private final String Filter_COMPONENT_CSSSELECTOR = "????";

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

    // Business Logic

}
