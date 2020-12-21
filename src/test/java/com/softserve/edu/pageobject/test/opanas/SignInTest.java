package com.softserve.edu.pageobject.test.opanas;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.edu.pageobject.pages.myhabits.MyHabitsPage;
import com.softserve.edu.pageobject.test.GreencityTestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends GreencityTestRunner {
    private final String EXPECTED_MYHABITS_Title="TAQC team uses this account for automated tests.";
    private final String EXPECTED_CHOSE_ACCOUNT_TITLE="Виберіть обліковий запис";
    @DataProvider(name = "users")
    public Object[][] users() {
        return new Object[][] {
                { UserRepository.getDefault() }
        };
    }

    @Test(dataProvider = "users")
    public void verifySignInWithValidEmailAndPassword(User user){
        String actualTempUserName=loadApplication()
                .navigateLogin()
                .successfulLogin(user)
                .actualAccountDescription();
        Assert.assertEquals(actualTempUserName,EXPECTED_MYHABITS_Title);
    }
   @Test
   public void verifyLoginViaGmail(){
        MyHabitsPage actualGmailText=loadApplication()
                .navigateLogin()
                .successfulGmailLogin()
                .getChoseAccountText();
        Assert.assertEquals(actualGmailText,EXPECTED_CHOSE_ACCOUNT_TITLE);

   }

}
