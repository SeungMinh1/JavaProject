package com.yedam.java.ch0605;

public class Calculator {
	
	//필드
	static double pi = 3.14159;
	//생성자 => 정적 멤버 x
	
	//메소드
	static int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	static int minus(int x, int y) {
		int result = x - y;
		return result;
	}
}
