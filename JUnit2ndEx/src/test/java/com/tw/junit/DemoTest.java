package com.tw.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DemoTest {
	static Demo demo;

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	@BeforeAll
	public static void createObj() {
		demo = new Demo();
	}

	@ParameterizedTest
	@ValueSource(strings = { "madam", "radar", "lol", "pop", "apurupa" })
	public void testPalindrome(String s) {
		assertTrue(Demo.isPalindrome(s));
	}

	@AfterAll
	public static void deketeObj() {
		demo = null;
	}

}
