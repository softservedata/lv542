package com.softserve.edu.pageobject.rest.services;

import com.softserve.edu.pageobject.rest.data.LoginEntity;
import com.softserve.edu.pageobject.rest.data.addcommentsdata.CommentEntity;
import com.softserve.edu.pageobject.rest.data.econewsallactivecommentsdata.ActiveCommentsEntity;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class EcoNewsCommentsService extends TopService {

    public EcoNewsCommentsService() {
        super();
    }

    protected String getJsonResultOfCommentsAddingByNewsId(LoginEntity loginEntity, String comment, long newsId) {
        Response response = null;
        String textBody = null;
        RequestBody formBody = RequestBody.create(MediaType.parse("application/json"),
                "{ \"parentCommentId\": 0, \"text\": \"" + comment + "\"}");
        Request request = new Request.Builder()
                .url(serverUrl + "/econews/comments/" + newsId)
                .header("accept", "*/*")
                .header("Authorization", "Bearer " + loginEntity.getAccessToken())
                .post(formBody)
                .build();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            // Save log
            logger.error("getJsonResultOfCommentsAddingByNewsId Error");
            // TODO Developcustom Exception
            throw new RuntimeException("getJsonResultOfCommentsAddingByNewsId Request Error, user = " + loginEntity, e);
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        //if (!response.isSuccessful()) {
        if (response == null) {
            // TODO Developcustom Exception
            throw new RuntimeException("getJsonResultOfCommentsAddingByNewsId Error, response == null");
        }
        try {
            textBody = response.body().string();
        } catch (IOException e) {
            // Save log
            logger.error("getJsonResultOfCommentsAddingByNewsId Error");
            // TODO Developcustom Exception
            throw new RuntimeException("getJsonResultOfCommentsAddingByNewsId Error, response = " + response, e);
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return textBody;
    }

    protected String getJsonOfAllActiveCommentsByNewsId(long id) {
        Response response;
        String textBody;
        Request request = new Request
                .Builder()
                .url(String.format("%s/econews/comments/active?ecoNewsId=%s&page=0&size=5", serverUrl, id))
                .header("accept", "*/*")
                .get()
                .build();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            // Save log
            logger.error("Request getJsonOfAllActiveCommentsByNewsId Error");
            // TODO Developcustom Exception
            throw new RuntimeException(String.format("getJsonOfAllActiveCommentsByNewsId Request Error, filter = ", id));
            // TODO Auto-generated catch block
        }

        if (response == null) {
            // TODO Developcustom Exception
            throw new RuntimeException("getJsonOfAllActiveCommentsByNewsId Error, response == null");
        }

        try {
            textBody = response.body().string();
        } catch (IOException e) {
            // Save log
            logger.error("Response getJsonOfAllActiveCommentsByNewsId Error");
            // TODO Developcustom Exception
            throw new RuntimeException("getJsonOfAllActiveCommentsByNewsId Error, response = " + response, e);
            // TODO Auto-generated catch block
        }
        return textBody;
    }

    public CommentEntity getCommentData(LoginEntity loginEntity, String comment, long newsId) {
        return gson.fromJson(getJsonResultOfCommentsAddingByNewsId(loginEntity, comment, newsId), CommentEntity.class);
    }

    public ActiveCommentsEntity getActiveCommentsEntity(long newsId) {
        return gson.fromJson(getJsonOfAllActiveCommentsByNewsId(newsId), ActiveCommentsEntity.class);
    }


//    public static void main(String[] args) {
//        User u1 = new User("xdknxusqvjeovowpfk@awdrt.com", "temp", "Temp#001");
//        LogginedLogic logginedLogic = new GuestLogic().successfulLogin(u1).generateUserProfileEntity();
////        System.out.println(logginedLogic.getLoginEntity().getAccessToken());
////        String result = new EcoNewsCommentsService().getJsonResultOfCommentsAddingByNewsId(logginedLogic.getLoginEntity(), "lol", 8137);
////        System.out.println(result);
////        System.out.println(new EcoNewsCommentsService().getResultOfCommentAddingByNewsId(logginedLogic.getLoginEntity(), "lol", 8137).toString());
//        System.out.println(new EcoNewsCommentsService().getActiveCommentsEntity(8137).toString());
//    }

}
