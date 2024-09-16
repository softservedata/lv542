package com.softserve.edu.pageobject.pages.myhabits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.TopPart;

public class AllHabitsPage extends TopPart {

    private WebElement mainHeader;

    public AllHabitsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        mainHeader = driver.findElement(By.cssSelector("div.habits_header-wrapper h1"));
    }

    public WebElement getMainHeader() {
        return mainHeader;
    }

    public String getAllHabitsLabelText() {
        return getMainHeader().getText().trim();
    }

}
