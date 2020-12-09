package com.softserve.edu.pageobject.pages.myhabits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.TopPart;

public class AllHabits extends TopPart {

    private WebElement allHabitsLabel;

    public AllHabits(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        allHabitsLabel = driver.findElement(By.cssSelector("div.habits_header-wrapper h1"));
    }

    // Page Object

    // allHabitsLabel
    public WebElement getAllHabitsLabel() {
        return allHabitsLabel;
    }

    public String getAllHabitsLabelText() {
        return getAllHabitsLabel().getText().trim();
    }

    // Functional

    // Business Logic

}
