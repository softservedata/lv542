package com.softserve.rest.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.rest.business.GuestLogic;
import com.softserve.rest.business.LogginedLogic;

public class SmokeRestTest extends GreencityRestTestRunner {

	@DataProvider//(parallel = true)
    public Object[][] users() {
        return new Object[][] {
            { UserRepository.getDefault() },
        };
    }
	
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
	
	@Test(dataProvider = "invalidUsers")
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
