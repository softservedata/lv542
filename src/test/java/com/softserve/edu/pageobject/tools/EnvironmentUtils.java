package com.softserve.edu.pageobject.tools;

public final class EnvironmentUtils {

	private EnvironmentUtils() {
    }
	
	public static String readEnvironment(String text) {
		//System.out.println("readEnvironment(): text = " + text);
        String result = "";
        String value = System.getenv().get(text);
        if ((value != null) && (!value.isEmpty())) {
        	result = value;
        }
        //System.out.println("***System.getenv(\"DEFAULT_PASS\") = " + System.getenv("DEFAULT_PASS"));
        //System.out.println("readEnvironment(): value = " + value + "   result = " + result);
        return result;
    }
}
