//package com.acit.andriichornyi.javaautomation;
//
//import org.junit.jupiter.api.Assertions;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.testng.Assert.*;
//
//public class NaturalNumberTestNG {
//
//    @BeforeMethod
//    public void setUp() {
//    }
//
//    @AfterMethod
//    public void tearDown() {
//    }
//
//    // Getter, Setter, Constructor - BOUNDARY VALUES :
//    // POSITIVE: min natural, max natural (and their String and Double literals fo Constructor only)
//    // NEGATIVE: negative Long, 0, maxLong + 1 (and their String and Double literals fo Constructor only)
//    @Test
//    public void testGetValue() {
//        //POSITIVE
//        NaturalNumber positiveMinL = new NaturalNumber(1L);
//        assertEquals(1L, positiveMinL.getValue(), "Constructor(Long = 1L), Getter - positiveMinL NaturalNumber");
//        NaturalNumber positiveMinS = new NaturalNumber("1");
//        assertEquals(1L, positiveMinS.getValue(), "Constructor(String ='1'), Getter - positiveMinS NaturalNumber");
//        NaturalNumber positiveMinD = new NaturalNumber(1.0d);
//        assertEquals(1L, positiveMinD.getValue(), "Constructor(Double = 1.0), Getter - positiveMinD NaturalNumber");
//        NaturalNumber positiveMaxL = new NaturalNumber(9223372036854775807L);
//        assertEquals(9223372036854775807L, positiveMaxL.getValue(), "Constructor(Long = 9223372036854775807L), " +
//                "Getter - positiveMaxL NaturalNumber");
//        NaturalNumber positiveMaxS = new NaturalNumber("9223372036854775807");
//        assertEquals(9223372036854775807L, positiveMaxS.getValue(), "Constructor(String = 9223372036854775807L), " +
//                "Getter - positiveMaxS NaturalNumber");
//        NaturalNumber positiveMaxD = new NaturalNumber(9223372036854775807.0d);
//        assertEquals(9223372036854775807L, positiveMaxD.getValue(), "Constructor(Double = 9223372036854775807L), " +
//                "Getter - positiveMaxD NaturalNumber");
//        //NEGATIVE
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            new NaturalNumber(-1L);
//        }, "Initializing -1L via Constructor");
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            new NaturalNumber("-1");
//        }, "Initializing '-1' String via Constructor");
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            new NaturalNumber(-1.0d);
//        }, "Initializing -1.0d via Constructor");
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            new NaturalNumber(0L);
//        }, "Initializing 0L via Constructor");
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            new NaturalNumber("0");
//        }, "Initializing '0' String via Constructor");
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            new NaturalNumber(0.0d);
//        }, "Initializing 0.0d via Constructor");
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            new NaturalNumber(9223372036854775807L+1L);
//        }, "Initializing 9223372036854775807L+1L via Constructor");
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            new NaturalNumber("9223372036854775808");
//        }, "Initializing '9223372036854775808' String via Constructor");
//        Assertions.assertDoesNotThrow(() -> {
//            new NaturalNumber(9223372036854775808125.0d);
//        }, "Initializing 9223372036854775807.0d+1.0d via Constructor");
//
//        //Setter POSITIVE
//        NaturalNumber n = new NaturalNumber(1L);
//        n.setValue(1L);
//        assertEquals(1L, n.getValue(), "Setter 1L");
//        n.setValue(9223372036854775807L);
//        assertEquals(9223372036854775807L, n.getValue(), "Setter 9223372036854775807L");
//        //Setter NEGATIVE
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            n.setValue(-1L);
//        }, "Setter -1L");
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            n.setValue(0L);
//        }, "Setter 0L");
//        Assertions.assertThrows(NumberFormatException.class,() -> {
//            n.setValue(9223372036854775807L+1L);
//        }, "Setter 9223372036854775807L + 1L");
//
//
//
//
//    }
//// Setter testing
//    @Test
//    public void testSetValue() {
//        NaturalNumber n = new NaturalNumber(1l);
//    }
//
//    @Test
//    public void testIsSimple() {
//    }
//
//    @Test
//    public void testTestIsSimple() {
//    }
//
//    @Test
//    public void testIsDividerOf() {
//    }
//
//    @Test
//    public void testGetPairedDividerFor() {
//    }
//
//    @Test
//    public void testCompareTo() {
//    }
//
//    @Test
//    public void testTestEquals() {
//    }
//
//    @Test
//    public void testAdd() {
//    }
//
//    @Test
//    public void testTestAdd() {
//    }
//
//    @Test
//    public void testTestAdd1() {
//    }
//
//    @Test
//    public void testIsPaired() {
//    }
//
//    @Test
//    public void testEndsWith6() {
//    }
//
//    @Test
//    public void testPowTo() {
//    }
//
//    @Test
//    public void testNumberOfDigits() {
//    }
//
//    @Test
//    public void testGetTaleDigits() {
//    }
//
//    @Test
//    public void testGetNaturalDividers() {
//    }
//
//    @Test
//    public void testGetSimpleNaturalDividers() {
//    }
//
//    @Test
//    public void testGetPowered2TaleDigitsCoinciders() {
//    }
//}