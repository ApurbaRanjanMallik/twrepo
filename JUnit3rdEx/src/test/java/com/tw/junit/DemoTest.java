package com.tw.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DemoTest {
	static Demo demo;

	@BeforeAll
	public static void createObj() {
		demo = new Demo();
	}

	@Test
	public void test01() {
		assertThrows(ArithmeticException.class, () -> demo.convertToDecimal(3, 0));
	}
	@Test
	public void test02() {
		assertEquals(6.0, demo.convertToDecimal(18, 3));
	}

	public static void destroyObj() {
		demo = null;
	}

}
