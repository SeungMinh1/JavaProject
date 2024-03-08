package com.yedam.java.ch0603;

import java.util.Scanner;

public class CalculatorExample {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("더하고자 하는 값 : ");
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		
		int result = cal.plus(x, y);
		System.out.println("결과값 : " + result);
	}

}
