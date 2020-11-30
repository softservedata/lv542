package com.softserve.edu.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {
    private static Calc calc = null;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("@BeforeClass");
        calc = new Calc();
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("@AfterClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("\t@Before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\t@After");
    }

    @Test
    public void testAdd1() {
        System.out.println("\t\t@Test testAdd1()");
        // fail("Not yet implemented");
        double actual;
        double expected;
        // 
        expected = 4;
        actual = calc.add(2, 2);
        Assert.assertEquals("message-1", expected, actual, 0.001);
    }

    @Test
    public void testAdd2() {
        System.out.println("\t\t@Test testAdd2()");
        //
        double actual;
        double expected;
        //
        expected = 5;
        actual = calc.add(3, 2);
        //Assert.assertEquals(expected, actual);
        Assert.assertEquals("message-2", expected, actual, 0.001);
    }

}
