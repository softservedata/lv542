package com.softserve.edu.pageobject.test.dganushkevych;

import com.softserve.edu.pageobject.test.GreencityTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Owner(value = "OWNER DIANA")
@Epic("EPIC UI")
public class SmokeTestAboutPage extends GreencityTestRunner {

    @Description("TEST DESCRIPTION: SMOKE TEST ABOUT US PAGE")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY Check About As Page")
    @Issue("LVTAQC542-106")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    @Test
    public void verifyAboutPageIsOpened() {
        logger.info("@Test verifyPageMainText() start");
        boolean isTextOnThePage = openHomePage()
                .openAboutUsPage()
                .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }

    @Description("TEST DESCRIPTION: SMOKE TEST ABOUT US PAGE SIGN IN WINDOW")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY Check About As Page")
    @Issue("LVTAQC542-107")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    @Test
    public void verifySignInPageIsOpened() {
        boolean isTextOnThePage = openHomePage()
                .openAboutUsPage()
                .openSignInWindow()
                .closeSignInWindowOpenAboutPage()
                .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }


    @Description("TEST DESCRIPTION: SMOKE TEST ABOUT US PAGE PLACES PAGE")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY Check About As Page")
    @Issue("LVTAQC542-113")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    @Test
    public void verifyPlacesPageIsOpened() {
        boolean isTextOnThePage = openHomePage()
                .openAboutUsPage()
                .openPlacesPageFromAboutPage()
                .openAboutUsPage()
                .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }

    @Description("TEST DESCRIPTION: SMOKE TEST ABOUT US PAGE HOME PAGE")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY Check About As Page")
    @Issue("LVTAQC542-105")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    @Test
    public void verifyHomePageIsOpened() {
        boolean isTextOnThePage = openHomePage()
                .openAboutUsPage()
                .openWelcomePageFromAboutPage()
                .openAboutUsPage()
                .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }

    @Test
    public void verifyTipsTricksPageIsOpened() {
        boolean isTextOnThePage = openHomePage()
                .openAboutUsPage()
                .openTipsTricksPageFromAboutPage()
                .openAboutUsPage()
                .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }

}
