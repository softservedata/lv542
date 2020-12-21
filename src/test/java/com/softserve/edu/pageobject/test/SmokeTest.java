package com.softserve.edu.pageobject.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.pageobject.data.Languages;
import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

public class SmokeTest extends GreencityTestRunner {

    //@Test
    public void checkMenu() {
        // Precondition
        //setWindowSize(640, 480);
        //setWindowSize(480, 640);
        //
        // Steps
        WelcomePage welcomePage = openHomePage()
            .openEcoNewsPage()
            .openTipsTricksPage()
            .openPlacesPage()
            .openAboutUsPage()
            .openWelcomePage();
        //
        // Check
        Assert.assertEquals(welcomePage.getFirstButtonAttributeClass(),
                WelcomePage.HEADER_LEFT_ATTRIBUTE);
    }
    
    @DataProvider//(parallel = true)
    public Object[][] users() {
        return new Object[][] {
            { UserRepository.getDefault() },
        };
    }
    
    //@Test(dataProvider = "users")
    public void checkLogin(User user) {
        MyHabitsPage myHabitsPage = openHomePage()
                .openSignInPage()
                .successfulLogin(user);
        Assert.assertEquals(myHabitsPage.getProfileText(),
                user.getName());
        WelcomePage welcomePage = myHabitsPage.logOut();
        Assert.assertTrue(welcomePage.isSignInAvailable());
    }
    
    //@Test(dataProvider = "users")
    public void checkMyHabits(User user) {
        // Steps
        WelcomePage welcomePage = openHomePage()
            .openMyHabitsPage(user)
            .openAddHabitsPage()
            .openEcoNewsPage()
            .openTipsTricksPage()
            .openPlacesPage()
            .openAboutUsPage()
            .openMyHabitsPage()
            .openWelcomePage()
            .logOut();
        //
        // Check
        Assert.assertEquals(welcomePage.getFirstButtonAttributeClass(),
                WelcomePage.HEADER_LEFT_ATTRIBUTE);
        Assert.assertTrue(welcomePage.isSignInAvailable());
    }
    
    @DataProvider//(parallel = true)
    public Object[][] languages() {
        return new Object[][] {
            { Languages.UA },
            { Languages.EN },
        };
    }
    
    @Test(dataProvider = "languages")
    public void checkLanguage(Languages languageName) {
        // Steps
        WelcomePage welcomePage = openHomePage()
                .chooseLanguage(languageName);
        //
        // Check
        Assert.assertTrue(welcomePage.isValidLocalization(languageName));
    }
    
}
