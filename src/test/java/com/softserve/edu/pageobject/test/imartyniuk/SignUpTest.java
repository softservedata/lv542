package com.softserve.edu.pageobject.test.imartyniuk;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import com.softserve.edu.pageobject.test.GreencityTestRunner;
import com.softserve.edu.pageobject.tools.PropertiesReader;
import io.qameta.allure.*;
//import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpTest extends GreencityTestRunner {
    @DataProvider
    public Object[][] newUsers() {
        return new Object[][] {
                { UserRepository.getNewUser() },
        };
    }

    @Description("TEST DESCRIPTION: class SearchAllureTest; findByXPath().")
    @Severity(SeverityLevel.BLOCKER)
    @Story("STORY SearchAllureTest")
    @Issue("LVTAQC542-95")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    @Test(dataProvider = "newUsers")
    public void checkSignUp(User newUser) {
        //User newUser = UserRepository.getNewUser();
        logger.info("@Test checkSignUp() start, user = " + newUser);
        MyHabitsPage myHabitsPage = loadApplication()
                .openSignUpPage()
                .successfulSignUp(newUser)
                .successfulLogin(newUser);
        Assert.assertEquals(myHabitsPage.getProfileText(),
                newUser.getName());
        WelcomePage welcomePage = myHabitsPage.logOut();
        Assert.assertTrue(welcomePage.isSignInAvailable());
    }

    //@Test(dataProvider = "users")
    public void checkMyHabits(User user) {
        logger.info("@Test checkMyHabits() start, user = " + user);
        WelcomePage welcomePage = loadApplication();
        Assert.assertEquals(welcomePage.getFirstButtonAttributeClass(),
                WelcomePage.HEADER_LEFT_ATTRIBUTE);
        Assert.assertTrue(welcomePage.isSignInAvailable());
    }
}
