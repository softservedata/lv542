package com.softserve.rest.business;

import com.softserve.rest.data.LoginEntity;
import com.softserve.rest.data.UserProfileEntity;
import com.softserve.rest.services.UserService;

public class LogginedLogic extends GuestLogic {

	private UserService userService;
	//
	private LoginEntity loginEntity;
	private UserProfileEntity userProfileEntity;

	public LogginedLogic(LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
		userService = new UserService();
		userProfileEntity = null;
	}

	public LoginEntity getLoginEntity() {
		return loginEntity;
	}
	
	public UserProfileEntity getUserProfileEntity() {
		if (userProfileEntity == null) {
			// TODO Developcustom Exception
			throw new RuntimeException("userProfileEntity == null");
		}
		//System.out.println(userProfileEntity);
		return userProfileEntity;
	}
	
	public LogginedLogic generateUserProfileEntity() {
		userProfileEntity = userService.getUserProfileEntity(loginEntity);
		return this;
	}
}
