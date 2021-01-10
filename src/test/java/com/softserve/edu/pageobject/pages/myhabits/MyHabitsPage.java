package com.softserve.edu.pageobject.pages.myhabits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.pages.TopPart;

public class MyHabitsPage extends TopPart {

    private WebElement myHabitsTab;
    private WebElement addNewHabitsButton;

    public MyHabitsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        myHabitsTab = driver.findElement(By.cssSelector("span.profile-span.active.ng-star-inserted"));
        addNewHabitsButton = driver.findElement(By.cssSelector("div.menu-title a"));
    }

    public WebElement getMyHabitsTab() {
        return myHabitsTab;
    }

    public String getMyHabitsTabText() {
        return getMyHabitsTab().getText().trim();
    }

    public void openMyHabitsTab() {
        getMyHabitsTab().click();
    }

    public WebElement getAddNewHabitsButton() {
        return addNewHabitsButton;
    }

    public String getAddNewHabitsButtonText() {
        return getAddNewHabitsButton().getText().trim();
    }

    public MyHabitsPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new MyHabitsPage(driver);
    }

    public AllHabitsPage openAddHabitsPage() {
        getAddNewHabitsButton().click();
        return new AllHabitsPage(driver);
    }
}