package com.tyss.junittyss;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SimpleCalculatorTest {
	
	  @Test void test() {
	  SimpleCalculator calculator =new SimpleCalculator();
	   
	 
	   assertThrows(ArithmeticException.class, ()->{
		   calculator.div(20, 0);
	   });
	  
	  }
	 
	
	/*
	 * @ParameterizedTest
	 * 
	 * @MethodSource("getDivValues") void getDivResultTest(int a,int b,int expected)
	 * { SimpleCalculator calculator =new SimpleCalculator(); int actual =
	 * calculator.div(a, b); assertEquals(expected, actual); }
	 * 
	 * 
	 * 
	 * static Stream<Arguments> getDivValues(){ return
	 * Stream.of(Arguments.arguments(10,5,2), Arguments.arguments(60,-6,-10) ); }
	 */
}
