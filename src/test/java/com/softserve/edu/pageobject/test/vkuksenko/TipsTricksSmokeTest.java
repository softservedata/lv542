package com.softserve.edu.pageobject.test.vkuksenko;

import com.softserve.edu.pageobject.test.GreencityTestRunner;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TipsTricksSmokeTest extends GreencityTestRunner {

    @Test
    public void verifyPageTitleIsPresent() {
        logger.info("@Test verifyPageTitleIsPresent()");
        boolean isPresentPageTitle = loadApplication()
                .openTipsTricksPage()
                .isPageTitlePresent();
        Assert.assertTrue(isPresentPageTitle);
    }

    @Test
    public void verifyPageTitleName() {
        logger.info("@Test verifyPageTitleName()");
        String pageTitleName = loadApplication()
                .openTipsTricksPage()
                .getPageTitleText();
        Assert.assertTrue(pageTitleName.equals("Tips & Tricks"));
    }

    @Test
    public void verifyMainHeaderIsPresent() {
        logger.info("@Test verifyMainHeaderIsPresent()");
        boolean isPresentMainHeader = loadApplication()
                .openTipsTricksPage()
                .isMainHeaderPresent();
        Assert.assertTrue(isPresentMainHeader);
    }

    @Test
    public void verifyMainHeaderName() {
        logger.info("@Test verifyMainHeaderName()");
        String mainHeader = loadApplication()
                .openTipsTricksPage()
                .getMainHeaderText();
        Assert.assertTrue(mainHeader.equals("Tips & Tricks"));
    }

    @Test
    public void verifyLeftTipCardItemParagraphIsPresent() {
        logger.info("@Test verifyLeftTipCardItemParagraphIsPresent()");
        boolean isParagraphPresent = loadApplication()
                .openTipsTricksPage()
                .openTipCardSection()
                .isLeftTipCardParagraphPresent();
        Assert.assertTrue(isParagraphPresent);
    }

    @Test
    public void verifyMiddleTipCardItemParagraphIsPresent() {
        logger.info("@Test verifyMiddleTipCardItemParagraphIsPresent()");
        boolean isParagraphPresent = loadApplication()
                .openTipsTricksPage()
                .openTipCardSection()
                .isMiddleTipCardParagraphPresent();
        Assert.assertTrue(isParagraphPresent);
    }

    @Test
    public void verifyRightTipCardItemParagraphIsPresent() {
        logger.info("@Test verifyRightTipCardItemParagraphIsPresent()");
        boolean isParagraphPresent = loadApplication()
                .openTipsTricksPage()
                .openTipCardSection()
                .isRightTipCardParagraphPresent();
        Assert.assertTrue(isParagraphPresent);
    }

//    @Test
//    public void verifyHiddenTipCardItemParagraphIsPresent() {
//        boolean isParagraphPresent = loadApplication()
//                .openTipsTricksPage()
//                .openTipCardSection()
//                .isHiddenTipCardParagraphPresent();
//        Assert.assertTrue(isParagraphPresent);
//    }

    @Test
    public void verifyBottleImageIsPresent() {
        logger.info("@Test verifyBottleImageIsPresent()");
        boolean isImagePresent = loadApplication()
                .openTipsTricksPage()
                .openTipCardSection()
                .isBottleImagePresent();
        Assert.assertTrue(isImagePresent);
    }

    @Test
    public void verifySpoonForkKnifeImageIsPresent() {
        logger.info("@Test verifySpoonForkKnifeImageIsPresent()");
        boolean isImagePresent = loadApplication()
                .openTipsTricksPage()
                .openTipCardSection()
                .isSpoonForkKnifeImagePresent();
        Assert.assertTrue(isImagePresent);
    }

    @Test
    public void verifyCoffeCupImageIsPresent() {
        logger.info("@Test verifyCoffeCupImageIsPresent()");
        boolean isImagePresent = loadApplication()
                .openTipsTricksPage()
                .openTipCardSection()
                .isCoffeCupImagePresent();
        Assert.assertTrue(isImagePresent);
    }

    @Test
    public void verifyLeftButtonIsPresent() {
        logger.info("@Test verifyLeftButtonIsPresent()");
        boolean isLeftButtonPresent = loadApplication()
                .openTipsTricksPage()
                .isPresentLeftButton();
        Assert.assertTrue(isLeftButtonPresent);
    }

    @Test
    public void verifyRightButtonIsPresent() {
        logger.info("@Test verifyRightButtonIsPresent()");
        boolean isRightButtonPresent = loadApplication()
                .openTipsTricksPage()
                .isPresentRightButton();
        Assert.assertTrue(isRightButtonPresent);
    }

    @Test
    public void verifyScrollingUsingRightButton() {
        logger.info("@Test verifyScrollingUsingRightButton()");
        String expectedParagraph = "Не ходіть до магазину голодними. Складайте список покупок заздалегідь." +
                " Тоді ви витратите менше і не купите зайвого, що потім потрібно буде викидати";
        String actualParagraph = loadApplication()
                .openTipsTricksPage()
                .activateRightButton()
                .getMiddleTipCardParagraphTextAfterRightButtonClick();
        Assert.assertTrue(!actualParagraph.equals(expectedParagraph));
    }

    @Test
    public void verifyScrollingUsingLeftButton() {
        logger.info("@Test verifyScrollingUsingLeftButton()");
        String expectedParagraph = "Не ходіть до магазину голодними. Складайте список покупок заздалегідь." +
                " Тоді ви витратите менше і не купите зайвого, що потім потрібно буде викидати";
        String actualParagraph = loadApplication()
                .openTipsTricksPage()
                .activateLeftButton()
                .getMiddleTipCardParagraphTextAfterLeftButtonClick();
        Assert.assertTrue(!actualParagraph.equals(expectedParagraph));
    }

    private void verifyBottomMenuItemsArePresent(String expectedMenuItem) {
        logger.info("@Test verifyBottomMenuItemsArePresent() Menu item = " + expectedMenuItem);
        List<String> bottomMenuItems = loadApplication()
                .openTipsTricksPage()
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
                .openTipsTricksPage()
                .getFollowUs();
        Assert.assertTrue(followUsElement.length() > 0);
    }

    @Test
    public void verifyFollowUsElementName() {
        logger.info("@Test verifyFollowUsElementName()");
        String followUsElement = loadApplication()
                .openTipsTricksPage()
                .getFollowUs();
        Assert.assertTrue(followUsElement.equals("Follow us"));
    }

    @Test
    public void verifyGreencityLogoIsClickable() {
        logger.info("@Test verifyGreencityLogoIsClickable()");
        String welcomePageLeftHeader = loadApplication()
                .openTipsTricksPage()
                .isGreenCityLogoClickable()
                .getFirstHeaderText();
        Assert.assertTrue("A new way to cultivate useful habits".equals(welcomePageLeftHeader));
    }

    @Test
    public void verifyGreencityLogoIsPresent() {
        logger.info("@Test verifyGreencityLogoIsPresent()");
        boolean isGreencityLogoPresent = loadApplication()
                .openTipsTricksPage()
                .isGreenCityLogoPresent();
        Assert.assertTrue(isGreencityLogoPresent);
    }
}
