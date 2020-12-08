package com.softserve.edu.pageobject.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    
    @Test(dataProvider = "users")
    public void checkLogin(User user) {
        MyHabitsPage myHabitsPage = loadApplication()
                .navigateLogin()
                .successfulLogin(user);
    }
    
}
