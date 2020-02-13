package com.tyss.junittyss;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Its a simple test class")
class DemoTest {

	@Test
	@DisplayName("To test add method of calculator")
	void addTest() {
		Calculator cal = new Calculator();
		int i = cal.add(10, 5);
		assertEquals(15, i);
	
	}
	
	@Test
	@DisplayName("To test add method for Negative Values")
	void addNegativeTest() {
		Calculator cal = new Calculator();
		int actual = cal.add(-10, -5);
		int expected = -15;
		assertEquals(expected, actual);
	}
	
	
}
