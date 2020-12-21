package com.softserve.edu.pageobject.test.andriyc;

import com.softserve.edu.pageobject.test.GreencityTestRunner;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class headerResizeTest extends GreencityTestRunner {
    private final int DEFAULT_WINDOW_HEIGHT = 700;
    private final int WINDOW_WIDTH_900 = 900;
    private final int WINDOW_WIDTH_850 = 850;
    private final int WINDOW_WIDTH_500 = 500;

    private boolean areAllMenuItemsAvailable() {
        try {
            openHomePage()
                    .openEcoNewsPage()
                    .openTipsTricksPage()
                    .openPlacesPage()
                    .openAboutUsPage()
                    .openMyHabitsPageLoggedOutUser();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Test
    void verifyHeaderLeftMenuBlockAppearance_inWindowWidth_900px() {
        setWindowSize(WINDOW_WIDTH_900, DEFAULT_WINDOW_HEIGHT);
        Assert.assertTrue(areAllMenuItemsAvailable());
    }

    @Test
    void verifySignInLinkAppearance_inWindowWidth_900px() {
        setWindowSize(WINDOW_WIDTH_900, DEFAULT_WINDOW_HEIGHT);
        Assert.assertTrue(openHomePage()
                .isSignInAvailable());
    }

    @Test
    void verifyHeaderLeftMenuBlockAppearance_inWindowWidth_850px() {
        setWindowSize(WINDOW_WIDTH_850, DEFAULT_WINDOW_HEIGHT);
        Assert.assertTrue(areAllMenuItemsAvailable());
    }

    @Test
    void verifySignInLinkAppearance_inWindowWidth_850px() {
        setWindowSize(WINDOW_WIDTH_850, DEFAULT_WINDOW_HEIGHT);
        Assert.assertTrue(openHomePage()
                .isSignInAvailable());
    }

    @Test
    void verifyHeaderLeftMenuBlockAppearance_inWindowWidth_500px() {
        setWindowSize(WINDOW_WIDTH_500, DEFAULT_WINDOW_HEIGHT);
        Assert.assertTrue(areAllMenuItemsAvailable());
    }

    @Test
    void verifySignInLinkAppearance_inWindowWidth_500px() {
        setWindowSize(WINDOW_WIDTH_500, DEFAULT_WINDOW_HEIGHT);
        Assert.assertTrue(openHomePage()
                .isSignInAvailable());
    }

}
