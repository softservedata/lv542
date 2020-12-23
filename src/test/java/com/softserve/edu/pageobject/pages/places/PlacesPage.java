package com.softserve.edu.pageobject.pages.places;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.pages.TopPart;

public class PlacesPage extends TopPart {

    private WebElement searchField;
    private WebElement clearFilters;
    private PlacesSection placesComponent;
    private FiltersSection filtersComponent;

    public PlacesPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        searchField = driver.findElement(By.name("search"));
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public PlacesPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new PlacesPage(driver);
    }

}
