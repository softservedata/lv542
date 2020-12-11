package com.softserve.edu.pageobject.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTestAboutPage extends GreencityTestRunner {

    @Test
    public void verifyPageMainText() {
        boolean isTextOnThePage = loadApplication()
    			.navigateAbout()
    	        .isAboutUsTextDisplayed();
        Assert.assertTrue(isTextOnThePage);
    }

}
