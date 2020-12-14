package com.softserve.edu.pageobject.test.andriyc;

import com.softserve.edu.pageobject.pages.econews.EconewsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import com.softserve.edu.pageobject.test.GreencityTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuLoggedOutUserTest extends GreencityTestRunner {
    @Test
    void verifyEcoNewsMenuTargetPageTitleCompliance() {
        String actualEcoNewsPageTitle = loadApplication()
                .navigateEconews()
                .getPageTitle();

        Assert.assertEquals(actualEcoNewsPageTitle, "Eco news");
    }

    @Test
    void verifyTipsTricksMenuTargetPageTitleCompliance() {
        String actualTipsTricksPageTitle = loadApplication()
                .navigateTipsTricks()
                .getPageTitle();

        Assert.assertEquals(actualTipsTricksPageTitle, "Tips & Tricks");
    }

    @Test
    void verifyPlacesMenuTargetPageTitleCompliance() {
        String actualPlacesPageTitle = loadApplication()
                .navigatePlaces()
                .getPageTitle();

        Assert.assertEquals(actualPlacesPageTitle, "Places");
    }

    @Test
    void verifyAboutUsMenuTargetPageTitleCompliance() {
        String actualAboutUsPageTitle = loadApplication()
                .navigateAbout()
                .getPageTitle();

        Assert.assertEquals(actualAboutUsPageTitle, "About us");
    }

}
