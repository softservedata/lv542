package com.softserve.edu.pageobject.rest.test.imartyniuk;

import com.softserve.edu.pageobject.rest.data.LoginErrorEntity;
import com.softserve.edu.pageobject.rest.data.signupdata.SignUpErrorEntity;
import com.softserve.edu.pageobject.rest.test.GreencityRestTestRunner;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.List;

public class SignUpRestTest extends GreencityRestTestRunner {

    @Description("TEST DESCRIPTION: ")
    @Severity(SeverityLevel.BLOCKER)
    @Story("STORY SearchAllureTest")
    @Issue("LVTAQC542-134")
    @Link(name = "LINK to Greencity site", url = "https://ita-social-projects.github.io/GreenCityClient/#/news")
    @Test
    public void signUpTestByRestWithIncorrectData() {
        List<SignUpErrorEntity> loginErrorEntity = loadApplication().getSignUpErrorEntity("temptemp@", "ihr", "ihor001" );
        System.out.println(loginErrorEntity.toString());
    }
}