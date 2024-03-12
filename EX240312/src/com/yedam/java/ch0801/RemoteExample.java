package com.yedam.java.ch0801;

public class RemoteExample {
	public static void main(String[] args) {
		
		Television tv = new Television();
		tv.turnOn();
		tv.turnOff();
		
		SmartTelevision stv = new SmartTelevision();
		stv.search("네이버");
		
		//다형성 = 메소드 오버라이딩 + 타입변환
		RemoteControl rc = new Television();
		rc.turnOn();
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		
		rc = new SmartTelevision();
		rc.turnOn();
		rc.turnOff();
		//List<String> sc
	}

}
