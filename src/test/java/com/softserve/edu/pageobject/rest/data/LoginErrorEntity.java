package com.softserve.edu.pageobject.rest.data;

public class LoginErrorEntity {
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public LoginErrorEntity(String timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "LoginErrorEntity [timestamp=" + timestamp
                + ", status=" + status
                + ", error=" + error
                + ", message=" + message
                + ", path=" + path
                + "]";
    }

}
