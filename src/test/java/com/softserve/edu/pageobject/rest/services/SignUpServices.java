package com.softserve.edu.pageobject.rest.services;

import com.google.gson.reflect.TypeToken;
import com.softserve.edu.pageobject.rest.data.signupdata.SignUpErrorEntity;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class SignUpServices extends TopService {
    public SignUpServices() {
        super();
    }

    protected String jsonSignUp(String email, String name, String password) {
        Response response = null;
        String textBody = null;
        RequestBody formBody = RequestBody.create(MediaType.parse("application/json"),
                "{ \"email\": \""+ email +"\", \"name\": \""+ name +"\", \"password\": \""+ password +"\"}");
        Request request = new Request.Builder()
                .url(serverUrl + "/ownSecurity/signUp")
                .header("accept", "*/*")
                .post(formBody)
                .build();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            // Save log
            // TODO Develop custom Exception
            throw new RuntimeException("signUp Request Error, user = " + e);
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        //if (!response.isSuccessful()) {
        if (response == null) {
            // TODO Develop custom Exception
            throw new RuntimeException("signUp Response Error, response == null");
        }
        try {
            textBody = response.body().string();
        } catch (IOException e) {
            // Save log
            // TODO Develop custom Exception
            throw new RuntimeException("signUp Response Error, response = " + response, e);
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return textBody;
    }

    public List<SignUpErrorEntity> registrationEntitySignUp(String email, String name, String password) {
        return gson.fromJson(jsonSignUp(email, name, password), new TypeToken<List<SignUpErrorEntity>>(){}.getType());
    }

}

