package com.yedam.java.extend;

public class Calculator {
	
	double areaCircle(double r) {
		System.out.println("Calculator 객체의 areaCircle()실행");
		return 3.14159 *r *r;
	}
	void print() {
		System.out.println("부모 메소드입니다.");
	}

}
