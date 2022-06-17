/**
 * 
 */
package com.reavature.calculator;


/**
 * @author KevinTranHuu
 *
 */
public class Calculator {
	/*
	 * - add(int a, int b)
	 * 		- if the result is 13
	 * 			- throw an exception
	 * 				- Number13Exception
	 * - subtract
	 * - multiply
	 * - sum of an array
	 * - divide
	 * 		- throw a custom exception if divided by 0
	 */
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public float divide(int a, int b) {
		if(b == 0) {
			throw new DivByZeroException();
		}
		return (float)a / (float)b;
	}
	
	public int sumOfAnArray(int[] intArr) {
		int sum = 0;
		
		for(int i = 0; i < intArr.length; i++) {
			sum += intArr[i];
		}
		
		return sum;
	}
}