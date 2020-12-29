package com.softserve.rest.services;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softserve.edu.pageobject.data.User;
import com.softserve.rest.data.LoginEntity;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SecurityServices {
	//
	private final String SERVER_SERVICES = "https://greencity.azurewebsites.net";
	//
	private OkHttpClient client;
	private Gson gson;

	public SecurityServices() {
		client = new OkHttpClient();
		gson = new Gson();
	}

	protected String jsonSignIn(User existUser) {
		Response response = null;
		String textBody = null;
		RequestBody formBody = RequestBody.create(MediaType.parse("application/json"),
				"{\"email\":\"" + existUser.getEmail() + "\", \"password\":\"" + existUser.getPassword() + "\"}");
		Request request = new Request.Builder().url(SERVER_SERVICES + "/ownSecurity/signIn").header("accept", "*/*")
				.post(formBody).build();
		try {
			response = client.newCall(request).execute();
			textBody = response.body().string();
		} catch (IOException e) {
			// Save log
			// TODO Developcustom Exception
			throw new RuntimeException("signIn Request Error, user = " + existUser);
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		// TODO
		if (!response.isSuccessful()) {
			// TODO Developcustom Exception
			throw new RuntimeException("signIn Error, textBody = " + textBody);
		}
		return textBody;
	}
	
	public LoginEntity loginEntitySignIn(User existUser) {
		return gson.fromJson(jsonSignIn(existUser), new TypeToken<LoginEntity>(){}.getType());
	}

}
