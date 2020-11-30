package com.softserve.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // String[] a = new String[] { "aa", "bb", "cc", "dd", "aa" };
        String[] a = { "aa", "bb", "cc", "dd", "aa" };
        // System.out.println("a = " + Arrays.toString(a));
        List<String> aList = Arrays.asList(a);
        System.out.println("aList = " + aList);
        aList.forEach(s -> System.out.print(s.replaceAll("\\w+", "1111") + "  "));
        // aList.add("qq"); // Error
        List<String> sList = new ArrayList<>(aList);
        sList.add("qq");
        System.out.println("\nsList = " + sList);
    }
}
