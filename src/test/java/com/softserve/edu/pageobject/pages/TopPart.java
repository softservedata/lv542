package com.softserve.edu.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.pages.about.AboutPage;
import com.softserve.edu.pageobject.pages.econews.EconewsPage;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.places.PlacesPage;
import com.softserve.edu.pageobject.pages.tipstricks.TipsTricksPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

public abstract class TopPart implements Attributes {

    protected final String COMPONENT_NULL_MESSAGE = "Component is null or Disabled";

    protected WebDriver driver;
    //
    // private final String IMG_LOGO_CSS = "div.logo a";
    // private By logo;
    // @FindBy(css = "div.logo a")
    private WebElement logo;
    private WebElement search;
    private WebElement language;
    //
    private SearchComponent searchComponent;
    private LanguageComponent languageComponent;
    private GuestComponent guestComponent;
    private LoggedComponent loggedComponent;
    //
    private WebElement burger;
    private WebElement econews;
    private WebElement tipsTricks;
    private WebElement places;
    private WebElement about;
    private WebElement myHabits;

    public TopPart(WebDriver driver) {
        // super(driver);
        // PageFactory.initElements(driver, this); // for @FindBy
        this.driver = driver;
        initElements();
        // checkElements();
    }

    private void initElements() {
        //System.out.println("***TopPart Created");
        // init elements
        // logo = By.cssSelector("div.logo a");
        logo = driver.findElement(By.cssSelector("div.logo a"));
        search = driver.findElement(By.cssSelector("li[class*='search'] a"));
        language = driver.findElement(By.cssSelector("div.switcher-wrapper ul"));
        //
        burger = driver.findElement(By.cssSelector("li.burger-b"));
        econews = driver.findElement(By.cssSelector("div.navigation-menu a[href*='/news']"));
        tipsTricks = driver.findElement(By.cssSelector("div.navigation-menu a[href*='/tips']"));
        places = driver.findElement(By.cssSelector("div.navigation-menu a[href*='/map']"));
        about = driver.findElement(By.cssSelector("div.navigation-menu a[href*='/about']"));
        myHabits = driver.findElement(By.cssSelector("div.navigation-menu a[href*='/profile']"));
    }

//    private void checkElements() {
//        getLogo();
//    }

    // Page Object

    // logo
    public WebElement getLogo() {
        // return driver.findElement(logo);
        // return driver.findElement(By.cssSelector(IMG_LOGO_CSS));
        // return driver.findElement(By.cssSelector("div.logo a"));
        return logo;
    }

    public void clickLogo() {
        getLogo().click();
    }

    // search
    public WebElement getSearch() {
        return search;
    }

    public void clickSearch() {
        getSearch().click();
        // TODO
    }

    // language
    public WebElement getLanguage() {
        return language;
    }

    public String getLanguageText() {
        return getLanguage().getText().trim();
    }

    public void clickLanguage() {
        getLanguage().click();
        // TODO
    }

    // burger
    public WebElement getBurger() {
        return burger;
    }

    public boolean isDisplayedBurger() {
        return getBurger().isDisplayed();
    }

    public void clickBurger() {
        if (isDisplayedBurger()) {
            getBurger().click();
        }
        // TODO else new Exception();
    }

    // econews
    public boolean isDisplayedEconews() {
        return econews.isDisplayed();
    }

    public WebElement getEconews() {
        if (!isDisplayedEconews()) {
            clickBurger();
        }
        return econews;
    }

    public String getEconewsText() {
        return getEconews().getText();
    }

    public void clickEconews() {
        getEconews().click();
    }

    // tipsTricks
    public boolean isDisplayedTipsTricks() {
        return tipsTricks.isDisplayed();
    }

    public WebElement getTipsTricks() {
        if (!isDisplayedTipsTricks()) {
            clickBurger();
        }
        return tipsTricks;
    }

    public String getTipsTricksText() {
        return getTipsTricks().getText();
    }

    public void clickTipsTricks() {
        getTipsTricks().click();
    }

    // places
    public boolean isDisplayedPlaces() {
        return places.isDisplayed();
    }

    public WebElement getPlaces() {
        if (!isDisplayedPlaces()) {
            clickBurger();
        }
        return places;
    }

