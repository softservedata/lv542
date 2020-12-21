package com.softserve.edu.pageobject.test.vkuksenko;

import com.softserve.edu.pageobject.test.GreencityTestRunner;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class EcoNewsSmokeTest extends GreencityTestRunner {
    @Description("TEST DESCRIPTION: class SearchAllureTest; findByXPath().")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY SearchAllureTest")
    @Issue("LVTAQC542-115")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")

    @Step("1")
    @Test
    public void verifyPageTitleIsPresent() {
        String pageTitle = loadApplication()
                .openEcoNewsPage()
                .getPageTitle();
        logger.info("@Test verifyPageTitleIsPresent()");
        Assert.assertTrue(pageTitle.length() > 0);
    }

    @Step("2")
    @Test
    public void verifyPageTitleName() {
        String pageTitle = loadApplication()
                .openEcoNewsPage()
                .getPageTitle();
        logger.info("@Test verifyPageTitleName()");
        Assert.assertTrue(pageTitle.equals("Eco news"));
    }

    @Step("3")
    @Test
    public void verifyEcoNewsPageHeaderIsPresent() {
        String mainHeader = loadApplication()
                .openEcoNewsPage()
                .getPageTitle();
        logger.info("@Test verifyEcoNewsPageHeaderIsPresent()");
        Assert.assertTrue(mainHeader.length() > 0);
    }

    @Test
    public void verifyEcoNewsPageHeaderName() {
        String mainHeader = loadApplication()
                .openEcoNewsPage()
                .getPageTitle();
        logger.info("@Test verifyEcoNewsPageHeaderName()");
        Assert.assertTrue(mainHeader.equals("Eco news"));
    }

    public void verifyPresenceOfFilterButtons(String expectedFilterElement) {
        logger.info("@Test verifyAdsFilterButtonIsPresent() Filter button name = " + expectedFilterElement);
        boolean isButtonPresent = loadApplication()
                .openEcoNewsPage()
                .createFilterBlock()
                .areFilterButtonsPresent(expectedFilterElement);
        Assert.assertTrue(isButtonPresent);
    }

    @Test
    public void verifyAdsFilterButtonIsPresent() {
        verifyPresenceOfFilterButtons("Ads");
    }

    @Test
    public void verifyEventsFilterButtonIsPresent() {
        verifyPresenceOfFilterButtons("Events");
    }

    @Test
    public void verifyNewsFilterButtonIsPresent() {
        verifyPresenceOfFilterButtons("News");
    }

    @Test
    public void verifyEducationFilterButtonIsPresent() {
        verifyPresenceOfFilterButtons("Education");
    }

    @Test
    public void verifyInitiativesFilterButtonIsPresent() {
        verifyPresenceOfFilterButtons("Initiatives");
    }

    @Test
    public void verifyFilterByElementIsPresent() {
        logger.info("@Test verifyFilterByElementIsPresent()");
        String filterByElement = loadApplication()
                .openEcoNewsPage()
                .createFilterBlock()
                .getFilterByElement();
        Assert.assertTrue(filterByElement.equals("Filter by"));
    }

    public void verifyClickabilityOfFilterButtons(String expectedFilterButton) {
        logger.info("@Test verifyClickabilityOfFilterButtons() Filter button name = " + expectedFilterButton);
        String filterButtonClass = loadApplication()
                .openEcoNewsPage()
                .createFilterBlock()
                .getFilterButtonClass(expectedFilterButton);
        Assert.assertTrue(filterButtonClass.equals("custom-chip global-tag global-tag-clicked"));
    }

    @Test
    public void verifyAdsFilterButtonIsClickable() {
        verifyClickabilityOfFilterButtons("Ads");
    }

    @Test
    public void verifyEventsFilterButtonIsClickable() {
        verifyClickabilityOfFilterButtons("Events");
    }

    @Test
    public void verifyNewsFilterButtonIsClickable() {
        verifyClickabilityOfFilterButtons("News");
    }

    @Test
    public void verifyEducationFilterButtonIsClickable() {
        verifyClickabilityOfFilterButtons("Education");
    }

    @Test
    public void verifyInitiativesFilterButtonIsClickable() {
        verifyClickabilityOfFilterButtons("Initiatives");
    }

    private void verifyBottomMenuItemsArePresent(String expectedMenuItem) {
        logger.info("@Test verifyBottomMenuItemsArePresent() Bottom menu item = " + expectedMenuItem);
        List<String> bottomMenuItems = loadApplication()
                .openEcoNewsPage()
                .getBottomMenuItemsName();
        Assert.assertTrue(bottomMenuItems.contains(expectedMenuItem));
    }

    @Test
    public void verifyEcoNewsBottomMenuItemIsPresent() {
        verifyBottomMenuItemsArePresent("Eco news");
    }

    @Test
    public void verifyTipsAndTricksBottomMenuItemIsPresent() {
        verifyBottomMenuItemsArePresent("Tips & Tricks");
    }

    @Test
    public void verifyPlacesBottomMenuItemIsPresent() {
        verifyBottomMenuItemsArePresent("Places");
    }

    @Test
    public void verifyAboutUsBottomMenuItemIsPresent() {
        verifyBottomMenuItemsArePresent("About us");
    }

    @Test
    public void verifyMyHabitsBottomMenuItemIsPresent() {
        verifyBottomMenuItemsArePresent("My habits");
    }

    @Test
    public void verifyFollowUsElementIsPresent() {
        String followUsElement = loadApplication()
                .openEcoNewsPage()
                .getFollowUs();
        logger.info("@Test verifyFollowUsElementIsPresent()");
        Assert.assertTrue(followUsElement.length() > 0);
    }

    @Test
    public void verifyFollowUsElementName() {
        String followUsElement = loadApplication()
                .openEcoNewsPage()
                .getFollowUs();
        logger.info("@Test verifyFollowUsElementName()");
        Assert.assertTrue(followUsElement.equals("Follow us"));
    }

    @Test
    public void verifyItemsFoundParagraphIsPresent() {
        String actualItemsFoundParagraph = loadApplication()
                .openEcoNewsPage()
                .getItemsFoundParagraph();
        logger.info("@Test verifyItemsFoundParagraphIsPresent()");
        Assert.assertEquals(actualItemsFoundParagraph, "items found");
    }

    @Test
    public void verifyGridButtonIsPresent() {
        boolean isPresentGridButton = loadApplication()
                .openEcoNewsPage()
                .isPresentGridButton();
        logger.info("@Test verifyGridButtonIsPresent()");
        Assert.assertTrue(isPresentGridButton);
    }

    @Test
    public void verifyListButtonIsPresent() {
        boolean isPresentListButton = loadApplication()
                .openEcoNewsPage()
                .isPresentListButton();
        logger.info("@Test verifyListButtonIsPresent()");
        Assert.assertTrue(isPresentListButton);
    }

    @Test
    public void verifyListButtonIsClickable() {
        boolean isClickableListButton = loadApplication()
                .openEcoNewsPage()
                .isListButtonClickable();
        logger.info("@Test verifyListButtonIsClickable()");
        Assert.assertTrue(isClickableListButton);
    }

    @Test
    public void verifyGridButtonIsClickable() {
        boolean isClickableGridButton = loadApplication()
                .openEcoNewsPage()
                .isGridButtonClickable();
        logger.info("@Test verifyGridButtonIsClickable()");
        Assert.assertTrue(isClickableGridButton);
    }

    @Test
    public void verifyGreencityLogoIsClickable() {
        String welcomePageLeftHeader = loadApplication()
                .openEcoNewsPage()
                .isGreenCityLogoClickable()
                .getFirstHeaderText();
        logger.info("@Test verifyGreencityLogoIsClickable()");
        Assert.assertTrue("A new way to cultivate useful habits".equals(welcomePageLeftHeader));
    }

    @Test
    public void verifyGreencityLogoIsPresent() {
        boolean isGreencityLogoPresent = loadApplication()
                .openEcoNewsPage()
                .isGreenCityLogoPresent();
        logger.info("@Test verifyGreencityLogoIsPresent()");
        Assert.assertTrue(isGreencityLogoPresent);
    }
}
