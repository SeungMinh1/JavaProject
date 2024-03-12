package com.yedam.java.ch0702;

public class Car { //집합관계
	
	//필드   자동타입변환으로 값 초기화
	Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new KumhoTire("앞오른쪽", 2);
	Tire backLeftTire= new Tire("뒤왼쪽", 4);
	Tire backRightTire = new HankookTire("뒤오른쪽", 3);
	//NexenTire backRightTire = new NexenTire("뒤오른쪽", 3);
	//생성자
	
	//메소드
	//필드의 다형성
	boolean run() {
		System.out.println("=자동차는 달립니다.=");
		boolean isRun = true;
		isRun = frontLeftTire.roll();
		isRun = frontRightTire.roll();
		isRun = backLeftTire.roll();
		isRun = backRightTire.roll();
		return isRun;
	}
	//타이어 교체 : 매걔변수의 다형성
	void changedTire(int location, Tire newTire) {
		System.out.println("타이어를 교체합니다.");
		switch(location) {
		case 1:
			frontLeftTire = newTire;
			break;
		case 2:
			frontRightTire = newTire;
			break;
		case 3:
			backLeftTire = newTire;
			break;
		case 4:
			backRightTire = newTire;
			break;
		}
	}
	
}
