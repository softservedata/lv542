package com.softserve.edu.pageobject.rest.services;

import com.softserve.edu.pageobject.rest.data.econewsdata.FirstNewsEntity;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class EcoNewsServices extends TopService{
    public EcoNewsServices() {
        super();
    }

    public String getTheFirstNews(String filterName) {
        Response response;
        String textBody;
        Request request = new Request
                .Builder()
//                .url(serverUrl + "/econews/tags?page=0&size=1&tags=" + filterName)
                .url(String.format("%s/econews/tags?page=0&size=1&tags=%s", serverUrl, filterName))
                .header("accept", "*/*")
                .get()
                .build();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            // Save log
            logger.error("Request Error");
            // TODO Developcustom Exception
            throw new RuntimeException(String.format("getTheFirstNews Request Error, filter = ", filterName));
            // TODO Auto-generated catch block
        }

        if (response == null) {
            // TODO Developcustom Exception
            throw new RuntimeException("getTheFirstNews Error, response == null");
        }

        try {
            textBody = response.body().string();
        } catch (IOException e) {
            // Save log
            logger.error("Response Error");
            // TODO Developcustom Exception
            throw new RuntimeException("getTheFirstNews Error, response = " + response, e);
            // TODO Auto-generated catch block
        }
        return textBody;
    }

    //DESERIALIZATION
    public FirstNewsEntity getFirstNewsEntity(String filterName) {
        return gson.fromJson(getTheFirstNews(filterName), FirstNewsEntity.class);
    }
}
