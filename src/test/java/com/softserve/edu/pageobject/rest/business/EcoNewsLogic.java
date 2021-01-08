package com.softserve.edu.pageobject.rest.business;

import com.softserve.edu.pageobject.rest.data.LoginEntity;
import com.softserve.edu.pageobject.rest.data.addcommentsdata.CommentEntity;
import com.softserve.edu.pageobject.rest.data.econewsallactivecommentsdata.ActiveCommentsEntity;
import com.softserve.edu.pageobject.rest.data.econewsdata.FirstNewsEntity;
import com.softserve.edu.pageobject.rest.services.EcoNewsCommentsService;
import com.softserve.edu.pageobject.rest.services.EcoNewsServices;

public class EcoNewsLogic {

    private EcoNewsServices ecoNewsServices;
    private EcoNewsCommentsService ecoNewsCommentsService;

    public EcoNewsLogic() {
        ecoNewsServices = new EcoNewsServices();
        ecoNewsCommentsService = new EcoNewsCommentsService();
    }

    public FirstNewsEntity activateFilterButton(String filterName) {
        return ecoNewsServices.getFirstNewsEntity(filterName);
    }

    public CommentEntity writeCommentAsLoggedUser(LoginEntity loginEntity, String comment, long newsId) {
        return ecoNewsCommentsService.getCommentData(loginEntity, comment, newsId);
    }

    public ActiveCommentsEntity checkCommentsPresence(long newsId) {
        return ecoNewsCommentsService.getActiveCommentsEntity(newsId);
    }

}
