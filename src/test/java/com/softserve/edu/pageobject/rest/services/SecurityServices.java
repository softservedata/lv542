package com.softserve.edu.pageobject.rest.services;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softserve.edu.pageobject.data.User;
import com.softserve.edu.pageobject.rest.data.LoginEntity;
import com.softserve.edu.pageobject.rest.data.LoginErrorEntity;
import com.softserve.edu.pageobject.rest.test.GreencityRestTestRunner;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SecurityServices extends TopService {

    public SecurityServices() {
        super();
    }

    // login

    protected String jsonSignIn(User existUser) {
        Response response = null;
        String textBody = null;
        RequestBody formBody = RequestBody.create(MediaType.parse("application/json"),
                "{\"email\":\"" + existUser.getEmail()
                        + "\", \"password\":\"" + existUser.getPassword() + "\"}");
        Request request = new Request.Builder()
                .url(serverUrl + "/ownSecurity/signIn")
                .header("accept", "*/*")
                .post(formBody)
                .build();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            // Save log
            // TODO Develop custom Exception
            throw new RuntimeException("signIn Request Error, user = " + existUser, e);
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        //if (!response.isSuccessful()) {
        if (response == null) {
            // TODO Develop custom Exception
            throw new RuntimeException("signIn Error, response == null");
        }
        try {
            textBody = response.body().string();
        } catch (IOException e) {
            // Save log
            // TODO Develop custom Exception
            throw new RuntimeException("signIn Error, response = " + response, e);
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return textBody;
    }

    public LoginEntity loginEntitySignIn(User existUser) {
        return gson.fromJson(jsonSignIn(existUser), new TypeToken<LoginEntity>(){}.getType());
    }

    public LoginErrorEntity loginErrorEntitySignIn(User invalidUser) {
        return gson.fromJson(jsonSignIn(invalidUser), new TypeToken<LoginErrorEntity>(){}.getType());
    }

}
