package com.softserve.edu.pageobject.pages.tipstricks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.pages.TopPart;

public class TipsTricksPage extends TopPart {

    private WebElement mainHeader;

    public TipsTricksPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        mainHeader = driver.findElement(By.cssSelector("h2.section-caption"));
    }

    public WebElement getMainHeader() {
        return mainHeader;
    }

    public String getMainHeaderText() {
        return getMainHeader().getText().trim();
    }

    public TipsTricksPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new TipsTricksPage(driver);
    }
}