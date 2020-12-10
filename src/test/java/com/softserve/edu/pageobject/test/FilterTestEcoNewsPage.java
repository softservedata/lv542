package com.softserve.edu.pageobject.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTestEcoNewsPage  extends GreencityTestRunner {

    // couldn't try to run the test - greencity the best(not answering)
    //@Test
    public void checkFilter() throws InterruptedException {
        boolean isLabelsCorrect = loadApplication()
                .navigateEconews()
                .clickOnFilterContainer("News", "Ads")
                .createNewsContainer()
                .checkFiltersWithNews("News", "Ads");

        Assert.assertTrue(isLabelsCorrect);
    }

}
