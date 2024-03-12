package com.yedam.java.ch0802;

public class PhoneExample {

	public static void main(String[] args) {
		//타입변환 : 구현클래스 -> 인터페이스 변수, 인터페이스에 정의된 상수와 메소드만 사용가능
		//변수의 데이터 타입이 인터페이스 => 데이터타입인 인터페이스를 기준으로 삼아서 실행할수있는지 없는지
		Phone phone = new SmartPhone("Lee");
		phone.turnOn();
		phone.callTo("Hong");
		phone.turnOff();
		//phone.search("네이버"); // 구현클래스 고유의 메소드 사용불가
		
		//강제타입변환 : 인터페이스 변수가 가지는 객체 - >구현클래스
		// 구현클래스 고유의 메소드를 사용하기 위해
		if(phone instanceof SmartPhone) {
			SmartPhone sm = (SmartPhone) phone;
			sm.turnOn();
			sm.callTo("Hong");
			sm.turnOff();
			sm.search("네이버"); // 구현클래스 고유의 메소드 사용불가
		}
		
	}

}
