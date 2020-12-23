package com.softserve.edu.pageobject.pages.places;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlacesContainer {
    private final String PLACES_COMPONENT_CSSSELECTOR = "????"; //TODO Rostyk
    private WebDriver driver;
    private List<WebElement> places;

    public PlacesContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        places = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(PLACES_COMPONENT_CSSSELECTOR))) {
            places.add(current);
        }
    }
}

