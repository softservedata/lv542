package com.softserve.edu.pageobject.pages.about;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.pages.TopPart;

public class AboutPage extends TopPart {

    //protected WebDriver driver;

    private WebElement formHabitUpperButton;
    private WebElement formHabitBottomButton;
    private WebElement findEcoPlacesButton;
    private WebElement tipsAndTricksButton;
    private WebElement findPeopleUpperButton;
    private WebElement getInspiredButton;
    private WebElement findPeopleBottomButton;

    private WebElement aboutUsText;

    public AboutPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
//        //not all correct paths (page changes often)

//        formHabitUpperButton = driver.findElement(By.cssSelector(".container-about .full-text-block > button"));
//        formHabitBottomButton =  driver.findElement(By.cssSelector(".container-vision .full-text-block > button"));
//        findEcoPlacesButton = driver.findElement(By.xpath("//a[contains(text(),'places')]")); //map
//        tipsAndTricksButton = driver.findElement(By.id("//a[contains(text(),'Go')]"));
//        findPeopleUpperButton = driver.findElement(By.id("fourth-card-link")); //disabled link
//        getInspiredButton = driver.findElement(By.xpath("//a[contains(text(),'inspired')]"));
//        findPeopleBottomButton = driver.findElement(By.cssSelector("#fifth-card-text + a"));

          aboutUsText = driver.findElement(By.cssSelector("div.container-about h2"));
    }

    // Buttons
    public WebElement getFormHabitUpperButton() {
        return formHabitUpperButton;
    }

    public void clickFormHabitUpperButton() {
        getFormHabitUpperButton().click();
    }

    public WebElement getFormHabitBottomButton() {
        return formHabitBottomButton;
    }

    public void clickFormHabitBottomButton() {
        getFormHabitBottomButton().click();
    }

    public WebElement getFindEcoPlacesButton() {
        return findEcoPlacesButton;
    }

    public void clickFindEcoPlacesButton() {
        getFindEcoPlacesButton().click();
    }

    public WebElement getTipsAndTricksButton() {
        return tipsAndTricksButton;
    }

    public void clickTipsAndTricksButton() {
        getTipsAndTricksButton().click();
    }

    public WebElement getFindPeopleUpperButton() {
        return findPeopleUpperButton;
    }

    public void clickFindPeopleUpperButton() {
        getFindPeopleUpperButton().click();
    }

    public WebElement getGetInspiredButton() {
        return getInspiredButton;
    }

    public void clickGetInspiredButton() {
        getGetInspiredButton().click();
    }

    public WebElement getFindPeopleBottomButton() {
        return findPeopleBottomButton;
    }

    public void clickFindPeopleBottomButton() {
        getFindPeopleBottomButton().click();
    }

    // Text
    public boolean isAboutUsTextDisplayed() {
        return aboutUsText.getText().contains("About Us");
    }

    public String getAboutText() {
        return getAboutElement().getText().trim();
    }

    public WebElement getAboutElement() {
        return aboutUsText;
    }

}