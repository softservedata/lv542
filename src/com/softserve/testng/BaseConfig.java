package com.softserve.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseConfig {
    
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite BaseConfig");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite BaseConfig");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("\t@BeforeTest BaseConfig");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("\t@AfterTest BaseConfig");
    }
}
