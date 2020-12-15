package com.softserve.edu.pageobject.test;

import com.softserve.edu.pageobject.pages.econews.FilterContainer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTestEcoNewsPage  extends GreencityTestRunner {


    public void verifyFilterCoupleTest(String firstFilter, String secondFilter) {
        boolean isLabelsCorrect = loadApplication()
                .navigateEconews()
                .clickOnFilterContainer(firstFilter, secondFilter)
                .createNewsContainer()
                .checkFiltersWithNews(firstFilter, secondFilter);

        FilterContainer filters = new FilterContainer(getDriver());
        filters.unclickFilters();

        Assert.assertTrue(isLabelsCorrect);
    }

    @Test
    public void verifyFilterEventsAdsTest()  {
        verifyFilterCoupleTest("EVENTS", "ADS");
    }

    @Test
    public void verifyFilterEventsInitiativesTest() throws Exception {
        verifyFilterCoupleTest("EVENTS", "INITIATIVES");
    }

    @Test
    public void verifyFilterEventsEducationTest() throws Exception {
        verifyFilterCoupleTest("EVENTS", "EDUCATION");
    }

    @Test
    public void verifyFilterEventsNewsTest() throws Exception {
        verifyFilterCoupleTest("EVENTS", "NEWS");
    }

    @Test
    public void verifyFilterAdsInitiativesTest() throws Exception {
        verifyFilterCoupleTest("ADS", "INITIATIVES");
    }

    @Test
    public void verifyFilterEducationAdsTest() throws Exception {
        verifyFilterCoupleTest("ADS", "EDUCATION");
    }

    @Test
    public void verifyFilterNewsAdsTest() throws Exception {
        verifyFilterCoupleTest("ADS", "NEWS");
    }

    @Test
    public void verifyFilterNewsEducationTest() throws Exception {
        verifyFilterCoupleTest("NEWS", "EDUCATION");
    }

    @Test
    public void verifyFilterNewsInitiativesTest() throws Exception {
        verifyFilterCoupleTest("NEWS", "INITIATIVES");
    }

    @Test
    public void verifyFilterEducationInitiativesTest() throws Exception {
        verifyFilterCoupleTest("EDUCATION", "INITIATIVES");
    }

}
