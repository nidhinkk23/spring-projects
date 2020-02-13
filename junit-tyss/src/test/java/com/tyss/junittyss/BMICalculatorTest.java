package com.tyss.junittyss;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BMICalculatorTest {

	@Test
	void bmiCalculator() {
		BMICalculator bmiCalculator = new BMICalculator();
		double actual = bmiCalculator.bmiCalculator(10, 10);
		
		assertEquals(.1, actual);
	}
	
	
	@ParameterizedTest
	@MethodSource("getBmiValues")
	void getBmiResultTest(double value,String result) {
		BMICalculator bmiCalculator = new BMICalculator();
		String actual = bmiCalculator.getBmiResult(value);
		assertEquals(result, actual);
	}
	
	
	static Stream<Arguments> getBmiValues(){
		return Stream.of(Arguments.arguments(18.9,"Normal"),
				Arguments.arguments(18,"Under Weight"),
				Arguments.arguments(26,"Over weight"),
				Arguments.arguments(36,"Obesity")
				
				);
		
	}
	
	
	
}
