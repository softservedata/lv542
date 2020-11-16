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
        out.println("Natural dividers of " + number.getValue() + ":");
        number.getNaturalDividers()
                .stream()
                .sorted()
                .map(x -> String.valueOf(x) + " ")
                .forEach(System.out::print);

        out.println("\nSimple natural dividers of " + number.getValue() + ":");
        number.getSimpleNaturalDividers()
                .stream()
                .sorted()
                .map(x -> String.valueOf(x) + " ")
                .forEach(System.out::print);

        out.println("\nNumbers [1.." + number.getValue() + "], whose record coincides with the last " +
                        "digits of their power 2 :");
        out.println(new TreeMap(number.getPowered2TaleDigitsCoinciders()));
    }
}

