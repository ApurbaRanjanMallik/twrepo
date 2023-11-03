package com.tw.junit;

/**
 * Hello world!
 *
 */
public class Demo {
	public double convertToDecimal(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException();
		}
		return (double) a / (double) b;
	}
}
