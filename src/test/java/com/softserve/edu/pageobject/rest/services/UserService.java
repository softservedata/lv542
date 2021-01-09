package com.softserve.edu.pageobject.rest.services;

import java.io.IOException;

import com.google.gson.reflect.TypeToken;
import com.softserve.edu.pageobject.rest.data.LoginEntity;
import com.softserve.edu.pageobject.rest.data.UserProfileEntity;

import okhttp3.Request;
import okhttp3.Response;

public class UserService extends TopService {

    public UserService() {
        super();
    }

    // Get user profile

    protected String jsonUserProfile(LoginEntity loginEntity) {
        Response response = null;
        String textBody = null;
        Request request = new Request.Builder()
                .url(serverUrl + "/user/" + loginEntity.getUserId() + "/profile/")
                .header("accept", "*/*")
                .header("Authorization", "Bearer " + loginEntity.getAccessToken())
                .get()
                .build();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            // Save log
            // TODO Develop custom Exception
            throw new RuntimeException("userProfile Request Error, loginEntity = " + loginEntity, e);
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        // if (!response.isSuccessful()) {
        if (response == null) {
            // TODO Develop custom Exception
            throw new RuntimeException("userProfile Error, response == null");
        }
        try {
            textBody = response.body().string();
        } catch (IOException e) {
            // Save log
            // TODO Develop custom Exception
            throw new RuntimeException("userProfile Error, response = " + response, e);
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return textBody;
    }

    public UserProfileEntity getUserProfileEntity(LoginEntity loginEntity) {
        return gson.fromJson(jsonUserProfile(loginEntity), new TypeToken<UserProfileEntity>(){}.getType());
    }
}
