package com.softserve.edu.pageobject.pages.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.engine.WaitWrapper;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

public class EmailTenPage {

    public static final String HEADER_LEFT_ATTRIBUTE = "button primary-global-button";

    protected WebDriver driver;
    //
    private WebElement inboxLabel;
    // private WebElement confirmLink;

    public EmailTenPage(WebDriver driver) {
        this.driver = driver;
        initElements();
        // System.out.println("***WelcomePage Created");
    }

    private void initElements() {
        // init elements
        inboxLabel = driver.findElement(By.cssSelector("div#inbox_count"));
        // confirmLink =
        // driver.findElement(By.cssSelector("a[href*='/GreenCityClient/?token']"));
    }

    // Page Object

    // inboxLabel
    public WebElement getInboxLabel() {
        return inboxLabel;
    }

    public String getInboxLabelText() {
        return getInboxLabel().getText().trim();
    }

    // confirmLink
    public WebElement getConfirmLink() {
        return driver.findElement(By.cssSelector("a[href*='/GreenCityClient/?token']"));
    }

    public String getConfirmLinkText() {
        return getConfirmLink().getText().trim();
    }

    public void clickConfirmLink() {
        getConfirmLink().click();
    }

    // Functional

    // Business Logic

    public EmptyPage confirmEmail() {
        // TODO create const
        WaitWrapper.invisibilityOfElementLocated​Wait(driver,
                By.xpath("//span[@id='inbox_count_number' and text()='0']"));
        clickConfirmLink();
        return new EmptyPage(driver);
    }
}
