package com.softserve.edu.pageobject.pages.places;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.TopPart;

public class PlacesPage extends TopPart {

    private WebElement sectionCaption;

    public PlacesPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        sectionCaption = driver.findElement(By.name("search"));
    }

    // Page Object

    // sectionCaption
    public WebElement getSectionCaption() {
        return sectionCaption;
    }

    public String getSectionCaptionText() {
        return getSectionCaption().getText().trim();
    }

    // Functional

    // Business Logic

}