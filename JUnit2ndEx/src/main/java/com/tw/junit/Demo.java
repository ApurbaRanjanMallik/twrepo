package com.tw.junit;

/**
 * Hello world!
 *
 */
public class Demo {
	public static boolean isPalindrome(String input) {
		String reverse = "";

		for (int i = input.length() - 1; i >= 0; i--) {
			reverse = reverse + input.charAt(i);
		}
		if (input.equals(reverse))
			return true;
		else
			return false;
	}
}
