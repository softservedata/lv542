package com.softserve.edu.pageobject.test.andriyc;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.edu.pageobject.pages.GuestComponent;
import com.softserve.edu.pageobject.pages.TopPart;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.pages.welcome.WelcomePage;
import com.softserve.edu.pageobject.test.GreencityTestRunner;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class headerResizeTest extends GreencityTestRunner {

    @Test
    void verifyHeaderLeftMenuBlockAppearance_inWindowWidth900px() {

        try {
            loadApplication()
                    .navigateEconews()
                    .navigateTipsTricks()
                    .navigatePlaces()
                    .navigateAbout()
                    .navigateMyHabits(UserRepository.getDefault());
            //TODO fix a bug in navigateMyHabits() - returns new MyHabitsPage that is not applicable for not logged in users
        }
        catch (NoSuchElementException e) {
            Assert.assertTrue(false, "Menu item not found");
        }
        Assert.assertTrue(true);
    }

    @Test
    void verifySignInLinkAppearance_inWindowWidth900px() {
    //    loadApplication().getGuestComponent();
    }
}
