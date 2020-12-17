package com.softserve.edu.pageobject.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Owner(value = "OWNER First name")
@Epic("EPIC Greencity Test")
@Feature("FEATURE Smoke Test")
public class SmokeTest extends GreencityTestRunner {

    //@Test
    public void checkMenu() {
        logger.info("@Test checkMenu() start");
        // Precondition
        //setWindowSize(640, 480);
        //setWindowSize(480, 640);
        //
        // Steps
        WelcomePage welcomePage = loadApplication()
            .navigateEconews()
            .navigateTipsTricks()
            .navigatePlaces()
            .navigateAbout()
            .navigateWelcome();
        //
        // Check
        Assert.assertEquals(welcomePage.getButtonStartAttributeClass(),
                WelcomePage.HEADER_LEFT_ATTRIBUTE);
    }
    
    @DataProvider//(parallel = true)
    public Object[][] users() {
        return new Object[][] {
            { UserRepository.getDefault() },
        };
    }
    
    @Description("TEST DESCRIPTION: class SearchAllureTest; findByXPath().")
    @Severity(SeverityLevel.BLOCKER)
    @Story("STORY SearchAllureTest")
    @Issue("SSITAGT-1")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    //@TmsLink(value = "TL-678")
    //@Test(dataProvider = "users")
    public void checkLogin(User user) {
        logger.info("@Test checkMenu() start, user = " + user);
        MyHabitsPage myHabitsPage = loadApplication()
                .navigateLogin()
                .successfulLogin(user);
        Assert.assertEquals(myHabitsPage.getProfileText(),
                user.getName());
        WelcomePage welcomePage = myHabitsPage.gotoLogout();
        Assert.assertTrue(welcomePage.isSignInAvailable());
    }
    
    @Description("TEST DESCRIPTION: class SearchAllureTest; findByXPath().")
    @Severity(SeverityLevel.BLOCKER)
    @Story("STORY SearchAllureTest")
    @Issue("LVTAQC542-95")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    //@TmsLink(value = "TL-678")
    @Test(dataProvider = "users")
    public void checkSignUp(User newUser) {
        logger.info("@Test checkSignUp() start, user = " + newUser);
        MyHabitsPage myHabitsPage = loadApplication()
                .navigateSignUp()
                .successfulSignUp(newUser);
        Assert.assertEquals(myHabitsPage.getProfileText(),
                newUser.getName());
        WelcomePage welcomePage = myHabitsPage.gotoLogout();
        Assert.assertTrue(welcomePage.isSignInAvailable());
    }
    
    //@Test(dataProvider = "users")
    public void checkMyHabits(User user) {
        logger.info("@Test checkMyHabits() start, user = " + user);
        // Steps
        WelcomePage welcomePage = loadApplication()
            .navigateMyHabits(user)
            .gotoAddHabits()
            .navigateEconews()
            .navigateTipsTricks()
            .navigatePlaces()
            .navigateAbout()
            .navigateMyHabits()
            .navigateWelcome()
            .gotoLogout();
        //
        // Check
        Assert.assertEquals(welcomePage.getButtonStartAttributeClass(),
                WelcomePage.HEADER_LEFT_ATTRIBUTE);
        Assert.assertTrue(welcomePage.isSignInAvailable());
    }
    
    @DataProvider//(parallel = true)
    public Object[][] languages() {
        return new Object[][] {
            { Languages.UA },
            //{ Languages.EN },
        };
    }
    
    //@Test(dataProvider = "languages")
    public void checkLanguage(Languages languageName) {
        logger.info("@Test checkLanguage() start, languageName = " + languageName.toString());
        // Steps
        WelcomePage welcomePage = loadApplication()
                .chooseLanguage(languageName);
        //
        // Check
        Assert.assertTrue(welcomePage.isValidLocalization(languageName));
    }
    
}
