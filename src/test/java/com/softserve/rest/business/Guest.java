package com.softserve.rest.business;

import com.softserve.edu.pageobject.data.User;
import com.softserve.rest.data.LoginEntity;
import com.softserve.rest.services.SecurityServices;

public class Guest {
	
	private SecurityServices securityServices;
	
	public Guest() {
		securityServices = new SecurityServices();
	}
	
	public Loggined successfulLogin(User existUser) {
		LoginEntity loginEntity = securityServices.loginEntitySignIn(existUser);
		return new Loggined(loginEntity);
	}
	
	public Guest unsuccessfulLogin(User invalidUser) {
		securityServices.loginEntitySignIn(invalidUser);
		return this;
	}
	
}
