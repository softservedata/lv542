package com.softserve.edu.pageobject.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtils {

    public final static String DELETE_SERVER = "http://[^/]+/";
    //
    private final static String DOUBLE_UI_SEPARATOR = ",";
    private final static String PATTERN_UNSIGNED_NUMBER = "\\d+";
    // private final static String PATTERN_UNSIGNED_DOUBLE = "\\d+(\\.\\d+)*";
    private final static String PATTERN_UNSIGNED_DOUBLE = "\\d+(,\\d+)*\\.\\d{2}";
    private final static String PATTERN_SECURITY_VALUE = "^\\$\\{(\\w+)\\}$";
    private final static String EXTRACT_NUMBER_MESSAGE = "NumberFormatException for pattern =  %s text =  %s";

    private RegexUtils() {
    }

    public static String extractFirstString(String pattern, String text) {
        String result = new String();
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if (matcher.find()) {
            result = text.substring(matcher.start(), matcher.end());
        }
        return result;
    }

    public static String extractFirstGroup(String pattern, String text) {
        String result = new String();
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if(matcher.matches()) {
            result = matcher.group(1);
            //System.out.println("First Group is " + result);
        }
        //System.out.println("extractFirstGroup(): result = " + result);
        return result;
    }

    public static int extractFirstNumber(String text) {
        int result = -1;
        String extractText = extractFirstString(PATTERN_UNSIGNED_NUMBER, text);
        if (!extractText.isEmpty()) {
            try {
                result = Integer.parseUnsignedInt(extractText);
            } catch (NumberFormatException e) {
                // TODO Develop Custom Exception
                throw new RuntimeException(String.format(EXTRACT_NUMBER_MESSAGE, PATTERN_UNSIGNED_NUMBER, text));
            }
        }
        return result;
    }

    public static double extractFirstDouble(String text) {
        double result = -1;
        String extractText = extractFirstString(PATTERN_UNSIGNED_DOUBLE, text);
        if (!extractText.isEmpty()) {
            try {
                result = Double.parseDouble(commaRemover(extractText));
            } catch (NumberFormatException e) {
                // TODO Develop Custom Exception
                throw new RuntimeException(String.format(EXTRACT_NUMBER_MESSAGE, PATTERN_UNSIGNED_DOUBLE, text));
            }
        }
        return result;
    }

    public static String extractSecurityValue(String text) {
        String result = "";
        String extractText = extractFirstGroup(PATTERN_SECURITY_VALUE, text);
        if (!extractText.isEmpty()) {
            result = extractText;
        } else {
            // TODO Develop Custom Exception
            throw new RuntimeException(String.format(EXTRACT_NUMBER_MESSAGE, PATTERN_SECURITY_VALUE, text));
        }
        return result;
    }

    public static boolean isTextContains(String pattern, String text) {
        return !extractFirstString(pattern, text).isEmpty();
    }

    public static boolean isTextMatches(String pattern, String text) {
        return Pattern.compile(pattern).matcher(text).matches();
    }

    public static boolean isDoubleMatches(String text) {
        return isTextMatches(PATTERN_UNSIGNED_DOUBLE, text);
    }

    public static boolean isSecurityMatches(String text) {
        return isTextMatches(PATTERN_SECURITY_VALUE, text);
    }

    public static String extractPathWithoutServer(String pattern, String text) {
        String result = text;
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if (matcher.find()) {
            result = text.substring(matcher.end() - 1);
        }
        return result;
    }

    private static String commaRemover(String text) {
        return text.replaceAll(DOUBLE_UI_SEPARATOR, new String());
    }

}