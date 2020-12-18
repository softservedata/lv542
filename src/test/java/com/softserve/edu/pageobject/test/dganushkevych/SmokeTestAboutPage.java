package com.softserve.edu.pageobject.test.dganushkevych;

import com.softserve.edu.pageobject.test.GreencityTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Owner(value = "OWNER First name")
@Epic("EPIC AllureTest")
@Feature("FEATURE SearchAllureTes")
public class SmokeTestAboutPage extends GreencityTestRunner {

    @Description("TEST DESCRIPTION: class SearchAllureTest; findByXPath().")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY SearchAllureTest")
    @Issue("SSITAGT-1")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    @TmsLink(value = "TL-678")
    @Test
    public void verifyPageMainText() {
        logger.info("@Test verifyPageMainText() start");
        boolean isTextOnThePage = loadApplication()
    			.openAboutUsPage()
    	        .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }

    @Test
    public void verifySignInPageIsOpened() {
        boolean isTextOnThePage = loadApplication()
                .openAboutUsPage()
                .getSignInPageFormHabitButton()
                .openAboutPageWithClose()
                .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }


    @Test
    public void verifyPlacesPageIsOpened() {
        boolean isTextOnThePage = loadApplication()
                .openAboutUsPage()
                .getPlacesPage()
                .openAboutUsPage()
                .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }

    @Test
    public void verifyTipsTricksPageIsOpened() {
        boolean isTextOnThePage = loadApplication()
                .openAboutUsPage()
                .getTipsTricksPage()
                .openAboutUsPage()
                .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }


    @Test
    public void verifyHomePageIsOpened() {
        boolean isTextOnThePage = loadApplication()
                .openAboutUsPage()
                .getWelcomePage()
                .openAboutUsPage()
                .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }


}
