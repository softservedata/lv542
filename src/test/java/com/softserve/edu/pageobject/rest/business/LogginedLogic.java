package com.softserve.edu.pageobject.rest.business;

import com.softserve.edu.pageobject.rest.data.LoginEntity;
import com.softserve.edu.pageobject.rest.data.UserProfileEntity;
import com.softserve.edu.pageobject.rest.data.addcommentsdata.CommentEntity;
import com.softserve.edu.pageobject.rest.services.EcoNewsCommentsService;
import com.softserve.edu.pageobject.rest.services.UserService;

public class LogginedLogic extends GuestLogic {

	private UserService userService;
	//
	private LoginEntity loginEntity;
	private UserProfileEntity userProfileEntity;
	private EcoNewsCommentsService ecoNewsCommentsService;

	public LogginedLogic(LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
		userService = new UserService();
		userProfileEntity = null;
		ecoNewsCommentsService = new EcoNewsCommentsService();
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

	public CommentEntity writeCommentAsLoggedUser(LoginEntity loginEntity, String comment, long newsId) {
		return ecoNewsCommentsService.getCommentData(loginEntity, comment, newsId);
	}
}
