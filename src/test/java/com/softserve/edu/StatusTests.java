package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StatusTests {
    private String testMethod;
    private boolean testStatus;

    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\t@BeforeClass FirstTest");
        testMethod = "";
        testStatus = true;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\t@AfterClass FirstTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\t@BeforeMethod FirstTest");
        testStatus = false;

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t@AfterMethod FirstTest");
        if (!testStatus) {
            System.out.println("TC error, name = " + testMethod);
        }
    }

    @Test
    public void f1() {
        testMethod = "f1";
        System.out.println("\t\t\t\t@Test f1() FirstTest");
        testStatus = true;
    }

    @Test
    public void f2() {
        testMethod = "f2";
        System.out.println("\t\t\t\t@Test f1() FirstTest");
        Assert.assertTrue(false);
        testStatus = true;
    }
}
