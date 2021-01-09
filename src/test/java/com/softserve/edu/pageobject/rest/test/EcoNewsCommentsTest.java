package com.softserve.edu.pageobject.rest.test;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.edu.pageobject.rest.business.LogginedLogic;
import com.softserve.edu.pageobject.rest.data.addcommentsdata.CommentEntity;
import com.softserve.edu.pageobject.rest.data.econewsallactivecommentsdata.EcoNewsCommentsRepository;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EcoNewsCommentsTest extends GreencityRestTestRunner {

    @DataProvider
    public Object[][] commentTestData() {
        return new Object[][]{
                {UserRepository.getDefault(), new EcoNewsCommentsRepository("Some Comment", 8357)},
        };
    }
    @Description("TEST DESCRIPTION: Eco news filter test")
    @Severity(SeverityLevel.MINOR)
    @Story("STORY SearchAllureTest")
    @Issue("LVTAQC542-136")
    //check comment and author in response data
    @Test(dataProvider = "commentTestData")
    public void verifyPossibilityOfAddingCommentOnTheEcoNewsPage(User existUser
            , EcoNewsCommentsRepository ecoNewsCommentsRepository) {
        logger.info("@Test verifyPossibilityOfAddingCommentOnTheEcoNewsPage");
        LogginedLogic logginedLogic = loadApplication()
                .successfulLogin(existUser)
                .generateUserProfileEntity();
        CommentEntity commentEntity = loadApplication()
                .successfulLogin(existUser)
                .writeCommentAsLoggedUser(logginedLogic.getLoginEntity(), ecoNewsCommentsRepository.getComment()
                        , ecoNewsCommentsRepository.getEcoNewsPageId());
        //check if the author of the comment is the same as existing user
        Assert.assertEquals(commentEntity.getAuthor().getName(), existUser.getName());
        //check if existing comment is the same as send
        Assert.assertEquals(commentEntity.getText(), ecoNewsCommentsRepository.getComment());
    }

    @Test(dataProvider = "commentTestData")
    public void verifyPresenceOfWrittenCommentsOnTheEcoNewsPage(User existUser
            , EcoNewsCommentsRepository ecoNewsCommentsRepository) {
        logger.info("@Test verifyPresenceOfWrittenCommentsOnTheEcoNewsPage");
        String commentAfter = loadApplication()
                .checkCommentsPresence(ecoNewsCommentsRepository.getEcoNewsPageId())
                .getPage()
                .get(0)
                .getText();
        Assert.assertEquals(ecoNewsCommentsRepository.getComment(), commentAfter);
    }
}
