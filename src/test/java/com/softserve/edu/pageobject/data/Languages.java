package com.softserve.edu.pageobject.data;

public enum Languages {
    EN("En"),
    UA("Ua"),
    RU("Ru");
    //
    private String name;

    private Languages(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
