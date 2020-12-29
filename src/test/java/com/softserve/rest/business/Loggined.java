package com.softserve.rest.business;

import com.softserve.rest.data.LoginEntity;

public class Loggined extends Guest {
	
	private LoginEntity loginEntity;
	
	public Loggined(LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}

}
