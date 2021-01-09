package com.softserve.edu.pageobject.rest.data.signupdata;

public class SignUpErrorEntity {
    private String name;
    private String message;

    public SignUpErrorEntity(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SignUpErrorEntity{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}