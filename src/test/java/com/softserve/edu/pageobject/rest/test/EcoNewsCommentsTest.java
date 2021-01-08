package com.softserve.edu.pageobject.rest.test;

import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.data.UserRepository;
import com.softserve.edu.pageobject.rest.business.LogginedLogic;
import com.softserve.edu.pageobject.rest.data.addcommentsdata.CommentEntity;
import com.softserve.edu.pageobject.rest.data.econewsallactivecommentsdata.EcoNewsCommentsRepository;
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

    // Login
    //type some comment
    //logout
    //Check if comment is present

    //check comment and author in response data //verify
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
    public void verifyPossibilityOfAddingCommentOnTheEcoNewsPage1(User existUser, EcoNewsCommentsRepository ecoNewsCommentsRepository) {
        String commentAfter = loadApplication()
                .checkCommentsPresence(ecoNewsCommentsRepository.getEcoNewsPageId())
                .getPage()
                .get(0)
                .getText();
        Assert.assertEquals(ecoNewsCommentsRepository.getComment(), commentAfter);
    }

    //1. додаю коментар , перевірити чи автор співпадає з юзером існуючим і текст комента відповідає відправленому
    //2. витягнути коменти по id  і перевірити чи він існує
}
