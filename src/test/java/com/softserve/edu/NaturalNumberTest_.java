package com.acit.andriichornyi.javaautomation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class NaturalNumberTest_ {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getValue() {
    }

    @Test
    void setValue() {
    }

    @Test
    void getgetNaturalDividersResultSizeTest() {

    }

    @Test
    void getNaturalDividers() {
        NaturalNumber number = new NaturalNumber(1000L);
        Set<Long> expectedResult = new HashSet<>();
        Set<Long> realResult = number.getNaturalDividers();

        for(long i = 1; i <= number.getValue(); i++) {
            if (number.getValue() % i == 0) expectedResult.add(new NaturalNumber(i).getValue());
        }
        assert expectedResult.equals(realResult) : "Expected set of dividers differs from received set";
    }

    @Test
    void getSimpleNaturalDividers() {
        NaturalNumber number = new NaturalNumber(1000L);
        Set<Long> expectedResult = new HashSet<>();
        Set<Long> realResult = number.getSimpleNaturalDividers();

        for(long i = 1, n = 0; i <= number.getValue(); i++) {
            if (number.getValue() % i == 0) {
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) n++;
                }
                if (n <= 2) {
                    expectedResult.add(new NaturalNumber(i).getValue());
                }
            }
            n = 0;
        }
        assert expectedResult.equals(realResult) : "Expected set of simple dividers differs from received set";
    }

    @Test
    void getPow2Coincidence() {
    }
}