package com.yedam.java.ch0603;

public class Calculator {
	
	//필드
	
	//생성자
	
	//메소드  - 리턴타입 메소드이름 ([매개변수]){실행코드}    리턴타입과 리턴의 형식은 같아야됨
	
	//더하기
	int plus(int a, int b) {
		int result = a + b;
		return result;
	}
	/*
	double plus(double a, double b) {
		double result = a + b;
		return result;
	}
	*/
	int plus(double a, double b) {
		int result = (int)(a + b);
		return result;
	}
	//빼기
	int minus(int a, int b) {
		int result = a - b;
		return result;
	}
	double minus(double a, double b) {
		double result = a - b;
		return result;
	}
	
	//평균
	int avg(int a, int b) {
		int result = (a+b)/2;
		return result;
	}
	double avg(double a, double b) {
		double result = plus(a,b)/2;
		return result;
	}
	
	/*
	for(int i=0; i<sdfkj; i++) {
		if(max == diclist[i]) {
			max =i;
		}
	}
	*/
	

}
