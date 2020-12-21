package com.softserve.edu.pageobject.pages.tipstricks;

import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.pages.TopPart;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class TipsTricksPage extends TopPart {
    private WebElement mainHeader;
    private List<WebElement> leftButton;
    private List<WebElement> rightButton;

    public TipsTricksPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        mainHeader = driver.findElement(By.xpath("//h2[@class='section-caption']"));
        leftButton = driver.findElements(By
                .xpath("//button[@class='button-prev tips-navigation primary-global-button']"));
        rightButton = driver.findElements(By
                .xpath("//button[@class='button-next tips-navigation primary-global-button']"));
    }

    public String getPageTitleText() {
        return driver.getTitle();
    }

    public boolean isPageTitlePresent() {
        return getPageTitleText().length() > 0;
    }

    public WebElement getMainHeader() {
        return mainHeader;
    }

    public boolean isMainHeaderPresent() {
        return getMainHeaderText().length() > 0;
    }

    public String getMainHeaderText() {
        return getMainHeader().getText().trim();
    }

    public WebElement getLeftButton() {
        return leftButton.get(0);
    }

    public WebElement getRightButton() {
        return rightButton.get(0);
    }

    public TipCardContainer activateLeftButton() {
        getLeftButton().click();
        return new TipCardContainer(driver);
    }

    public TipCardContainer activateRightButton() {
        getRightButton().click();
        return new TipCardContainer(driver);
    }

    public boolean isPresentLeftButton() {
        return !leftButton.isEmpty();
    }

    public boolean isPresentRightButton() {
        return !rightButton.isEmpty();
    }

    public TipCardContainer openTipCardSection() {
        return new TipCardContainer(driver);
    }

    public List<WebElement> getGreencityLogo() {
        return driver.findElements(By.xpath("//img[@class='logo']"));
    }

    public boolean isGreenCityLogoPresent() {
        return !getGreencityLogo().isEmpty();
    }

    public WelcomePage isGreenCityLogoClickable() {
        getGreencityLogo().get(0).click();
        return new WelcomePage(driver);
    }

    public String getFollowUs() {
        return driver.findElement(By.xpath("//div[@class='follow-us-text']/p")).getText();
    }

    public List<WebElement> getBottomMenu() {
        return driver.findElements(By.xpath("//li/a[@class='router-links']"));
    }

    public List<String> getBottomMenuItemsName() {
        List<String> bottomMenuItems = new ArrayList<>();
        for (WebElement menuItem : getBottomMenu()) {
            bottomMenuItems.add(menuItem.getText());
        }
        return bottomMenuItems;
    }

    public TipsTricksPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new TipsTricksPage(driver);
    }
}