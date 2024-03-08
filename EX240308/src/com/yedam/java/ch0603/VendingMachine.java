package com.yedam.java.ch0603;

public class VendingMachine {
	
	//필드
	String[] list;
	//생성자
	VendingMachine(){
		list = new String[] {"콜라", "생수", "오렌지쥬스", "탄산수"};
	}
	//메소드   - 리턴타입 메소드이름 ([매개변수]){실행코드}    리턴타입과 리턴의 형식은 같아야됨
	String getBeverage(int menu) {
		String selectProduct = list[menu-1];
		return selectProduct;
		//리턴뒤 코드추가안됨
	}
	
	
	
}
