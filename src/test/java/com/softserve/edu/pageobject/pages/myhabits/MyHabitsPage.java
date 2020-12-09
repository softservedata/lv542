package com.softserve.edu.pageobject.pages.myhabits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.TopPart;

public class MyHabitsPage extends TopPart {

    private WebElement myHabitsTab;
    private WebElement addNewHabits;

    public MyHabitsPage(WebDriver driver) {
        super(driver);
        initElements();
        // System.out.println("***MyHabitsPage Created");
    }

    private void initElements() {
        // init elements
        myHabitsTab = driver.findElement(By.cssSelector("div.profile-menu > span.profile-span.active.ng-star-inserted"));
        addNewHabits = driver.findElement(By.cssSelector("div.menu-title a"));
    }

    // Page Object

    // myHabitsTab
    public WebElement getMyHabitsTab() {
        return myHabitsTab;
    }

    public String getMyHabitsTabText() {
        return getMyHabitsTab().getText().trim();
    }

    public void clickMyHabitsTab() {
        getMyHabitsTab().click();
    }

    // addNewHabits
    public WebElement getAddNewHabits() {
        return addNewHabits;
    }

    public String getAddNewHabitsText() {
        return getAddNewHabits().getText().trim();
    }

    public void clickAddNewHabits() {
        getAddNewHabits().click();
    }

    // Functional

    // Business Logic
    
    public AllHabits gotoAddHabits() {
        clickAddNewHabits();
        return new AllHabits(driver);
    }

}
