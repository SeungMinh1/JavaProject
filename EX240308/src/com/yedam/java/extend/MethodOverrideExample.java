package com.yedam.java.extend;

public class MethodOverrideExample {

	public static void main(String[] args) {
		Computer com = new Computer();
		double result = com.areaCircle(10);
		System.out.println("computer : " + result);
		/*
		Calculator cal = new Calculator();
		double result2 = cal.areaCircle(10);
		System.out.println("Calculator : " + result2);
		*/
		result = com.selectParentMethod(10);
		System.out.println("computer2 : " + result);
		com.print();
	}

}
