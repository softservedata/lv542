package com.softserve.edu;

import java.util.Arrays;
import java.util.TreeMap;

import static java.lang.System.*;


public class Runner {
    private static NaturalNumber number;
    private NaturalNumber i;

    public Runner() {
    }

    public static void main(String[] args) {
        NaturalNumber number = new NaturalNumber(
                ConsoleDialog
                        .getAnswerFromConsole("Input natural number: "));

        number.getNaturalDividers()
                .stream()
                .sorted()
                .map(x -> x + " ")
                .forEach(System.out::print);

        number.getSimpleNaturalDividers()
                .stream()
                .sorted()
                .map(x -> x + " ")
                .forEach(System.out::print);

        out.println(new TreeMap(number.getPowered2TaleDigitsCoinciders()));
    }
}

