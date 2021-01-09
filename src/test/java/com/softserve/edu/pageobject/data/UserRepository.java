package com.softserve.edu.pageobject.data;

import com.softserve.edu.pageobject.tools.PropertiesReader;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class UserRepository {
    private static final String USER_CREDENTIALS_FILE = "user.properties";
    private static final String USER_PASSWORD_KEY = "password";
    private static final String SECONDS_TEMPLATE = "mmss";
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

    public static User getNewUser() {
        String currentSeconds = new SimpleDateFormat(SECONDS_TEMPLATE).format(new Date());
        return new User("temp@awdrt.com", "temp12" + currentSeconds,
                propertiesReader.getPropertiesByKey(USER_PASSWORD_KEY));
    }

    public static User getInvalidUser() {
        return new User("abc@abc.com", "temp11", "qwerty");
    }

}
