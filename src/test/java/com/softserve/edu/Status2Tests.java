package com.softserve.edu;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Status2Tests {


    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\t@BeforeClass FirstTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\t@AfterClass FirstTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\t@BeforeMethod FirstTest");

    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        System.out.println("\t\t\t@AfterMethod FirstTest");
        if (!result.isSuccess()) {
            System.out.println("***TC error, name = " + result.getName() + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to;
            // previous state, logout, etc.
        }
    }

    @Test
    public void f1() {
        System.out.println("\t\t\t\t@Test f1() FirstTest");
    }

    @Test
    public void f2() {
        System.out.println("\t\t\t\t@Test f1() FirstTest");
        Assert.assertTrue(false);
    }
}
