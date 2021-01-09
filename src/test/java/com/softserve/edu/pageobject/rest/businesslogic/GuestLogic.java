package com.softserve.edu.pageobject.rest.businesslogic;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.rest.data.LoginEntity;
import com.softserve.edu.pageobject.rest.data.LoginErrorEntity;
import com.softserve.edu.pageobject.rest.data.signupdata.SignUpErrorEntity;
import com.softserve.edu.pageobject.rest.services.SecurityServices;
import com.softserve.edu.pageobject.rest.services.SignUpServices;

import java.util.List;

public class GuestLogic {

    public static final String USER_NOT_EXIST = "The user does not exist by this email:";

    private SecurityServices securityServices;
    private LoginErrorEntity loginErrorEntity;
    private SignUpServices signUpServices ;

    public GuestLogic() {
        securityServices = new SecurityServices();
        loginErrorEntity = null;
        signUpServices = new SignUpServices();
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

    public List<SignUpErrorEntity> getSignUpErrorEntity(String email, String name, String password ) {
        return signUpServices.registrationEntitySignUp(email, name, password);
    }

}
