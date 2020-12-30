package com.softserve.rest.data;

import java.util.List;

class SocialNetworkImage {
	private long id;
	private String imagePath;
	private String hostPath;

	public SocialNetworkImage(long id, String imagePath, String hostPath) {
		this.id = id;
		this.imagePath = imagePath;
		this.hostPath = hostPath;
	}

	public long getId() {
		return id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getHostPath() {
		return hostPath;
	}

	@Override
	public String toString() {
		return "SocialNetworkImage [id=" + id
				+ ", imagePath=" + imagePath
				+ ", hostPath=" + hostPath
				+ "]";
	}
}

class SocialNetwork {
	private long id;
	private String url;
	private SocialNetworkImage socialNetworkImage;
	
	public SocialNetwork(long id, String url, SocialNetworkImage socialNetworkImage) {
		this.id = id;
		this.url = url;
		this.socialNetworkImage = socialNetworkImage;
	}

	public long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public SocialNetworkImage getSocialNetworkImage() {
		return socialNetworkImage;
	}

	@Override
	public String toString() {
		return "SocialNetwork [id=" + id
				+ ", url=" + url
				+ ", socialNetworkImage=" + socialNetworkImage + "]";
	}
}

public class UserProfileEntity {
	public static final String ROLE_USER = "ROLE_USER";
	//
	private String profilePicturePath;
	private String firstName;
	private String city;
	private String userCredo;
	private List<SocialNetwork> socialNetworks;
	private String showLocation;
	private String showEcoPlace;
	private String showShoppingList;
	private String rating;
	private String role;
	
	public UserProfileEntity(String profilePicturePath, String firstName, String city, String userCredo,
			List<SocialNetwork> socialNetworks, String role, String showLocation, String showEcoPlace,
			String showShoppingList, String rating) {
		this.profilePicturePath = profilePicturePath;
		this.firstName = firstName;
		this.city = city;
		this.userCredo = userCredo;
		this.socialNetworks = socialNetworks;
		this.showLocation = showLocation;
		this.showEcoPlace = showEcoPlace;
		this.showShoppingList = showShoppingList;
		this.rating = rating;
		this.role = role;
	}

	public static String getRoleUser() {
		return ROLE_USER;
	}

	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getCity() {
		return city;
	}

	public String getUserCredo() {
		return userCredo;
	}

	public List<SocialNetwork> getSocialNetworks() {
		return socialNetworks;
	}

	public String getShowLocation() {
		return showLocation;
	}

	public String getShowEcoPlace() {
		return showEcoPlace;
	}

	public String getShowShoppingList() {
		return showShoppingList;
	}

	public String getRating() {
		return rating;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserProfileEntity [profilePicturePath=" + profilePicturePath
				+ ", firstName=" + firstName
				+ ", city="	+ city
				+ ", userCredo=" + userCredo
				+ ", socialNetworks=" + socialNetworks
				+ ", showLocation=" + showLocation
				+ ", showEcoPlace=" + showEcoPlace
				+ ", showShoppingList="	+ showShoppingList
				+ ", rating=" + rating
				+ ", role=" + role
				+ "]";
	}
	
}
