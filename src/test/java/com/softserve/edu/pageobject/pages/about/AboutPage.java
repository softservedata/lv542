package com.softserve.edu.pageobject.pages.about;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.pages.TopPart;

public class AboutPage extends TopPart {

    private WebElement about;

    public AboutPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        about = driver.findElement(By.cssSelector("div.container-about h2"));
    }

    // Page Object

    // about
    public WebElement getAbout() {
        return about;
    }

    public String getAboutText() {
        return getAbout().getText().trim();
    }

    // Functional

    // Business Logic
    
    public AboutPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new AboutPage(driver);
    }

}