    public String getPlacesText() {
        return getPlaces().getText();
    }

    public void clickPlaces() {
        getPlaces().click();
    }

    // about
    public boolean isDisplayedAbout() {
        return about.isDisplayed();
    }

    public WebElement getAbout() {
        if (!isDisplayedAbout()) {
            clickBurger();
        }
        return about;
    }

    public String getAboutText() {
        return getAbout().getText();
    }

    public void clickAbout() {
        getAbout().click();
    }

    // myHabits
    public boolean isDisplayedMyHabits() {
        return myHabits.isDisplayed();
    }

    public WebElement getMyHabits() {
        if (!isDisplayedMyHabits()) {
            clickBurger();
        }
        return myHabits;
    }

    public String getMyHabitsText() {
        return getMyHabits().getText();
    }

    public void clickMyHabits() {
        getMyHabits().click();
    }

    // guestComponent
    protected GuestComponent getGuestComponent() {
        if ((guestComponent == null) || (!guestComponent.getSignIn().isEnabled())) {
            // TODO Develop Custom Exception
            throw new RuntimeException(COMPONENT_NULL_MESSAGE);
        }
        if (!guestComponent.getSignIn().isDisplayed()) {
            clickBurger();
        }
        return guestComponent;
    }

    private GuestComponent createGuestComponent() {
        guestComponent = new GuestComponent(driver);
        return getGuestComponent();
    }

    private void clickGuestComponentSignIn() {
        getGuestComponent().clickSignIn();
        // dropdownGuest = null;
    }

    private void clickGuestComponentSignUp() {
        getGuestComponent().clickSignUp();
        // dropdownGuest = null;
    }

    protected void closeGuestComponent() {
        guestComponent = null;
    }

    // loggedComponent;
    protected LoggedComponent getLoggedComponent() {
        if ((loggedComponent == null) || (!loggedComponent.getProfile().isEnabled())) {
            // TODO Develop Custom Exception
            throw new RuntimeException(COMPONENT_NULL_MESSAGE);
        }
        if (!loggedComponent.getProfile().isDisplayed()) {
            clickBurger();
        }
        return loggedComponent;
    }

    private LoggedComponent createLoggedComponent() {
        loggedComponent = new LoggedComponent(driver);
        return getLoggedComponent();
    }

    private void clickLoggedComponentSettings() {
        getLoggedComponent().clickSettings();
        // loggedComponent = null;
    }

    private void clickLoggedComponentSignOut() {
        getLoggedComponent().clickSignOut();
        // loggedComponent = null;
    }

    protected void closeLoggedComponent() {
        loggedComponent = null;
    }

    // Functional

    // guestComponent
    public boolean isSignInAvailable() {
        return createGuestComponent() != null;
    }

    // loggedComponent;
    public String getProfileText() {
        return createLoggedComponent().getProfileText();
    }

    // Business Logic

    public WelcomePage navigateWelcome() {
        clickLogo();
        return new WelcomePage(driver);
    }

    public EconewsPage navigateEconews() {
        clickEconews();
        return new EconewsPage(driver);
    }

    public TipsTricksPage navigateTipsTricks() {
        clickTipsTricks();
        return new TipsTricksPage(driver);
    }

    public PlacesPage navigatePlaces() {
        clickPlaces();
        return new PlacesPage(driver);
    }

    public AboutPage navigateAbout() {
        clickAbout();
        return new AboutPage(driver);
    }

    public MyHabitsPage navigateMyHabits() {
        clickMyHabits();
        return new MyHabitsPage(driver);
    }

    public MyHabitsPage navigateMyHabits(User user) {
        return navigateLogin().successfulLogin(user);
    }

    public SignInPage navigateLogin() {
        // createGuestComponent().clickSignIn();
        createGuestComponent();
        clickGuestComponentSignIn();
        return new SignInPage(driver);
    }

    public WelcomePage gotoLogout() {
        createLoggedComponent();
        clickLoggedComponentSignOut();
        return new WelcomePage(driver);
    }

    //andriyc implementation
    public String getPageTitle() {
        return driver.getTitle();
    }

}
