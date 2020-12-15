package com.softserve.edu.pageobject.pages.tipstricks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.pages.TopPart;

public class TipsTricksPage extends TopPart {

    private WebElement sectionCaption;

    public TipsTricksPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        sectionCaption = driver.findElement(By.cssSelector("h2.section-caption"));
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
    
    public TipsTricksPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new TipsTricksPage(driver);
    }

}