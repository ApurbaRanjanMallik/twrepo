package com.tw.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DemoTest {
	static Demo demo;

	@BeforeAll
	public static void createObj() {
		List<String> names = new ArrayList<String>();
		names.add("Sita");
		names.add("Rama");
		names.add("Laxman");
		// demo = new Demo(names);
		demo = new Demo(Arrays.asList("Sita", "Rama", "Laxman"));
	}

	@Test
	public void checkConacatination() {
		assertEquals("Sita Rama Laxman", demo.concatinateNames());
	}

	@AfterAll
	public static void deleteObj() {
		demo = null;
	}

}
