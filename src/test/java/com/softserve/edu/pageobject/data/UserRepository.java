package com.softserve.edu.pageobject.data;

import com.softserve.edu.pageobject.tools.PropertiesReader;

public final class UserRepository {
    private static final String USER_CREDENTIALS_FILE = "user.properties";
    private static final String USER_PASSWORD_KEY = "password";
    private static PropertiesReader propertiesReader;

    static {
        propertiesReader = new PropertiesReader(USER_CREDENTIALS_FILE);
    }

    private UserRepository() {
    }

    public static User getDefault() {
        return getCustomer();
    }

    public static User getCustomer() {
        return new User("xdknxusqvjeovowpfk@awdrt.com", "temp",
                propertiesReader.getPropertiesByKey(USER_PASSWORD_KEY));
    }

}
