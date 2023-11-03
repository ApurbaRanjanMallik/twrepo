package com.tw.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
	@Mock
	Calculator calculator;
	@InjectMocks
	MyCalculator myCalculator;

	@Test
	public void checkForAddition() {
		Mockito.when(calculator.addition(10.0, 20.0)).thenReturn(30.0);
		assertEquals(30.0, myCalculator.add(10, 20));
	}
}
