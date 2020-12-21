package com.softserve.edu.pageobject.pages.econews;

import com.softserve.edu.pageobject.engine.WaitWrapper;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;

import com.softserve.edu.pageobject.pages.TopPart;

import java.util.ArrayList;
import java.util.List;

public class EconewsPage extends TopPart {

    private WebElement mainHeader;
    private NewsSection newsSection;
    private FilterBlock filterBlock;
    private List<WebElement> bottomMenu;
    private WebElement followUs;
    private List<WebElement> greencityLogo;
    private WebElement itemsFoundParagraph;

    public EconewsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        mainHeader = driver.findElement(By.cssSelector("h1.main-header"));
        bottomMenu = driver.findElements(By.xpath("//li/a[@class='router-links']"));
        followUs = driver.findElement(By.xpath("//div[@class='follow-us-text']/p"));
        greencityLogo = driver.findElements(By.xpath("//img[@class='logo']"));
        itemsFoundParagraph = driver.findElement(By.xpath("//div[@class='main-wrapper']//p"));

    }

    public String getEcoNewsPageTitle() {
        return driver.getTitle();
    }

    public WebElement getMainHeader() {
        return mainHeader;
    }

    public String getMainHeaderText() {
        return getMainHeader().getText().trim();
    }

    public EconewsPage activateTwoFilterItems(String firstFilter, String secondFilter) {
        createFilterBlock().activateTwoFilterItems(firstFilter, secondFilter);
        return this;
    }

    public List<WebElement> getBottomMenu() {
        return bottomMenu;
    }

    public List<String> getBottomMenuItemsName() {
        List<String> bottomMenuItems = new ArrayList<>();
        for (WebElement menuItem : getBottomMenu()) {
            bottomMenuItems.add(menuItem.getText());
        }
        return bottomMenuItems;
    }


    public FilterBlock createFilterBlock() {
        return new FilterBlock(driver);
    }

    public NewsSection createNewsSection() {
        return new NewsSection(driver);
    }

    public String getItemsFoundParagraph() {
        return itemsFoundParagraph.getText().replaceAll("[^A-z]", " ").trim();
    }

    private List<WebElement> getGridButton() {
        return driver.findElements(By.xpath("//span[@class='btn-tiles']"));
    }

    private List<WebElement> getListButton() {
        return driver.findElements(By.xpath("//span[@class='btn-bars']"));
    }

    private List<WebElement> getGridButtonClicked() {
        return driver.findElements(By.xpath("//span[@class='btn-tiles btn-tiles-active']"));
    }

    private List<WebElement> getListButtonClicked() {
        return driver.findElements(By.xpath("//span[@class='btn-bars btn-bars-active']"));
    }

    public String getFollowUs() {
        return followUs.getText();
    }

    public boolean isPresentListButton() {
        return !getListButton().isEmpty();
    }

    public boolean isPresentGridButton() {
        return !getGridButtonClicked().isEmpty();
    }

    public boolean isGridButtonClickable() {
        getListButton().get(0).click();
        getGridButton().get(0).click();
        //check if class of grid button changed after click
        return "btn-tiles btn-tiles-active".equals(getGridButtonClicked().get(0).getAttribute("class"));
    }

    public boolean isListButtonClickable() {
        getListButton().get(0).click();
        //check if class of list button changed after click
        return "btn-bars btn-bars-active".equals(getListButtonClicked().get(0).getAttribute("class"));
    }

    public boolean isGreenCityLogoPresent() {
        return !greencityLogo.isEmpty();
    }

    public WelcomePage isGreenCityLogoClickable() {
        greencityLogo.get(0).click();
        return new WelcomePage(driver);
    }

    public EconewsPage chooseLanguage(Languages languageName) {
        chooseLanguageByName(languageName);
        return new EconewsPage(driver);
    }
}