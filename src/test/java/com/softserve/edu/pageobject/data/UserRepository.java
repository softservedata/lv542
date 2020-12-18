package com.softserve.edu.pageobject.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.softserve.edu.pageobject.tools.PropertiesReader;

public final class UserRepository {
    private static final String USER_CREDENTIALS = "user.properties";
    private static final String USER_PASSWORD = "password";
    private static final String SECONDS_TEMPLATE = "mmss";
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
        return new User("xdknxusqvjeovowpfk@awdrt.com", "temp",
                propertiesReader.getPropertiesByKey(USER_PASSWORD));
    }
    
    public static User getNewUser() {
        String currentSeconds = new SimpleDateFormat(SECONDS_TEMPLATE).format(new Date());
        return new User("temp@awdrt.com", "temp12" + currentSeconds,
                propertiesReader.getPropertiesByKey(USER_PASSWORD));
    }

}
