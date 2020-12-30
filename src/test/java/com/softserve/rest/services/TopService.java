package com.softserve.rest.services;

import com.google.gson.Gson;
import com.softserve.rest.test.GreencityRestTestRunner;

import okhttp3.OkHttpClient;

public abstract class TopService {
	
	protected OkHttpClient client;
	protected Gson gson;
	//
	protected String serverUrl;
	
	public TopService() {
		client = new OkHttpClient();
		gson = new Gson();
		serverUrl = GreencityRestTestRunner.BASE_SERVER_URL;
	}
	
}
