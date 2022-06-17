package com.reavature.calculator;

public class DivByZeroException extends RuntimeException {
	DivByZeroException() {
		System.out.println("No Division by Zero");
	}
}
