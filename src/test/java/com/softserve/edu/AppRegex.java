package com.softserve.edu;

import com.softserve.edu.pageobject.tools.RegexUtils;

public class AppRegex {
	public static void main(String[] args) {
		String text = "${Temp}";
		System.out.println("" + RegexUtils.isSecurityMatches(text));
	}
}
