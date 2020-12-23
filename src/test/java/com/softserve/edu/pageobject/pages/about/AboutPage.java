package com.softserve.edu.pageobject.pages.about;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.pages.SignInPage;
import com.softserve.edu.pageobject.pages.places.PlacesPage;
import com.softserve.edu.pageobject.pages.tipstricks.TipsTricksPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.TopPart;

public class AboutPage extends TopPart {

    private WebElement formHabitUpperButton;
    private WebElement formHabitBottomButton;
    private WebElement findEcoPlacesButton;
    private WebElement tipsAndTricksButton;
    private WebElement findPeopleUpperButton;
    private WebElement getInspiredButton;
    private WebElement findPeopleBottomButton;
    private WebElement aboutUsText;
    private WebElement about;

    public AboutPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        aboutUsText = driver.findElement(By.cssSelector("div.container-about h2"));
        formHabitUpperButton = driver.findElement(By.cssSelector(".container-about .full-text-block > button"));
        findEcoPlacesButton = driver.findElement(By.xpath("//a[contains(text(),'places')]")); //map
        tipsAndTricksButton = driver.findElement(By.xpath("//a[contains(text(),'Go')]"));
        getInspiredButton = driver.findElement(By.xpath("//a[contains(text(),'inspired')]"));
//        findPeopleBottomButton = driver.findElement(By.cssSelector("#fifth-card-text + a"));
//        formHabitBottomButton =  driver.findElement(By.cssSelector(".container-vision .full-text-block > button"));
//        findPeopleUpperButton = driver.findElement(By.id("fourth-card-link")); //disabled link
    }

    // Buttons
    public SignInPage openSignInWindow() {
        formHabitUpperButton.click();
        return new SignInPage(driver);
    }

    public PlacesPage openPlacesPageFromAboutPage() {
        findEcoPlacesButton.click();
        return new PlacesPage(driver);
    }

    public TipsTricksPage openTipsTricksPageFromAboutPage() {
        tipsAndTricksButton.click();
        return new TipsTricksPage(driver);
    }

    public WelcomePage openWelcomePageFromAboutPage() {
        getInspiredButton.click();
        return new WelcomePage(driver);
    }

    public boolean isAboutUsTextDisplayed() {
        return aboutUsText.getText().contains("About Us");
    }

    public String getAboutHeaderText() {
        return getAboutElement().getText().trim();
    }

    // about
    public WebElement getAboutUsMenuItem() {
        return about;
    }

    public String getAboutUsMenuItemText() {
        return getAboutUsMenuItem().getText().trim();
    }

    public WebElement getAboutElement() {
        return aboutUsText;
    }

    public AboutPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new AboutPage(driver);
    }

}
