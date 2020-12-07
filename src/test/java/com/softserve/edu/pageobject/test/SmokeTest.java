package com.softserve.edu.pageobject.test;

import java.awt.Dimension;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.pageobject.pages.welcome.WelcomePage;

public class SmokeTest extends GreencityTestRunner {

    @Test
    public void checkMenu() {
        // Precondition
        //setWindowSize(640, 480);
        //setWindowSize(480, 640);
        //
        // Steps
        WelcomePage welcomePage = loadApplication()
            .navigateEconewsPage()
            .navigateTipsTricksPage()
            .navigatePlacesPage()
            .navigateAboutPage()
            .navigateWelcomePage();
        //
        // Check
        Assert.assertEquals(welcomePage.getButtonStartAttributeClass(),
                WelcomePage.HEADER_LEFT_ATTRIBUTE);
    }
}
