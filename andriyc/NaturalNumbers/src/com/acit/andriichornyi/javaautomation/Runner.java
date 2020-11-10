package com.acit.andriichornyi.javaautomation;

import java.util.Arrays;
import java.util.TreeMap;

import static java.lang.System.*;

public class Runner {

    public Runner() {
    }

    public static void main(String[] args) {
        NaturalNumber n = new NaturalNumber(
                ConsoleDialog
                        .getAnswerFromConsole("Input natural number: "));
        out.println(
                Arrays.asList(
                n.getNaturalDividers()
                        .stream()
                        .sorted()
                        .toArray()));
        out.println(
                Arrays.asList(
                n.getSimpleNaturalDividers()
                        .stream()
                        .sorted()
                        .toArray()));
        out.println(new TreeMap<>(n.getPowered2TaleDigitsCoinciders()));

    }
}

