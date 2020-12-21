package com.softserve.edu.pageobject.pages.welcome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.pages.TopPart;

public class WelcomePage extends TopPart {

    public static final String HEADER_LEFT_ATTRIBUTE = "button primary-global-button";
    private WebElement firstHeader;
    private WebElement firstButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        firstHeader = driver.findElement(By.cssSelector("div#header-left h1"));
        firstButton = driver.findElement(By.cssSelector("#header .button.primary-global-button"));
    }

    public WebElement getFirstHeader() {
        return firstHeader;
    }

    public String getFirstHeaderText() {
        return getFirstHeader().getText().trim();
    }

    public WebElement getFirstButton() {
        return firstButton;
    }

    public String getFirstButtonText() {
        return getFirstButton().getText().trim();
    }

    public String getFirstButtonAttributeClass() {
        return getFirstButton().getAttribute(TAG_ATTRIBUTE_CLASS);
    }

    public WelcomePage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new WelcomePage(driver);
    }
}
