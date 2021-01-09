package com.softserve.edu.pageobject.rest.data.signupdata;

public class SignUpEntity {
    private int userId;
    private String username;
    private String email;
    private boolean ownRegistrations;

    public SignUpEntity(int userId, String username, String email, boolean ownRegistrations) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.ownRegistrations = ownRegistrations;
    }

    public int getSignUpUserId() {
        return userId;
    }

    public String getSignUpUsername() {
        return username;
    }

    public String getSignUpEmail() {
        return email;
    }

    public boolean isSignUpOwnRegistrations() {
        return ownRegistrations;
    }

    @Override
    public String toString() {
        return "SignUpEntity [userId=" + userId
                + ", username=" + username
                + ", email=" + email
                + ", ownRegistrations=" + ownRegistrations + "]";
    }
}
