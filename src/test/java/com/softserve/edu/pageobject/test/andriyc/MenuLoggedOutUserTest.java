package com.softserve.edu.pageobject.test.andriyc;

import com.softserve.edu.pageobject.test.GreencityTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuLoggedOutUserTest extends GreencityTestRunner {
    private final String EXPECTED_ECONEWS_PAGE_TITLE = "Eco news";
    private final String EXPECTED_TIPSTRICKS_PAGE_TITLE = "Tips & Tricks";
    private final String EXPECTED_PLACES_PAGE_TITLE = "Places";
    private final String EXPECTED_ABOUTUS_PAGE_TITLE = "About us";

    @Test
    void verifyEcoNewsMenuTargetPageTitleCompliance() {
        String actualEcoNewsPageTitle = loadApplication()
                .navigateEconews()
                .getPageTitle();

        Assert.assertEquals(actualEcoNewsPageTitle, EXPECTED_ECONEWS_PAGE_TITLE);
    }

    @Test
    void verifyTipsTricksMenuTargetPageTitleCompliance() {
        String actualTipsTricksPageTitle = loadApplication()
                .navigateTipsTricks()
                .getPageTitle();

        Assert.assertEquals(actualTipsTricksPageTitle, EXPECTED_TIPSTRICKS_PAGE_TITLE);
    }

    @Test
    void verifyPlacesMenuTargetPageTitleCompliance() {
        String actualPlacesPageTitle = loadApplication()
                .navigatePlaces()
                .getPageTitle();

        Assert.assertEquals(actualPlacesPageTitle, EXPECTED_PLACES_PAGE_TITLE);
    }

    @Test
    void verifyAboutUsMenuTargetPageTitleCompliance() {
        String actualAboutUsPageTitle = loadApplication()
                .navigateAbout()
                .getPageTitle();

        Assert.assertEquals(actualAboutUsPageTitle, EXPECTED_ABOUTUS_PAGE_TITLE);
    }

}
