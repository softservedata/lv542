package com.softserve.edu.pageobject.test.imartyniuk;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import com.softserve.edu.pageobject.test.GreencityTestRunner;
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

    @Description("TEST DESCRIPTION: class SignUpTest; findByCssSelector().")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register user through ten minutes mail")
    @Issue("LVTAQC542-133")
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
}
