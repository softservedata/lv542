package com.softserve.edu.pageobject.test.andriyc;

import com.softserve.edu.pageobject.pages.econews.EconewsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import com.softserve.edu.pageobject.test.GreencityTestRunner;
import org.testng.annotations.Test;

public class MenuLoggedOutUserTest extends GreencityTestRunner {
    @Test
    void verifyEcoNewMenuTargetPageTitleCompliance() {
        EconewsPage ecoNewsPage = loadApplication()
                .navigateEconews()
    }
}
