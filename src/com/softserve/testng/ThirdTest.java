package com.softserve.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ThirdTest {
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t@AfterMethod ThirdTest");
    }

    @Test
    public void f1() {
        System.out.println("\t\t\t\t@Test f1() ThirdTest");
    }
}
