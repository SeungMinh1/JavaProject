package com.yedam.java.ch0702;

public class ParentChildExample {

	public static void main(String[] args) {
		
		//자동타입변환 : 자식 -> 부모 자식고유의 필드 메소드  사용불가
		//변수의 데이터 타입이 부모 클래스를 의미
		//데이터 타입인 부모 클래스를 기준으로 사용할수 있는지 없는지
		//예외 상황 > 메소드 오버라이딩  (자식 클래스의 메소드 사용)
		
		Parent parent = new Child();
		parent.method1();
		parent.method2();
		//parent.method3();
		
		//강제 타입변환  부모 -> 자식  에러날 확률 높음
		//전제조건 자동타입변환이 먼저 실행된 대상만 가능
		//항상 instanceof 사용
		if(parent instanceof Child) { //변수 parent가 가진 인스턴스가 child클래스 인스턴스가 맞는지
			Child child = (Child)parent;
			child.method1();
			child.method2();
			child.method3();
		}
		
		if(parent instanceof Second) {
			Second second = (Second)parent;
			second.method1();
			second.method2();
			second.method4();
		}
	}

}
