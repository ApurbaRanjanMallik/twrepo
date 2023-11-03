package com.tw.junit;

public class MyCalculator {

	Calculator calculator;

	public double add(int a, int b) {
		return calculator.addition(a, b);
	}

	public double sub(int a, int b) {
		return calculator.subtraction(a, b);
	}

	public double mul(int a, int b) {
		return calculator.multiplication(a, b);
	}

	public double div(int a, int b) {
		return calculator.division(a, b);
	}
}
