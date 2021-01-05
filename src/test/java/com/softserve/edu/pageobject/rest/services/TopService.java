package com.softserve.edu.pageobject.rest.services;

import com.google.gson.Gson;
import com.softserve.edu.pageobject.rest.test.GreencityRestTestRunner;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TopService {

	protected final Logger logger;
	protected OkHttpClient client;
	protected Gson gson;
	protected String serverUrl;

	public TopService() {
		client = new OkHttpClient();
		gson = new Gson();
		serverUrl = GreencityRestTestRunner.BASE_SERVER_URL;
		logger = LoggerFactory.getLogger(this.getClass());
	}
}
