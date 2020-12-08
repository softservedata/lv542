package com.softserve.edu.pageobject.data;

import com.softserve.edu.pageobject.tools.PropertiesReader;

public final class UserRepository {
    private static final String USER_CREDENTIALS = "user.properties";
    private static final String USER_PASSWORD = "password";
    private static PropertiesReader propertiesReader;

    static {
        propertiesReader = new PropertiesReader(USER_CREDENTIALS);
    }

    private UserRepository() {
    }

    public static User getDefault() {
        return getCustomer();
    }

    public static User getCustomer() {
        return new User("xdknxusqvjeovowpfk@awdrt.com",
                propertiesReader.getPropertiesByKey(USER_PASSWORD));
    }

}
