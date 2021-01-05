package com.softserve.rest.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.rest.business.GuestLogic;
import com.softserve.rest.business.LogginedLogic;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Owner(value = "OWNER First name")
@Epic("EPIC Greencity Test")
@Feature("FEATURE Smoke Test")
public class SmokeRestTest extends GreencityRestTestRunner {

	@DataProvider//(parallel = true)
    public Object[][] users() {
        return new Object[][] {
            { UserRepository.getDefault() },
        };
    }
	
	@Description("TEST DESCRIPTION: class SearchAllureTest; findByXPath().")
    @Severity(SeverityLevel.BLOCKER)
    @Story("STORY SearchAllureTest")
    @Issue("SSITAGT-1")
    @Link(name = "LINK goto site", url = "https://ita-social-projects.github.io/GreenCityClient/")
    //@TmsLink(value = "TL-678")
	@Test(dataProvider = "users")
	public void checkLoginGreenCity(User existUser) {
		logger.info("@Test checkLoginGreenCity() start, user = " + existUser);
		LogginedLogic logginedLogic = loadApplication()
                .successfulLogin(existUser)
                .generateUserProfileEntity();
        Assert.assertEquals(logginedLogic.getUserProfileEntity().getFirstName(),
        		existUser.getName());
	}
	
	@DataProvider//(parallel = true)
    public Object[][] invalidUsers() {
        return new Object[][] {
            { UserRepository.getInvalidUser() },
        };
    }
	
	//@Test(dataProvider = "invalidUsers")
	public void checkInvalidLoginGreenCity(User invalidUser) {
		logger.info("@Test checkLoginGreenCity() start, user = " + invalidUser);
		GuestLogic guestLogic = loadApplication()
                .unsuccessfulLogin(invalidUser);
        Assert.assertTrue(guestLogic.getLoginErrorEntity().getMessage()
        		.contains(GuestLogic.USER_NOT_EXIST));
        Assert.assertTrue(guestLogic.getLoginErrorEntity().getMessage()
        		.contains(invalidUser.getEmail()));
	}
}
