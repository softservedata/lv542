package com.softserve.edu.pageobject.pages.mailforregistration;

import com.softserve.edu.pageobject.engine.BrowserTabUtils;
import com.softserve.edu.pageobject.pages.Attributes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.engine.WaitWrapper;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

public class EmailTenPage implements Attributes, BrowserTabUtils {

    //public static final String HEADER_LEFT_ATTRIBUTE = "button primary-global-button";
    public static final String EMAIL_TEN_PAGE_URL = "https://10minutemail.com/";

    protected WebDriver driver;

    private WebElement inboxLabel;
    private WebElement mailAddress;
    //private WebElement smallSender
    //private WebElement confirmLink;

    private String tabHandle;

    public EmailTenPage(WebDriver driver) {
        this.driver = driver;
        initPage();
        initElements();
        //System.out.println("***WelcomePage Created");
    }

    private void initPage() {
        WaitWrapper.gotoUrl(driver, EMAIL_TEN_PAGE_URL);
        tabHandle = getCurrentTabHandle(driver);
    }

    private void initElements() {
        //init elements
        inboxLabel = driver.findElement(By.cssSelector("div#inbox_count"));
        mailAddress = driver.findElement(By.id("mail_address"));
        //confirmLink = driver.findElement(By.cssSelector("a[href*='/GreenCityClient/?token']"));
    }

    public WebElement getInboxLabel() {
        return inboxLabel;
    }

    public String getInboxLabelText() {
        return getInboxLabel().getText().trim();
    }

    public WebElement getMailAddress() {
        return mailAddress;
    }

    public String getMailAddressText() {
        return getMailAddress().getAttribute(TAG_ATTRIBUTE_VALUE).trim();
    }

    public WebElement getSmallSender() {
        return driver.findElement(By.cssSelector("div.small_sender"));
    }

    public void clickSmallSender() {
        getSmallSender().click();
    }

    public WebElement getConfirmLink() {
        return driver.findElement(By.cssSelector("a[href*='/GreenCityClient/?token']"));
    }

    public String getConfirmLinkText() {
        return getConfirmLink().getText().trim();
    }

    public void clickConfirmLink() {
        getConfirmLink().click();
    }

    //Functional
    public EmailTenPage switchToEmailTenPage() {
        switchToTab(driver, tabHandle);
        return this;
    }

    // Business Logic
    public ConfirmEmailPage confirmEmail() {
        WaitWrapper.waitForInvisibilityOfElementLocated(driver,
                By.xpath("//span[@id='inbox_count_number' and text()='0']"));
        clickSmallSender();
        clickConfirmLink();
        return new ConfirmEmailPage(driver);
    }
}