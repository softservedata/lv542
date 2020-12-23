package com.softserve.edu.pageobject.test.dganushkevych;

import com.softserve.edu.pageobject.pages.econews.FilterBlock;
import com.softserve.edu.pageobject.test.GreencityTestRunner;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Owner(value = "OWNER DIANA")
@Epic("EPIC FUNCTIONAL")
public class FilterTestEcoNewsPage  extends GreencityTestRunner {

    public void verifyFilterCoupleTest(String firstFilter, String secondFilter) {
        boolean isLabelsCorrect = openHomePage()
                .openEcoNewsPage()
                .activateTwoFilters(firstFilter, secondFilter)
                .goToNewsSection()
                .areNewsSortedByFilters(firstFilter, secondFilter);

        FilterBlock filters = new FilterBlock(getDriver());
        filters.deactivateAllFilters();

        Assert.assertTrue(isLabelsCorrect);
    }

    @Description("TEST DESCRIPTION: FILTER TEST ECO NEWS PAGE")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY Check Eco News Page")
    @Issue("LVTAQC542-82")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    @Test
    public void verifyFilterEventsAdsTest() throws Exception {
        verifyFilterCoupleTest("Events", "Ads");
    }

    @Test
    public void verifyFilterEventsInitiativesTest() throws Exception {
        verifyFilterCoupleTest("Events", "Initiatives");
    }

    @Test
    public void verifyFilterEventsEducationTest() throws Exception {
        verifyFilterCoupleTest("Events", "Education");
    }

    @Test
    public void verifyFilterEventsNewsTest() throws Exception {
        verifyFilterCoupleTest("Events", "News");
    }

    @Test
    public void verifyFilterAdsInitiativesTest() throws Exception {
        verifyFilterCoupleTest("Ads", "Initiatives");
    }

    @Test
    public void verifyFilterEducationAdsTest() throws Exception {
        verifyFilterCoupleTest("Ads", "Education");
    }

    @Test
    public void verifyFilterNewsAdsTest() throws Exception {
        verifyFilterCoupleTest("Ads", "News");
    }

    @Test
    public void verifyFilterNewsEducationTest() throws Exception {
        verifyFilterCoupleTest("News", "Education");
    }

    @Test
    public void verifyFilterNewsInitiativesTest() throws Exception {
        verifyFilterCoupleTest("News", "Initiatives");
    }

    @Test
    public void verifyFilterEducationInitiativesTest() throws Exception {
        verifyFilterCoupleTest("Education", "Initiatives");
    }

}
