package com.softserve.edu.pageobject.rest.test;

import com.softserve.edu.pageobject.rest.business.EcoNewsLogic;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EcoNewsFilterButtonsRestTest extends GreencityRestTestRunner {

    @Description("TEST DESCRIPTION: Eco news filter test")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY SearchAllureTest")
    @Issue("LVTAQC542-115")
    @Link(name = "LINK to Greencity site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    public void filterButtonsTest(String expectedFilterButton) {
        logger.info("@Test filterButtonsTest filter button name = " + expectedFilterButton);
        List<String> actualFilterButtons = new EcoNewsLogic()
                .activateFilterButton(expectedFilterButton)
                .getPages()
                .get(0)
                .getTags();
        System.out.println(new EcoNewsLogic().activateFilterButton(expectedFilterButton).toString());
        Assert.assertTrue(actualFilterButtons.contains(expectedFilterButton));
    }

    @Test
    public void verifyNewsFilterButtonIsPresent() {
        filterButtonsTest("News");
    }

    @Test
    public void verifyAdsFilterButtonIsPresent() {
        filterButtonsTest("Ads");
    }

    @Test
    public void verifyEventsFilterButtonIsPresent() {
        filterButtonsTest("Events");
    }

    @Test
    public void verifyInitiativesFilterButtonIsPresent() {
        filterButtonsTest("Initiatives");
    }

    @Test
    public void verifyEducationFilterButtonIsPresent() {
        filterButtonsTest("Education");
    }
}
