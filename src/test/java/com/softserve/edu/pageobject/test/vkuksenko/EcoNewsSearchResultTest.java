package com.softserve.edu.pageobject.test.vkuksenko;

import com.softserve.edu.pageobject.test.GreencityTestRunner;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcoNewsSearchResultTest extends GreencityTestRunner {

    @Description("TEST DESCRIPTION: Verify clickability of search result")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY SearchAllureTest")
    @Issue("LVTAQC542-131")
    @Link(name = "LINK to Greencity site", url = "https://ita-social-projects.github.io/GreenCityClient/")

    private void verifyClickabilityFirstSearchResult(String filterButton) {
        logger.info("@Test verifyClickabilityFirstSearchResult Filter button name = " + filterButton);
        String mainHeader = loadApplication()
                .openEcoNewsPage()
                .createFilterBlock()
                .activateFilterButtonByName(filterButton)
                .getFirstNewsComponent()
                .activateBackToNewsButton()
                .deactivateFilterButton()
                .getMainHeaderText();
        Assert.assertEquals(mainHeader, "Eco news");
    }

    @Test
    public void verifyResultOfSearchUsingAdsFilterButtonIsClickable() {
        verifyClickabilityFirstSearchResult("Ads");
    }

    @Test
    public void verifyResultOfSearchUsingEventsFilterButtonIsClickable() {
        verifyClickabilityFirstSearchResult("Events");
    }

    @Test
    public void verifyResultOfSearchUsingNewsFilterButtonIsClickable() {
        verifyClickabilityFirstSearchResult("News");
    }

    @Test
    public void verifyResultOfSearchUsingEducationFilterButtonIsClickable() {
        verifyClickabilityFirstSearchResult("Education");
    }

    @Test
    public void verifyResultOfSearchUsingInitiativesFilterButtonIsClickable() {
        verifyClickabilityFirstSearchResult("Initiatives");
    }
}
