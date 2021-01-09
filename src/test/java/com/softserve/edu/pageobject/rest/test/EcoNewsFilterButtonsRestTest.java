package com.softserve.edu.pageobject.rest.test;

import com.softserve.edu.pageobject.rest.business.EcoNewsLogic;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EcoNewsFilterButtonsRestTest extends GreencityRestTestRunner {

    public void filterButtonsTest(String expectedFilterButton) {
        logger.info("@Test filterButtonsTest filter button name = " + expectedFilterButton);
        List<String> actualFilterButtons = new EcoNewsLogic()
                .activateFilterButton(expectedFilterButton)
                .getPages()
                .get(0)
                .getTags();
//        System.out.println(new EcoNewsLogic().activateFilterButton(expectedFilterButton).toString());
        Assert.assertTrue(actualFilterButtons.contains(expectedFilterButton));
    }

    @Description("TEST DESCRIPTION: Eco news tags test")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY SearchAllureTest")
    @Issue("LVTAQC542-135")
    @Link(name = "LINK to Greencity site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    @Test
    public void verifyNewsTagIsPresentInResponseBody() {
        filterButtonsTest("News");
    }

    @Test
    public void verifyAdsTagIsPresentInResponseBody() {
        filterButtonsTest("Ads");
    }

    @Test
    public void verifyEventsTagIsPresentInResponseBody() {
        filterButtonsTest("Events");
    }

    @Test
    public void verifyInitiativesTagIsPresentInResponseBody() {
        filterButtonsTest("Initiatives");
    }

    @Test
    public void verifyEducationTagIsPresentInResponseBody() {
        filterButtonsTest("Education");
    }
}
