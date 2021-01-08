package com.softserve.edu.pageobject.rest.data.econewsallactivecommentsdata;

public class AuthorEntity {
    private long id;
    private String name;
    private String userProfilePicturePath;

    public AuthorEntity(long id, String name, String userProfilePicturePath) {
        this.id = id;
        this.name = name;
        this.userProfilePicturePath = userProfilePicturePath;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserProfilePicturePath() {
        return userProfilePicturePath;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", userProfilePicturePath='" + userProfilePicturePath + '\'' + "\n" +
                '}';
    }
}
