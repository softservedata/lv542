package com.softserve.edu.pageobject.test.vkuksenko;

import com.softserve.edu.pageobject.test.GreencityTestRunner;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class EcoNewsSmokeTest extends GreencityTestRunner {
    @Description("TEST DESCRIPTION: Eco news smoke test")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY SearchAllureTest")
    @Issue("LVTAQC542-115")
    @Link(name = "LINK to Greencity site", url = "https://ita-social-projects.github.io/GreenCityClient/")

    @Test
    public void verifyPageTitleIsPresent() {
        String pageTitle = loadApplication()
                .openEcoNewsPage()
                .getPageTitle();
        logger.info("@Test verifyPageTitleIsPresent()");
        Assert.assertTrue(pageTitle.length() > 0);
    }

    @Test
    public void verifyPageTitleName() {
        String pageTitle = loadApplication()
                .openEcoNewsPage()
                .getPageTitle();
        logger.info("@Test verifyPageTitleName()");
        Assert.assertTrue(pageTitle.equals("Eco news"));
    }

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

    private void verifyPresenceOfFilterButtons(String expectedFilterElement) {
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
        logger.info("@Test verifyFollowUsElementIsPresent()");
        String followUsElement = loadApplication()
                .openEcoNewsPage()
                .getFollowUs();
        Assert.assertTrue(followUsElement.length() > 0);
    }

    @Test
    public void verifyFollowUsElementName() {
        logger.info("@Test verifyFollowUsElementName()");
        String followUsElement = loadApplication()
                .openEcoNewsPage()
                .getFollowUs();
        Assert.assertTrue(followUsElement.equals("Follow us"));
    }

    @Test
    public void verifyItemsFoundParagraphIsPresent() {
        logger.info("@Test verifyItemsFoundParagraphIsPresent()");
        String actualItemsFoundParagraph = loadApplication()
                .openEcoNewsPage()
                .getItemsFoundParagraph();
        Assert.assertEquals(actualItemsFoundParagraph, "items found");
    }

    @Test
    public void verifyGridButtonIsPresent() {
        logger.info("@Test verifyGridButtonIsPresent()");
        boolean isPresentGridButton = loadApplication()
                .openEcoNewsPage()
                .isGridButtonPresent();
        Assert.assertTrue(isPresentGridButton);
    }

    @Test
    public void verifyListButtonIsPresent() {
        logger.info("@Test verifyListButtonIsPresent()");
        boolean isPresentListButton = loadApplication()
                .openEcoNewsPage()
                .isListButtonPresent();
        Assert.assertTrue(isPresentListButton);
    }

    @Test
    public void verifyListButtonIsClickable() {
        logger.info("@Test verifyListButtonIsClickable()");
        boolean isClickableListButton = loadApplication()
                .openEcoNewsPage()
                .isListButtonClickable();
        Assert.assertTrue(isClickableListButton);
    }

    @Test
    public void verifyGridButtonIsClickable() {
        logger.info("@Test verifyGridButtonIsClickable()");
        boolean isClickableGridButton = loadApplication()
                .openEcoNewsPage()
                .isGridButtonClickable();
        Assert.assertTrue(isClickableGridButton);
    }

    @Test
    public void verifyGreencityLogoIsClickable() {
        logger.info("@Test verifyGreencityLogoIsClickable()");
        String welcomePageLeftHeader = loadApplication()
                .openEcoNewsPage()
                .isGreenCityLogoClickable()
                .getFirstHeaderText();
        Assert.assertTrue("A new way to cultivate useful habits".equals(welcomePageLeftHeader));
    }

    @Test
    public void verifyGreencityLogoIsPresent() {
        logger.info("@Test verifyGreencityLogoIsPresent()");
        boolean isGreencityLogoPresent = loadApplication()
                .openEcoNewsPage()
                .isGreenCityLogoPresent();
        Assert.assertTrue(isGreencityLogoPresent);
    }
}
