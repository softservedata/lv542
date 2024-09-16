package com.softserve.edu.pageobject.pages.places;

import org.openqa.selenium.WebDriver;

public class PlacesSection {

    private WebDriver driver;
    private PlacesContainer placesContainer;

    public PlacesSection(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
    }
}

