package com.softserve.edu.pageobject.rest.business;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.rest.data.LoginEntity;
import com.softserve.edu.pageobject.rest.data.LoginErrorEntity;
import com.softserve.edu.pageobject.rest.services.SecurityServices;

public class GuestLogic {
	
	public static final String USER_NOT_EXIST = "The user does not exist by this email:";
	
	private SecurityServices securityServices;
	private LoginErrorEntity loginErrorEntity;
	
	public GuestLogic() {
		securityServices = new SecurityServices();
		loginErrorEntity = null;
	}
	
	public LoginErrorEntity getLoginErrorEntity() {
		if (loginErrorEntity == null) {
			// TODO Developcustom Exception
			throw new RuntimeException("loginErrorEntity == null");
		}
		//System.out.println(loginErrorEntity);
		return loginErrorEntity;
	}
	 
	public LogginedLogic successfulLogin(User existUser) {
		LoginEntity loginEntity = securityServices.loginEntitySignIn(existUser);
		return new LogginedLogic(loginEntity);
	}
	
	public GuestLogic unsuccessfulLogin(User invalidUser) {
		loginErrorEntity = securityServices.loginErrorEntitySignIn(invalidUser);
		return this;
	}
	
}
