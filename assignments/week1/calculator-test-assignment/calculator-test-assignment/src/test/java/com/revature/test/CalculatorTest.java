package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.reavature.calculator.Calculator;
import com.reavature.calculator.DivByZeroException;

public class CalculatorTest {

	private static Calculator sut = new Calculator();
	
	/*
	 * JUnit 5
	 * 	- @BeforeAll
	 *  - @BeforeEach
	 *  - @AfterAll
	 *  - @AfterEach
	 *  
	 *  - @Test
	 *  - @Ignore
	 *  - @Order
	 */
	
	// Used to set up the test
//	@BeforeAll
//	public static void setUp() {
//		sut = new Calculator();
//	}
	
	@AfterAll
	public static void tearDown() {
		System.out.println("Tear down behavior.");
	}
	
	@BeforeEach
	public void before() {
		System.out.println("@Before each behavior");
	}
	
	@Test
	public void addOneAndTwo() {
		int expected = 3;
		int actual = sut.add(1, 2);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void subTenAndFive() {
		int expected = 5;
		int actual = sut.subtract(10, 5);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void divFiveAndZero() {	
		assertThrows(DivByZeroException.class, () -> sut.divide(5, 0));
	}
	
	@Test
	public void divFiveAndTwo() {
		float expected = 2.5f;
		float actual = sut.divide(5, 2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void addThreeFiveEightTenArray() {
		int expected = 26;
		int[] arr = new int[4];
		arr[0] = 3; arr[1] = 5; arr[2] = 8; arr[3] = 10;
		int actual = sut.sumOfAnArray(arr);
		
		assertEquals(expected, actual);
	}
}