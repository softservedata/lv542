package com.softserve.edu.pageobject.pages.econews;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.pages.TopPart;

public class EconewsPage extends TopPart {

    private WebElement mainHeader;
    //
    private NewsContainer newsContainer;

    public EconewsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        mainHeader = driver.findElement(By.cssSelector("h1.main-header"));
        //newsContainer = new NewsContainer(driver);
    }

    // Page Object

    // mainHeader
    public WebElement getMainHeader() {
        return mainHeader;
    }

    public String getMainHeaderText() {
        return getMainHeader().getText().trim();
    }

    // Functional

    // Business Logic

    public EconewsPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new EconewsPage(driver);
    }

}
