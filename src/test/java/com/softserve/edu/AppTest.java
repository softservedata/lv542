package com.softserve.edu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTest {

    @BeforeClass
    public void beforeClass(ITestContext context) {
        // From testNG.xml
        System.out.println("\t\t+++class TestNGTest6 @BeforeClass");
        for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
            System.out.println("\t\t*** parameter: key=" + entry.getKey() + " value=" + entry.getValue());
        }
    }
    
    @Test
    public void testApp() {
        Assert.assertTrue(true);
        System.out.println("***class AppTest testApp() done");
    }
 

    //@Test
    @Parameters(value = "number")
    public void parameterIntTest(int number) {
        // From testNG.xml
        System.out.println("Parameterized Number is: " + (number + 1));
    }

    @Test
    public void checkApp() {
        // From Maven
        System.out.println("***surefire.application.password = " + System.getProperty("surefire.application.password"));
        // From OS
        System.out.println("***System.getenv().MY_PASSWORD = " + System.getenv().get("MY_PASSWORD"));
        // From Eclipse/Idea
        System.out.println("***System.getenv().MY_IDE = " + System.getenv().get("MY_IDE"));
    }
    
    @Test
    public void checkCSV() {
        String fileName = "./target/test-classes/users.csv";
        //String fileName = AppTest.class.getResource("/users.csv").getPath();
        System.out.println("fileName = " + fileName.substring(1));
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String s = null;
            System.out.println("Read data from file: " + fileName);
            while ((s = br.readLine()) != null) {
                System.out.println("+++read: " + s);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }

}
