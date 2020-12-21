package com.softserve.edu.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBlock implements Attributes {

    private WebDriver driver;
    private WebElement searchField;
    private WebElement closeIcon;

    public SearchBlock(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        searchField = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        closeIcon = driver.findElement(By.cssSelector("div.close-icon"));
    }

    public void clearSearchField() {
        searchField.clear();
    }

    public void fillSearchField(String text) {
        searchField.sendKeys(text);
    }

    public void closeSearchBlock() {
        closeIcon.click();
    }
}
