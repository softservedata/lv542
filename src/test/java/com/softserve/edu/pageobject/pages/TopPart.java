package com.softserve.edu.pageobject.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.engine.WaitWrapper;
import com.softserve.edu.pageobject.pages.about.AboutPage;
import com.softserve.edu.pageobject.pages.econews.EconewsPage;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.places.PlacesPage;
import com.softserve.edu.pageobject.pages.tipstricks.TipsTricksPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TopPart implements Attributes {

    public static final Logger logger = LoggerFactory.getLogger(TopPart.class);

    protected final String COMPONENT_NULL_MESSAGE = "Component is null or Disabled";

    protected WebDriver driver;
    private WebElement logo;
    private WebElement searchButton;
    private WebElement languagePopUp;
    private SearchBlock searchBlock;
    private LanguageBlock languageBlock;
    private LogInBlock logInBlock;
    private userProfileBlock userProfileBlock;
    private WebElement burgerButton;
    private WebElement ecoNewsMenuItem;
    private WebElement tipsTricksMenuItem;
    private WebElement placesMenuItem;
    private WebElement aboutMenuItem;
    private WebElement myHabitsMenuItem;

    Map<Languages, Map<WebElement, String>> localization;

    public TopPart(WebDriver driver) {
        this.driver = driver;
        initElements();
        initLocalization();
    }

    private void initElements() {
        logo = driver.findElement(By.cssSelector("div.logo a"));
        searchButton = driver.findElement(By.cssSelector("li[class*='search'] a"));
        languagePopUp = driver.findElement(By.cssSelector("div.switcher-wrapper ul"));
        burgerButton = driver.findElement(By.cssSelector("li.burger-b"));
        ecoNewsMenuItem = driver.findElement(By.cssSelector("div.navigation-menu a[href*='/news']"));
        tipsTricksMenuItem = driver.findElement(By.cssSelector("div.navigation-menu a[href*='/tips']"));
        placesMenuItem = driver.findElement(By.cssSelector("div.navigation-menu a[href*='/map']"));
        aboutMenuItem = driver.findElement(By.cssSelector("div.navigation-menu a[href*='/about']"));
        myHabitsMenuItem = driver.findElement(By.cssSelector("div.navigation-menu a[href*='/profile']"));
    }

    private void initLocalization() {
        localization = new HashMap<>();
        Map<WebElement, String> localizationEn = new HashMap<>();
        localizationEn.put(ecoNewsMenuItem, "Eco news");
        localizationEn.put(tipsTricksMenuItem, "Tips & Tricks");
        localizationEn.put(placesMenuItem, "Places");
        localizationEn.put(aboutMenuItem, "About us");
        localizationEn.put(myHabitsMenuItem, "My habits");
        localization.put(Languages.EN, localizationEn);
        Map<WebElement, String> localizationUa = new HashMap<>();
        localizationUa.put(ecoNewsMenuItem, "Еко новини");
        localizationUa.put(tipsTricksMenuItem, "Поради");
        localizationUa.put(placesMenuItem, "Карта");
        localizationUa.put(aboutMenuItem, "Про нас");
        localizationUa.put(myHabitsMenuItem, "Мій кабінет");
        localization.put(Languages.UA, localizationUa);
    }

    private void clickLogo() {
        logo.click();
    }

    public void clickSearch() {
        searchButton.click();
        // TODO
    }

    public String getLanguageText() {
        return languagePopUp.getText().trim();
    }

    public void clickLanguage() {
        languagePopUp.click();
        // TODO
    }

    public boolean isDisplayedBurger() {
        return burgerButton.isDisplayed();
    }

    public void openBurgerMenu() {
        if (isDisplayedBurger()) {
            burgerButton.click();
        }
        // TODO else new Exception();
    }

    public boolean isDisplayedEcoNewsMenuItem() {
        return ecoNewsMenuItem.isDisplayed();
    }

    public WebElement getEcoNewsMenuItem() {
        if (!isDisplayedEcoNewsMenuItem()) {
            openBurgerMenu();
        }
        return ecoNewsMenuItem;
    }

    public String getEcoNewsMenuItemText() {
        return getEcoNewsMenuItem().getText();
    }

    private void clickEcoNews() {
        getEcoNewsMenuItem().click();
    }

    public boolean isDisplayedTipsTricksMenuItem() {
        return tipsTricksMenuItem.isDisplayed();
    }

    public WebElement getTipsTricksMenuItem() {
        if (!isDisplayedTipsTricksMenuItem()) {
            openBurgerMenu();
        }
        return tipsTricksMenuItem;
    }

    public String getTipsTricksMenuItemText() {
        return getTipsTricksMenuItem().getText();
    }

    private void clickTipsTricks() {
        getTipsTricksMenuItem().click();
    }

    public boolean isDisplayedPlacesMenuItem() {
        return placesMenuItem.isDisplayed();
    }

    public WebElement getPlacesMenuItem() {
        if (!isDisplayedPlacesMenuItem()) {
            openBurgerMenu();
        }
        return placesMenuItem;
    }

    public String getPlacesMenuItemText() {
        return getPlacesMenuItem().getText();
    }

    private void clickPlaces() {
        getPlacesMenuItem().click();
    }

    public boolean isDisplayedAboutUsMenuItem() {
        return aboutMenuItem.isDisplayed();
    }

    public WebElement getAboutUsMenuItem() {
        if (!isDisplayedAboutUsMenuItem()) {
            openBurgerMenu();
        }
        return aboutMenuItem;
    }

    public String getAboutUsMenuItemText() {
        return getAboutUsMenuItem().getText();
    }

    private void clickAboutUs() {
        getAboutUsMenuItem().click();
    }

    public boolean isDisplayedMyHabitsMenuItem() {
        return myHabitsMenuItem.isDisplayed();
    }

    public WebElement getMyHabitsMenuItem() {
        if (!isDisplayedMyHabitsMenuItem()) {
            openBurgerMenu();
        }
        return myHabitsMenuItem;
    }

    public String getMyHabitsMenuItemText() {
        return getMyHabitsMenuItem().getText();
    }

    private void clickMyHabits() {
        getMyHabitsMenuItem().click();
    }

    protected LanguageBlock getLanguageBlock() {
        if ((languageBlock == null) || (!languagePopUp.isEnabled())) {
            // TODO Develop Custom Exception
            throw new RuntimeException(COMPONENT_NULL_MESSAGE);
        }
        return languageBlock;
    }

    private LanguageBlock createLanguageBlock() {
        clickLanguage();
        languageBlock = new LanguageBlock(driver);
        return getLanguageBlock();
    }

    private void chooseEnglish() {
        getLanguageBlock().chooseEnglish();
        languageBlock = null;
    }

    protected void chooseUkrainian() {
        getLanguageBlock().chooseUkrainian();
        languageBlock = null;
    }

    protected void choseRussian() {
        getLanguageBlock().chooseRussian();
        languageBlock = null;
    }

    protected void chooseLanguageByName(String name) {
        getLanguageBlock().clickLanguageByName(name);
        languageBlock = null;
    }

    protected LogInBlock getLogInBlock() {
        if ((logInBlock == null) || (!logInBlock.getSignInButton().isEnabled())) {
            // TODO Develop Custom Exception
            throw new RuntimeException(COMPONENT_NULL_MESSAGE);
        }
        if (!logInBlock.getSignInButton().isDisplayed()) {
            openBurgerMenu();
        }
        return logInBlock;
    }

    private LogInBlock createLogInBlock() {
        logInBlock = new LogInBlock(driver);
        return getLogInBlock();
    }

    private void clickSignIn() {
        getLogInBlock().clickSignIn();
    }

    private void clickSignUp() {
        getLogInBlock().clickSignUp();
    }

    protected userProfileBlock getUserProfileBlock() {
        if ((userProfileBlock == null) || (!userProfileBlock.getProfilePopUp().isEnabled())) {
            // TODO Develop Custom Exception
            throw new RuntimeException(COMPONENT_NULL_MESSAGE);
        }
        if (!userProfileBlock.getProfilePopUp().isDisplayed()) {
            openBurgerMenu();
        }
        return userProfileBlock;
    }

    private userProfileBlock createUserProfileBlock() {
        userProfileBlock = new userProfileBlock(driver);
        return getUserProfileBlock();
    }

    private void clickUserSettings() {
        getUserProfileBlock().openUserSettingsPage();
    }

    private void clickSignOut() {
        getUserProfileBlock().clickSignOut();
    }

    protected void chooseLanguageByName(Languages languagesName) {
        String languageText = getLanguageText();
        if (!languageText.toLowerCase().trim().equals(languagesName.toString().toLowerCase().trim())) {
            createLanguageBlock();
            chooseLanguageByName(languagesName.toString());
            WaitWrapper.waitForInvisibilityOfElementLocated(driver, By.xpath("//div[@class='switcher-wrapper']//ul/li[contains(text(),'" + languageText + "')]"));
        }
    }

    public boolean isSignInAvailable() {
        return createLogInBlock() != null;
    }

    public String getProfileText() {
        return createUserProfileBlock().getProfileText();
    }

    public boolean isValidLocalization(Languages languageName) { //TODO Oksana
        boolean result = true;
        for (Map.Entry<WebElement, String> current : localization.get(languageName).entrySet()) {
            if (!current.getKey().getText().toLowerCase().trim()
                    .contains(current.getValue().toLowerCase().trim())) {
                result = false;
                break;
            }
        }
        return result;
    }

    public WelcomePage openWelcomePage() {
        clickLogo();
        return new WelcomePage(driver);
    }

    public EconewsPage openEcoNewsPage() {
        clickEcoNews();
        return new EconewsPage(driver);
    }

    public TipsTricksPage openTipsTricksPage() {
        clickTipsTricks();
        return new TipsTricksPage(driver);
    }

    public PlacesPage openPlacesPage() {
        clickPlaces();
        return new PlacesPage(driver);
    }

    public AboutPage openAboutUsPage() {
        clickAboutUs();
        return new AboutPage(driver);
    }

    public MyHabitsPage openMyHabitsPage() {
        clickMyHabits();
        return new MyHabitsPage(driver);
    }

    public SignInPage openMyHabitsPageLoggedOutUser() {
        clickMyHabits();
        return new SignInPage(driver);
    }

    public MyHabitsPage openMyHabitsPage(User user) {
        return openSignInPage().successfulLogin(user);
    }

    public SignInPage openSignInPage() {
        createLogInBlock();
        clickSignIn();
        return new SignInPage(driver);
    }

    public SignUpPage openSignUpPage() {
        createLogInBlock();
        clickSignUp();
        return new SignUpPage(driver);
    }

    public WelcomePage logOut() {
        createUserProfileBlock();
        clickSignOut();
        return new WelcomePage(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
