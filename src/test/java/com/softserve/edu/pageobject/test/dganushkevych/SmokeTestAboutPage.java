package com.softserve.edu.pageobject.test.dganushkevych;

import com.softserve.edu.pageobject.test.GreencityTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTestAboutPage extends GreencityTestRunner {

    @Test
    public void verifyPageMainText() {
        boolean isTextOnThePage = loadApplication()
    			.openAboutUsPage()
    	        .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }

}
