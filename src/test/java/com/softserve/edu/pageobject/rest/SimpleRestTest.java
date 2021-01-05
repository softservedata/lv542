package com.softserve.edu.pageobject.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

class GitHubSimple {

    private String login;
    private String id;
    private String name;

    public GitHubSimple(String login, String id, String name) {
        this.login = login;
        this.id = id;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GitHubSimple ["
                + " login=" + login
                + ", id=" + id
                + ", name=" + name
                + " ]";
    }
}

class GitHubDifficult {

	private long id;
    private String description;
    private String homepage;
    private String language;

    public GitHubDifficult(long id, String description, String homepage, String language) {
        this.id = id;
        this.description = description;
        this.homepage = homepage;
        this.language = language;
    }

    public long getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "\ngitHubDifficult ["
        		+ " id = " + id
                + " description = " + description
                + ", homepage = " + homepage
                + ", language = " + language
                + " ]";
    }
}

//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

class LoginEntity {

	private int userId;
	private String accessToken;
	private String refreshToken;
	private String name;
	private boolean ownRegistrations;
	
	public LoginEntity(int userId, String accessToken, String refreshToken, String name, boolean ownRegistrations) {
		this.userId = userId;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.name = name;
		this.ownRegistrations = ownRegistrations;
	}

	public int getUserId() {
		return userId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public String getName() {
		return name;
	}

	public boolean isOwnRegistrations() {
		return ownRegistrations;
	}

	@Override
	public String toString() {
		return "LoginEntity [userId=" + userId
				+ ", accessToken=" + accessToken
				+ ", refreshToken=" + refreshToken
				+ ", name=" + name
				+ ", ownRegistrations=" + ownRegistrations + "]";
	}
}

class UserProfile {

	private String firstName;
	private String userCredo;
	private String role;
	
	public UserProfile(String firstName, String userCredo, String role) {
		this.firstName = firstName;
		this.userCredo = userCredo;
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getUserCredo() {
		return userCredo;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserProfile [firstName=" + firstName
				+ ", userCredo=" + userCredo
				+ ", role=" + role
				+ "]";
	}
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

public class SimpleRestTest {
	
	@Test
    public void checkGithubSimple() throws Exception {
        Gson gson = new Gson();
        GitHubSimple gitHubSimple;
        //
        OkHttpClient client = new OkHttpClient();
        Request request;
        Response response;
        String resultJson;
        //
        // Get TokenLifetime
        request = new Request.Builder()
                .url("https://api.github.com/orgs/dotnet")
                .get()
                .build();
        response = client.newCall(request).execute();
        resultJson = response.body().string();
        gitHubSimple = gson.fromJson(resultJson, GitHubSimple.class);
        //
        Assert.assertTrue(response.isSuccessful());
        System.out.println("resultJson: " + resultJson);
        System.out.println("gitHubSimple: " + gitHubSimple);
        //
    }

    //@Test
    public void checkGithubDifficult() throws Exception {
        Gson gson = new Gson();
        List<GitHubDifficult> gitHubDifficult;
        //
        OkHttpClient client = new OkHttpClient();
        Request request;
        Response response;
        String resultJson;
        //
        // Get TokenLifetime
        request = new Request.Builder()
                .url("https://api.github.com/orgs/dotnet/repos")
                .get()
                .build();
        response = client.newCall(request).execute();
        resultJson = response.body().string();
        gitHubDifficult = gson.fromJson(resultJson, new TypeToken<List<GitHubDifficult>>(){}.getType());
        //
        Assert.assertTrue(response.isSuccessful());
        System.out.println("resultJson: " + resultJson);
        System.out.println("gitHubSimple: " + gitHubDifficult);
        //
    }
    
    @Test
  	public void checkLoginGreenCity() throws Exception {
  		OkHttpClient client = new OkHttpClient();
  		RequestBody formBody;
  		Request request;
  		Response response;
  		String textBody;
  		//
  		Gson gson = new Gson();
  		LoginEntity loginEntity;
  		//List<UserGoalsEntity> userGoalsEntities;
  		//
  		//
  		// login
  		formBody = RequestBody.create(MediaType.parse("application/json"),
  				"{\"email\":\"xdknxusqvjeovowpfk@awdrt.com\", \"password\":\"Temp#001\"}");
//  		formBody = new FormBody.Builder()
//  				.add("email", "xdknxusqvjeovowpfk@awdrt.com")
//  				.add("password", "Temp#001")
//  				.build();
  		request = new Request.Builder()
  				.url("https://greencity.azurewebsites.net/ownSecurity/signIn")
  				.header("accept", "*/*")
  				//.addHeader("Content-Type", "application/json")
  				.post(formBody)
  				.build();
  		response = client.newCall(request).execute();
  		textBody = response.body().string();
  		//
  		System.out.println("Http Code: " + response.code());
  		System.out.println("JSON = " + textBody);
  		//loginEntity = gson.fromJson(textBody, LoginEntity.class);
  		loginEntity = gson.fromJson(textBody, new TypeToken<LoginEntity>(){}.getType());
  		System.out.println(loginEntity);
  		//
  		//
  		// Get user profile.
  		request = new Request.Builder()
  				.url("https://greencity.azurewebsites.net/user/" + loginEntity.getUserId() + "/profile/")
  				.header("accept", "*/*")
  				.header("Authorization", "Bearer " + loginEntity.getAccessToken())
  				.get()
  				.build();
  		response = client.newCall(request).execute();
  		textBody = response.body().string();
  		//
  		System.out.println("Http Code: " + response.code());
  		System.out.println("JSON = " + textBody);
  		//
  		//Type type = new TypeToken<List<UserGoalsEntity>>(){}.getType();
  		//Type type = new GenericConverter<List<UserGoalsEntity>>(){}.getGenericType();
  		//String typeStr = type.toString();
  		//System.out.println("+++typeStr=" + typeStr);
  		//Type type2 = Class.forName(typeStr, false, ClassLoader.getSystemClassLoader()); // Error
  		//String typeStr2 = type.toString();
  		//System.out.println("+++typeStr2=" + typeStr2);
  		//@SuppressWarnings("unchecked")
  		//Class<List<UserGoalsEntity>> cls = (Class<List<UserGoalsEntity>>)(Object)List.class;
  		//Class<List<UserGoalsEntity>> cls = (Class<List<UserGoalsEntity>>) new ArrayList<UserGoalsEntity>().getClass();
  		//System.out.println("+++cls=" + ((Type) cls).toString());
  		//
  		//userGoalsEntities = gson.fromJson(textBody, new TypeToken<List<UserGoalsEntity>>(){}.getType());
  		//userGoalsEntities = gson.fromJson(textBody, type);
  		//userGoalsEntities = gson.fromJson(textBody, (Type) Class.forName(typeStr));
  		//System.out.println(userGoalsEntities);
  		UserProfile userProfile = gson.fromJson(textBody, UserProfile.class);
  		System.out.println(userProfile);
  	}
    
}
